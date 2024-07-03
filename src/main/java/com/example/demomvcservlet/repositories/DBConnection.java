package com.example.demomvcservlet.repositories;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static final String jdbcURL = "jdbc:mysql://localhost:3306/jdbcdemo?useSSL=false";
    private static final String jdbcUsername = "root";
    private static final String jdbcPassword = "codegym";
    private static Connection connection = null;
    private DBConnection() {

    }

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnectionInstance() {
        return connection;
    }
}
