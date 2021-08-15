package com.initgrep.apps.nauth.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/sample")
public class SampleAuthController {

  @GetMapping("/message/{message}")
  public Map<String, String> getMessage(@PathVariable String message) {
    System.out.println("message -> " + message);
    System.out.println("another message");
    return Collections.singletonMap("message", message);
  }

  @GetMapping("/error")
  public String error() {
    return "error happened";
  }

}
