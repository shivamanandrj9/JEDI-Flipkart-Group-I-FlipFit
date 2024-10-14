package com.flipkart.dao;

import com.flipkart.bean.Booking;
import com.flipkart.utils.DbUtils;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookingDao implements BookingDaoInterface {

    public static DbUtils dbUtils = new DbUtils();

    @Override
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

    @Override
    public int bookedSlotCount(String slotId) {
        String sql = "SELECT COUNT(*) AS countSlots FROM Booking WHERE slotID=?";

        try (PreparedStatement pstmt = dbUtils.connection.prepareStatement(sql)) {
            pstmt.setString(1, slotId);
            ResultSet resultSet = pstmt.executeQuery();

            if (resultSet.next()) {
                return resultSet.getInt("countSlots");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public List<Booking> getUserBookings(String userId) {
        List<Booking> bookings = new ArrayList<>();
        String sql = "SELECT * FROM Booking WHERE userID=?";

        try (PreparedStatement statement = dbUtils.connection.prepareStatement(sql)) {
            statement.setString(1, userId);
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

    @Override
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
