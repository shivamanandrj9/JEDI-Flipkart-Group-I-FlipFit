package com.flipkart.exception;

public class SlotsInsufficientException extends Exception{

    static String prefix = "The slot has reached maximum capacity";
    public SlotsInsufficientException() {
        super(prefix);
    }

    public SlotsInsufficientException(String slotTime, String gymName) {
        super(prefix + ":" + gymName + ":" + slotTime);
    }
}
