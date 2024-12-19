package com.company.payroll.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.company.payroll.dao.EmployeeDao;
import com.company.payroll.dao.UserDao;
import com.company.payroll.model.EmployeeModel;
import com.company.payroll.services.PasswordEncription;

public class EmployeeChangePasswordController extends HttpServlet {
	private static final long serialVersionUID = -8808104359432902756L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/employee/change-password.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String oldPass = req.getParameter("old_password");
		HttpSession session = req.getSession();
		Integer id = Integer.valueOf(session.getAttribute("id").toString());
		
		PrintWriter out = resp.getWriter();
		
    	EmployeeModel auth = UserDao.employeeAuth(id);
    	Boolean validate = PasswordEncription.verifyUserPassword(oldPass, auth.getPassword(), auth.getKey());
    	if(validate==true) {
        	String newPass = req.getParameter("new_password");
        	String confirmedPass = req.getParameter("c_password");
        	
        	if(newPass.equals(confirmedPass)) {
        		String salt = PasswordEncription.getSaltvalue(30);
		    	String hashed_password = PasswordEncription.generateSecurePassword(newPass, salt);
		    	
        		EmployeeModel employee = new EmployeeModel(id, hashed_password, salt);
        		int status = EmployeeDao.updatePassword(employee);
        		if(status > 0 ) {
        			String success_str = "<script type='text/javascript'>\n"
									   + "alert('Password changed successful.');\n"
									   + "window.close();\n"
									   + "window.opener.location='employee?profile';\n"
									   + "</script>";
        			out.println(success_str);
        		} else {
        			String fail_str1 = "<script type='text/javascript'>\n"
							 		 + "alert('Failed to change password');\n"
							 		 + "window.close();\n"
									 + "window.opener.location='employee?profile';\n"
							 		 + "</script>";
        			out.println(fail_str1);
        		}
        	} else {
        		String fail_str2 = "<script type='text/javascript'>\n"
						 		 + "alert('New password and confirmed password are not equal.');\n"
						 		 + "window.close();\n"
								 + "window.opener.location='employee?profile';\n"
						 		 + "</script>";
        		out.println(fail_str2);
        	}	
		} else {
			String fail_str3 = "<script type='text/javascript'>\n"
					 		 + "alert('Old password incorrect.');\n"
					 		 + "window.close();\n"
							 + "window.opener.location='employee?profile';\n"
					 		 + "</script>";
			out.println(fail_str3);
		}
	}

}
