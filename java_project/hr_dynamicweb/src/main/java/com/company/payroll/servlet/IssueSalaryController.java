package com.company.payroll.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.company.payroll.dao.ManagerDao;
import com.company.payroll.model.MonthlySalaryModel;

public class IssueSalaryController extends HttpServlet {
	private static final long serialVersionUID = 4277800658489216481L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		String manager_name = session.getAttribute("username").toString();
		String e_name = req.getParameter("employee_name");
    	Double base_salary = Double.valueOf(req.getParameter("base_salary").toString());
    	Double ot_salary = Double.valueOf(req.getParameter("ot_pay").toString());
    	Double deduct_salary = Double.valueOf(req.getParameter("deduction").toString());
    	Double total_salary = base_salary + ot_salary - deduct_salary;
    	Date date = Date.valueOf(req.getParameter("date_issue").toString());
    	
    	PrintWriter out = resp.getWriter();
    	
    	MonthlySalaryModel salary = new MonthlySalaryModel(base_salary, ot_salary, deduct_salary, total_salary, e_name, manager_name, date);
    	int status = ManagerDao.issueSalary(salary);
    	if(status > 0) {	
    		String success_str = "<script type='text/javascript'>\n"
							   + "alert('Sucessful issued employee salary.');\n"
							   + "location='manager?issueSalary';\n"
							   + "</script>";
    		out.println(success_str);
		} else {
			String fail_str = "<script type='text/javascript'>\n"
					 		+ "alert('Failed to issue salary.');\n"
					 		+ "location='manager?viewSalary';\n"
					 		+ "</script>";
			out.println(fail_str);
		}
	}
}
