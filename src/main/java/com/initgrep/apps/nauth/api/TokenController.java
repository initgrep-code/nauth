package com.initgrep.apps.nauth.api;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class TokenController {

    @Autowired
    private FirebaseAuth firebaseAuth;

    @GetMapping("/token")
    public Map<String, String> getToken() throws FirebaseAuthException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        String authorities = authentication.getAuthorities()
                .stream()
                        .map(GrantedAuthority::getAuthority)
                                .collect(Collectors.joining(","));
        System.out.println(authorities);
        String customToken = firebaseAuth.createCustomToken("andrew", Collections.singletonMap("authorities", authorities));
        return Collections.singletonMap("token", customToken);
    }

}
