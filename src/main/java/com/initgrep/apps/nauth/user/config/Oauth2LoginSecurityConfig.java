package com.initgrep.apps.nauth.user.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.mapping.GrantedAuthoritiesMapper;

@EnableWebSecurity
public class Oauth2LoginSecurityConfig extends WebSecurityConfigurerAdapter {



    public GrantedAuthoritiesMapper grantedAuthoritiesMapper(){

        return (authorities) -> {
            authorities.forEach(authority -> System.out.println("authorty - "+authority.getAuthority()));
            return authorities;
        };
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .oauth2Login()
                .userInfoEndpoint().userAuthoritiesMapper(this.grantedAuthoritiesMapper());
    }
}
