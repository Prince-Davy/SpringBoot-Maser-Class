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

    public List<Customer> getCustomer() {
        return customerRepo.getCustomers();
    }
}
