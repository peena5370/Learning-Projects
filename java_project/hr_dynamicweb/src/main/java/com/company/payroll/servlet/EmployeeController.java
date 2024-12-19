package com.company.payroll.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.company.payroll.dao.EmployeeDao;
import com.company.payroll.model.LeaveModel;
import com.company.payroll.model.MonthlySalaryModel;
import com.company.payroll.model.TrainingModel;

public class EmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1123953408949353803L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String queryStr = req.getQueryString();
		HttpSession session = req.getSession();
		Integer e_id = Integer.valueOf(session.getAttribute("id").toString());
		
		switch(queryStr) {
		case "profile":
			req.getRequestDispatcher("/WEB-INF/views/employee/employee.jsp").forward(req, resp);
			break;
		case "training":
			List<TrainingModel> training_list = EmployeeDao.viewTraining(e_id);
			session.setAttribute("training_list", training_list);
			req.getRequestDispatcher("/WEB-INF/views/employee/training.jsp").forward(req, resp);
			break;
		case "salary":
			List<MonthlySalaryModel> salary_list = EmployeeDao.viewSalary(e_id);
			session.setAttribute("salary_list", salary_list);
			req.getRequestDispatcher("/WEB-INF/views/employee/salary.jsp").forward(req, resp);
			break;
		case "leave":
			List<LeaveModel> leave_list = EmployeeDao.viewLeave(e_id);
			session.setAttribute("leave_list", leave_list);
			req.getRequestDispatcher("/WEB-INF/views/employee/leave.jsp").forward(req, resp);
			break;
		case "applyLeave":
			req.getRequestDispatcher("/WEB-INF/views/employee/apply-leave.jsp").forward(req, resp);
			break;
		case "applyLoan":
			req.getRequestDispatcher("/WEB-INF/views/employee/apply-loan.jsp").forward(req, resp);
			break;
		default:
			break;
	}
	}
}
