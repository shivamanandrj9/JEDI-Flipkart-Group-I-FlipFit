package com.flipkart.business;

import com.flipkart.bean.*;
import com.flipkart.dao.*;
import com.flipkart.exception.UserNoBookingException;
import com.flipkart.helper.StringTriplet;

import java.util.List;

public class BookingService implements BookingServiceInterface {

    private static BookingDao bookingDao = new BookingDao();
    private static SlotDao slotDao = new SlotDao();
    private static GymDao gymDao = new GymDao();

    @Override
    public void viewAllBookings(String userId) {


        System.out.println();
        System.out.println("=== User Bookings ===");
        System.out.printf("%-15s %-25s %-20s %-30s %-10s %-10s %-10s%n",
                "Booking ID", "Gym Name", "City", "Address", "Date", "Start Time", "End Time");
        System.out.println("------------------------------------------------------------------------------------------------------------------------------");

        List<Booking> bookingsUser;

        try {
             bookingsUser = bookingDao.getUserBookings(userId);
        } catch (UserNoBookingException e) {
            System.out.println(e.toString());
            return;
        }


        for (Booking booking : bookingsUser) {
            Slot curr_slot = slotDao.getSlotFromSlotId(booking.getSlotID());
            Gym curr_gym = gymDao.getGymFromGymId(curr_slot.getGymId());

            StringTriplet datetime = slotDao.getSlotTiming(booking.getSlotID());

            System.out.printf("%-15s %-25s %-20s %-30s %-10s %-10s %-10s%n",
                    booking.getBookingID(),
                    curr_gym.getGymName(),
                    curr_gym.getCity(),
                    curr_gym.getAddress(),
                    datetime.getDate(),
                    datetime.getStarttime(),
                    datetime.getEndtime());
        }
        System.out.println();

    }

    @Override
    public void cancelBooking(String bookingID) {

    }

}
