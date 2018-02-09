package io.github.georgwittberger.strangler.microservice.message;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {
  private static final Logger log = LoggerFactory.getLogger(MessageController.class);

  @GetMapping("/message")
  public Message message() {
    log.debug("Received message request");
    return new Message().message("Hello from the microservice!");
  }
}
