package com.spring.rest_api.dto;

public class AuthRoleRegisterDto {

  private String name;

  public AuthRoleRegisterDto(String name) {
    this.name = name;
  }

  public String getName(){
    return name;
  }
}
