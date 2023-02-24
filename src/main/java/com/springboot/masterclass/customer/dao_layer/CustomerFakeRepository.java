package com.springboot.masterclass.customer.dao_layer;

import java.util.Arrays;
import java.util.List;

public class CustomerFakeRepository implements CustomerRepo {
    @Override
    public List<Customer> getCustomers() {
        return Arrays.asList(
                new Customer(1L, "John", "password127896", "email@gmail.com"),
                new Customer(2L, "Sophie", "password1973", "email@gmail.com"),
                new Customer(3L, "Matty", "password82465", "email@gmail.com"));
    }

    public List<Customer> getCustomer() {
        return null;
    }
}
