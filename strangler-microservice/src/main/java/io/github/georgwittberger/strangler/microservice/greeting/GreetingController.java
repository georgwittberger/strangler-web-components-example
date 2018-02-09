package io.github.georgwittberger.strangler.microservice.greeting;

import io.github.georgwittberger.strangler.microservice.monolith.UserData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

@RestController
public class GreetingController {
  private static final Logger log = LoggerFactory.getLogger(GreetingController.class);
  private RestTemplate monolithRestTemplate;

  @Autowired
  public GreetingController(@Qualifier("monolith") RestTemplate monolithRestTemplate) {
    this.monolithRestTemplate = monolithRestTemplate;
  }

  @GetMapping("/greeting")
  public Greeting greeting(@RequestHeader("X-Monolith-Session-Cookie-Name") String monolithSessionCookieName,
                           @RequestHeader("X-Monolith-Session-Cookie-Value") String monolithSessionCookieValue) {
    log.debug("Received greeting request");

    // Request user data for the given session from the monolith
    HttpHeaders requestHeaders = new HttpHeaders();
    requestHeaders.add(HttpHeaders.COOKIE, monolithSessionCookieName + "=" + monolithSessionCookieValue);
    HttpEntity<?> httpEntity = new HttpEntity<>(requestHeaders);
    log.debug("Requesting user data from the monolith for session ID '{}'", monolithSessionCookieValue);
    ResponseEntity<UserData> userDataResponse = monolithRestTemplate.exchange(
      "/user-data", HttpMethod.GET, httpEntity, UserData.class);
    if (userDataResponse.getStatusCode() != HttpStatus.OK)
      throw new ResourceAccessException("Unexpected status code: " + userDataResponse.getStatusCodeValue());

    // Respond with a greeting containing the user data received from the monolith
    UserData userData = userDataResponse.getBody();
    log.debug("User data for session ID '{}' received from the monolith: {}", monolithSessionCookieValue, userData);
    if (userData.getName() != null && userData.getName().length() > 0
      && userData.getEmail() != null && userData.getEmail().length() > 0) {
      return new Greeting().greeting("Hello " + userData.getName()
        + ", may I contact you at " + userData.getEmail() + "?");
    } else {
      return new Greeting().greeting("Hello unknown user.");
    }
  }
}
