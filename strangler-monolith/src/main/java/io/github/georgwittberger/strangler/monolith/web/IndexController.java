package io.github.georgwittberger.strangler.monolith.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class IndexController {
  @ModelAttribute("sessionId")
  public String sessionId(HttpSession session) {
    return session.getId();
  }

  @GetMapping("/")
  public String index(Map<String, Object> model) {
    model.put("message", "Hello from the monolith!");
    return "index";
  }
}
