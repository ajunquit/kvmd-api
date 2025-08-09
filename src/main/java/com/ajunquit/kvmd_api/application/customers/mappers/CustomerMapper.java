package com.ajunquit.kvmd_api.application.customers.mappers;

import com.ajunquit.kvmd_api.application.customers.dtos.requests.CustomerRequest;
import com.ajunquit.kvmd_api.application.customers.dtos.responses.CustomerResponse;
import com.ajunquit.kvmd_api.domain.customer.entity.Customer;

public class CustomerMapper {
  public static Customer toEntity(CustomerRequest request) {
    Customer customer = new Customer();
    customer.setFirstName(request.getFirstName());
    customer.setLastName(request.getLastName());
    customer.setEmail(request.getEmail());
    customer.setPhone(request.getPhone());
    customer.setAddress(request.getAddress());
    customer.setRUC(request.getRuc());
    return customer;
  }

  public static CustomerResponse toResponse(Customer customer) {
    CustomerResponse response = new CustomerResponse();
    response.setId(customer.getId());
    response.setFirstName(customer.getFirstName());
    response.setLastName(customer.getLastName());
    response.setEmail(customer.getEmail());
    response.setPhone(customer.getPhone());
    response.setAddress(customer.getAddress());
    response.setRuc(customer.getRUC());
    return response;
  }
}
