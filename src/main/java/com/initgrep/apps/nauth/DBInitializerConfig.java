package com.initgrep.apps.nauth;

import com.initgrep.apps.nauth.config.AuthGrantedAuthorityRepository;
import com.initgrep.apps.nauth.config.AuthUserDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class DBInitializerConfig {
  @Autowired
  private AuthUserDetailsRepository authUserDetailsRepository;

  @Autowired
  private AuthGrantedAuthorityRepository authGrantedAuthorityRepository;

  @Autowired
  private PasswordEncoder passwordEncoder;


  // initialize the user in DB
  @Bean
  public CommandLineRunner initializeJpaData() {
    return (args)->{
      System.out.println("application started");

//      AuthUserDetails user2 = new AuthUserDetails();
//      user2.setUsername("user2");
//      user2.setPassword(passwordEncoder.encode("password"));
//      user2.setEnabled(true);
//      user2.setCredentialsNonExpired(true);
//      user2.setAccountNonExpired(true);
//      user2.setAccountNonLocked(true);
//
//      AuthGrantedAuthority grantedAuthority = new AuthGrantedAuthority();
//      grantedAuthority.setAuthority("USER");
//      grantedAuthority.setAuthUserDetail(user2);
//      authUserDetailsRepository.save(user2);
//      authGrantedAuthorityRepository.save(grantedAuthority);
//      user2.setAuthorities(Collections.singleton(grantedAuthority));
    };

  }
}
