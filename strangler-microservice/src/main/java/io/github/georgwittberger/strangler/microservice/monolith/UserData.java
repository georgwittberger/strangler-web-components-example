package io.github.georgwittberger.strangler.microservice.monolith;

import java.util.Objects;

public class UserData {
  private String name;
  private String email;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public UserData name(String name) {
    setName(name);
    return this;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public UserData email(String email) {
    setEmail(email);
    return this;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    UserData userData = (UserData) o;
    return Objects.equals(name, userData.name) &&
      Objects.equals(email, userData.email);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, email);
  }

  @Override
  public String toString() {
    return "UserData{" +
      "name='" + name + '\'' +
      ", email='" + email + '\'' +
      '}';
  }
}
