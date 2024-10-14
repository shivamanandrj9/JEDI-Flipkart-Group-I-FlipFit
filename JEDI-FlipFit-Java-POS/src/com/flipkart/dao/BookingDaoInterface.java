package com.flipkart.dao;

import com.flipkart.bean.Booking;

import java.util.List;

public interface BookingDaoInterface {
    public void bookSlot(Booking booking);
    public int bookedSlotCount(String slotId);
    public List<Booking> getUserBookings(String userId);
    public void deleteSlot(String bookingId);
}
