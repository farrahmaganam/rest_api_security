package com.spring.rest_api.service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.spring.rest_api.entity.Auth_Roles;
import com.spring.rest_api.entity.Auth_User;
import com.spring.rest_api.repository.AuthUserRepository;

@Service 
public class CustomUserDetailsService implements UserDetailsService {

  private final AuthUserRepository authUserRepo;

  public CustomUserDetailsService(AuthUserRepository authUserRepo) {
    this.authUserRepo = authUserRepo;
  }

  @Override
  public UserDetails loadUserByUsername(String theUsername) {
    Auth_User user = authUserRepo.findByUsername(theUsername)
        .orElseThrow(() -> new UsernameNotFoundException("Username " + theUsername + " does not exist."));
    return new User(user.getUsername(),
                    user.getPassword(),
                    mapRolesToAuthorities(user.getRoles()));
  }

  private Collection<GrantedAuthority> mapRolesToAuthorities(List<Auth_Roles> roles) {
    return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
  }

}
