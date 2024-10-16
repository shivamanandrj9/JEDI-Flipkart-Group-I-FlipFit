package com.flipkart.exception;

public class UserAlreadyExistsException extends Exception {

    static String prefix = "User already exists:";
    // Default constructor
    public UserAlreadyExistsException() {
        super(prefix);
    }

    // Constructor that accepts a custom message
    public UserAlreadyExistsException(String uname) {
        super(prefix + uname);
    }

    // Constructor that accepts a cause
    public UserAlreadyExistsException(Throwable cause) {
        super(cause);
    }

    // Constructor that accepts both a message and a cause
    public UserAlreadyExistsException(String message, Throwable cause) {
        super(message, cause);
    }
}


