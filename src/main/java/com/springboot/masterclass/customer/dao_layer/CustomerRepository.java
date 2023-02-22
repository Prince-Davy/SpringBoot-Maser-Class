package com.springboot.masterclass.customer.dao_layer;

import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public class CustomerRepository implements CustomerRepo {
    //TODO Connect to DB

    @Override
    public List<Customer> getCustomers() {
        return Arrays.asList(
                new Customer(1L, "Alan","password123"),
                new Customer(2L, "Tobal" , "password456"),
                new Customer(3L, "Larral", "password789"));
    }
}
