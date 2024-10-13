package com.flipkart.bean;

public class Booking {

    private String bookingID;
    private String userID;
    private String slotID;

    public Booking(String bookingID, String userID, String slotID) {
        this.userID = userID;
        this.bookingID = bookingID;
        this.slotID = slotID;
    }

    public String getBookingID() {
        return bookingID;
    }

    public void setBookingID(String bookingID) {
        this.bookingID = bookingID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getSlotID() {
        return slotID;
    }

    public void setSlotID(String slotID) {
        this.slotID = slotID;
    }

}
