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

import com.company.payroll.dao.ManagerDao;
import com.company.payroll.model.SalaryModel;

public class IssueIncrementController extends HttpServlet {
	private static final long serialVersionUID = -6243635596959237199L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String issuer = req.getParameter("user");
		String e_name = req.getParameter("name");

		req.setAttribute("manager_name", issuer);
		req.setAttribute("emp_name", e_name);
		req.getRequestDispatcher("/WEB-INF/views/manager/issue-increment.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String e_name = req.getParameter("employee_name");
		String manager_name = req.getParameter("manager_name");
		Double inc_salary = Double.valueOf(req.getParameter("incremented_salary").toString());
    	DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	Date date = new Date(System.currentTimeMillis());
    	String inc_date = dateFormat.format(date);
    	
    	PrintWriter out = resp.getWriter();
		
		SalaryModel salary = new SalaryModel(inc_salary, inc_date, e_name, manager_name);
    	int status = ManagerDao.issueIncrement(salary);
    	if(status > 0) {
    		String success_str = "<script type='text/javascript'>\n"
							   + "alert('Sucessful updated info.');\n"
							   + "window.close();\n"
							   + "window.opener.location='manager?viewSalary';\n"
							   + "</script>";
			out.println(success_str);
    	} else {
    		String fail_str = "<script type='text/javascript'>\n"
					 		+ "alert('Failed to update employee salary.');\n"
					 		+ "window.opener.location='manager?viewSalary';\n"
					 		+ "</script>";
    		out.println(fail_str);
    	}
	}
}
