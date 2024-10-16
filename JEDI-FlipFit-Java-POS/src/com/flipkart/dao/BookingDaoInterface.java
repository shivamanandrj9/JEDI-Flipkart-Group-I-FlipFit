package com.flipkart.dao;

import com.flipkart.bean.Booking;

import java.util.List;

/**
 *
 * Interface for booking-related data operations.
 * Defines the methods required for booking management, such as creating bookings,
 * counting slot bookings, retrieving user bookings, and deleting bookings.
 * @author bharadwaj
 */
public interface BookingDaoInterface {

    /**
     * Books a slot by creating a new booking entry in the database.
     * @param booking The {@link Booking} object containing the booking details such as booking ID, user ID, and slot ID.
     */
    public void bookSlot(Booking booking);

    /**
     * Retrieves the total count of bookings for a specific slot.
     *
     * @param slotId The ID of the slot for which the booking count is needed.
     * @return The number of bookings for the specified slot.
     */
    public int bookedSlotCount(String slotId);

    /**
     * Retrieves a list of bookings made by a specific user.
     *
     * @param userId The ID of the user whose bookings are to be fetched.
     * @return A list of {@link Booking} objects representing the bookings made by the user.
     */
    public List<Booking> getUserBookings(String userId);

    /**
     * Deletes a specific booking from the database based on the booking ID.
     * @param bookingId The ID of the booking to be deleted.
     */
    public void deleteSlot(String bookingId);
}
