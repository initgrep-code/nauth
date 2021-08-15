package com.initgrep.apps.nauth.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TemplateController {

  @GetMapping("/login")
  public String login() {
    return "login";
  }

  @GetMapping("/logout")
  public String logout() {
    return "logout";
  }

  @GetMapping("/home")
  public String home() {
    return "home";
  }
}
