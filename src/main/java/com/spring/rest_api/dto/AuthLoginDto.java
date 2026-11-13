package com.spring.rest_api.dto;

public class AuthLoginDto {
  private String username;
  private String password;

  public AuthLoginDto(String username, String password) {
    this.username = username;
    this.password = password;
  }

  public String getUsername(){
    return username;
  }

  public String getPassword(){
    return password;
  }

}
