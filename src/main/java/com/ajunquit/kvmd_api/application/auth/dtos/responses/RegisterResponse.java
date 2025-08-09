package com.ajunquit.kvmd_api.application.auth.dtos.responses;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class RegisterResponse {
  private String message;
  private String userId;
}
