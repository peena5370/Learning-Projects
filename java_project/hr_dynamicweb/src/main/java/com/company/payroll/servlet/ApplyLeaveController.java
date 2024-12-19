package com.company.payroll.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.company.payroll.dao.EmployeeDao;
import com.company.payroll.model.LeaveModel;

public class ApplyLeaveController extends HttpServlet {
	private static final long serialVersionUID = -3452948443967665003L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String reason = req.getParameter("reasons");
    	String leaveType = req.getParameter("leave_type");
    	Date date_from = Date.valueOf(req.getParameter("date_from").toString());
    	String time_from = req.getParameter("time_from");
    	String str_dateTimeFrom = date_from.toString() + " " + time_from;
    	Date date_to = Date.valueOf(req.getParameter("date_to").toString());
    	String time_to = req.getParameter("time_to");
    	String str_dateTimeTo = date_to.toString() + " " + time_to;
    	String status = "PENDING";
    	HttpSession session = req.getSession();
    	Integer e_id = Integer.valueOf(session.getAttribute("id").toString());
    	
    	PrintWriter out = resp.getWriter();
    	
    	LeaveModel leave = new LeaveModel(reason, str_dateTimeFrom, str_dateTimeTo, leaveType, status, e_id);
    	int l_status = EmployeeDao.issueLeave(leave);
    	if(l_status > 0) {
    		String success_str = "<script type='text/javascript'>\n"
							   + "alert('Application success, please query with your manager for further informations.');\n"
							   + "location='employee?leave';\n"
							   + "</script>";
    		out.println(success_str);
    	} else {
    		String fail_str = "<script type='text/javascript'>\n"
					 		+ "alert('Failed to apply leave. Please try again.');\n"
					 		+ "location='employee?applyLeave';\n"
					 		+ "</script>";
    		out.println(fail_str);
    	}
	}
}
