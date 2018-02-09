package io.github.georgwittberger.strangler.microservice.monolith;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class MonolithConfiguration {
  @Bean
  @Qualifier("monolith")
  public RestTemplate monolithRestTemplate(RestTemplateBuilder builder, @Value("${monolith.root-url}") String rootUrl) {
    return builder.rootUri(rootUrl).build();
  }
}
