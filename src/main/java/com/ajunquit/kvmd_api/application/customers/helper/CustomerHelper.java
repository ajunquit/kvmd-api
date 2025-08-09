package com.ajunquit.kvmd_api.application.customers.helper;

import java.time.Instant;
import java.util.UUID;

import com.ajunquit.kvmd_api.domain.customer.entity.Customer;

public class CustomerHelper {

  public static void setAuditFields(Customer customer, String user) {
    customer.setCreatedAt(Instant.now());
    customer.setCreatedBy(user);
    customer.setUpdatedAt(Instant.now());
    customer.setUpdatedBy(user);
    customer.setActiveRecord(true);
  }

  public static void setId(Customer customer) {
    customer.setId(UUID.randomUUID());
  }

}
