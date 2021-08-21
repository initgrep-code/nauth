package com.initgrep.apps.nauth.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
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


  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    Optional<AuthUserDetails> byUsername = repository.findByUsername(username);
    byUsername.ifPresent(System.out::println);
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

  /**
   * This method assumes that both oldPassword and the newPassword params
   * are encoded with configured passwordEncoder
   *
   * @param oldPassword the old password of the user
   * @param newPassword the new password of the user
   */
  @Override
  @Transactional
  public void changePassword(String oldPassword, String newPassword) {
    AuthUserDetails userDetails = repository.findByPassword(oldPassword)
      .orElseThrow(() -> new BadCredentialsException("Invalid password provided"));
    userDetails.setPassword(newPassword);
    repository.save(userDetails);
  }

  @Override
  public boolean userExists(String username) {
    return repository.findByUsername(username).isPresent();
  }
}
