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
import com.company.payroll.model.ResignationModel;

public class IssueResignationController extends HttpServlet {
	private static final long serialVersionUID = -1895905166219149567L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		String username = session.getAttribute("username").toString();
		String e_name = req.getParameter("employee_name");
    	String reasons = req.getParameter("reason");
    	Date end_date = Date.valueOf(req.getParameter("date_end").toString());
    	String end_time = req.getParameter("time_end");
    	String str_date = end_date.toString() + " " + end_time;
    	
    	PrintWriter out = resp.getWriter();

    	ResignationModel resign = new ResignationModel(reasons, end_date, e_name, username);
    	int status = ManagerDao.issueResignation(resign);
		int status2 = ManagerDao.insertResignDate(str_date, e_name);
    	if(status > 0 && status2 > 0) {
	    	String success_str = "<script type='text/javascript'>\n"
							   + "alert('Resign details issued.');\n"
							   + "location='manager?viewResignation';\n"
							   + "</script>";
	    	out.println(success_str);
    	} else {
	    	String fail_str = "<script type='text/javascript'>\n"
					 		+ "alert('Failed to issue resign details.');\n"
					 		+ "location='manager?issueResignation';\n"
					 		+ "</script>";
	    	out.println(fail_str);
    	}
	}
}
