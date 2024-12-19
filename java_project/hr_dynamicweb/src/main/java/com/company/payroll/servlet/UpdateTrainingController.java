package com.company.payroll.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.payroll.dao.EmployeeDao;

public class UpdateTrainingController extends HttpServlet {
	private static final long serialVersionUID = -6975665385729101485L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer t_id = Integer.valueOf(req.getParameter("id").toString());
		Integer e_id = Integer.valueOf(req.getParameter("employee_id").toString());
		String status = "COMPLETED";
		
		PrintWriter out = resp.getWriter();

		int trainingStatus = EmployeeDao.updateTraining(status, e_id, t_id);
		if(trainingStatus > 0) {
			String success_str = "<script type='text/javascript'>\n"
							   + "alert('Status Updated.');\n"
							   + "location='employee?training';\n"
							   + "</script>";
			out.println(success_str);
		} else {
			String fail_str = "<script type='text/javascript'>\n"
					 		+ "alert('Status update failed. Please try again later.');\n"
					 		+ "location='employee?training';\n"
					 		+ "</script>";
			out.println(fail_str);
		}
	}
	
}
