package com.priya.sample.demo.exception;

public class BadCustomerException extends RuntimeException {
    public BadCustomerException(String message) {
        super(message);
    }
}