package com.primatec.ADAS.security.auth;


import com.primatec.ADAS.model.User.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {

  private String firstname;
  private String lastname;
  private String email;
  private String password;
  private String username;
  private String phone_number;
  private Role role;
  private Date birthdate;
  private Date joinDate;

}
