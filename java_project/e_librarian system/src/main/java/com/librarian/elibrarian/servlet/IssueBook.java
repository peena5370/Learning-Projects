package com.librarian.elibrarian.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.librarian.elibrarian.dao.BooksDao;
import com.librarian.elibrarian.model.IssueBooks;

@SuppressWarnings("serial")
public class IssueBook extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		
		String title = "Issue Book Page";
		String header = "<!DOCTYPE html>"
					  + "<head>\r\n"
					  + "  <meta charset='utf-8'>\r\n"
					  + "  <meta name='viewport' content='width=device-width, initial-scale=1'>\r\n"
					  + "  <title>" + title + "</title>\r\n"
					  + "  <link rel='stylesheet' type='text/css' href='resources/css/bootstrap.min.css'/>\r\n"
					  + "  <link rel='stylesheet' type='text/css' href='resources/css/main.css'/>\r\n"
					  + "</head>\r\n\n"
					  + "<body>";
		out.println(header);
		request.getRequestDispatcher("/WEB-INF/views/navigation/librarian-nav.html").include(request, response);
		out.println("<div class='container'>");
		
		request.getRequestDispatcher("/WEB-INF/views/form/issueBook.html").include(request, response);
		
		out.println("</div>");
		request.getRequestDispatcher("/WEB-INF/views/navigation/footer.html").include(request, response);
		out.close();
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		
		String title = "Issue Book Page";
		String header = "<!DOCTYPE html>"
					  + "<head>\r\n"
					  + "  <meta charset='utf-8'>\r\n"
					  + "  <meta name='viewport' content='width=device-width, initial-scale=1'>\r\n"
					  + "  <title>" + title + "</title>\r\n"
					  + "  <link rel='stylesheet' type='text/css' href='resources/css/bootstrap.min.css'/>\r\n"
					  + "  <link rel='stylesheet' type='text/css' href='resources/css/main.css'/>\r\n"
					  + "</head>\r\n\n"
					  + "<body>";
		out.println(header);
		request.getRequestDispatcher("/WEB-INF/views/navigation/librarian-nav.html").include(request, response);
		out.println("<div class='container'>");
		
		String callno = request.getParameter("book_callno");
		String stud_id = request.getParameter("student_id");
		String stud_name = request.getParameter("student_name");
		String stud_phone = request.getParameter("student_phone");
		
		IssueBooks book_issue = new IssueBooks(callno, stud_id, stud_name, stud_phone);
		int issue_status = BooksDao.issueBook(book_issue);
		
		if(issue_status > 0) {
			out.println("<script type='text/javascript'>");
		    out.println("alert('Book issued successful.');");
		    out.println("location='IssueBook'");
		    out.println("</script>");
		} else {
			out.println("<script type='text/javascript'>");
		    out.println("alert('Unable issue the book.\nThe book may not available this time.\nPlease visit later.');");
		    out.println("location='IssueBook'");
		    out.println("</script>");
		}
		
		out.println("</div>");
		request.getRequestDispatcher("/WEB-INF/views/navigation/footer.html").include(request, response);
		out.close();
	}

}
