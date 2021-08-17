package com.initgrep.apps.nauth.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class JpaUserDetailsManager implements UserDetailsManager {

  @Autowired
  private AuthUserDetailsRepository repository;

  @Autowired
  private PasswordEncoder passwordEncoder;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    Optional<AuthUserDetails> byUsername = repository.findByUsername(username);
    if (byUsername.isPresent()) {
      System.out.println(byUsername.get());
    }
    return byUsername.orElseThrow(() -> new UsernameNotFoundException("No user found with username = " + username));
  }

  @Override
  public void createUser(UserDetails user) {
    repository.save((AuthUserDetails) user);
  }

  @Override
  public void updateUser(UserDetails user) {
    repository.save((AuthUserDetails) user);
  }

  @Override
  public void deleteUser(String username) {
    AuthUserDetails userDetails = repository.findByUsername(username)
      .orElseThrow(() -> new UsernameNotFoundException("No User found for username -> " + username));
    repository.delete(userDetails);
  }

  @Override
  @Transactional
  public void changePassword(String oldPassword, String newPassword) {
    AuthUserDetails userDetails = repository.findByPassword(passwordEncoder.encode(oldPassword))
      .orElseThrow(() -> new UsernameNotFoundException("Invalid password "));
    userDetails.setPassword(newPassword);
    repository.save(userDetails);
  }

  @Override
  public boolean userExists(String username) {
    return repository.findByUsername(username).isPresent();
  }
}
