package com.flipkart.dao;

import com.flipkart.bean.Payment;
import com.flipkart.bean.User;
import com.flipkart.exception.UserAlreadyExistsException;
import com.flipkart.utils.DbUtils;
import com.flipkart.utils.SQLConstants;

import java.sql.*;

public class PaymentDao implements PaymentDaoInterface {

    public static DbUtils dbUtils = new DbUtils();

    @Override
    public void addPayment(Payment payment) {

        String sql = "INSERT INTO payment (paymentsId, cardNumber, expiryDate, name, cvv) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = dbUtils.connection.prepareStatement(sql)){
            pstmt.setInt(1, payment.getPaymentsId());
            pstmt.setString(2, payment.getCardNumber());
            pstmt.setString(3, payment.getExpiryDate());
            pstmt.setString(4, payment.getName());
            pstmt.setString(5, payment.getCvv());
            pstmt.executeUpdate();



        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
