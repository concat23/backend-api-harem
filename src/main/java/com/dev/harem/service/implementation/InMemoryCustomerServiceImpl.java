package com.dev.harem.service.implementation;

import com.dev.harem.entity.Customer;
import com.dev.harem.repository.InMemoryCustomerRepository;
import com.dev.harem.service.ICustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
@Qualifier(value = "inMemoryCustomerService")
public class InMemoryCustomerServiceImpl implements ICustomerService {
    private final InMemoryCustomerRepository inMemoryCustomerRepository;
    @Override
    public Customer addCustomer(Customer customer) {
       return inMemoryCustomerRepository.addCustomer(customer);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return  inMemoryCustomerRepository.getAllCustomers();
    }

    @Override
    public Customer findById(Long id) {
        return inMemoryCustomerRepository.findById(id);
    }

    @Override
    public void updateCustomer(Customer customer) {

    }
}
