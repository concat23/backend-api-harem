package com.dev.harem.repository;

import com.dev.harem.entity.Customer;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
public class InMemoryCustomerRepository {
    private static final List<Customer> DATABASE_INIT = new ArrayList<>();

    static {
        DATABASE_INIT.add(new Customer(1L,"Bang","Vo Anh","bang@gmail.com","01113456789"));
        DATABASE_INIT.add(new Customer(2L,"Han","Truong Gia","han@gmail.com","02223456789"));
        DATABASE_INIT.add(new Customer(3L,"Ha","Tran Khanh","ha@gmail.com","0333456789"));
        DATABASE_INIT.add(new Customer(4L,"Dao","Dao Phuong Anh","dao@gmail.com","0444456789"));
        DATABASE_INIT.add(new Customer(5L,"Mai","Mai Thi Anh","mai@gmail.com","0555556789"));
    }

    public Customer addCustomer(Customer customer){
      DATABASE_INIT.add(customer);
      return customer;
    }

    public List<Customer> getAllCustomers(){
        return List.copyOf(DATABASE_INIT);
    }
    public Customer findById(Long id){
        return DATABASE_INIT.stream().filter(customer ->id.equals(customer.getId()))
                .findFirst()
                .orElseThrow();
    }

    void updateCustomer(Customer customer){

    }
}
