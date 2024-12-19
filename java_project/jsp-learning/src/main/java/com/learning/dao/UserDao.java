package com.learning.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.learning.model.AdminModel;
import com.learning.model.EmployeeModel;
import com.learning.model.ManagerModel;
import com.learning.services.Databases;

public class UserDao {
	private static Connection conn = null;
	private static PreparedStatement pstmt = null;
	private static ResultSet rs = null;
	
	public static AdminModel adminAuth(String username) {
		AdminModel admin = new AdminModel();
		String sql = "SELECT a_authpassword, a_authkey, a_role "
				+ "FROM admin WHERE a_username=?";
		conn = Databases.connect();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, username);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				admin.setPassword(rs.getString("a_authpassword"));
				admin.setKey(rs.getString("a_authkey"));
				admin.setRole(rs.getString("a_role"));
			}
		} catch(SQLException e) {
			System.out.println(e);
		} finally {
			Databases.queryClose(pstmt, rs, conn);
		}
		return admin;
	}
	
	public static ManagerModel managerAuth(int id) {
		ManagerModel manager = new ManagerModel();
		conn = Databases.connect();
		String sql = "SELECT m_authpassword, m_authkey, m_role "
					+ "FROM tbl_manager WHERE m_id=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				manager.setId(id);
				manager.setPassword(rs.getString("m_authpassword"));
				manager.setKey(rs.getString("m_authkey"));
				manager.setRole(rs.getString("m_role"));
			}
		} catch(SQLException e) {
			System.out.println(e);
		} finally {
			Databases.queryClose(pstmt, rs, conn);
		}
		return manager;
	}
	
	public static EmployeeModel employeeAuth(int id) {
		EmployeeModel employee = new EmployeeModel();
		conn = Databases.connect();
		String sql = "SELECT e_authpassword, e_authkey "
					+ "FROM tbl_employee WHERE e_id=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				employee.setId(id);
				employee.setPassword(rs.getString("e_authpassword"));
				employee.setKey(rs.getString("e_authkey"));
			}
		} catch(SQLException e) {
			System.out.println(e);
		} finally {
			Databases.queryClose(pstmt, rs, conn);
		}
		return employee;
	}
}
