package com.company.payroll.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.payroll.dao.EmployeeDao;
import com.company.payroll.dao.ManagerDao;


public class DeleteUserController extends HttpServlet {
	private static final long serialVersionUID = 2330732710497475250L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String user = req.getParameter("user");
		String role = req.getParameter("role");
		
		PrintWriter out = resp.getWriter();
		
		switch(user) {
			case "admin":
				if(role.equals("manager")) {
					Integer id = Integer.valueOf(req.getParameter("id"));
					
		            int status = ManagerDao.delete(id);
		            if(status > 0) {
		            	String success_str = "<script type='text/javascript'>\n"
								   + "alert('User have been deleted.');\n"
								   + "location='admin?viewManager';\n"
								   + "</script>";
		            	out.println(success_str);
		            } else {
		            	String fail_str = "<script type='text/javascript'>\n"
								 		+ "alert('Failed to delete manager.');\n"
								 		+ "location='admin?viewManager';\n"
								 		+ "</script>";
		            	out.println(fail_str);
		            }
				} else if(role.equals("employee")) {
					Integer id = Integer.valueOf(req.getParameter("id"));
	
		            int status = EmployeeDao.delete(id);     
		            if(status > 0) {
		                String success_str = "<script type='text/javascript'>\n"
										   + "alert('User have been deleted.');\n"
										   + "location='admin?viewEmployee';\n"
										   + "</script>";
		                out.println(success_str);
		            } else {
		            	String fail_str = "<script type='text/javascript'>\n"
								 		+ "alert('Failed to delete employee.');\n"
								 		+ "location='javascript:history.back();';\n"
								 		+ "</script>";
		            	out.println(fail_str);
		            }
				} else {
					System.out.println("User delete error");
				}
				break;
			case "manager":
				Integer id = Integer.valueOf(req.getParameter("id"));
	
	            int status = EmployeeDao.delete(id);     
	            if(status > 0) {
	                String success_str = "<script type='text/javascript'>\n"
									   + "alert('User have been deleted.');\n"
									   + "location='manager?viewEmployee';\n"
									   + "</script>";
	                out.println(success_str);
	            } else {
	            	String fail_str = "<script type='text/javascript'>\n"
							 		+ "alert('Failed to delete employee.');\n"
							 		+ "location='javascript:history.back();';\n"
							 		+ "</script>";
	            	out.println(fail_str);
	            }
				break;
			default:
				break;
		}
			
	}
}
