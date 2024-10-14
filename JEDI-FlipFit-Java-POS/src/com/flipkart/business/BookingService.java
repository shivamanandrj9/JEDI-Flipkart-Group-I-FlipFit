package com.flipkart.business;

import com.flipkart.bean.*;
import com.flipkart.dao.*;
import com.flipkart.helper.StringTriplet;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
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


             bookingsUser = bookingDao.getUserBookings(userId);



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
                    convertTo12HourFormat(datetime.getStarttime()),
                    convertTo12HourFormat(datetime.getEndtime()));
        }
        System.out.println();

    }

    @Override
    public void cancelBooking(String bookingID) {

    }

    public static String convertTo12HourFormat(String time24) {
        // Ensure the input is in the correct format
        if (time24.length() != 4) {
            throw new IllegalArgumentException("Time must be in the format HHMM (e.g., 1430).");
        }

        // Parse the hours and minutes
        int hour = Integer.parseInt(time24.substring(0, 2));
        int minute = Integer.parseInt(time24.substring(2, 4));

        // Create a LocalTime object
        LocalTime time = LocalTime.of(hour, minute);

        // Define a formatter for 12-hour format
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("h:mm a");

        // Format the LocalTime to the desired 12-hour format string
        return time.format(formatter);
    }
}
