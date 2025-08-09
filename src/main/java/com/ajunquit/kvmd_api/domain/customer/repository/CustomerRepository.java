package com.ajunquit.kvmd_api.domain.customer.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ajunquit.kvmd_api.domain.customer.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, UUID> {
  public Optional<Customer> findByRUC(String ruc);
  // public Optional<Customer> create(Customer customer);
  // public Optional<Customer> update(Customer customer);
  // public boolean delete(UUID customerId);
  // public Optional<Customer> findById(UUID customerId);
  // public List<Customer> findAll();
}