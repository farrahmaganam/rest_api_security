package com.spring.rest_api.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity 
@Table(name="auth_user")
public class Auth_User {

  @Id 
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long id;

  private String username;
  private String password;

  @ManyToMany(fetch=FetchType.EAGER,
              cascade=CascadeType.ALL)
  @JoinTable(name="authusers_authroles",
             joinColumns=@JoinColumn(name="authuser_id",
                                     referencedColumnName="id"),
             inverseJoinColumns=@JoinColumn(name="authrole_id",
                                            referencedColumnName="id"))
  private List<Auth_Roles> roles = new ArrayList<>();

  public Long getId() {
    return id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  @Override
  public String toString() {
    return "auth [id=" + id
        + ", firstName='" + username + '\''
        + ", lastName='" + password + '\''
        + ']';
  }

  public List<Auth_Roles> getRoles() {
    return roles;
  }

  public void setRoles(List<Auth_Roles> roles) {
    this.roles = roles;
  }
}
