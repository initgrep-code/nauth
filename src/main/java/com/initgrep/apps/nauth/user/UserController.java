package com.initgrep.apps.nauth.user;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class UserController {

    @GetMapping("/users")
    public List<User> getUsers(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        System.out.println("Authentication - "+authentication);
        return Arrays.asList(
                new User("irshad", 100),
                new User("sheikh",300)
        );
    }
}
