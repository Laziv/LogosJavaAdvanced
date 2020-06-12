package com.lgs.laziv.lesson4_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
    private final static String URL = "jdbc:mysql://localhost:3306/library3?serverTimezone=UTC";
    private static final String USER = "laziv";
    private static final String PASSWORD = "Qwer1234";
    private static Connection connection;

    private ConnectionManager() {
    }

    public static Connection createConnection() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
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
