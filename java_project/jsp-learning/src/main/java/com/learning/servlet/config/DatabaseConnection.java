package com.learning.servlet.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatabaseConnection {

    private DatabaseConnection() {
    }

    public static Connection getConnection() throws SQLException {
        String driver = PropertyConfig.getProperty("db.driver");
        String dbUrl = PropertyConfig.getProperty("db.url");
        String username = PropertyConfig.getProperty("db.username");
        String password = PropertyConfig.getProperty("db.password");

        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            System.err.println("JDBC driver not found: " + driver);
            throw new SQLException("JDBC driver not found: ", e);
        }

        return DriverManager.getConnection(dbUrl, username, password);
    }

    public static void closeConnection(PreparedStatement pstmt, Connection conn) {
        try {
            if (pstmt != null) {
                pstmt.close();
            }

            if (conn != null) {
                conn.close();
            }
        } catch (SQLException ex) {
            System.out.println("exception occur when closing resource: " + ex.getMessage());
        }
    }

    public static void queryClose(PreparedStatement pstmt, ResultSet rs, Connection conn) {
        try {
            if (pstmt != null) {
                pstmt.close();
            }

            if (rs != null) {
                rs.close();
            }

            if (conn != null) {
                conn.close();
            }
        } catch (SQLException ex) {
            System.out.println("exception occur when closing resource: " + ex.getMessage());
        }
    }
}
