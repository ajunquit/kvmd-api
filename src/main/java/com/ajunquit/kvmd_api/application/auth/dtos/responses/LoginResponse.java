package com.ajunquit.kvmd_api.application.auth.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginResponse {

  private String message;
  private String token;

}
