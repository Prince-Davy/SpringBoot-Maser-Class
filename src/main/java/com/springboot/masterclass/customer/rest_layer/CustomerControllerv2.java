package com.springboot.masterclass.customer.rest_layer;

import com.springboot.masterclass.customer.dao_layer.Customer;
import com.springboot.masterclass.customer.service_layer.CustomerService;
import com.springboot.masterclass.exception.ApiRequestException;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@Slf4j
@AllArgsConstructor
@RequestMapping(path = "api/v2/customers")
public class CustomerControllerv2 {

    private static final String EMAIL = "email@gmail.com";
    private final CustomerService customerService;

    @GetMapping(value = "list")
    List<Customer> getListCustomers() {
        return Arrays.asList(
                new Customer(0L, "John", "password127896", EMAIL),
                new Customer(1L, "Sophie", "password1973", EMAIL),
                new Customer(2L, "Matty", "password82465", EMAIL),
                new Customer(3L, "Roro", "password127896", EMAIL),
                new Customer(4L, "Bella", "password1973", EMAIL),
                new Customer(5L, "Louve", "password82465", EMAIL));
    }

    @GetMapping(value = "all")
    List<Customer> getCustomers() {
        return customerService.getCustomers();
    }

    @GetMapping("{customerId}")
    public Customer getCustomer(@PathVariable("customerId") Long id) {
        return customerService.getCustomer(id);
    }

    @GetMapping("{customerId}/exception")
    public Customer getCustomerException(@PathVariable("customerId") Long id) {
        throw new ApiRequestException("ApiRequestException for customer " + id);
    }

    @PostMapping
    public void createCustomer(@Valid @RequestBody Customer customer) {
        System.out.println(" POST REQUEST \nCustomer created : " + customer);
    }

    @PutMapping
    public void updateCustomer(@RequestBody Customer customer) {
        System.out.println("PUT request \nCustomer updated : " + customer);
    }

    @DeleteMapping("{customerId}")
    public void deleteCustomer(@PathVariable("customerId") Long customerId) {
        System.out.println("DELETE request \nCustomer with id : " + customerId + " is deleted ");
    }

    @GetMapping("/something")
    public ResponseEntity<String> createLogs() {
        log.warn("Just checking");
        return ResponseEntity.ok().body("All Ok");
    }
}
