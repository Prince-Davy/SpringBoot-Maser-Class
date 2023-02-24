package com.springboot.masterclass.customer.dao_layer;

import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public class CustomerRepository implements CustomerRepo {
    private static final String EMAIL = "email@gmail.com";

    @Override
    public List<Customer> getCustomers() {
        return Arrays.asList(
                new Customer(1L, "Alan", "password123", EMAIL),
                new Customer(2L, "Tobal", "password456", EMAIL),
                new Customer(3L, "Larral", "password789", EMAIL));
    }
}
