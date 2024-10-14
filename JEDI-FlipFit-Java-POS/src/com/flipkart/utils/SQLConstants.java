package com.flipkart.utils;

public class SQLConstants {

    /**
     * USER related SQL Queries
     * */
    public static String INSERT_USER = "INSERT INTO User (userId, username, password, name, email, phone, age, roleId) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    public static String GET_USER =  "SELECT * FROM User WHERE username = ? AND password = ?";
    /**
     * GYM related SQL Queries
     * */
    public static String INSERT_GYM = "INSERT INTO Gym (gymId, gymName, address, city, gymOwnerId, listed) VALUES (?, ?, ?, ?, ?, ?)";
    public static String GET_OWNER_GYMS =  "SELECT * FROM Gym WHERE gymOwnerID = ?";;
    public static String GET_ALL_GYMS = "SELECT * FROM Gym";

    /**
     * ADMIN GYM LISTING and UNLISTING SQL Queries
     * */
    public static String LIST_GYM = "UPDATE Gym SET listed = 1 WHERE gymId = (?)";
    public static String UNLIST_GYM = "UPDATE Gym SET listed = 0 WHERE gymId = (?)";

    /**
     * GYM SLOT related SQL Queries
     * */
    public static String INSERT_SLOT = "INSERT INTO Slot (slotID, gymId,date, starttime, endtime, capacity) VALUES (?, ?,?, ?, ?, ?)";
    public static String GET_DATE_SLOTS = "SELECT * FROM Slot WHERE gymId = ? AND date=?";
    public static String GET_SLOT_TIMINGS = "SELECT * FROM Slot WHERE slotID = ?";


    /**
     * USER BOOKING related SQL Queries
     * */
    public static String INSERT_BOOKING_SLOT = "INSERT INTO Booking (bookingID, userID, slotID) VALUES (?, ?, ?)";
    public static String GET_BOOKING_SLOT_COUNT = "SELECT COUNT(*) AS countSlots FROM Booking WHERE slotID=?";
    public static String GET_USER_BOOKINGS = "SELECT * FROM Booking WHERE userID=?";
    public static String DELETE_USER_BOOKING = "DELETE FROM Booking WHERE bookingID=?";
}
