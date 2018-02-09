package io.github.georgwittberger.strangler.microservice.greeting;

import io.github.georgwittberger.strangler.microservice.cors.CORSProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class GreetingConfiguration extends WebMvcConfigurerAdapter {
  private CORSProperties corsProperties;

  @Autowired
  public GreetingConfiguration(CORSProperties corsProperties) {
    this.corsProperties = corsProperties;
  }

  @Override
  public void addCorsMappings(CorsRegistry registry) {
    registry.addMapping("/greeting")
      .allowedMethods("OPTIONS", "HEAD", "GET")
      .allowedHeaders("X-Monolith-Session-Cookie-Name", "X-Monolith-Session-Cookie-Value")
      .allowedOrigins(corsProperties.getMessage().getAllowedOrigins().toArray(new String[0]))
      .maxAge(3600);
  }
}
