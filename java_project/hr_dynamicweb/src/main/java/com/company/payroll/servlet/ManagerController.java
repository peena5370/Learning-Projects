package com.company.payroll.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.company.payroll.dao.EmployeeDao;
import com.company.payroll.dao.ManagerDao;
import com.company.payroll.model.EmployeeModel;
import com.company.payroll.model.LeaveModel;
import com.company.payroll.model.LoanModel;
import com.company.payroll.model.MonthlySalaryModel;
import com.company.payroll.model.ResignationModel;
import com.company.payroll.model.SalaryModel;
import com.company.payroll.model.TrainingModel;

public class ManagerController extends HttpServlet {
	private static final long serialVersionUID = -4437760796497096471L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String queryStr = req.getQueryString();
		HttpSession session = req.getSession();
		switch(queryStr) {
			case "viewEmployee":
				List<EmployeeModel> employee_list = EmployeeDao.view();
		    	session.setAttribute("viewEmployee", employee_list);
				req.getRequestDispatcher("/WEB-INF/views/manager/manager.jsp").forward(req, resp);
				break;
			case "addEmployee":
				req.getRequestDispatcher("/WEB-INF/views/manager/add-employee.jsp").forward(req, resp);
				break;
			case "viewSalary":
				List<SalaryModel> salary_list = ManagerDao.viewEmployeeSalary();
				session.setAttribute("viewSalary", salary_list);
		    	req.getRequestDispatcher("/WEB-INF/views/manager/view-salary.jsp").forward(req, resp);
				break;
			case "viewPayment":
				List<MonthlySalaryModel> payment_list = ManagerDao.viewMonthlySalary();
				session.setAttribute("viewPayment", payment_list);
				req.getRequestDispatcher("/WEB-INF/views/manager/view-payment.jsp").forward(req, resp);
				break;
			case "issueSalary":
				req.getRequestDispatcher("/WEB-INF/views/manager/issue-salary.jsp").forward(req, resp);
				break;
			case "viewLeave":
				List<LeaveModel> leave_list = ManagerDao.viewLeave();
				session.setAttribute("viewLeave", leave_list);
				req.getRequestDispatcher("/WEB-INF/views/manager/view-leave.jsp").forward(req, resp);
				break;
			case "viewLoan":
				List<LoanModel> loan_list = ManagerDao.viewLoan();
				session.setAttribute("viewLoan", loan_list);
				req.getRequestDispatcher("/WEB-INF/views/manager/view-loan.jsp").forward(req, resp);
				break;
			case "viewTraining":
				List<TrainingModel> training_list = ManagerDao.viewTraining();
				session.setAttribute("viewTraining", training_list);
				req.getRequestDispatcher("/WEB-INF/views/manager/view-training.jsp").forward(req, resp);
				break;
			case "issueTraining":
				req.getRequestDispatcher("/WEB-INF/views/manager/issue-training.jsp").forward(req, resp);
				break;
			case "viewResignation":
				List<ResignationModel> resign_list = ManagerDao.viewResignation();
				session.setAttribute("viewResignation", resign_list);
				req.getRequestDispatcher("/WEB-INF/views/manager/view-resignation.jsp").forward(req, resp);
				break;
			case "issueResignation":
				req.getRequestDispatcher("/WEB-INF/views/manager/issue-resignation.jsp").forward(req, resp);
				break;
			default:
				break;
		}
	}
}
