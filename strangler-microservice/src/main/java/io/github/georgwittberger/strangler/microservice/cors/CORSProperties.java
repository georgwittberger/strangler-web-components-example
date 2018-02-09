package io.github.georgwittberger.strangler.microservice.cors;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@ConfigurationProperties("cors")
public class CORSProperties {
  public static class MessageCORSProperties {
    private List<String> allowedOrigins;

    public List<String> getAllowedOrigins() {
      return allowedOrigins;
    }

    public void setAllowedOrigins(List<String> allowedOrigins) {
      this.allowedOrigins = allowedOrigins;
    }
  }

  private MessageCORSProperties message;

  public MessageCORSProperties getMessage() {
    return message;
  }

  public void setMessage(MessageCORSProperties message) {
    this.message = message;
  }
}
