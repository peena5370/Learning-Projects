package com.learning.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.learning.model.Librarian;
import com.learning.services.DatabaseConnection;

public class LibrarianDao {
	private static Connection conn = null;
	private static PreparedStatement pstmt = null;
	private static ResultSet rs = null;
	
	/**
	 * Add new librarian into database
	 * @param	librarian
	 * 			Librarian info
	 * @return	status
	 * */
	public static int save(Librarian librarian) {
		int status = 0;
		conn = DatabaseConnection.dbConn();
		String sql = "INSERT INTO e_librarian(lib_name, lib_email, lib_pass, lib_phone) "
					+ "VALUES (?, ?, ?, ?)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, librarian.getLib_name());
			pstmt.setString(2, librarian.getLib_email());
			pstmt.setString(3, librarian.getLib_pass());
			pstmt.setString(4, librarian.getLib_phone());
			
			int rs = pstmt.executeUpdate();
			if(rs > 0) {
				status = rs;
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			DatabaseConnection.dbClose(pstmt, conn);
		}
		return status;
	}
	
	/**
	 * Update librarian info
	 * @param	librarian
	 * 			Librarian info
	 * @return	status
	 * */
	public static int update(Librarian librarian) {
		int status = 0;
		conn = DatabaseConnection.dbConn();
		String sql = "UPDATE e_librarian SET lib_name=?, lib_email=?, lib_pass=?, lib_phone=? WHERE lib_id=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, librarian.getLib_name());
			pstmt.setString(2, librarian.getLib_email());
			pstmt.setString(3, librarian.getLib_pass());
			pstmt.setString(4, librarian.getLib_phone());
			pstmt.setInt(5, librarian.getLib_id());
			
			int rs = pstmt.executeUpdate();
			if(rs > 0) {
				status = rs;
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			DatabaseConnection.dbClose(pstmt, conn);
		}
		return status;
	}
	
	/**
	 * View all the librarian info in list
	 * @return librarian_list
	 * */
	public static List<Librarian> view() {
		List<Librarian> librarian_list = new ArrayList<Librarian>();
		conn = DatabaseConnection.dbConn();
		String sql = "SELECT * FROM e_librarian";
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Librarian librarian = new Librarian();
				librarian.setLib_id(rs.getInt("lib_id"));
				librarian.setLib_name(rs.getString("lib_name"));
				librarian.setLib_email(rs.getString("lib_email"));
				librarian.setLib_pass(rs.getString("lib_pass"));
				librarian.setLib_phone(rs.getString("lib_phone"));
				
				librarian_list.add(librarian);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			DatabaseConnection.queryClose(pstmt, rs, conn);
		}
		return librarian_list;
	}
	
	/**
	 * View the librarian info according to lib_id
	 * @param	lib_id
	 * 			Librarian ID
	 * @return	librarian
	 * 			Return librarian info
	 * */
	public static Librarian viewById(int lib_id) {
		Librarian librarian = new Librarian();
		conn = DatabaseConnection.dbConn();
		String sql = "SELECT * FROM e_librarian WHERE lib_id=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, lib_id);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				librarian.setLib_id(rs.getInt(1));
				librarian.setLib_name(rs.getString(2));
				librarian.setLib_pass(rs.getString(3));
				librarian.setLib_email(rs.getString(4));
				librarian.setLib_phone(rs.getString(5));
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			DatabaseConnection.queryClose(pstmt, rs, conn);
		}
		return librarian;
	}
	
	/**
	 * Delete the librarian according to lib_id
	 * @param	lib_id
	 * 			Librarian ID
	 * @return	status
	 * */
	public static int delete(int lib_id) {
		int status = 0;
		conn = DatabaseConnection.dbConn();
		String sql = "DELETE FROM e_librarian WHERE lib_id=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, lib_id);
			
			int rs = pstmt.executeUpdate();
			if(rs > 0) {
				status = rs;
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			DatabaseConnection.dbClose(pstmt, conn);
		}
		return status;
	}
	
	/**
	 * Authenticate the librarian info
	 * @param	lib_email
	 * 			Librarian email
	 * @param	lib_pass
	 * 			Librarian password
	 * @return	bool
	 * */
	public static boolean authenticate(String lib_email, String lib_pass) {
		boolean bool = false;
		conn = DatabaseConnection.dbConn();
		String sql = "SELECT * FROM e_librarian WHERE lib_email=? AND lib_pass=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, lib_email);
			pstmt.setString(2, lib_pass);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				bool = true;
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			DatabaseConnection.queryClose(pstmt, rs, conn);
		}
		return bool;
	}
}
