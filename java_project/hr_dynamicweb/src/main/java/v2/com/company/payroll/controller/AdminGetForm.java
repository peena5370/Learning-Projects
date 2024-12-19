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
import v2.com.company.payroll.dao.ManagerDao;
import v2.com.company.payroll.dao.TitleDao;
import v2.com.company.payroll.dao.impl.DepartmentDaoImpl;
import v2.com.company.payroll.dao.impl.EmployeeDaoImpl;
import v2.com.company.payroll.dao.impl.ManagerDaoImpl;
import v2.com.company.payroll.dao.impl.TitleDaoImpl;
import v2.com.company.payroll.model.DepartmentModel;
import v2.com.company.payroll.model.EmployeeModel;
import v2.com.company.payroll.model.ManagerModel;
import v2.com.company.payroll.model.TitleModel;

public class AdminGetForm extends HttpServlet {
	private static final long serialVersionUID = -3034592015534741336L;
	
	private ManagerDao managerDao = new ManagerDaoImpl();
	private EmployeeDao employeeDao = new EmployeeDaoImpl();
	private TitleDao titleDao = new TitleDaoImpl();
	private DepartmentDao departmentDao = new DepartmentDaoImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pathInfo = req.getPathInfo();
		
		HttpSession session = req.getSession();

		List<TitleModel> title_list = titleDao.getAllTitleList();
		session.setAttribute("titleList", title_list);	

		List<DepartmentModel> dept_list = departmentDao.getAllDepartment();
		session.setAttribute("deptList", dept_list);
		
		switch(pathInfo) {
			case "/addManager":
				req.getRequestDispatcher("/WEB-INF/v2/views/admin/form-add-manager.jsp").forward(req, resp);
				break;
			case "/updateManager":
				Integer id = Integer.valueOf(req.getParameter("id"));
				ManagerModel manager = managerDao.getManagerByManagerId(id);
				session.setAttribute("manager", manager);
				req.getRequestDispatcher("/WEB-INF/v2/views/admin/form-edit-manager.jsp").forward(req, resp);
				break;
			case "/updateManagerPassword":
				req.getRequestDispatcher("/WEB-INF/v2/views/admin/form-edit-manager-password.jsp").forward(req, resp);
				break;
			case "/addEmployee":
				req.getRequestDispatcher("/WEB-INF/v2/views/admin/form-add-employee.jsp").forward(req, resp);
				break;
			case "/updateEmployee":
				Integer e_id = Integer.valueOf(req.getParameter("id"));
				EmployeeModel employee = employeeDao.getEmployeeByEmployeeId(e_id);
				session.setAttribute("updateEmployee", employee);
				req.getRequestDispatcher("/WEB-INF/v2/views/admin/form-edit-employee.jsp").forward(req, resp);
				break;	
			case "/updateEmployeePassword":
				req.getRequestDispatcher("/WEB-INF/v2/views/admin/form-edit-employee-password.jsp").forward(req, resp);
				break;	
			case "/addTitle":
				req.getRequestDispatcher("/WEB-INF/v2/views/admin/form-add-title.jsp").forward(req, resp);
				break;
			case "/updateTitle":
				req.getRequestDispatcher("/WEB-INF/v2/views/admin/form-edit-title.jsp").forward(req, resp);
				break;
			case "/addDepartment":
				req.getRequestDispatcher("/WEB-INF/v2/views/admin/form-add-department.jsp").forward(req, resp);
				break;
			case "/updateDepartment":
				req.getRequestDispatcher("/WEB-INF/v2/views/admin/form-edit-department.jsp").forward(req, resp);
				break;
			default:
				break;
		}
	}
	
}
