package com.springboot.masterclass.customer.rest_layer;


import com.springboot.masterclass.customer.dao_layer.Customer;
import com.springboot.masterclass.customer.service_layer.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("test")
    List<Customer> getCustomer() {
        return customerService.getCustomer();
    }
}
