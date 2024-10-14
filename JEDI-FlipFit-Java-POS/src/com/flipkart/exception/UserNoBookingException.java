package com.flipkart.exception;

public class UserNoBookingException extends Exception{

    static String prefix = "No booking available for the current user";
    public UserNoBookingException() {
        super(prefix);
    }

    public UserNoBookingException(String uname) {
        super(prefix + ":" + uname);
    }
}
