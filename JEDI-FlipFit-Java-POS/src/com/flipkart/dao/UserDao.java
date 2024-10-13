package com.flipkart.dao;

import com.flipkart.bean.*;
import com.flipkart.utils.DbUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao{

    public static DbUtils dbUtils = new DbUtils();

    public void addUser(User user) {

        String sql = "INSERT INTO User (userId, username, password, name, email, phone, age, roleId) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement pstmt = dbUtils.connection.prepareStatement(sql)) {

            pstmt.setString(1, user.getUserId());
            pstmt.setString(2, user.getUsername());
            pstmt.setString(3, user.getPassword());
            pstmt.setString(4, user.getName());
            pstmt.setString(5, user.getEmail());
            pstmt.setString(6, user.getPhone());
            pstmt.setInt(7, user.getAge());
            pstmt.setString(8, user.getRoleId());
            System.out.println(pstmt.toString());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }



    public User validateUser(String username, String password) {
        String sql = "SELECT * FROM User WHERE username = ? AND password = ?";
        try (PreparedStatement statement = dbUtils.connection.prepareStatement(sql)) {
            statement.setString(1, username);
            statement.setString(2, password);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                return new User(rs.getString("userId"),rs.getString("username"), rs.getString("password"), rs.getString("name"), rs.getString("email"), rs.getString("phone"), rs.getInt("age"), rs.getString("roleId"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
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
