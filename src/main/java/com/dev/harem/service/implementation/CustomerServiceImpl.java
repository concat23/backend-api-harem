package com.dev.harem.service.implementation;

import com.dev.harem.entity.Customer;
import com.dev.harem.repository.ICustomerRepository;
import com.dev.harem.service.ICustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Qualifier(value = "mySQLCustomerService")
public class CustomerServiceImpl implements ICustomerService {

    private final ICustomerRepository iCustomerRepository;
    @Override
    public Customer addCustomer(Customer customer) {
        return iCustomerRepository.save(customer);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return iCustomerRepository.findAll();
    }

    @Override
    public Customer findById(Long id) {
        return iCustomerRepository.findById(id).get();
    }

    @Override
    public void updateCustomer(Customer customer) {

    }
}
