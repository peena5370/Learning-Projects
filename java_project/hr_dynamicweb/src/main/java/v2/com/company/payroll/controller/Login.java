package v2.com.company.payroll.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.company.payroll.services.PasswordEncription;

import v2.com.company.payroll.dao.AccountDao;
import v2.com.company.payroll.dao.DepartmentDao;
import v2.com.company.payroll.dao.EmployeeDao;
import v2.com.company.payroll.dao.EmployeeSalaryDao;
import v2.com.company.payroll.dao.ManagerDao;
import v2.com.company.payroll.dao.PayRollDao;
import v2.com.company.payroll.dao.TitleDao;
import v2.com.company.payroll.dao.impl.AccountDaoImpl;
import v2.com.company.payroll.dao.impl.DepartmentDaoImpl;
import v2.com.company.payroll.dao.impl.EmployeeDaoImpl;
import v2.com.company.payroll.dao.impl.EmployeeSalaryDaoImpl;
import v2.com.company.payroll.dao.impl.ManagerDaoImpl;
import v2.com.company.payroll.dao.impl.PayRollDaoImpl;
import v2.com.company.payroll.dao.impl.TitleDaoImpl;
import v2.com.company.payroll.model.AccountModel;
import v2.com.company.payroll.model.DepartmentModel;
import v2.com.company.payroll.model.EmployeeModel;
import v2.com.company.payroll.model.EmployeeSalaryModel;
import v2.com.company.payroll.model.ManagerModel;
import v2.com.company.payroll.model.PayRollModel;
import v2.com.company.payroll.model.TitleModel;

public class Login extends HttpServlet {
	private static final long serialVersionUID = -4509600893122288974L;

	private AccountDao accountDao = new AccountDaoImpl();
	private ManagerDao managerDao = new ManagerDaoImpl();
	private EmployeeDao employeeDao = new EmployeeDaoImpl();
	private DepartmentDao departmentDao = new DepartmentDaoImpl();
	private TitleDao titleDao = new TitleDaoImpl();
	private EmployeeSalaryDao salaryDao = new EmployeeSalaryDaoImpl();
	private PayRollDao payrollDao = new PayRollDaoImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/v2/views/login.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		HttpSession session = req.getSession();

		AccountModel account = accountDao.getPasswordKey(username);
		
		if(account != null) {
			Boolean validatePassword = PasswordEncription.verifyUserPassword(password, account.getPassword(), account.getKey());
			session.setAttribute("username", username);
			if(validatePassword==true) {
				ManagerModel manager = managerDao.getManagerById(account.getId());
				EmployeeModel employee = employeeDao.getEmployeeById(account.getId());

				List<TitleModel> title_list = titleDao.getAllTitleList();
				session.setAttribute("titleList", title_list);
				
				List<DepartmentModel> dept_list = departmentDao.getAllDepartment();
				session.setAttribute("deptList", dept_list);
				
				if(manager != null) {
					String role = manager.getRole();
					
					switch(role) {
						case "Administrator":
							List<ManagerModel> manager_list = managerDao.getAllManagerList();
							session.setAttribute("user", manager);
							session.setAttribute("managerList", manager_list);
							req.getRequestDispatcher("/WEB-INF/v2/views/admin/main.jsp").forward(req, resp);
							break;
						case "Manager":
							List<EmployeeModel> employee_list = employeeDao.listAllEmployee();
							session.setAttribute("user", manager);
							session.setAttribute("employeeList", employee_list);
							req.getRequestDispatcher("/WEB-INF/v2/views/manager/main.jsp").forward(req, resp);
							break;
						default:
							break;
					}
				} else if(employee != null) {
					String name = employee.getFullname();
					EmployeeSalaryModel salary = salaryDao.getSalaryByEmployeeName(name);
					List<PayRollModel> payroll_list = payrollDao.getListByEmployee(name);
					
					session.setAttribute("user", employee);
					session.setAttribute("userFullname", name);
					session.setAttribute("employeeSalary", salary);
					session.setAttribute("payrollList", payroll_list);
					req.getRequestDispatcher("/WEB-INF/v2/views/employee/main.jsp").forward(req, resp);
				} else {
					String user_str = "No such user, please get further assistance from administrator.";
					alertMessage(req, resp, user_str);
				}
			} else {
				String pass_str = "Wrong password, please try again";
				alertMessage(req, resp, pass_str);
			}
		} else {
			String acc_str = "Wrong user name or password, please try again.";
			alertMessage(req, resp, acc_str);
		}	
	}
	
	private void alertMessage(HttpServletRequest req, HttpServletResponse resp, String text) throws IOException {
		PrintWriter out = resp.getWriter();
		
		HttpSession session = req.getSession();
		
		String alert_str = "<script type='text/javascript'>\n"
						 + "alert('" + text + "');\n"
						 + "location='user-login';\n"
						 + "</script>";
		
		out.println(alert_str);
		session.invalidate();
	}
}
