package com.initgrep.apps.nauth.jpa;

import com.initgrep.apps.nauth.jpa.AuthGrantedAuthority;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthGrantedAuthorityRepository extends JpaRepository<AuthGrantedAuthority, Long> {
}
