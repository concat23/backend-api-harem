package com.dev.harem.service;

import com.dev.harem.entity.Customer;

import java.util.List;

public interface ICustomerService {
    Customer addCustomer(Customer customer);
    List<Customer> getAllCustomers();
    Customer findById(Long id);

    void updateCustomer(Customer customer);
}
