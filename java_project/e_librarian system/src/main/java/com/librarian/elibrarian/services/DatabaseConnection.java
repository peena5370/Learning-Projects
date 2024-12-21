package com.librarian.elibrarian.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseConnection {
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:6036/e_librarian";
	static final String USER = "root";
	static final String PASS = "password";
	
	/**
	 * Open Database connection
	 * */
	public static Connection dbConn() {
		Connection conn = null;	
		try {
			Class.forName(JDBC_DRIVER);
			conn= DriverManager.getConnection(DB_URL, USER, PASS);
		} catch(SQLException e) {
			e.printStackTrace();
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	/**
	 * Close Database connection
	 * Using PreparedStatement besides createStatement() will prevent SQL injection occur.
	 * 
	 * @param pstmt, conn
	 * */
	public static void dbClose(PreparedStatement pstmt, Connection conn) {
		try {
			if(pstmt != null) {
				pstmt.close();
			}
		} catch(SQLException e1) {
			e1.printStackTrace();
		}
		
		try {
			if(conn != null) {
				conn.close();
			}
		} catch(SQLException e2) {
			e2.printStackTrace();
		}
	}
	
	/**
	 * Close database source
	 * @param pstmt, rs, conn
	 * */
	public static void queryClose(PreparedStatement pstmt, ResultSet rs, Connection conn) {
		try {
			if(pstmt != null) {
				pstmt.close();
			}
		} catch(SQLException e1) {
			e1.printStackTrace();
		}
		
		try {
			if(rs != null) {
				rs.close();
			}
		} catch(SQLException e2) {
			e2.printStackTrace();
		}
		
		try {
			if(conn != null) {
				conn.close();
			}
		} catch(SQLException e3) {
			e3.printStackTrace();
		}
	}
}
