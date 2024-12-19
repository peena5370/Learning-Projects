package com.company.payroll.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.company.payroll.dao.EmployeeDao;
import com.company.payroll.model.EmployeeModel;

public class EmployeeEditInfoController extends HttpServlet {
	private static final long serialVersionUID = 8264385113630771597L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/employee/edit-info.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("fullname");
    	String post = req.getParameter("position");
    	String dept = req.getParameter("department");
    	String phone_num = req.getParameter("phone");
    	String mail = req.getParameter("email");
    	HttpSession session = req.getSession();
    	Integer id = Integer.valueOf(session.getAttribute("id").toString());
    	
    	PrintWriter out = resp.getWriter();
    	
    	EmployeeModel employee = new EmployeeModel(id, name, post, dept, phone_num, mail);
    	int status = EmployeeDao.update(employee);
    	if(status > 0) {
    		String success_str = "<script type='text/javascript'>\n"
						 		+ "alert('Sucessful updated info.');\n"
						 		+ "window.close();\n"
								+ "window.opener.location='employee?profile';\n"
						 		+ "</script>";
    		out.println(success_str);
    	} else {
    		String fail_str = "<script type='text/javascript'>\n"
					 		+ "alert('Failed to update info.');\n"
					 		+ "window.close();\n"
							+ "window.opener.location='employee?profile';\n"
					 		+ "</script>";
    		out.println(fail_str);
    	}
	}

}
