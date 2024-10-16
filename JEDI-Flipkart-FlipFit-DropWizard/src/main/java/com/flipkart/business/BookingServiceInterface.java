package com.flipkart.business;

import java.util.List;
import java.util.Map;

/**
 * interface for view all existing bookings and option to cancel bookings
 */
public interface BookingServiceInterface {

    /**
     * Prints all existing bookings
     * @param userId ID of user viewing the booking
     */
    List<Map<String, Object>> viewAllBookings(String userId);

    /**
     * Cancel booking with booking ID
     * @param bookingID booking ID of slot to cancel
     */
    void cancelBooking(String bookingID);
}
