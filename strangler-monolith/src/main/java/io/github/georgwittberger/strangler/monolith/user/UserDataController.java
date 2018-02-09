package io.github.georgwittberger.strangler.monolith.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserDataController {
  @GetMapping("/user-data")
  @ResponseBody
  public UserData getUserData(@ModelAttribute("userData") UserData userData) {
    return userData;
  }

  @PostMapping("/user-data")
  public String postUserData(@ModelAttribute("userData") UserData userData) {
    return "redirect:/";
  }
}
