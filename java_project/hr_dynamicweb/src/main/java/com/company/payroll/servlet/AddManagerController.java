package com.company.payroll.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.payroll.dao.ManagerDao;
import com.company.payroll.model.ManagerModel;
import com.company.payroll.services.PasswordEncription;

public class AddManagerController extends HttpServlet {
	private static final long serialVersionUID = 2081979556313864732L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String m_name = req.getParameter("fullname");
    	String m_role = req.getParameter("role");
    	String pass = req.getParameter("password");
    	String confirmed_pass = req.getParameter("c_password");
    	String post = req.getParameter("position");
    	String dept = req.getParameter("department");
    	String phone_num = req.getParameter("phone");
    	String mail = req.getParameter("email");
    	
    	PrintWriter out = resp.getWriter();
    	
    	if(pass.equals(confirmed_pass) && !pass.isEmpty()) {
    		String salt = PasswordEncription.getSaltvalue(30);
	    	String hashed_password = PasswordEncription.generateSecurePassword(pass, salt);

	    	ManagerModel manager = new ManagerModel(hashed_password, salt, m_role, m_name, post, dept, phone_num, mail);
	    	
	    	int status = ManagerDao.add(manager);
	    	if(status > 0) {
	    		String success_str = "<script type='text/javascript'>\n"
								   + "alert('Sucessful added new user.');\n"
								   + "location='admin?addManager';\n"
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
	}

}
