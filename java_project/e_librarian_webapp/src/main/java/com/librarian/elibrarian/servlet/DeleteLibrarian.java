package com.librarian.elibrarian.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.librarian.elibrarian.dao.LibrarianDao;

@SuppressWarnings("serial")
public class DeleteLibrarian extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String sid=request.getParameter("id");
		int lib_id=Integer.parseInt(sid);
		
		LibrarianDao.delete(lib_id);
		out.println("<script type='text/javascript'>");
	    out.println("alert('Delete Successful.');");
	    out.println("location='ViewLibrarian'");
	    out.println("</script>");
	    out.close();
	}

}
