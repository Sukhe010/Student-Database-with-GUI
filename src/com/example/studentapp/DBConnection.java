package com.example.studentapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/studentdb_GUI";
    private static final String USER = "root";
    private static final String PASSWORD = "helloIam21";

    public static Connection getConnection() {
        try {
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("✅ Database connection successful.");
            return conn;
        } catch (SQLException e) {
            System.err.println("❌ Failed to connect to database: " + e.getMessage());
            return null; // or throw new RuntimeException(e); if you want to crash intentionally
        }
    }
}
