package com.initgrep.apps.nauth.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http
      .authorizeRequests()
      .anyRequest().authenticated()
      .and()
      .formLogin().loginPage("/login").permitAll()
      .successHandler(((request, response, authentication) -> {
        //Log the loggedIn user
        System.out.println("LoggedIn user " + authentication.getPrincipal());
      }))
      .failureHandler((request, response, exception) -> {
        //log exception message
        System.err.println("Login failed ->" + exception.getMessage());
      })
      .and()
      .logout().logoutUrl("/logout");
  }
}
