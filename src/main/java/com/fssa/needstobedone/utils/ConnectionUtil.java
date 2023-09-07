package com.fssa.needstobedone.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Utility class for managing database connections.
 */
public class ConnectionUtil {

    // Private constructor to prevent instantiation
    private ConnectionUtil() {
        // Do nothing (empty constructor)
    }

    /**
     * Establishes a connection to the database.
     *
     * @return A database connection.
     * @throws SQLException If a database access error occurs.
     */
    public static Connection getConnection() {
        final String dbUrl;
        final String dbUser;
        final String dbPassword;

        // Set your database connection parameters here
        // For example, you can use environment variables or hard-coded values
        // dbUrl = System.getenv("DB_URL");
        // dbUser = System.getenv("DB_USER");
        // dbPassword = System.getenv("DB_PASSWORD");

        // Local Database (example values, replace with your actual database information)
        dbUrl = "jdbc:mysql://localhost:3306/needstobedone";
        dbUser = "root";
        dbPassword = "root";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(dbUrl, dbUser, dbPassword);
        } catch (SQLException e) {
            throw new RuntimeException("Unable to connect to the database", e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Database driver class not found", e);
        }
    }
}
