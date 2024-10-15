package com.flipkart.dao;

import com.flipkart.bean.User;
import com.flipkart.exception.UserAlreadyExistsException;
import com.flipkart.exception.UserNotFoundException;
import com.flipkart.utils.DbUtils;
import com.flipkart.utils.SQLConstants;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao implements UserDaoInterface {

    public static DbUtils dbUtils = new DbUtils();

    @Override
    public void addUser(User user) throws UserAlreadyExistsException {

        String sql = "INSERT INTO User (userId, username, password, name, email, phone, age, roleId) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = dbUtils.connection.prepareStatement(SQLConstants.GET_USER)){
            pstmt.setString(1, user.getUsername());
            pstmt.setString(2, user.getPassword());
            ResultSet res = pstmt.executeQuery();

            if(res.next()){
                //user already exists
                throw new UserAlreadyExistsException(user.getUsername());
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        try (PreparedStatement pstmt = dbUtils.connection.prepareStatement(SQLConstants.INSERT_USER)) {
            pstmt.setString(1, user.getUserId());
            pstmt.setString(2, user.getUsername());
            pstmt.setString(3, user.getPassword());
            pstmt.setString(4, user.getName());
            pstmt.setString(5, user.getEmail());
            pstmt.setString(6, user.getPhone());
            pstmt.setInt(7, user.getAge());
            pstmt.setString(8, user.getRoleId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public User validateUser(String username, String password) throws UserNotFoundException {
//        String sql = "SELECT * FROM User WHERE username = ? AND password = ?";
        try (PreparedStatement statement = dbUtils.connection.prepareStatement(SQLConstants.GET_USER)) {
            statement.setString(1, username);
            statement.setString(2, password);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                return new User(
                        rs.getString("userId"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("phone"),
                        rs.getInt("age"),
                        rs.getString("roleId")
                );
            }else{
                throw new UserNotFoundException();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


}
