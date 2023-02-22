package com.springboot.masterclass.customer.dao_layer;

import java.util.Arrays;
import java.util.List;

public class CustomerFakeRepository implements CustomerRepo {
    @Override
    public List<Customer> getCustomers() {
        return Arrays.asList(
                new Customer(1L, "John", "password127896"),
                new Customer(2L, "Sophie", "password1973"),
                new Customer(3L, "Matty", "password82465"));
    }

    public List<Customer> getCustomer() {
        return null;
    }
}
