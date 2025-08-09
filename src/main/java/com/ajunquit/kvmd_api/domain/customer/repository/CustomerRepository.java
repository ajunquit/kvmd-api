package com.ajunquit.kvmd_api.domain.customer.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.ajunquit.kvmd_api.domain.customer.entity.Customer;

public interface CustomerRepository{
  public Optional<Customer> create(Customer customer);
  public Optional<Customer> update(Customer customer);
  public boolean delete(UUID customerId);
  public Optional<Customer> findById(UUID customerId);
  public List<Customer> findAll();
}