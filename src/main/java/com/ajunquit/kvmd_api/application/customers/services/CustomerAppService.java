package com.ajunquit.kvmd_api.application.customers.services;

import org.springframework.stereotype.Service;

import com.ajunquit.kvmd_api.application.customers.dtos.requests.CustomerRequest;
import com.ajunquit.kvmd_api.application.customers.dtos.responses.CustomerResponse;
import com.ajunquit.kvmd_api.application.customers.helper.CustomerHelper;
import com.ajunquit.kvmd_api.application.customers.mappers.CustomerMapper;
import com.ajunquit.kvmd_api.domain.customer.entity.Customer;
import com.ajunquit.kvmd_api.domain.customer.repository.CustomerRepository;

@Service
public class CustomerAppService {
  
  private final CustomerRepository _customerRepository;

  public CustomerAppService(CustomerRepository customerRepository ) {
    _customerRepository = customerRepository;
  }

  public CustomerResponse createCustomer(CustomerRequest customerRequest) {
    Customer customer = CustomerMapper.toEntity(customerRequest);
    CustomerHelper.setAuditFields(customer, "root");
    CustomerHelper.setId(customer);
    return CustomerMapper.toResponse(_customerRepository.save(customer));
  }
}
