package com.learning.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class UserLogin extends HttpServlet {
       
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		
		String queryString = request.getQueryString();
		if(queryString.equals("admin")) {
			request.getRequestDispatcher("/WEB-INF/views/form/admin.html").include(request, response);
			out.close();
		} else if(queryString.equals("librarian")) {
			request.getRequestDispatcher("/WEB-INF/views/form/librarian.html").include(request, response);
			out.close();
		} else {
			request.getRequestDispatcher("index.html").include(request, response);
			out.close();
		}
	}
}
