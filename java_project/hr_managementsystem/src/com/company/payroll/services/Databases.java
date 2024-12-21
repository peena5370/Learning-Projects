package com.company.payroll.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Databases {
//	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	static final String JDBC_DRIVER = "org.mariadb.jdbc.Driver";
//	static final String DB_URL = "jdbc:mysql://localhost:6036/humanresource";
	static final String DB_URL = "jdbc:mysql://localhost:3306/humanresource";
	static final String USER = "root";
//	static final String PASS = "Makise5370";
	static final String PASS = "Kurosaki@5241";
	
	/**
	 * Open Database connection
	 * @return Connection
	 * */
	public static Connection connect() {
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
	 * Close Database query statement
	 * @param	pstmt
	 * @param	conn
	 * */
	public static void close(PreparedStatement pstmt, Connection conn) {
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
	 * Close database query statement and result set
	 * @param	pstmt
 	 * @param	rs
 	 * @param	conn
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
