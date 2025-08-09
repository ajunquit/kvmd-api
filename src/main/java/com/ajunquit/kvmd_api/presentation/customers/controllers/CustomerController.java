package com.ajunquit.kvmd_api.presentation.customers.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ajunquit.kvmd_api.application.customers.dtos.requests.CustomerRequest;
import com.ajunquit.kvmd_api.application.customers.dtos.responses.CustomerResponse;
import com.ajunquit.kvmd_api.application.customers.services.CustomerAppService;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

  private final CustomerAppService _customerAppService;

  public CustomerController(CustomerAppService customerAppService) {
    _customerAppService = customerAppService;
  }

  @PostMapping
  public ResponseEntity<CustomerResponse> createCustomer(@RequestBody CustomerRequest request) {
    CustomerResponse createdCustomer = _customerAppService.createCustomer(request);
    return new ResponseEntity<>(createdCustomer, HttpStatus.CREATED);
  }

}
