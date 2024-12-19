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
import com.company.payroll.model.TrainingModel;

public class IssueTrainingController extends HttpServlet {
	private static final long serialVersionUID = -8051643489180982610L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		String username = session.getAttribute("username").toString();
		String e_name = req.getParameter("employee_name");
    	String info = req.getParameter("training_info");
    	Date startdate = Date.valueOf(req.getParameter("date_start").toString());
    	Date enddate = Date.valueOf(req.getParameter("date_end").toString());
    	String training_status = "PENDING";
    	
    	PrintWriter out = resp.getWriter();

    	TrainingModel training = new TrainingModel(info, startdate, enddate, training_status, e_name, username);
    	int status = ManagerDao.issueTraining(training);
    	if(status > 0) {
    		String success_str = "<script type='text/javascript'>\n"
							   + "alert('Sucessful issued employee training info.');\n"
							   + "location='manager?viewTraining';\n"
							   + "</script>";
    		out.println(success_str);
    	} else {
    		String fail_str = "<script type='text/javascript'>\n"
					 		+ "alert('Failed to issue employee training info.');\n"
					 		+ "location='manager?viewTraining';\n"
					 		+ "</script>";
    		out.println(fail_str);
    	}
	}
	
	

}
