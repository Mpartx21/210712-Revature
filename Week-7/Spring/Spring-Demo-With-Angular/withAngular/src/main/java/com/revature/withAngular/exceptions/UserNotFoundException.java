package com.revature.withAngular.exceptions;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String message) {
    super(message);
    }
}
