package com.librarian.elibrarian.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.librarian.elibrarian.model.Librarian;
import com.librarian.elibrarian.services.DatabaseConnection;
import org.springframework.stereotype.Component;

public class LibrarianDao {
    private static Connection conn = null;
    private static PreparedStatement stmt = null;
    private static ResultSet rs = null;

    /**
     * Add new librarian into database
     *
     * @param librarian Librarian info
     * @return status
     */
    public static int save(Librarian librarian) {
        int status = 0;
        conn = DatabaseConnection.dbConn();
        String sql = "INSERT INTO e_librarian(lib_name, lib_email, lib_pass, lib_phone) "
                + "VALUES (?, ?, ?, ?)";

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, librarian.getLib_name());
            stmt.setString(2, librarian.getLib_email());
            stmt.setString(3, librarian.getLib_pass());
            stmt.setString(4, librarian.getLib_phone());

            status = stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("error when inserting librarian info: " + e.getMessage());
        } finally {
            DatabaseConnection.dbClose(stmt, conn);
        }

        return status;
    }

    /**
     * Update librarian info
     *
     * @param librarian Librarian info
     * @return status
     */
    public static int update(Librarian librarian) {
        int status = 0;
        conn = DatabaseConnection.dbConn();
        String sql = "UPDATE e_librarian SET lib_name=?, lib_email=?, lib_pass=?, lib_phone=? WHERE lib_id=?";

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, librarian.getLib_name());
            stmt.setString(2, librarian.getLib_email());
            stmt.setString(3, librarian.getLib_pass());
            stmt.setString(4, librarian.getLib_phone());
            stmt.setInt(5, librarian.getLib_id());

            status = stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("error when updating librarian info: " + e.getMessage());
        } finally {
            DatabaseConnection.dbClose(stmt, conn);
        }

        return status;
    }

    /**
     * View all the librarian info in list
     *
     * @return librarian_list
     */
    public static List<Librarian> view() {
        List<Librarian> librarianList = new ArrayList<>();
        conn = DatabaseConnection.dbConn();
        String sql = "SELECT * FROM e_librarian";

        try {
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Librarian librarian = new Librarian();
                librarian.setLib_id(rs.getInt("lib_id"));
                librarian.setLib_name(rs.getString("lib_name"));
                librarian.setLib_email(rs.getString("lib_email"));
                librarian.setLib_pass(rs.getString("lib_pass"));
                librarian.setLib_phone(rs.getString("lib_phone"));

                librarianList.add(librarian);
            }
        } catch (SQLException e) {
            System.err.println("error when retrieving librarian list: " + e.getMessage());
        } finally {
            DatabaseConnection.queryClose(stmt, rs, conn);
        }

        return librarianList;
    }

    /**
     * View the librarian info according to lib_id
     *
     * @param lib_id Librarian ID
     * @return librarian Return librarian info
     */
    public static Librarian viewById(int lib_id) {
        Librarian librarian = new Librarian();
        conn = DatabaseConnection.dbConn();
        String sql = "SELECT * FROM e_librarian WHERE lib_id=?";

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, lib_id);

            rs = stmt.executeQuery();
            while (rs.next()) {
                librarian.setLib_id(rs.getInt(1));
                librarian.setLib_name(rs.getString(2));
                librarian.setLib_pass(rs.getString(3));
                librarian.setLib_email(rs.getString(4));
                librarian.setLib_phone(rs.getString(5));
            }
        } catch (SQLException e) {
            System.err.println("error when retrieving librarin info by librarianId: " +
                    lib_id + "\t Error message: " + e.getMessage());
        } finally {
            DatabaseConnection.queryClose(stmt, rs, conn);
        }
        return librarian;
    }

    /**
     * Delete the librarian according to lib_id
     *
     * @param lib_id Librarian ID
     * @return status
     */
    public static int delete(int lib_id) {
        int status = 0;
        conn = DatabaseConnection.dbConn();
        String sql = "DELETE FROM e_librarian WHERE lib_id=?";

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, lib_id);

            status = stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("error when deleting librarian info: " + e.getMessage());
        } finally {
            DatabaseConnection.dbClose(stmt, conn);
        }
        return status;
    }

    /**
     * Authenticate the librarian info
     *
     * @param lib_email Librarian email
     * @param lib_pass  Librarian password
     * @return bool
     */
    public static boolean authenticate(String lib_email, String lib_pass) {
        boolean bool = false;
        conn = DatabaseConnection.dbConn();
        String sql = "SELECT * FROM e_librarian WHERE lib_email=? AND lib_pass=?";

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, lib_email);
            stmt.setString(2, lib_pass);

            rs = stmt.executeQuery();
            if (rs.next()) {
                bool = true;
            }
        } catch (SQLException e) {
            System.err.println("error when authenticating librarian account: " + e.getMessage());
        } finally {
            DatabaseConnection.queryClose(stmt, rs, conn);
        }

        return bool;
    }
}
