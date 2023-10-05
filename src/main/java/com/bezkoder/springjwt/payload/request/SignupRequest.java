package com.bezkoder.springjwt.payload.request;

import java.util.Set;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignupRequest {
  @NotBlank
  @Size(max = 20)
  private String username;
  private String firstname;
  private String lastname;
  @NotBlank
  @Size(max = 50)
  @Email
  private String email;
  private String address;
  private String phone;
  private Set<String> role;
  @NotBlank
  @Size(min = 6, max = 40)
  private String password;
}