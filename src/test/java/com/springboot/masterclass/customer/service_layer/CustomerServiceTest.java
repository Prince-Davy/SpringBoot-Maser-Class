package com.springboot.masterclass.customer.service_layer;

import com.springboot.masterclass.customer.dao_layer.Customer;
import com.springboot.masterclass.customer.dao_layer.CustomerRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
class CustomerServiceTest {

    private CustomerService  serviceUnderTest;

    @Autowired
    private CustomerRepository customerRepository;

    @BeforeEach
    void setUp() {
        serviceUnderTest = new CustomerService(customerRepository);
    }

    @AfterEach
    void tearDown() {
        customerRepository.deleteAll();
    }

    @Test
    void getCustomers() {
        //Given
        Customer patrick = new Customer(1L,"Patrick","010203","patrick@gmail.com");
        Customer ali = new Customer(2L,"Ali","654125","ali@gmail.com");

        customerRepository.saveAll(Arrays.asList(patrick,ali));

        //When
        List<Customer> customerList = serviceUnderTest.getCustomers();
        //then
        assertEquals(2,customerList.size());
    }

    @Test
    void getCustomer() {
        //Given
        Customer patrick = new Customer(1L,"Patrick","010203","patrick@gmail.com");
        customerRepository.save(patrick);
        //When
        Customer customerActual = serviceUnderTest.getCustomer(1L);

        //Then
        assertEquals(1L, customerActual.getId());
        assertEquals("Patrick", customerActual.getName());
        assertEquals("010203", customerActual.getPassword());
        assertEquals("patrick@gmail.com", customerActual.getEmail());
    }

    @Test
    void contribute() {
    }
}