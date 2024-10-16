package com.flipkart.business;

/**
 *
 * interface for view all existing bookings and option to cancel bookings
 * @author arpit shrivastava
 */
public interface BookingServiceInterface {

    /**
     * Prints all existing bookings
     * @param userId ID of user viewing the booking
     */
    void viewAllBookings(String userId);

    /**
     * Cancel booking with booking ID
     * @param bookingID booking ID of slot to cancel
     */
    void cancelBooking(String bookingID);
}
