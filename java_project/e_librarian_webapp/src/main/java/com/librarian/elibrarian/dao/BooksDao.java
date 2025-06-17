package com.librarian.elibrarian.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.librarian.elibrarian.model.Books;
import com.librarian.elibrarian.model.IssueBooks;
import com.librarian.elibrarian.services.DatabaseConnection;

public class BooksDao {
	private static Connection conn = null;
	private static PreparedStatement pstmt = null;
	private static ResultSet rs = null;

	/**
	 * save new book info into database
	 * @param	book
	 * 			Book info that need to store into database
	 * @return	status
	 * */
	public static int save(Books book) {
		int status = 0;
		conn = DatabaseConnection.dbConn();
		String sql = "INSERT INTO e_book(callno, book_name, author, publisher, book_quantity, book_issued) "
					+ "VALUES(?, ?, ?, ?, ?, ?)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, book.getCallno());
			pstmt.setString(2, book.getBookname());
			pstmt.setString(3, book.getAuthor());
			pstmt.setString(4, book.getPublisher());
			pstmt.setInt(5, book.getBookquantity());
			pstmt.setInt(6, 0);
			
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
	 * View all available books that store inside database
	 * @return	book_list
	 * 			Return all the book info that stored inside database
	 * */
	public static List<Books> view() {
		List<Books> book_list = new ArrayList<Books>();
		conn = DatabaseConnection.dbConn();
		String sql = "SELECT * FROM e_book";
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Books books = new Books();
				books.setCallno(rs.getString("callno"));
				books.setBookname(rs.getString("book_name"));
				books.setAuthor(rs.getString("author"));
				books.setPublisher(rs.getString("publisher"));
				books.setBookquantity(rs.getInt("book_quantity"));
				books.setBookissued(rs.getInt("book_issued"));
				
				book_list.add(books);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			DatabaseConnection.queryClose(pstmt, rs, conn);
		}
		return book_list;
	}

	/**
	 * Delete the book
	 * @param	callno
	 * 			Book callno
	 * */
	public static int delete(String callno) {
		int status = 0;
		conn = DatabaseConnection.dbConn();
		String sql = "DELETE FROM e_book WHERE callno = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, callno);
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
	 * Get book info with callno
	 * @param	callno
	 * 			Book callno
	 * @return	issued
	 * */
	public static int getIssued(String callno) {
		int issued = 0;
		conn = DatabaseConnection.dbConn();
		String sql = "SELECT * FROM e_book WHERE callno = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, callno);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				issued = rs.getInt("book_issued");
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			DatabaseConnection.queryClose(pstmt, rs, conn);
		}
		return issued;
	}

	/**
	 * Check book quantity with callno, if book quantity still available, return true.
	 * @param	callno
	 * 			Book callno
	 * @return	bool
	 * */
	public static boolean checkIssue(String callno) {
		boolean bool = false;
		conn = DatabaseConnection.dbConn();
		String sql = "SELECT * FROM e_book WHERE callno = ? and book_quantity > book_issued";
		
		try {
			pstmt= conn.prepareStatement(sql);
			pstmt.setString(1, callno);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				bool = true;
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			DatabaseConnection.queryClose(pstmt, rs, conn);
		}
		return bool;
	}

	/**
	 * Insert issue book info into database
	 * @param	book
	 * 			Book info
	 * @return	status
	 * */
	public static int issueBook(IssueBooks book) {
		int status = 0;
		String callno = book.getCallno();
		boolean checkstatus = checkIssue(callno);
		
		if(checkstatus) {
			conn = DatabaseConnection.dbConn();
			String sql = "INSERT INTO e_issuebook(stud_id, stud_name, stud_phone, issued_date, return_status, book_id) "
						+ "VALUES(?, ?, ?, ?, ?, (SELECT book_id FROM e_book WHERE callno=?))";
			
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, book.getStud_id());
				pstmt.setString(2, book.getStud_name());
				pstmt.setString(3, book.getStud_phone());
				
				DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				Date currDate = new Date(System.currentTimeMillis());
				String currentdate = dateFormat.format(currDate);
				pstmt.setString(4, currentdate);
				pstmt.setString(5, "NO");
				pstmt.setString(6, book.getCallno());
				
				int rs = pstmt.executeUpdate();
				if(rs > 0) {
					String sql_update = "UPDATE e_book SET book_issued = ? WHERE callno = ?";
					PreparedStatement pstmt2 = conn.prepareStatement(sql_update);
					pstmt2.setInt(1, getIssued(callno) + 1);
					pstmt2.setString(2, callno);
					rs = pstmt2.executeUpdate();
					
					status = rs;
				}
				
			} catch(SQLException e) {
				e.printStackTrace();
			} finally {
				DatabaseConnection.dbClose(pstmt, conn);
			}
			return status;
		} else {
			return 0;	
		}
	}

	/**
	 * Update issue book status with book callno and student id
	 * @param	callno
	 * 			Book callno
	 * @param	stud_id
	 * 			Student ID
	 * @return	status
	 * */
	public static int returnBook(String callno, String stud_id) {
		int status = 0;
		conn = DatabaseConnection.dbConn();
		String sql = "UPDATE e_issuebook INNER JOIN e_book ON e_book.book_id = e_issuebook.book_id "
					+ "SET return_status = 'YES' WHERE e_book.callno = ? AND stud_id = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, callno);
			pstmt.setString(2, stud_id);
			
			int rs = pstmt.executeUpdate();
			if(rs > 0) {
				String sql2 = "UPDATE e_book SET book_issued = ? WHERE callno = ?";
				PreparedStatement pstmt2 = conn.prepareStatement(sql2);
				pstmt2.setInt(1, getIssued(callno) - 1);
				pstmt2.setString(2, callno);
				
				rs = pstmt2.executeUpdate();
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
	 * View all the issued book from database
	 * @return	book_list
	 * */
	public static List<IssueBooks> viewIssueBooks() {
		List<IssueBooks> book_list = new ArrayList<IssueBooks>();
		conn = DatabaseConnection.dbConn();
		String sql = "SELECT e_book.callno AS callno, e_issuebook.stud_id AS studentid, e_issuebook.stud_name AS studentname, "
					+ "e_issuebook.stud_phone AS studentphone, e_issuebook.issued_date AS issueddate, e_issuebook.return_status AS returnstatus "
					+ "FROM e_issuebook INNER JOIN e_book ON e_book.book_id = e_issuebook.book_id ORDER BY issued_date DESC";
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				IssueBooks issuebook = new IssueBooks();
				issuebook.setCallno(rs.getString("callno"));
				issuebook.setStud_id(rs.getString("studentid"));
				issuebook.setStud_name(rs.getString("studentname"));
				issuebook.setStud_phone(rs.getString("studentphone"));
				issuebook.setIssueddate(rs.getString("issueddate"));
				issuebook.setReturnstatus(rs.getString("returnstatus"));
				
				book_list.add(issuebook);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			DatabaseConnection.queryClose(pstmt, rs, conn);
		}
		return book_list;
	}
}
