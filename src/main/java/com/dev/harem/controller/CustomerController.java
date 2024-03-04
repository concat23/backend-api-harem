package com.dev.harem.controller;


import com.dev.harem.entity.Customer;
import com.dev.harem.service.ICustomerService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

import static org.springframework.web.servlet.support.ServletUriComponentsBuilder.fromCurrentRequest;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    private final ICustomerService iCustomerService;

    public CustomerController(@Qualifier(value = "mySQLCustomerService") ICustomerService iCustomerService) {
        this.iCustomerService = iCustomerService;
    }

    @GetMapping
    public ResponseEntity<List<Customer>> getCustomers(){
        return ResponseEntity.ok(iCustomerService.getAllCustomers());
    }

    @GetMapping("{id}")
    public ResponseEntity<Customer> getCustomer(@PathVariable("id") Long id){
        return ResponseEntity.ok(iCustomerService.findById(id));
    }


    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer){
        customer.setId(iCustomerService.getAllCustomers().size() + 1L);
        return ResponseEntity.created(getLocation(customer.getId())).body(iCustomerService.addCustomer(customer));
    }
    private URI getLocation(Long id) {
        return fromCurrentRequest().path("{id}").buildAndExpand(id).toUri();
    }
}
