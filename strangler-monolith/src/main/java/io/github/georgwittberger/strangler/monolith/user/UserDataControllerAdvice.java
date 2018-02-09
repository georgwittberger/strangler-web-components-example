package io.github.georgwittberger.strangler.monolith.user;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpSession;

@ControllerAdvice
public class UserDataControllerAdvice {
  @ModelAttribute("userData")
  public UserData userData(HttpSession session) {
    UserData userData = (UserData) session.getAttribute("userData");
    if (userData == null) {
      userData = new UserData();
      session.setAttribute("userData", userData);
    }
    return userData;
  }
}
