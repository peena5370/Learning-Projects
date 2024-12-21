package com.librarian.elibrarian.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.librarian.elibrarian.dao.BooksDao;
import com.librarian.elibrarian.model.IssueBooks;

@SuppressWarnings("serial")
public class ViewIssuedBook extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		
		String title = "Issued Book Page";
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
		
		List<IssueBooks> book_list = BooksDao.viewIssueBooks();
		out.println("<table class='table table-striped'>");
		out.println("<thead>\r\n"
				+ "    <tr>\r\n"
				+ "      <th scope='col'>Callno</th>\r\n"
				+ "      <th scope='col'>Student ID</th>\r\n"
				+ "      <th scope='col'>Student Name</th>\r\n"
				+ "      <th scope='col'>Phone Number</th>\r\n"
				+ "      <th scope='col'>Issued Date</th>\r\n"
				+ "      <th scope='col'>Return Status</th>\r\n"
				+ "    </tr>\r\n"
				+ "  </thead>\r\n"
				+ "<tbody>");
		
		for(IssueBooks book : book_list) {
			out.println("<tr>\r\n"
					  + "<th scope='row'>" + book.getCallno() + "</th>\r\n"
					  + "<td>" + book.getStud_id() + "</td>\r\n"
					  + "<td>" + book.getStud_name() + "</td>\r\n"
					  + "<td>" + book.getStud_phone() + "</td>\r\n"
					  + "<td>" + book.getIssueddate() + "</td>\r\n"
					  + "<td>" + book.getReturnstatus() + "</td>\r\n"
					  + "</tr>");
		}
		
		out.println("</tbody>\r\n"
				  + "</table>");
		
		out.println("</div>");
		request.getRequestDispatcher("/WEB-INF/views/navigation/footer.html").include(request, response);
		out.close();
	}

}
