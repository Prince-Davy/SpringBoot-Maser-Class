package com.springboot.masterclass.customer.service_layer;

import com.springboot.masterclass.customer.dao_layer.Customer;
import com.springboot.masterclass.customer.dao_layer.CustomerRepository;
import com.springboot.masterclass.exception.ApiNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements InfoContributor {

    private final static Logger LOGGER = LoggerFactory.getLogger(CustomerService.class);

    private  final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> getCustomers() {
        LOGGER.info("Getting customers was called");
        return customerRepository.findAll();
    }

    public Customer getCustomer(Long customerId){

        return customerRepository.findById(customerId)
                .orElseThrow(
                        () -> {
                            ApiNotFoundException apiNotFoundException = new ApiNotFoundException("Customer  with id : " + customerId + " not found !!");
                            LOGGER.error("Error getting customer {}", customerId, apiNotFoundException);
                            return apiNotFoundException;
                        });
    }

    @Override
    public void contribute(Info.Builder builder) {
        builder.withDetail("custom-info", "Customer info message");
    }
}