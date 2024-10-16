package com.flipkart.exception;

public class UserNotFoundException extends Exception{

    static String prefix = "Invalid user credentials";
    public UserNotFoundException() {
        super(prefix);
    }

    public UserNotFoundException(String message) {
        super(message);
    }
}
