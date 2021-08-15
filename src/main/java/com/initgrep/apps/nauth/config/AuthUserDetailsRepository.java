package com.initgrep.apps.nauth.config;

import com.initgrep.apps.nauth.jpa.AuthUserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthUserDetailsRepository extends JpaRepository<AuthUserDetails, Long> {
  Optional<AuthUserDetails> findByUsername(String username);
}
