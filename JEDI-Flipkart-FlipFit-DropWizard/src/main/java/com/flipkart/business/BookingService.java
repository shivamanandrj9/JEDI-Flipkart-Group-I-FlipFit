package com.flipkart.business;

import com.flipkart.bean.*;
import com.flipkart.dao.*;
import com.flipkart.helper.StringTriplet;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class BookingService implements BookingServiceInterface {

    private static BookingDao bookingDao = new BookingDao();
    private static SlotDao slotDao = new SlotDao();
    private static GymDao gymDao = new GymDao();

    @Override
    public List<Map<String, Object>> viewAllBookings(String userId) {

        List<Booking> bookingsUser = bookingDao.getUserBookings(userId);
        List<Map<String, Object>> bookingList = new ArrayList<>();

        if (bookingsUser.isEmpty()) {
            // Return an empty list if no bookings are found
            return bookingList;
        }

        for (Booking booking : bookingsUser) {
            Slot curr_slot = slotDao.getSlotFromSlotId(booking.getSlotID());
            Gym curr_gym = gymDao.getGymFromGymId(curr_slot.getGymId());
            StringTriplet datetime = slotDao.getSlotTiming(booking.getSlotID());

            // Create a map for each booking
            Map<String, Object> bookingDetails = new HashMap<>();
            bookingDetails.put("BookingID", booking.getBookingID());
            bookingDetails.put("GymName", curr_gym.getGymName());
            bookingDetails.put("City", curr_gym.getCity());
            bookingDetails.put("Address", curr_gym.getAddress());
            bookingDetails.put("Date", datetime.getDate());
            bookingDetails.put("StartTime", convertTo12HourFormat(datetime.getStarttime()));
            bookingDetails.put("EndTime", convertTo12HourFormat(datetime.getEndtime()));

            // Add booking details to the list
            bookingList.add(bookingDetails);
        }

        return bookingList;
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
