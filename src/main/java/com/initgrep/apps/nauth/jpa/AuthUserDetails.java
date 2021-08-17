package com.initgrep.apps.nauth.jpa;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;

@Entity
public class AuthUserDetails implements UserDetails {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String username;
  private String password;
  private boolean accountNonExpired;
  private boolean accountNonLocked;
  private boolean credentialsNonExpired;
  private boolean enabled;

  @OneToMany(mappedBy = "authUserDetails", fetch = FetchType.EAGER)
  private Set<AuthGrantedAuthority> authorities;

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return this.authorities;
  }

  @Override
  public String getPassword() {
    return this.password;
  }

  @Override
  public String getUsername() {
    return this.username;
  }

  @Override
  public boolean isAccountNonExpired() {
    return this.accountNonExpired;
  }

  @Override
  public boolean isAccountNonLocked() {
    return this.accountNonLocked;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return this.credentialsNonExpired;
  }

  @Override
  public boolean isEnabled() {
    return this.enabled;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public void setAccountNonExpired(boolean accountNonExpired) {
    this.accountNonExpired = accountNonExpired;
  }

  public void setAccountNonLocked(boolean accountNonLocked) {
    this.accountNonLocked = accountNonLocked;
  }

  public void setCredentialsNonExpired(boolean credentialsNonExpired) {
    this.credentialsNonExpired = credentialsNonExpired;
  }

  public void setEnabled(boolean enabled) {
    this.enabled = enabled;
  }

  public void setAuthorities(Set<AuthGrantedAuthority> authorities) {
    this.authorities = authorities;
  }

  @Override
  public String toString() {
    return "AuthUserDetails{" +
      "id=" + id +
      ", username='" + username + '\'' +
      ", password='" + password + '\'' +
      ", accountNonExpired=" + accountNonExpired +
      ", accountNonLocked=" + accountNonLocked +
      ", credentialsNonExpired=" + credentialsNonExpired +
      ", enabled=" + enabled +
      '}';
  }
}
