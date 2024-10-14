package com.flipkart.exception;

public class SlotInvalidTimeException extends Exception {

    static String prefix = "The entered time slot is invalid:";
    // Default constructor
    public SlotInvalidTimeException() {
        super(prefix);
    }

    // Constructor that accepts a custom message
    public SlotInvalidTimeException(String slotTime) {
        super(prefix + slotTime);
    }

    // Constructor that accepts a cause
    public SlotInvalidTimeException(Throwable cause) {
        super(cause);
    }

    // Constructor that accepts both a message and a cause
    public SlotInvalidTimeException(String message, Throwable cause) {
        super(message, cause);
    }
}


