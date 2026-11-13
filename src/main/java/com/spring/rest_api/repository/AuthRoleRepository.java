package com.spring.rest_api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.rest_api.entity.Auth_Roles;

public interface AuthRoleRepository extends JpaRepository<Auth_Roles, Long> {
  Optional<Auth_Roles> findByName(String theName);
  Boolean existsByName(String theUsername);
}
