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
import com.company.payroll.model.ManagerModel;

public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 382561464273419085L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String queryStr = req.getQueryString();
		HttpSession session = req.getSession();
		switch(queryStr) {
			case "viewManager":
				List<ManagerModel> manager_list = ManagerDao.view();
				session.setAttribute("viewManager", manager_list);
				req.getRequestDispatcher("/WEB-INF/views/admin/admin.jsp").forward(req, resp);
				break;
			case "addManager":
				req.getRequestDispatcher("/WEB-INF/views/admin/add-manager.jsp").forward(req, resp);
				break;
			case "viewEmployee":
				List<EmployeeModel> employee_list = EmployeeDao.view();
		    	session.setAttribute("viewEmployee", employee_list);
		    	req.getRequestDispatcher("/WEB-INF/views/admin/view-employee.jsp").forward(req, resp);
				break;
			case "addEmployee":
				req.getRequestDispatcher("/WEB-INF/views/admin/add-employee.jsp").forward(req, resp);
				break;
			default:
				break;
		}
	}
	
}
