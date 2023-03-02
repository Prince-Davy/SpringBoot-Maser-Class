package com.springboot.masterclass.customer.service_layer;

import com.springboot.masterclass.customer.dao_layer.Customer;
import com.springboot.masterclass.customer.dao_layer.CustomerRepository;
import com.springboot.masterclass.exception.ApiNotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class CustomerService implements InfoContributor {
    private final CustomerRepository customerRepository;

    public List<Customer> getCustomers() {
        log.info("Getting customers was called");
        return customerRepository.findAll();
    }

    public Customer getCustomer(Long customerId) {

        return customerRepository.findById(customerId)
                .orElseThrow(
                        () -> {
                            ApiNotFoundException apiNotFoundException = new ApiNotFoundException("Customer  with id : " + customerId + " not found !!");
                            log.error("Error getting customer {}", customerId, apiNotFoundException);
                            return apiNotFoundException;
                        });
    }

    @Override
    public void contribute(Info.Builder builder) {
        builder.withDetail("custom-info", "Customer info message");
    }
}