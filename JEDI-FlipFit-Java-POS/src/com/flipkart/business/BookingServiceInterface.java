package com.flipkart.business;

public interface BookingServiceInterface {
    void viewAllBookings(String userId);

    void cancelBooking(String bookingID);
}
