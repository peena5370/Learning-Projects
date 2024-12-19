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

public class Admin extends HttpServlet {
	private static final long serialVersionUID = -7566217692955844501L;
	
	private EmployeeDao employeeDao = new EmployeeDaoImpl();		
	private ManagerDao managerDao = new ManagerDaoImpl();	
	private TitleDao titleDao = new TitleDaoImpl();		
	private DepartmentDao departmentDao = new DepartmentDaoImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pathInfo = req.getPathInfo();
		
		HttpSession session = req.getSession();

		switch(pathInfo) {
			case "/view-manager":
				List<ManagerModel> manager_list = managerDao.getAllManagerList();
				session.setAttribute("managerList", manager_list);
				req.getRequestDispatcher("/WEB-INF/v2/views/admin/main.jsp").forward(req, resp);
				break;
			case "/view-employee":
				List<EmployeeModel> employee_list = employeeDao.listAllEmployee();
				session.setAttribute("employeeList", employee_list);
				req.getRequestDispatcher("/WEB-INF/v2/views/admin/view-employee.jsp").forward(req, resp);
				break;
			case "/view-account-employee":
				List<EmployeeModel> acc_list = employeeDao.getEmployeeAccountInfo();
				session.setAttribute("accList", acc_list);
				req.getRequestDispatcher("/WEB-INF/v2/views/admin/view-account-employee.jsp").forward(req, resp);
				break;
			case "/view-account-manager":
				List<ManagerModel> acc_list2 = managerDao.getManagerAccountInfo();
				session.setAttribute("accList2", acc_list2);
				req.getRequestDispatcher("/WEB-INF/v2/views/admin/view-account-manager.jsp").forward(req, resp);
				break;
			case "/view-title":
				List<TitleModel> title_list = titleDao.getAllTitleList();
				session.setAttribute("titleList", title_list);
				req.getRequestDispatcher("/WEB-INF/v2/views/admin/view-title.jsp").forward(req, resp);
				break;
			case "/view-department":
				List<DepartmentModel> dept_list = departmentDao.getAllDepartment();
				session.setAttribute("deptList", dept_list);
				req.getRequestDispatcher("/WEB-INF/v2/views/admin/view-department.jsp").forward(req, resp);
				break;
			case "/profile":
				Integer id = Integer.valueOf(req.getParameter("id"));
				ManagerModel manager = managerDao.getManagerByManagerId(id);
				session.setAttribute("user", manager);
				req.getRequestDispatcher("/WEB-INF/v2/views/admin/profile.jsp").forward(req, resp);
				break;
			default:
				break;
		}	
	}
}
