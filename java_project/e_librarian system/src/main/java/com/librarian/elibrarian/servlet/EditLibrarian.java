package com.librarian.elibrarian.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.librarian.elibrarian.dao.LibrarianDao;
import com.librarian.elibrarian.model.Librarian;

@SuppressWarnings("serial")
public class EditLibrarian extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		
		String title = "Librarian Information Update Form";
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
		
		String sid = request.getParameter("id");
		int lib_id = Integer.parseInt(sid);
		Librarian librarian = LibrarianDao.viewById(lib_id);
		
		out.println("<form action='EditLibrarian' method='POST'>"
				  	+ "<div class='form-row'>");
		out.println("<div class='form-group col-6'>\r\n"
				  + "	<input type='hidden' class='form-control' name='librarian_id' value='" + librarian.getLib_id() + "'/>"
				  + "	<label for='librarian_name' class='form-label'>Librarian Name</label>\r\n"
				  + "	<input type='text' class='form-control' id='librarian_name' name='librarian_name'/>\r\n"
				  + "</div>\r\n"
				  + "<div class='form-group col-6'>\r\n"
				  + "    <label for='librarian_email' class='form-label'>Email Address</label>\r\n"
				  + "    <input type='email' class='form-control' id='librarian_email' name='librarian_email' placeholder='example123@mail.com'/>\r\n"
				  + "</div>\r\n"
				  + "<div class='form-group col-6'>\r\n"
				  + "	<label for='librarian password' class='form-label'>Password</label>\r\n"
				  + "	<input type='password' class='form-control' id='librarian_password' name='librarian_password'/>\r\n"
				  + "</div>\r\n"
				  + "<div class='form-group col-6'>\r\n"
				  + "    <label for='librarian_phone' class='form-label'>Phone Number</label>\r\n"
				  + "    <input type='text' class='form-control' id='librarian_phone' name='librarian_phone' placeholder='012-2345678'/>\r\n"
				  + "</div>\r\n");
		out.println("</div>\r\n");
		out.println("<button type='submit' class='btn btn-primary mt-3'>Update</button>");
		out.println("</form>");

		out.println("</div>");
		request.getRequestDispatcher("/WEB-INF/views/navigation/footer.html").include(request, response);
		out.close();
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		String sid = request.getParameter("librarian_id");
		int lib_id = Integer.parseInt(sid);
		String lib_name = request.getParameter("librarian_name");
		String lib_email = request.getParameter("librarian_email");
		String lib_pass = request.getParameter("librarian_password");
		String lib_phone = request.getParameter("librarian_phone");
		
		Librarian librarian = new Librarian(lib_id, lib_name, lib_email,lib_pass, lib_phone);
		LibrarianDao.update(librarian);
		out.println("<script type=\"text/javascript\">");
	    out.println("alert('Update Successful.');");
	    out.println("location='ViewLibrarian'");
	    out.println("</script>");
	    out.close();
	}
}
