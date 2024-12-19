package com.learning.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.learning.dao.LibrarianDao;
import com.learning.model.Librarian;

@SuppressWarnings("serial")
public class AddLibrarian extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		
		String title = "Add Librarian Form";
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
		request.getRequestDispatcher("/WEB-INF/views/form/addLibrarian.html").include(request, response);
		
		out.println("</div>");
		request.getRequestDispatcher("/WEB-INF/views/navigation/footer.html").include(request, response);
		out.close();
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		
		String title = "Add Librarian Form";
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
		
		String lib_name = request.getParameter("librarian_name");
		String lib_email = request.getParameter("librarian_email");
		String lib_pass = request.getParameter("librarian_password");
		String lib_phone = request.getParameter("librarian_phone");
		Librarian librarian = new Librarian(lib_name, lib_email, lib_pass, lib_phone);
		int save_status = LibrarianDao.save(librarian);
		if(save_status > 0) {
			out.println("<script type='text/javascript'>");
		    out.println("alert('Added successful.');");
		    out.println("</script>");
		} else {
			out.println("<script type='text/javascript'>");
		    out.println("alert('Failed to add new librarian.');");
		    out.println("</script>");
		}
		
	    request.getRequestDispatcher("/WEB-INF/views/form/addLibrarian.html").include(request, response);
		
	    out.println("</div>");
		request.getRequestDispatcher("/WEB-INF/views/navigation/footer.html").include(request, response);
		out.close();
	}

}
