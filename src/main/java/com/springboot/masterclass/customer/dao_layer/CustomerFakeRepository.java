package com.springboot.masterclass.customer.dao_layer;

import java.util.Arrays;
import java.util.List;

public class CustomerFakeRepository implements CustomerRepo {
    private static final String EMAIL = "email@gmail.com";

    @Override
    public List<Customer> getCustomers() {
        return Arrays.asList(
                new Customer(1L, "John", "password127896", EMAIL),
                new Customer(2L, "Sophie", "password1973", EMAIL),
                new Customer(3L, "Matty", "password82465", EMAIL));
    }
}
