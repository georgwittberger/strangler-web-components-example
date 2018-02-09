package io.github.georgwittberger.strangler.microservice.message;

import io.github.georgwittberger.strangler.microservice.cors.CORSProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class MessageConfiguration extends WebMvcConfigurerAdapter {
  private CORSProperties corsProperties;

  @Autowired
  public MessageConfiguration(CORSProperties corsProperties) {
    this.corsProperties = corsProperties;
  }

  @Override
  public void addCorsMappings(CorsRegistry registry) {
    registry.addMapping("/message")
      .allowedMethods("OPTIONS", "HEAD", "GET")
      .allowedOrigins(corsProperties.getMessage().getAllowedOrigins().toArray(new String[0]))
      .maxAge(3600);
  }
}
