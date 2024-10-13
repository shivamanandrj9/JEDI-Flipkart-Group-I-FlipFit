package com.flipkart.dao;

import com.flipkart.bean.*;
import com.flipkart.utils.DbUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class BookingDao{

    public static DbUtils dbUtils = new DbUtils();



    public void bookSlot(Booking booking) {

        String sql = "INSERT INTO Booking (bookingID, userID, slotID) VALUES (?, ?, ?)";

        try (PreparedStatement pstmt = dbUtils.connection.prepareStatement(sql)) {

            pstmt.setString(1, booking.getBookingID());
            pstmt.setString(2, booking.getUserID());
            pstmt.setString(3, booking.getSlotID());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public int bookedSlotCount(String slotId) {
        String sql = "SELECT COUNT(*) AS countSlots FROM Booking WHERE slotID=?";

        try (PreparedStatement pstmt = dbUtils.connection.prepareStatement(sql)) {
            pstmt.setString(1, slotId);
            System.out.println(pstmt.toString());
            ResultSet resultSet = pstmt.executeQuery();

            if (resultSet.next()) {
                return resultSet.getInt("countSlots"); // Directly return the count
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Consider logging the error instead
        }
        return 0; // Return 0 if there's an issue or no rows
    }



    public List<Booking> getUserBookings(String userId) {
        List<Booking> bookings = new ArrayList<>();
        String sql = "SELECT * FROM Booking WHERE userID=?";

        try (PreparedStatement statement = dbUtils.connection.prepareStatement(sql)) {

            statement.setString(1, userId); // Assuming user.getId() gives the gymOwnerID
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String bookingId = resultSet.getString("bookingID");
                String userID = resultSet.getString("userID");
                String slotID = resultSet.getString("slotID");

                Booking booking = new Booking(bookingId, userID, slotID);
                bookings.add(booking);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return bookings;
    }


    public void deleteSlot(String bookingId) {

        String sql = "DELETE FROM Booking WHERE bookingID=?";

        try (PreparedStatement pstmt = dbUtils.connection.prepareStatement(sql)) {

            pstmt.setString(1, bookingId);


            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
