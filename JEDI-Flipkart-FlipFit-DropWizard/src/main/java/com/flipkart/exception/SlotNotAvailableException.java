package com.flipkart.exception;

public class SlotNotAvailableException extends Exception {

    static String prefix = "The requested time slot is not available.";
    // Default constructor
    public SlotNotAvailableException() {
        super(prefix);
    }

    // Constructor that accepts a custom message
    public SlotNotAvailableException(String slotTime) {
        super(prefix + ":" + slotTime);
    }

    // Constructor that accepts a cause
    public SlotNotAvailableException(Throwable cause) {
        super(cause);
    }

    // Constructor that accepts both a message and a cause
    public SlotNotAvailableException(String message, Throwable cause) {
        super(message, cause);
    }
}


