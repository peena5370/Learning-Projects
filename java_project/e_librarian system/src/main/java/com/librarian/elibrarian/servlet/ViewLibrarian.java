package com.librarian.elibrarian.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.librarian.elibrarian.dao.LibrarianDao;
import com.librarian.elibrarian.model.Librarian;

@SuppressWarnings("serial")
public class ViewLibrarian extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		
		String title = "Librarian Information Page";
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
		request.getRequestDispatcher("/WEB-INF/views/navigation/admin-nav.html").include(request, response);
		out.println("<div class='container'>");
		out.println("<h3 class='text-center'>" + title + "</h3>");
		List<Librarian> librarian_list = LibrarianDao.view();
		out.println("<table class='table table-striped'>");
		out.println("<thead>\r\n"
				+ "    <tr>\r\n"
				+ "      <th scope='col'>ID</th>\r\n"
				+ "      <th scope='col'>Name</th>\r\n"
				+ "      <th scope='col'>Email</th>\r\n"
				+ "      <th scope='col'>Password</th>\r\n"
				+ "      <th scope='col'>Phone</th>\r\n"
				+ "      <th scope='col'>Edit</th>\r\n"
				+ "      <th scope='col'>Delete</th>\r\n"
				+ "    </tr>\r\n"
				+ "  </thead>\r\n"
				+ "<tbody>");
		
		for(Librarian librarian : librarian_list) {
			out.println("<tr>\r\n"
					  + "<th scope='row'>" + librarian.getLib_id() + "</th>\r\n"
					  + "<td>" + librarian.getLib_name() + "</td>\r\n"
					  + "<td>" + librarian.getLib_email() + "</td>\r\n"
					  + "<td>" + librarian.getLib_pass() + "</td>\r\n"
					  + "<td>" + librarian.getLib_phone() + "</td>\r\n"
					  + "<td><a href='EditLibrarian?id=" + librarian.getLib_id() + "'>Edit</a></td>\r\n"
					  + "<td><a href='DeleteLibrarian?id=" + librarian.getLib_id() + "'>Delete</a></td>\r\n"
					  + "</tr>");
		}
		out.println("</tbody>\r\n"
				  + "</table>");
		
		out.println("</div>");
		request.getRequestDispatcher("/WEB-INF/views/navigation/footer.html").include(request, response);
		out.close();
	}

}
