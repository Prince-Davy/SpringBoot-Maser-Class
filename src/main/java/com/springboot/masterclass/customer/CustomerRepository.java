package com.springboot.masterclass.customer;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
@Primary
public class CustomerRepository implements CustomerRepo {
    //TODO Connect to DB
    @Override
    public List<Customer> getCustomers() {
        return Arrays.asList(
                new Customer(1L, "John"),
                new Customer(2L, "Marc"),
                new Customer(3L, "Matty"));
    }
}
