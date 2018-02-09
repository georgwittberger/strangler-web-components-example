package io.github.georgwittberger.strangler.monolith.user;

import java.io.Serializable;
import java.util.Objects;

public class UserData implements Serializable {
  private String name;
  private String email;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
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
