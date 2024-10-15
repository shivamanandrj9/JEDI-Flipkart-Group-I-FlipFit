package com.flipkart.bean;
/**
 * Represents a booking in the FlipFit system.
 * A booking links a user to a specific schedule.
 */
public class Booking {

    private String bookingID;
    private String userID;
    private String slotID;

    /**
     * Parameterized constructor to create a new booking.
     * @param userID ID of the user making the booking
     * @param bookingID ID of the booking
     * @param slotID ID of the slot being booked
     */
    public Booking(String bookingID, String userID, String slotID) {
        this.userID = userID;
        this.bookingID = bookingID;
        this.slotID = slotID;
    }

    /**
     * Retrieves booking ID for a particular booking (Getter Function)
     * @return bookingID for the particular booking
     */
    public String getBookingID() {
        return bookingID;
    }

    /**
     * Sets bookingID for a particular booking (Setter function)
     * @param bookingID ID of the booking
     */
    public void setBookingID(String bookingID) {
        this.bookingID = bookingID;
    }

    /**
     * Retrieves userID for a particular user doing the booking (Getter Function)
     * @return userID for the user doing the booking
     */
    public String getUserID() {
        return userID;
    }

    /**
     * Sets userID for a particular booking (Setter function)
     * @param userID ID of the user completing the booking
     */
    public void setUserID(String userID) {
        this.userID = userID;
    }

    /**
     * Retrieves slotID for a particular slot in a booking (Getter Function)
     * @return slotID for the slot in the booking
     */
    public String getSlotID() {
        return slotID;
    }

    /**
     * Sets slotID for a particular booking (Setter function)
     * @param slotID ID of slot in the booking
     */
    public void setSlotID(String slotID) {
        this.slotID = slotID;
    }

}
