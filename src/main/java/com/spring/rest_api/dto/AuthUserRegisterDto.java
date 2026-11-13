package com.spring.rest_api.dto;

public class AuthUserRegisterDto {
  private String username;
  private String password;

  public AuthUserRegisterDto(String username, String password) {
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
