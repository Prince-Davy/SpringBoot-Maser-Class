package com.springboot.masterclass.customer.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomerConfiguration {

    @Value("${app.useFakeCustomerRepo:false}")
    private Boolean useFakeCustomerRepo;

//    @Bean
//    CommandLineRunner commandLineRunner() {
//        return args -> {
//            System.out.println("Command Line Runner Hooray ");
//        };
//    }
//
//    @Bean
//    CustomerRepo customerRepo() {
//        System.out.println("useFakeCustomerRepo " + useFakeCustomerRepo);
//        return new CustomerFakeRepository();
//    }
}
