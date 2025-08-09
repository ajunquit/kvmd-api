package com.ajunquit.kvmd_api.application.auth.dtos.request;

import org.springframework.stereotype.Component;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Component
public class LoginRequest {
  @NotBlank private String username;
  @NotBlank private String password;
}
