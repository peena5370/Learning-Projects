package v2.com.company.payroll.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EmployeeGetForm extends HttpServlet {
	private static final long serialVersionUID = 7873443910685521423L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pathInfo = req.getPathInfo();
		
		switch(pathInfo) {
			case "/applyLeave":
				req.getRequestDispatcher("/WEB-INF/v2/views/employee/form-add-leave.jsp").forward(req, resp);
				break;
			case "/applyLoan":
				req.getRequestDispatcher("/WEB-INF/v2/views/employee/form-add-loan.jsp").forward(req, resp);
				break;
			default:
				break;
		}
	}	
}
