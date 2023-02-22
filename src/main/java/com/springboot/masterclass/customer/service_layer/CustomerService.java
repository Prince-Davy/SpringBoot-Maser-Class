package com.springboot.masterclass.customer.service_layer;

import com.springboot.masterclass.customer.dao_layer.Customer;
import com.springboot.masterclass.customer.dao_layer.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private  final CustomerRepo customerRepo;
    @Autowired
    public CustomerService(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }

    public List<Customer> getCustomers() {
        return customerRepo.getCustomers();
    }

    public Customer getCustomer(Long customerId){
        return getCustomers()
                .stream()
                .filter(customer -> customer.getId() == customerId)
                .findFirst()
                .orElseThrow( () -> new IllegalStateException("Customer  with id : " + customerId + " not found"));
    }
}