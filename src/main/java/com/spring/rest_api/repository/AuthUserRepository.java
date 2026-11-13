package com.spring.rest_api.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.spring.rest_api.entity.Auth_User;

public interface AuthUserRepository extends JpaRepository<Auth_User, Long> {
  Optional<Auth_User> findByUsername(String theUsername);
  boolean existsByUsername(String theUsername);
}
