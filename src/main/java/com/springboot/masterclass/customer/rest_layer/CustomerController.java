package com.springboot.masterclass.customer.rest_layer;


import com.springboot.masterclass.customer.dao_layer.Customer;
import com.springboot.masterclass.customer.service_layer.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/customers")
@Deprecated(since = "v1")
public class CustomerController {

    final static Logger logger = LoggerFactory.getLogger(CustomerControllerv2.class);
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
        logger.info("POST request");
        logger.info("Customer created : " + customer);
    }

    @PutMapping
    public void updateCustomer(@RequestBody Customer customer) {
        logger.info("PUT request");
        logger.info("Customer updated : " + customer);
    }

    @DeleteMapping("{customerId}")
    public void deleteCustomer(@PathVariable("customerId") Long customerId) {
        logger.info("DELETE request");
        logger.info("Customer with id : " + customerId + " is deleted ");
    }
}
