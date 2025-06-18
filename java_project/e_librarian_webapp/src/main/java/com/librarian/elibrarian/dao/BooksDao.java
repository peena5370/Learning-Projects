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
import org.springframework.stereotype.Component;

public class BooksDao {
    private static Connection conn = null;
    private static PreparedStatement stmt = null;
    private static ResultSet rs = null;

    /**
     * save new book info into database
     *
     * @param book Book info that need to store into database
     * @return status
     */
    public static int save(Books book) {
        int status = 0;
        conn = DatabaseConnection.dbConn();
        String sql = "INSERT INTO e_book(callno, book_name, author, publisher, book_quantity, book_issued) "
                + "VALUES(?, ?, ?, ?, ?, ?)";

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, book.getCallno());
            stmt.setString(2, book.getBookname());
            stmt.setString(3, book.getAuthor());
            stmt.setString(4, book.getPublisher());
            stmt.setInt(5, book.getBookquantity());
            stmt.setInt(6, 0);

            status = stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("error when saving book info: " + e.getMessage());
        } finally {
            DatabaseConnection.dbClose(stmt, conn);
        }

        return status;
    }

    /**
     * View all available books that store inside database
     *
     * @return bookList Return all the book info that stored inside database
     */
    public static List<Books> view() {
        List<Books> bookList = new ArrayList<>();
        conn = DatabaseConnection.dbConn();
        String sql = "SELECT * FROM e_book";

        try {
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Books books = new Books();
                books.setCallno(rs.getString("callno"));
                books.setBookname(rs.getString("book_name"));
                books.setAuthor(rs.getString("author"));
                books.setPublisher(rs.getString("publisher"));
                books.setBookquantity(rs.getInt("book_quantity"));
                books.setBookissued(rs.getInt("book_issued"));

                bookList.add(books);
            }
        } catch (SQLException e) {
            System.err.println("error when retrieving book list: " + e.getMessage());
        } finally {
            DatabaseConnection.queryClose(stmt, rs, conn);
        }

        return bookList;
    }

    /**
     * Delete the book
     *
     * @param callno Book callno
     */
    public static int delete(String callno) {
        int status = 0;
        conn = DatabaseConnection.dbConn();
        String sql = "DELETE FROM e_book WHERE callno = ?";

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, callno);
            status = stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("error when deleting book info: " + e.getMessage());
        } finally {
            DatabaseConnection.dbClose(stmt, conn);
        }

        return status;
    }

    /**
     * Get book info with callno
     *
     * @param callno Book callno
     * @return issued
     */
    public static int getIssued(String callno) {
        int issued = 0;
        conn = DatabaseConnection.dbConn();
        String sql = "SELECT * FROM e_book WHERE callno = ?";

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, callno);

            rs = stmt.executeQuery();
            while (rs.next()) {
                issued = rs.getInt("book_issued");
            }
        } catch (SQLException e) {
            System.err.println("error when getting issued book: " + e.getMessage());
        } finally {
            DatabaseConnection.queryClose(stmt, rs, conn);
        }

        return issued;
    }

    /**
     * Check book quantity with callno, if book quantity still available, return true.
     *
     * @param callno Book callno
     * @return bool
     */
    public static boolean checkIssue(String callno) {
        boolean bool = false;
        conn = DatabaseConnection.dbConn();
        String sql = "SELECT * FROM e_book WHERE callno = ? and book_quantity > book_issued";

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, callno);

            rs = stmt.executeQuery();
            while (rs.next()) {
                bool = true;
            }
        } catch (SQLException e) {
            System.err.println("error when checking issued book: " + e.getMessage());
        } finally {
            DatabaseConnection.queryClose(stmt, rs, conn);
        }

        return bool;
    }

    /**
     * Insert issue book info into database
     *
     * @param book Book info
     * @return status
     */
    public static int issueBook(IssueBooks book) {
        int status = 0;
        String callNo = book.getCallno();
        boolean checkStatus = checkIssue(callNo);

        if (checkStatus) {
            conn = DatabaseConnection.dbConn();
            String sql = "INSERT INTO e_issuebook(stud_id, stud_name, stud_phone, issued_date, return_status, book_id) "
                    + "VALUES(?, ?, ?, ?, ?, (SELECT book_id FROM e_book WHERE callno=?))";

            try {
                stmt = conn.prepareStatement(sql);
                stmt.setString(1, book.getStud_id());
                stmt.setString(2, book.getStud_name());
                stmt.setString(3, book.getStud_phone());

                DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Date currDate = new Date(System.currentTimeMillis());
                String currentdate = dateFormat.format(currDate);
                stmt.setString(4, currentdate);
                stmt.setString(5, "NO");
                stmt.setString(6, book.getCallno());

                status = stmt.executeUpdate();
                if (status > 0) {
                    String sql_update = "UPDATE e_book SET book_issued = ? WHERE callno = ?";
                    PreparedStatement pstmt2 = conn.prepareStatement(sql_update);
                    pstmt2.setInt(1, getIssued(callNo) + 1);
                    pstmt2.setString(2, callNo);
                    status = pstmt2.executeUpdate();
                }
            } catch (SQLException e) {
                System.err.println("error when issuing book: " + e.getMessage());
            } finally {
                DatabaseConnection.dbClose(stmt, conn);
            }

            return status;
        } else {
            return status;
        }
    }

    /**
     * Update issue book status with book callno and student id
     *
     * @param callNo  Book callno
     * @param stud_id Student ID
     * @return status
     */
    public static int returnBook(String callNo, String studId) {
        int status = 0;
        conn = DatabaseConnection.dbConn();
        String sql = "UPDATE e_issuebook INNER JOIN e_book ON e_book.book_id = e_issuebook.book_id "
                + "SET return_status = 'YES' WHERE e_book.callno = ? AND stud_id = ?";

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, callNo);
            stmt.setString(2, studId);

            status = stmt.executeUpdate();
            if (status > 0) {
                String sql2 = "UPDATE e_book SET book_issued = ? WHERE callno = ?";
                PreparedStatement pstmt2 = conn.prepareStatement(sql2);
                pstmt2.setInt(1, getIssued(callNo) - 1);
                pstmt2.setString(2, callNo);

                status = pstmt2.executeUpdate();
            }
        } catch (SQLException e) {
            System.err.println("error when updating returned book: " + e.getMessage());
        } finally {
            DatabaseConnection.dbClose(stmt, conn);
        }

        return status;
    }

    /**
     * View all the issued book from database
     *
     * @return book_list
     */
    public static List<IssueBooks> viewIssueBooks() {
        List<IssueBooks> bookList = new ArrayList<>();
        conn = DatabaseConnection.dbConn();
        String sql = "SELECT e_book.callno AS callno, e_issuebook.stud_id AS studentid, e_issuebook.stud_name AS studentname, "
                + "e_issuebook.stud_phone AS studentphone, e_issuebook.issued_date AS issueddate, e_issuebook.return_status AS returnstatus "
                + "FROM e_issuebook INNER JOIN e_book ON e_book.book_id = e_issuebook.book_id ORDER BY issued_date DESC";

        try {
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                IssueBooks issuedBook = new IssueBooks();
                issuedBook.setCallno(rs.getString("callno"));
                issuedBook.setStud_id(rs.getString("studentid"));
                issuedBook.setStud_name(rs.getString("studentname"));
                issuedBook.setStud_phone(rs.getString("studentphone"));
                issuedBook.setIssueddate(rs.getString("issueddate"));
                issuedBook.setReturnstatus(rs.getString("returnstatus"));

                bookList.add(issuedBook);
            }
        } catch (SQLException e) {
            System.err.println("error when retrieving issued book list: " + e.getMessage());
        } finally {
            DatabaseConnection.queryClose(stmt, rs, conn);
        }
        
        return bookList;
    }
}
