package com.springboot.masterclass.customer.rest_layer;


import com.springboot.masterclass.customer.dao_layer.Customer;
import com.springboot.masterclass.customer.service_layer.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/customers")
@Deprecated
public class CustomerController {

    private final CustomerService customerService;
    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    List<Customer> getCustomers() {
        return customerService.getCustomers();
    }

    @PostMapping
    public void createCustomer(@RequestBody Customer customer) {
        System.out.println("POST request");
        System.out.println("Customer created : " + customer);
    }

    @PutMapping
    public void updateCustomer(@RequestBody Customer customer) {
        System.out.println("PUT request");
        System.out.println("Customer updated : " + customer);
    }

    @DeleteMapping("{customerId}")
    public void deleteCustomer(@PathVariable("customerId") Long customerId) {
        System.out.println("DELETE request");
        System.out.println("Customer with id : " + customerId + " is deleted ");
    }

}
