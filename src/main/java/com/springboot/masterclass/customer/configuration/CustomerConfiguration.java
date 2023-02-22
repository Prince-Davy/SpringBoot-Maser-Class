package com.springboot.masterclass.customer.configuration;

import com.springboot.masterclass.customer.dao_layer.CustomerFakeRepository;
import com.springboot.masterclass.customer.dao_layer.CustomerRepo;
import com.springboot.masterclass.customer.dao_layer.CustomerRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomerConfiguration {

    @Value("${app.useFakeCustomerRepo:false}")
    private Boolean useFakeCustomerRepo;

    @Bean
    CommandLineRunner commandLineRunner() {
        return args -> {
            System.out.println("Command Line Runner Hooray ");
        };
    }

    @Bean
    CustomerRepo customerRepo() {
        System.out.println("useFakeCustomerRepo " + useFakeCustomerRepo);
        return useFakeCustomerRepo ? new CustomerFakeRepository() :
                new CustomerRepository();
    }
}
