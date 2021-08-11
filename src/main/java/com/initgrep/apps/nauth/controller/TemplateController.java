package com.initgrep.apps.nauth.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TemplateController {

    @GetMapping("/auth")
    public String getLogin(){
        return "login";
    }
}
