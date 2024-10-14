package com.flipkart.dao;

import com.flipkart.bean.Gym;
import com.flipkart.bean.Slot;
import com.flipkart.helper.StringTriplet;
import com.flipkart.utils.DbUtils;
import com.flipkart.utils.SQLConstants;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SlotDao implements SlotDaoInterface {

    public static DbUtils dbUtils = new DbUtils();

    @Override
    public void addSlot(Slot slot) {

//        String sql = "INSERT INTO Slot (slotID, gymId,date, starttime, endtime, capacity) VALUES (?, ?,?, ?, ?, ?)";

        try (PreparedStatement pstmt = dbUtils.connection.prepareStatement(SQLConstants.INSERT_SLOT)) {

            pstmt.setString(1, slot.getSlotID());
            pstmt.setString(2, slot.getGymId());
            pstmt.setString(3, slot.getDate());
            pstmt.setString(4, slot.getStarttime());
            pstmt.setString(5, slot.getEndtime());
            pstmt.setInt(6, slot.getCapacity());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Slot> getSlots(String gymId, String date) {
        List<Slot> slots = new ArrayList<>();

//        String sql = "SELECT * FROM Slot WHERE gymId = ? AND date=?";

        try (PreparedStatement statement = dbUtils.connection.prepareStatement(SQLConstants.GET_DATE_SLOTS)) {

            statement.setString(1, gymId); // Assuming user.getId() gives the gymOwnerID
            statement.setString(2, date);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String slotId = resultSet.getString("slotId");
                String starttime = resultSet.getString("starttime");
                String endtime = resultSet.getString("endtime");
                int capacity = resultSet.getInt("capacity");
                Slot slot = new Slot(gymId, slotId, date, starttime, endtime, capacity);
                slots.add(slot);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return slots;
    }

    @Override
    public StringTriplet getSlotTiming(String slotId)
    {
//        String sql = "SELECT * FROM Slot WHERE slotID = ?";

        try (PreparedStatement statement = dbUtils.connection.prepareStatement(SQLConstants.GET_SLOT_TIMINGS)) {

            statement.setString(1, slotId); // Assuming user.getId() gives the gymOwnerID
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String starttime = resultSet.getString("starttime");
                String endtime = resultSet.getString("endtime");
                String date = resultSet.getString("date");

                return new StringTriplet(date, starttime, endtime);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public Slot getSlotFromSlotId(String slotId)  {

        String sql = "SELECT * FROM Slot WHERE slotID = ?";

        try (PreparedStatement statement = dbUtils.connection.prepareStatement(sql)) {
            statement.setString(1, slotId);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String slotID = resultSet.getString("slotID");
                String gymId = resultSet.getString("gymId");
                String starttime = resultSet.getString("starttime");
                String endtime = resultSet.getString("endtime");
                int capacity = resultSet.getInt("capacity");
                String date= resultSet.getString("date");
                Slot slot = new Slot(gymId, slotId, date, starttime, endtime, capacity);
                return slot;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public List<Slot> getAllSlotForGym(String gymId) {
        List<Slot> slots = new ArrayList<>();

        String sql = "SELECT * FROM Slot WHERE gymId = ?";

        try (PreparedStatement statement = dbUtils.connection.prepareStatement(sql)) {

            statement.setString(1, gymId); // Assuming user.getId() gives the gymOwnerID
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String slotId = resultSet.getString("slotId");
                String starttime = resultSet.getString("starttime");
                String endtime = resultSet.getString("endtime");
                int capacity = resultSet.getInt("capacity");
                String date= resultSet.getString("date");
                Slot slot = new Slot(gymId, slotId, date, starttime, endtime, capacity);
                slots.add(slot);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return slots;
    }
}
