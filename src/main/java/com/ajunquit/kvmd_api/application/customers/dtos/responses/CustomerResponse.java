package com.ajunquit.kvmd_api.application.customers.dtos.responses;

import java.util.UUID;

import org.springframework.stereotype.Component;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Component
@Data
public class CustomerResponse {

  private UUID id;

  @Size(min = 2, max = 50, message = "First name should be between 2 and 50 characters")
  private String firstName;

  @Size(min = 2, max = 50, message = "Last name should be between 2 and 50 characters")
  private String lastName;

  @Email(message = "Invalid email format", regexp = ".+@.+\\..+")
  private String email;

  @Size(max = 15, message = "Phone number should be no longer than 15 characters")
  private String phone;

  @Size(max = 13, message = "RUC should be no longer than 13 characters")
  private String ruc;

  private String address;
}
