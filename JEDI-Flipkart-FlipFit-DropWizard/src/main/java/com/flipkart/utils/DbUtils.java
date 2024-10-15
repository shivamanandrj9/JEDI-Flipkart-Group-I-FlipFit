package com.flipkart.utils;

import java.sql.*;

import static java.sql.DriverManager.getConnection;

public class DbUtils {

    private static final String url = "jdbc:mysql://localhost:3306/FlipFitDB";
    private static final String user = "root";
    private static final String password = "password";

    public static Connection connection;

    static {
        try {
            connection = getConnection(url, user, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public static int getTableCnt(String table){
        int count = 0;
        String query = "SELECT COUNT(*) AS cnt FROM " + table;

        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            if (resultSet.next()) {
                count = resultSet.getInt("cnt");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exceptions (e.g., log them or rethrow them)
        }

        return count;
    }

    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
