package com.initgrep.apps.nauth.config;

import com.initgrep.apps.nauth.jpa.AuthUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class JpaAuthUserDetailsService implements UserDetailsService {

  @Autowired
  private AuthUserDetailsRepository repository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    Optional<AuthUserDetails> byUsername = repository.findByUsername(username);
    if (byUsername.isPresent()) {
      System.out.println(byUsername.get());
    }
    return byUsername.orElseThrow(() -> new UsernameNotFoundException("No user found with username = " + username));
  }
}
