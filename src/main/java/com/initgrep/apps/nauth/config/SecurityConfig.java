package com.initgrep.apps.nauth.config;

import com.initgrep.apps.nauth.jpa.JpaUserDetailsManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  @Autowired
  private JpaUserDetailsManager jpaAuthUserDetailsService;

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

  @Override
  protected void configure(AuthenticationManagerBuilder auth) {
    auth.authenticationProvider(inMemoryDaoAuthenticationProvider());
    auth.authenticationProvider(jpaDaoAuthenticationProvider());
  }

  @Bean
  public DaoAuthenticationProvider inMemoryDaoAuthenticationProvider() {
    DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
    daoAuthenticationProvider.setUserDetailsService(inMemoryUserDetailsService());
    daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
    return daoAuthenticationProvider;
  }

  @Bean
  public DaoAuthenticationProvider jpaDaoAuthenticationProvider() {
    DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
    daoAuthenticationProvider.setUserDetailsService(jpaAuthUserDetailsService);
    daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
    return daoAuthenticationProvider;
  }

  public UserDetailsService inMemoryUserDetailsService() {
    UserDetails user1 = User.builder()
      .username("user1")
      .password("password")
      .roles("USER")
      .passwordEncoder((password) -> passwordEncoder().encode(password))
      .build();
    return new InMemoryUserDetailsManager(user1);
  }

  @Bean
  public BCryptPasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder(4);
  }


}
