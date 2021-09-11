package com.initgrep.apps.nauth.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class UserController {



    @GetMapping("/users")
    public List<User> getUsers(){

        return Arrays.asList(
                new User("Irshad","irshad@gmail.com", "99065403980"),
                new User("Ahmad","ahmad@gmail.com", "8971261271721"),
                new User("Sheikh","sheikh@gmail.com", "989712121902")
        );
    }
}
