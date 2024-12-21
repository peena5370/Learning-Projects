package com.librarian.elibrarian.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.librarian.elibrarian.dao.BooksDao;

@SuppressWarnings("serial")
public class DeleteBook extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String callno = request.getParameter("callno");
		
		BooksDao.delete(callno);
		out.println("<script type='text/javascript'>");
	    out.println("alert('Delete Successful.');");
	    out.println("location='ViewBook'");
	    out.println("</script>");
	    out.close();
	}

}
