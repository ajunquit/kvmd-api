package com.ajunquit.kvmd_api.application.customers.dtos.requests;

import org.springframework.stereotype.Component;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Component
@Data
public class CustomerRequest {
  @NotEmpty(message = "First name is required")
  @Size(min = 2, max = 50, message = "First name should be between 2 and 50 characters")
  private String firstName;

  @NotEmpty(message = "Last name is required")
  @Size(min = 2, max = 50, message = "Last name should be between 2 and 50 characters")
  private String lastName;

  @NotEmpty(message = "Email is required")
  @Email(message = "Invalid email format")
  private String email;

  @Size(max = 15, message = "Phone number should be no longer than 15 characters")
  private String phone;

  @Size(max = 13, message = "RUC should be no longer than 13 characters")
  private String ruc;

  private String address;
}
