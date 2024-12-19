package com.company.payroll.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.payroll.dao.EmployeeDao;
import com.company.payroll.model.EmployeeModel;
import com.company.payroll.services.PasswordEncription;

public class AddEmployeeController extends HttpServlet {
	private static final long serialVersionUID = -4459450560783452390L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	String user = req.getParameter("user");
		String name = req.getParameter("fullname");
    	String post = req.getParameter("position");
    	String pass = req.getParameter("password");
    	String confirmed_pass = req.getParameter("c_password");
    	String dept = req.getParameter("department");
    	Double salary = Double.valueOf(req.getParameter("salary"));
    	String phone_num = req.getParameter("phone");
    	String mail = req.getParameter("email");
    	
    	DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	Date date = new Date(System.currentTimeMillis());
    	String startdate = dateFormat.format(date);
    	
    	PrintWriter out = resp.getWriter();
    	
    	switch(user) {
	    	case "admin":
	    		if(pass.equals(confirmed_pass) && !pass.isEmpty()) {
	        		String salt = PasswordEncription.getSaltvalue(30);
	    	    	String hashed_password = PasswordEncription.generateSecurePassword(pass, salt);
	    	    	EmployeeModel employee = new EmployeeModel(hashed_password, salt, name, post, dept, salary, phone_num, mail, startdate);
	    	    	
	    	    	int status = EmployeeDao.add(employee);
		    		int status2 = EmployeeDao.addBaseSalary(employee);
			    	if(status > 0 && status2 > 0) {
			    		String success_str = "<script type='text/javascript'>\n"
										   + "alert('Sucessful added new user.');\n"
										   + "location='admin?addEmployee';\n"
										   + "</script>";
			    		out.println(success_str);
			    	} else {
			    		String fail_str = "<script type='text/javascript'>\n"
								 		+ "alert('Failed to add new user.');\n"
								 		+ "location='javascript:history.back();';\n"
								 		+ "</script>";
			    		out.println(fail_str);
			    	}	
	    	    } else {
	    	    	String fail_str = "<script type='text/javascript'>\n"
							 		+ "alert('Password and confirmed password doesn't match!');\n"
							 		+ "location='javascript:history.back();';\n"
							 		+ "</script>";
	    	    	out.println(fail_str);
	    	    }
	    		break;
	    	case "manager":
	    		if(pass.equals(confirmed_pass) && !pass.isEmpty()) {
	        		String salt = PasswordEncription.getSaltvalue(30);
	    	    	String hashed_password = PasswordEncription.generateSecurePassword(pass, salt);
	    	    	EmployeeModel employee = new EmployeeModel(hashed_password, salt, name, post, dept, salary, phone_num, mail, startdate);
	    	    	
	    	    	int status = EmployeeDao.add(employee);
	        		int status2 = EmployeeDao.addBaseSalary(employee);
	    	    	if(status > 0 && status2 > 0) {
	    	    		String success_str = "<script type='text/javascript'>\n"
	    								   + "alert('Sucessful added new user.');\n"
	    								   + "location='manager?addEmployee';\n"
	    								   + "</script>";
	    	    		out.println(success_str);
	    	    	} else {
	    	    		String fail_str = "<script type='text/javascript'>\n"
	    						 		+ "alert('Failed to add new user.');\n"
	    						 		+ "location='javascript:history.back();';\n"
	    						 		+ "</script>";
	    	    		out.println(fail_str);
	    	    	}	
	    	    } else {
	    	    	String fail_str = "<script type='text/javascript'>\n"
							 		+ "alert('Password and confirmed password doesn't match!');\n"
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
