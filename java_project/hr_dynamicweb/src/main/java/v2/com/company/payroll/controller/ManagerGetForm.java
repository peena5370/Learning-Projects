package v2.com.company.payroll.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import v2.com.company.payroll.dao.DepartmentDao;
import v2.com.company.payroll.dao.EmployeeDao;
import v2.com.company.payroll.dao.EmployeePromotionDao;
import v2.com.company.payroll.dao.TitleDao;
import v2.com.company.payroll.dao.impl.DepartmentDaoImpl;
import v2.com.company.payroll.dao.impl.EmployeeDaoImpl;
import v2.com.company.payroll.dao.impl.EmployeePromotionDaoImpl;
import v2.com.company.payroll.dao.impl.TitleDaoImpl;
import v2.com.company.payroll.model.DepartmentModel;
import v2.com.company.payroll.model.EmployeeModel;
import v2.com.company.payroll.model.EmployeePromotionModel;
import v2.com.company.payroll.model.TitleModel;

public class ManagerGetForm extends HttpServlet {
	private static final long serialVersionUID = -4958740914621982117L;
	
	private EmployeeDao employeeDao = new EmployeeDaoImpl();
	private TitleDao titleDao = new TitleDaoImpl();
	private DepartmentDao departmentDao = new DepartmentDaoImpl();
	private EmployeePromotionDao promotionDao = new EmployeePromotionDaoImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pathInfo = req.getPathInfo();
		
		HttpSession session = req.getSession();	

		List<TitleModel> title_list = titleDao.getAllTitleList();
		session.setAttribute("titleList", title_list);		

		List<DepartmentModel> dept_list = departmentDao.getAllDepartment();
		session.setAttribute("deptList", dept_list);
		
		switch(pathInfo) {
			case "/addEmployee":
				req.getRequestDispatcher("/WEB-INF/v2/views/manager/form-add-employee.jsp").forward(req, resp);
				break;
			case "/updateEmployee":
				Integer e_id = Integer.valueOf(req.getParameter("id"));
				EmployeeModel employee = employeeDao.getEmployeeByEmployeeId(e_id);
				session.setAttribute("updateEmployee", employee);
				req.getRequestDispatcher("/WEB-INF/v2/views/manager/form-edit-employee.jsp").forward(req, resp);
				break;
			case "/promoteEmployee":
				req.getRequestDispatcher("/WEB-INF/v2/views/manager/form-add-promotion.jsp").forward(req, resp);
				break;
			case "/updatePromotion":
				Integer pr_id = Integer.valueOf(req.getParameter("id"));
				EmployeePromotionModel promotion = promotionDao.getPromotionById(pr_id);
				session.setAttribute("updatePromotion", promotion);
				req.getRequestDispatcher("/WEB-INF/v2/views/manager/form-edit-promotion.jsp").forward(req, resp);
				break;
			case "/issueSalary":
				req.getRequestDispatcher("/WEB-INF/v2/views/manager/form-add-salary.jsp").forward(req, resp);
				break;
			case "/issueResignation":
				req.getRequestDispatcher("/WEB-INF/v2/views/manager/form-add-resign.jsp").forward(req, resp);
				break;
			case "/issueTraining":
				req.getRequestDispatcher("/WEB-INF/v2/views/manager/form-add-training.jsp").forward(req, resp);
				break;
			default:
				break;
		}
	}
}
