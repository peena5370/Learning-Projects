package com.learning.servlet.repository;

import com.learning.servlet.config.DatabaseConnection;
import com.learning.servlet.model.AdminModel;
import com.learning.servlet.model.EmployeeModel;
import com.learning.servlet.model.ManagerModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper {

    private static Connection conn = null;
    private static PreparedStatement stmt = null;
    private static ResultSet rs = null;

    public static AdminModel adminAuth(String username) {

        AdminModel admin = new AdminModel();

        try {
            String sql = "SELECT a_authpassword, a_authkey, a_role "
                    + "FROM admin WHERE a_username=?";

            conn = DatabaseConnection.getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, username);
            rs = stmt.executeQuery();

            while (rs.next()) {
                admin.setPassword(rs.getString("a_authpassword"));
                admin.setKey(rs.getString("a_authkey"));
                admin.setRole(rs.getString("a_role"));
            }
        } catch (SQLException e) {
            System.out.println("error when retrieving admin info: " + e.getMessage());
        } finally {
            DatabaseConnection.queryClose(stmt, rs, conn);
        }
        return admin;
    }

    public static ManagerModel managerAuth(int id) {
        ManagerModel manager = new ManagerModel();
        try {
            String sql = "SELECT m_authpassword, m_authkey, m_role "
                    + "FROM tbl_manager WHERE m_id=?";

            conn = DatabaseConnection.getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();

            while (rs.next()) {
                manager.setId(id);
                manager.setPassword(rs.getString("m_authpassword"));
                manager.setKey(rs.getString("m_authkey"));
                manager.setRole(rs.getString("m_role"));
            }
        } catch (SQLException e) {
            System.out.println("error when retrieving manager info: " + e.getMessage());
        } finally {
            DatabaseConnection.queryClose(stmt, rs, conn);
        }

        return manager;
    }

    public static EmployeeModel employeeAuth(int id) {
        EmployeeModel employee = new EmployeeModel();
        try {
            String sql = "SELECT e_authpassword, e_authkey "
                    + "FROM tbl_employee WHERE e_id=?";

            conn = DatabaseConnection.getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();

            while (rs.next()) {
                employee.setId(id);
                employee.setPassword(rs.getString("e_authpassword"));
                employee.setKey(rs.getString("e_authkey"));
            }
        } catch (SQLException e) {
            System.out.println("error when retrieving employee info: " + e.getMessage());
        } finally {
            DatabaseConnection.queryClose(stmt, rs, conn);
        }

        return employee;
    }
}
