package com.librarian.elibrarian.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.librarian.elibrarian.dao.LibrarianDao;

/**
 * TODO bug inside here, try to solve it later on.
 * @see java.lang.NullPointerException
 * */
@SuppressWarnings("serial")
public class Login extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		
		String admin_email = request.getParameter("admin_email");
		String admin_pass = request.getParameter("admin_password");
		String lib_email = request.getParameter("librarian_email");
		String lib_pass = request.getParameter("librarian_password");
		String queryString = request.getQueryString();
		
		if(queryString.equals("admin")) {
			if(admin_email.equals("admin@library.com") && admin_pass.equals("Admin@1234")) {
				String header = "<!DOCTYPE html>"
						  + "<head>\r\n"
						  + "  <meta charset='utf-8'>\r\n"
						  + "  <meta name='viewport' content='width=device-width, initial-scale=1'>\r\n"
						  + "  <title>Admin Section</title>\r\n"
						  + "  <link rel='stylesheet' type='text/css' href='resources/css/bootstrap.min.css'/>\r\n"
						  + "  <link rel='stylesheet' type='text/css' href='resources/css/main.css'/>\r\n"
						  + "</head>\r\n\n"
						  + "<body>";
				out.println(header);
				
				HttpSession session = request.getSession();
				session.setAttribute("admin","true");
				
				request.getRequestDispatcher("/WEB-INF/views/navigation/admin-nav.html").include(request, response);
				out.println("<div class='container-fluid'>");
				request.getRequestDispatcher("/WEB-INF/views/carousel/admin-carousel.html").include(request, response);
			} else {
				out.println("<script type=\"text/javascript\">");
			    out.println("alert('Invalid username or password.');");
			    out.println("location='index.html'");
			    out.println("</script>");
			}
		} else {
			if(LibrarianDao.authenticate(lib_email, lib_pass)) {
				String header2 = "<!DOCTYPE html>"
						  + "<head>\r\n"
						  + "  <meta charset='utf-8'>\r\n"
						  + "  <meta name='viewport' content='width=device-width, initial-scale=1'>\r\n"
						  + "  <title>Librarian Section</title>\r\n"
						  + "  <link rel='stylesheet' type='text/css' href='resources/css/bootstrap.min.css'/>\r\n"
						  + "  <link rel='stylesheet' type='text/css' href='resources/css/main.css'/>\r\n"
						  + "</head>\r\n\n"
						  + "<body>";
				out.println(header2);
				
				HttpSession session2 = request.getSession();
				session2.setAttribute("email","true");
				
				request.getRequestDispatcher("/WEB-INF/views/navigation/librarian-nav.html").include(request, response);
				out.println("<div class='container-fluid'>");
				request.getRequestDispatcher("/WEB-INF/views/carousel/librarian-carousel.html").include(request, response);	
			} else {
				out.println("<script type=\"text/javascript\">");
			    out.println("alert('Invalid username or password.');");
			    out.println("location='index.html'");
			    out.println("</script>");
			}		
		}
		
		out.println("</div>");
		request.getRequestDispatcher("/WEB-INF/views/navigation/footer.html").include(request, response);
		out.close();
	}
}
