package com.springboot.masterclass.customer.exception;

public class ApiNotFoundException extends RuntimeException {

    public ApiNotFoundException(String message) {
        super(message);

    }
}
