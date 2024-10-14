package com.flipkart.dao;

import com.flipkart.bean.*;
import com.flipkart.utils.DbUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GymDao{

    public static DbUtils dbUtils = new DbUtils();

    public void addGym(Gym gym) {

        String sql = "INSERT INTO Gym (gymId, gymName, address, city, gymOwnerId, listed) VALUES (?, ?, ?, ?, ?, ?)";

        try (PreparedStatement pstmt = dbUtils.connection.prepareStatement(sql)) {

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

    public List<Gym> getGymCenters(String userId) {
        List<Gym> gymCenters = new ArrayList<>();
        String sql = "SELECT * FROM Gym WHERE gymOwnerID = ?";

        try (PreparedStatement statement = dbUtils.connection.prepareStatement(sql)) {

            statement.setString(1, userId); // Assuming user.getId() gives the gymOwnerID

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String gymId = resultSet.getString("gymId");
                String gymName = resultSet.getString("gymName");
                String address = resultSet.getString("address");
                String city = resultSet.getString("city");
                String gymOwnerID = resultSet.getString("gymOwnerID");
                boolean listed = resultSet.getBoolean("listed");
                Gym gym = new Gym(gymId, gymName, address, city, gymOwnerID,listed);
                gymCenters.add(gym);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return gymCenters;
    }

    public List<Gym> getAllGymCenters() {
        List<Gym> gymCenters = new ArrayList<>();
        String sql = "SELECT * FROM Gym";

        try (PreparedStatement statement = dbUtils.connection.prepareStatement(sql)) {

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String gymId = resultSet.getString("gymId");
                String gymName = resultSet.getString("gymName");
                String address = resultSet.getString("address");
                String city = resultSet.getString("city");
                String gymOwnerID = resultSet.getString("gymOwnerID");
                boolean listed = resultSet.getBoolean("listed");
                Gym gym = new Gym(gymId, gymName, address, city, gymOwnerID,listed);
                gymCenters.add(gym);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return gymCenters;
    }


    public void listGym(String gymId) {

        String sql = "UPDATE Gym SET listed = 1 WHERE gymId = (?)";

        try (PreparedStatement pstmt = dbUtils.connection.prepareStatement(sql)) {

            pstmt.setString(1, gymId);

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();

        }

        System.out.println();
        System.out.println("------Listed " + gymId + " on platform ------");
        System.out.println();


    }

    public void unlistGym(String gymId) {

        String sql = "UPDATE Gym SET listed = 0 WHERE gymId = (?)";

        try (PreparedStatement pstmt = dbUtils.connection.prepareStatement(sql)) {

            pstmt.setString(1, gymId);

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();

        }
        System.out.println();
        System.out.println("------Unlisted " + gymId + " on platform ------");
        System.out.println();



    }


//    public User validateUser(String username, String password) {
//        String sql = "SELECT * FROM User WHERE username = ? AND password = ?";
//        try (PreparedStatement statement = dbUtils.connection.prepareStatement(sql)) {
//            statement.setString(1, username);
//            statement.setString(2, password);
//            ResultSet rs = statement.executeQuery();
//            if (rs.next()) {
//                return new User(rs.getString("userId"),rs.getString("username"), rs.getString("password"), rs.getString("name"), rs.getString("email"), rs.getString("phone"), rs.getInt("age"), rs.getString("roleId"));
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//    @Override
//    public boolean updateUser(User user) {
//        String sql = "UPDATE user SET username = ?, password = ? WHERE userid = ?";
//        try (Connection conn = dbutils.getConnection();
//             PreparedStatement ps = conn.prepareStatement(sql)) {
//            ps.setString(1, user.getUsername());
//            ps.setString(2, user.getPassword());
//            ps.setString(3, user.getUserid());
//            return ps.executeUpdate() > 0;
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return false;
//    }
}
