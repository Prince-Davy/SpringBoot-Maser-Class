package com.springboot.masterclass.customer.rest_layer;


import com.springboot.masterclass.customer.dao_layer.Customer;
import com.springboot.masterclass.customer.service_layer.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(path = "api/v2/customer")
public class CustomerControllerv2 {

    private final CustomerService customerService;

    @Autowired
    public CustomerControllerv2(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping(value = "all")
    List<Customer> getCustomers() {
        return Arrays.asList(
                new Customer(0L, "John", "password127896"),
                new Customer(1L, "Sophie", "password1973"),
                new Customer(2L, "Matty", "password82465"),
                new Customer(3L, "Roro", "password127896"),
                new Customer(4L, "Bella", "password1973"),
                new Customer(5L, "Louve", "password82465"));
    }

    @GetMapping("{customerId}")
    public Customer getCustomer(@PathVariable("customerId") Long id) {
        return customerService.getCustomer(id);
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
