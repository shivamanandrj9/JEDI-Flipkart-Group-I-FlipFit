package com.flipkart.business;

import com.flipkart.bean.Booking;
import com.flipkart.dao.BookingDao;
import com.flipkart.dao.SlotDao;
import com.flipkart.helper.StringTriplet;

import java.util.List;

public class BookingService implements BookingServiceInterface {

    private static BookingDao bookingDao = new BookingDao();
    private static SlotDao slotDao = new SlotDao();

    @Override
    public void viewAllBookings(String userId) {

        List<Booking> bookingsUser = bookingDao.getUserBookings(userId);

        for (Booking booking : bookingsUser) {
            System.out.print(booking.getBookingID() + " ");
            StringTriplet datetime = slotDao.getSlotTiming(booking.getSlotID());
            System.out.println(datetime.getDate() + datetime.getStarttime() + datetime.getEndtime());
        }
    }

    @Override
    public void cancelBooking(String bookingID) {

    }

}
