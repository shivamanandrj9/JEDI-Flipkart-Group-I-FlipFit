package com.flipkart.dao;

import com.flipkart.bean.Gym;
import com.flipkart.utils.DbUtils;
import com.flipkart.utils.SQLConstants;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GymDao implements GymDaoInterface {

    public static DbUtils dbUtils = new DbUtils();

    @Override
    public void addGym(Gym gym) {

//        String sql = "INSERT INTO Gym (gymId, gymName, address, city, gymOwnerId, listed) VALUES (?, ?, ?, ?, ?, ?)";

        try (PreparedStatement pstmt = dbUtils.connection.prepareStatement(SQLConstants.INSERT_GYM)) {

            pstmt.setString(1, gym.getGymId());
            pstmt.setString(2, gym.getGymName());
            pstmt.setString(3, gym.getAddress());
            pstmt.setString(4, gym.getCity());
            pstmt.setString(5, gym.getGymOwnerID());
            pstmt.setBoolean(6, gym.getIsListed());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Gym> getGymCenters(String userId) {
        List<Gym> gymCenters = new ArrayList<>();
//        String sql = "SELECT * FROM Gym WHERE gymOwnerID = ?";


        try (PreparedStatement statement = dbUtils.connection.prepareStatement(SQLConstants.GET_OWNER_GYMS)) {

            statement.setString(1, userId); // Assuming user.getId() gives the gymOwnerID

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String gymId = resultSet.getString("gymId");
                String gymName = resultSet.getString("gymName");
                String address = resultSet.getString("address");
                String city = resultSet.getString("city");
                String gymOwnerID = resultSet.getString("gymOwnerID");
                boolean listed = resultSet.getBoolean("listed");
                Gym gym = new Gym(gymId, gymName, address, city, gymOwnerID, listed);
                gymCenters.add(gym);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return gymCenters;
    }

    @Override
    public List<Gym> getAllGymCenters() {
        List<Gym> gymCenters = new ArrayList<>();
//        String sql = "SELECT * FROM Gym";


        try (PreparedStatement statement = dbUtils.connection.prepareStatement(SQLConstants.GET_ALL_GYMS)) {

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String gymId = resultSet.getString("gymId");
                String gymName = resultSet.getString("gymName");
                String address = resultSet.getString("address");
                String city = resultSet.getString("city");
                String gymOwnerID = resultSet.getString("gymOwnerID");
                boolean listed = resultSet.getBoolean("listed");
                Gym gym = new Gym(gymId, gymName, address, city, gymOwnerID, listed);
                gymCenters.add(gym);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return gymCenters;
    }

    @Override
    public void listGym(String gymId) {

//        String sql = "UPDATE Gym SET listed = 1 WHERE gymId = (?)";

        try (PreparedStatement pstmt = dbUtils.connection.prepareStatement(SQLConstants.LIST_GYM)) {

            pstmt.setString(1, gymId);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }


        System.out.println();
        System.out.println("------Listed " + gymId + " on platform ------");
        System.out.println();



    }

    @Override
    public void unlistGym(String gymId) {


//        String sql = "UPDATE Gym SET listed = 0 WHERE gymId = (?)";

        try (PreparedStatement pstmt = dbUtils.connection.prepareStatement(SQLConstants.UNLIST_GYM)) {

            pstmt.setString(1, gymId);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println();
        System.out.println("------Unlisted " + gymId + " on platform ------");
        System.out.println();




    }
}
