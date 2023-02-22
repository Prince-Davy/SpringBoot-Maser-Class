package com.springboot.masterclass.customer.dao_layer;

import java.util.Arrays;
import java.util.List;

public class CustomerFakeRepository implements CustomerRepo {
    @Override
    public List<Customer> getCustomers() {
        return Arrays.asList(
                new Customer(1L, "John"),
                new Customer(2L, "Marc"),
                new Customer(3L, "Matty"));
    }

    public List<Customer> getCustomer() {
        return null;
    }
}
