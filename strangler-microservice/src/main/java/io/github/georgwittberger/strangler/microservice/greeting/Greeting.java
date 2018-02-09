package io.github.georgwittberger.strangler.microservice.greeting;

import java.util.Objects;

public class Greeting {
  private String greeting;

  public String getGreeting() {
    return greeting;
  }

  public void setGreeting(String greeting) {
    this.greeting = greeting;
  }

  public Greeting greeting(String greeting) {
    setGreeting(greeting);
    return this;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Greeting greeting1 = (Greeting) o;
    return Objects.equals(greeting, greeting1.greeting);
  }

  @Override
  public int hashCode() {
    return Objects.hash(greeting);
  }

  @Override
  public String toString() {
    return "Greeting{" +
      "greeting='" + greeting + '\'' +
      '}';
  }
}
