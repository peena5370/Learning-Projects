package com.librarian.elibrarian.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class DatabaseConnection {

    private static DataSource dataSource;

    @Autowired
    public DatabaseConnection(DataSource dataSource) {
        DatabaseConnection.dataSource = dataSource;
    }

    /**
     * Open Database connection
     */
    public static Connection dbConn() {
        Connection conn = null;
        try {
            conn = dataSource.getConnection();
        } catch (SQLException e) {
            System.err.println("error when connecting to database: " + e.getMessage());
        }

        return conn;
    }

    /**
     * Close Database connection
     * Using PreparedStatement besides createStatement() will prevent SQL injection occur.
     *
     * @param stmt, conn
     */
    public static void dbClose(PreparedStatement stmt, Connection conn) {
        try {
            if (stmt != null) {
                stmt.close();
            }

            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            System.err.println("error when closing query connection: " + e.getMessage());
        }
    }

    /**
     * Close database source
     *
     * @param stmt, rs, conn
     */
    public static void queryClose(PreparedStatement stmt, ResultSet rs, Connection conn) {
        try {
            if (stmt != null) {
                stmt.close();
            }

            if (rs != null) {
                rs.close();
            }

            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            System.err.println("error when closing database source: " + e.getMessage());
        }
    }
}
