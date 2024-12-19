package v2.com.company.payroll.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.company.payroll.services.PasswordEncription;

import v2.com.company.payroll.dao.AccountDao;
import v2.com.company.payroll.dao.DepartmentDao;
import v2.com.company.payroll.dao.EmployeeDao;
import v2.com.company.payroll.dao.ManagerDao;
import v2.com.company.payroll.dao.TitleDao;
import v2.com.company.payroll.dao.impl.AccountDaoImpl;
import v2.com.company.payroll.dao.impl.DepartmentDaoImpl;
import v2.com.company.payroll.dao.impl.EmployeeDaoImpl;
import v2.com.company.payroll.dao.impl.ManagerDaoImpl;
import v2.com.company.payroll.dao.impl.TitleDaoImpl;
import v2.com.company.payroll.model.AccountModel;
import v2.com.company.payroll.model.DepartmentModel;
import v2.com.company.payroll.model.EmployeeModel;
import v2.com.company.payroll.model.ManagerModel;

public class AdminPostForm extends HttpServlet {
	private static final long serialVersionUID = -6518343062768628602L;
	
	private ManagerDao managerDao = new ManagerDaoImpl();
	private EmployeeDao employeeDao = new EmployeeDaoImpl();	
	private AccountDao accountDao = new AccountDaoImpl();
	private TitleDao titleDao = new TitleDaoImpl();
	private DepartmentDao departmentDao = new DepartmentDaoImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pathInfo = req.getPathInfo();
		
		switch(pathInfo) {
			case "/deleteManager":
				deleteManager(req, resp);
				break;
			case "/deleteEmployee":
				deleteEmployee(req, resp);
				break;
			default:
				break;
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pathInfo = req.getPathInfo();
		
		switch(pathInfo) {
			case "/submitManager":
				submitManager(req, resp);
				break;
			case"/submitUpdateManager":
				submitUpdateManager(req, resp);
				break;
			case "/submitEmployee":
				submitEmployee(req, resp);
				break;
			case "/submitUpdateEmployee":
				submitUpdateEmployee(req, resp);
				break;
			case "/updateManagerPassword":
				updateManagerPassword(req, resp);
				break;
			case "/updateEmployeePassword":
				updateEmployeePassword(req, resp);
				break;
			case "/submitTitle":
				submitTitle(req, resp);
				break;
			case "/updateTitle":
				updateTitle(req, resp);
				break;
			case "/submitDepartment":
				submitDepartment(req, resp);
				break;
			case "/updateDepartment":
				updateDepartment(req, resp);
				break;
			case "/submitUpdateProfile":
				submitUpdateProfile(req, resp);
				break;
			case "/updateProfilePassword":
				updateProfilePassword(req, resp);
				break;
			default:
				break;
		}
	}
	
	private void deleteManager(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		
		int id = Integer.valueOf(req.getParameter("id"));
		Boolean status = managerDao.deleteManager(id);
		if(status) {
			String output = "<script type='text/javascript'>\n"
				 	  + "alert('Successful delete user.');\n"
				 	  + "location='" + req.getContextPath() + "/v2/admin/view-manager';\n"
				 	  + "</script>";

			out.println(output);
		} else {
			String output = "<script type='text/javascript'>\n"
				 	  + "alert('Failed to delete user. Please try again.');\n"
				 	  + "location='" + req.getContextPath() + "/v2/admin/view-manager';\n"
				 	  + "</script>";

			out.println(output);
		}
	}
	
	private void deleteEmployee(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		
		int id = Integer.valueOf(req.getParameter("id"));
		Boolean status = employeeDao.deleteEmployee(id);
		if(status) {
			String output = "<script type='text/javascript'>\n"
				 	  + "alert('Successful delete user.');\n"
				 	  + "location='" + req.getContextPath() + "/v2/admin/view-employee';\n"
				 	  + "</script>";

			out.println(output);
		} else {
			String output = "<script type='text/javascript'>\n"
				 	  + "alert('Failed to delete user. Please try again.');\n"
				 	  + "location='" + req.getContextPath() + "/v2/admin/view-employee';\n"
				 	  + "</script>";

			out.println(output);
		}
	}
	
	private void submitManager(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		
		String fullname = req.getParameter("fullname");
		String role = req.getParameter("role");
		String gender = req.getParameter("gender");
		int age = Integer.valueOf(req.getParameter("age"));
		String martialStatus = req.getParameter("martial-status");
		String education = req.getParameter("education");
		String address = req.getParameter("address");
		String state = req.getParameter("state");
		String country = req.getParameter("country");
		String phone = req.getParameter("phone");
		String email = req.getParameter("email");
		String dept = req.getParameter("department");
		String title = req.getParameter("title");
		LocalDate dateHired = LocalDate.now();
		
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String c_password = req.getParameter("c_password");
		
		if(password.equals(c_password)) {
			LocalDateTime nowDateTime = LocalDateTime.now();
			String dateCreated = nowDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
			
			String salt = PasswordEncription.getSaltvalue(30);
	    	String hashedPassword = PasswordEncription.generateSecurePassword(password, salt);

	    	AccountModel account = new AccountModel(username, hashedPassword, salt, dateCreated);
			Boolean accountStatus = accountDao.addNewAccount(account);
			if(accountStatus) {
				ManagerModel manager = new ManagerModel(fullname, role, gender, age, martialStatus, education, address, state, country, phone, email, dateHired, null,  
														username, dept, title);
				Boolean status = managerDao.addManager(manager);
				if(status) {
					String output = "<script type='text/javascript'>\n"
							 	  + "alert('Successful added new user.');\n"
							 	  + "location='" + req.getContextPath() + "/v2/admin/view-manager';\n"
							 	  + "</script>";
					out.println(output);
				} else {
					String output = "<script type='text/javascript'>\n"
						 	  + "alert('Failed to add user. Please try again.');\n"
						 	  + "location='" + req.getContextPath() + "/v2/admin/view-manager';\n"
						 	  + "</script>";
		
					out.println(output);
				}
			} else {
				String output = "<script type='text/javascript'>\n"
					 	  + "alert('Failed to add account.');\n"
					 	  + "location='" + req.getContextPath() + "/v2/admin/view-manager';\n"
					 	  + "</script>";

				out.println(output);
			}
		} else {
			String output = "<script type='text/javascript'>\n"
				 	  + "alert('Password and confirmed password are not equal.');\n"
				 	  + "location='" + req.getContextPath() + "/v2/admin/view-manager';\n"
				 	  + "</script>";

			out.println(output);
		}
			
	}
	
	private void submitUpdateManager(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		
		int id = Integer.valueOf(req.getParameter("id"));
		String name = req.getParameter("fullname");
		String gender = req.getParameter("gender");
		int age = Integer.valueOf(req.getParameter("age"));
		String martialStatus = req.getParameter("martial-status");
		String education = req.getParameter("education");
		String address = req.getParameter("address");
		String state = req.getParameter("state");
		String country = req.getParameter("country");
		String phone = req.getParameter("phone");
		String email = req.getParameter("email");

		ManagerModel manager = new ManagerModel(id, name, gender, age, martialStatus, education, address, state, country, phone, email);
		Boolean status = managerDao.updateManager(manager);
		if(status) {
			String output = "<script type='text/javascript'>\n"
				 	  + "alert('Successful update user.');\n"
				 	  + "location='" + req.getContextPath() + "/v2/admin/view-manager';\n"
				 	  + "</script>";

			out.println(output);
		} else {
			String output = "<script type='text/javascript'>\n"
				 	  + "alert('Failed to update user. Please try again.');\n"
				 	  + "location='" + req.getContextPath() + "/v2/admin/view-manager';\n"
				 	  + "</script>";

			out.println(output);
		}
	}
	
	private void submitEmployee(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
	
		String fullname = req.getParameter("fullname");
		String gender = req.getParameter("gender");
		int age = Integer.valueOf(req.getParameter("age"));
		String martialStatus = req.getParameter("martial-status");
		String education = req.getParameter("education");
		String address = req.getParameter("address");
		String state = req.getParameter("state");
		String country = req.getParameter("country");
		String phone = req.getParameter("phone");
		String email = req.getParameter("email");
		String hirer = req.getParameter("hirer");
		String dept = req.getParameter("department");
		String title = req.getParameter("title");
		LocalDate dateHired = LocalDate.now();
		
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String c_password = req.getParameter("c_password");
		
		if(password.equals(c_password)) {
			LocalDateTime nowDateTime = LocalDateTime.now();
			String dateCreated = nowDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
			
			String salt = PasswordEncription.getSaltvalue(30);
	    	String hashedPassword = PasswordEncription.generateSecurePassword(password, salt);
	    	
	    	AccountModel account = new AccountModel(username, hashedPassword, salt, dateCreated);
			Boolean accountStatus = accountDao.addNewAccount(account);
			
			if(accountStatus) {
				EmployeeModel employee = new EmployeeModel(fullname, gender, age, martialStatus, education, address, state, country, phone, email, dateHired, null, 
															username, dept, hirer, title);
				Boolean status = employeeDao.addEmployee(employee);
				if(status) {
					String output = "<script type='text/javascript'>\n"
							 	  + "alert('Successful added new user.');\n"
							 	  + "location='" + req.getContextPath() + "/v2/admin/view-employee';\n"
							 	  + "</script>";
			
					out.println(output);
				} else {
					String output = "<script type='text/javascript'>\n"
						 	  + "alert('Failed to add user. Please try again.');\n"
						 	  + "location='" + req.getContextPath() + "/v2/admin/view-employee';\n"
						 	  + "</script>";
		
					out.println(output);
				}
			} else {
				String output = "<script type='text/javascript'>\n"
					 	  + "alert('Failed to add account.');\n"
					 	  + "location='" + req.getContextPath() + "/v2/admin/view-employee';\n"
					 	  + "</script>";

				out.println(output);
			}
		} else {
			String output = "<script type='text/javascript'>\n"
				 	  + "alert('Password and confirmed password are not equal.');\n"
				 	  + "location='" + req.getContextPath() + "/v2/admin/view-employee';\n"
				 	  + "</script>";

			out.println(output);
		}
		
	}
	
	private void submitUpdateEmployee(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		
		int id = Integer.valueOf(req.getParameter("id"));
		String fullname = req.getParameter("fullname");
		String gender = req.getParameter("gender");
		int age = Integer.valueOf(req.getParameter("age"));
		String martialStatus = req.getParameter("martial-status");
		String education = req.getParameter("education");
		String address = req.getParameter("address");
		String state = req.getParameter("state");
		String country = req.getParameter("country");
		String phone = req.getParameter("phone");
		String email = req.getParameter("email");
		
		EmployeeModel employee = new EmployeeModel(id, fullname, gender, age, martialStatus, education, address, state, country, phone, email);
		Boolean status = employeeDao.updateEmployee(employee);
		if(status) {
			String output = "<script type='text/javascript'>\n"
				 	  + "alert('Successful update user.');\n"
				 	  + "location='" + req.getContextPath() + "/v2/admin/view-employee';\n"
				 	  + "</script>";

			out.println(output);
		} else {
			String output = "<script type='text/javascript'>\n"
				 	  + "alert('Failed to update user. Please try again.');\n"
				 	  + "location='" + req.getContextPath() + "/v2/admin/view-employee';\n"
				 	  + "</script>";

			out.println(output);
		}
	}
	
	private void updateManagerPassword(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		
		String username = req.getParameter("username");
		String oldPassword = req.getParameter("old_password");
		String newPassword = req.getParameter("new_password");
		String c_password = req.getParameter("c_password");
		
		if(newPassword.equals(c_password)) {
			LocalDateTime nowDateTime = LocalDateTime.now();
			String dateChanged = nowDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
			
			AccountModel account = accountDao.getPasswordKey(username);
			Boolean validatePassword = PasswordEncription.verifyUserPassword(oldPassword, account.getPassword(), account.getKey());
			
			String salt = PasswordEncription.getSaltvalue(30);
	    	String hashedPassword = PasswordEncription.generateSecurePassword(newPassword, salt);
	    	
			if(validatePassword) {
				Boolean status = accountDao.changePassword(username, hashedPassword, salt, dateChanged);
				if(status) {
					String output = "<script type='text/javascript'>\n"
						 	  + "alert('Modify success.');\n"
						 	  + "window.close();\n"
						 	  + "window.opener.location='" + req.getContextPath() + "/v2/admin/view-account-manager';\n"
						 	  + "</script>";
		
					out.println(output);
				} else {
					String output = "<script type='text/javascript'>\n"
						 	  + "alert('Failed to modify password.');\n"
						 	  + "window.close();\n"
						 	  + "window.opener.location='" + req.getContextPath() + "/v2/admin/view-account-manager';\n"
						 	  + "</script>";
		
					out.println(output);
				}
			} else {
				String output = "<script type='text/javascript'>\n"
					 	  + "alert('Wrong old password, please try again.');\n"
					 	  + "window.close();\n"
					 	  + "window.opener.location='" + req.getContextPath() + "/v2/admin/view-account-manager';\n"
					 	  + "</script>";

				out.println(output);
			}
		} else {
			String output = "<script type='text/javascript'>\n"
				 	  + "alert('New password and confirmed password are not equal.');\n"
				 	  + "window.close();\n"
				 	  + "window.opener.location='" + req.getContextPath() + "/v2/admin/view-account-manager';\n"
				 	  + "</script>";

			out.println(output);
		}
		
	}
	
	private void updateEmployeePassword(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		
		String username = req.getParameter("username");
		String oldPassword = req.getParameter("old_password");
		String newPassword = req.getParameter("new_password");
		String c_password = req.getParameter("c_password");
		
		if(newPassword.equals(c_password)) {
			LocalDateTime nowDateTime = LocalDateTime.now();
			String dateChanged = nowDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
			
			AccountModel account = accountDao.getPasswordKey(username);
			Boolean validatePassword = PasswordEncription.verifyUserPassword(oldPassword, account.getPassword(), account.getKey());
			
			String salt = PasswordEncription.getSaltvalue(30);
	    	String hashedPassword = PasswordEncription.generateSecurePassword(newPassword, salt);
	    	
			if(validatePassword) {
				Boolean status = accountDao.changePassword(username, hashedPassword, salt, dateChanged);
				if(status) {
					String output = "<script type='text/javascript'>\n"
						 	  + "alert('Modify success.');\n"
						 	  + "window.close();\n"
						 	  + "window.opener.location='" + req.getContextPath() + "/v2/admin/view-account-employee';\n"
						 	  + "</script>";
		
					out.println(output);
				} else {
					String output = "<script type='text/javascript'>\n"
						 	  + "alert('Failed to modify password.');\n"
							  + "window.close();\n"
						 	  + "window.opener.location='" + req.getContextPath() + "/v2/admin/view-account-employee';\n"
						 	  + "</script>";
		
					out.println(output);
				}
			} else {
				String output = "<script type='text/javascript'>\n"
					 	  + "alert('Wrong old password, please try again.');\n"
					 	  + "window.close();\n"
					 	  + "window.opener.location='" + req.getContextPath() + "/v2/admin/view-account-manager';\n"
					 	  + "</script>";

				out.println(output);
			}
		} else {
			String output = "<script type='text/javascript'>\n"
				 	  + "alert('New password and confirmed password are not equal.');\n"
				 	  + "window.close();\n"
				 	  + "window.opener.location='" + req.getContextPath() + "/v2/admin/view-account-manager';\n"
				 	  + "</script>";

			out.println(output);
		}	
	}
	
	private void submitTitle(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		
		String title = req.getParameter("title");
		Boolean status = titleDao.addNewTitle(title);
		if(status) {
			String output = "<script type='text/javascript'>\n"
				 	  + "alert('Add success.');\n"
				 	  + "window.close();\n"
				 	  + "window.opener.location='" + req.getContextPath() + "/v2/admin/view-title';\n"
				 	  + "</script>";

			out.println(output);
		} else {
			String output = "<script type='text/javascript'>\n"
				 	  + "alert('Failed to add title.');\n"
				 	  + "window.close();\n"
				 	  + "window.opener.location='" + req.getContextPath() + "/v2/admin/view-title';\n"
				 	  + "</script>";

			out.println(output);
		}
	}
	
	private void updateTitle(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		
		int id = Integer.valueOf(req.getParameter("id"));
		String title = req.getParameter("title");
		Boolean status = titleDao.updateTitleName(id, title);
		if(status) {
			String output = "<script type='text/javascript'>\n"
				 	  + "alert('Update title success.');\n"
				 	  + "window.close();\n"
				 	  + "window.opener.location='" + req.getContextPath() + "/v2/admin/view-title';\n"
				 	  + "</script>";

			out.println(output);
		} else {
			String output = "<script type='text/javascript'>\n"
				 	  + "alert('Failed to update title.');\n"
				 	  + "window.close();\n"
				 	  + "window.opener.location='" + req.getContextPath() + "/v2/admin/view-title';\n"
				 	  + "</script>";

			out.println(output);
		}
	}
	
	private void submitDepartment(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		
		String deptName = req.getParameter("dept-name");
		String address = req.getParameter("address");
		String state = req.getParameter("state");
		String country = req.getParameter("country");
		
		DepartmentModel department = new DepartmentModel(deptName, address, state, country);
		Boolean status = departmentDao.addNewDepartment(department);
		if(status) {
			String output = "<script type='text/javascript'>\n"
				 	  + "alert('Successful added department info.');\n"
				 	  + "window.close();\n"
				 	  + "window.opener.location='" + req.getContextPath() + "/v2/admin/view-department';\n"
				 	  + "</script>";

			out.println(output);
		} else {
			String output = "<script type='text/javascript'>\n"
				 	  + "alert('Failed to add department info.');\n"
				 	  + "window.close();\n"
				 	  + "window.opener.location='" + req.getContextPath() + "/v2/admin/view-department';\n"
				 	  + "</script>";

			out.println(output);
		}
	}
	
	private void updateDepartment(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		
		int id = Integer.valueOf(req.getParameter("id"));
		String deptName = req.getParameter("dept-name");
		String address = req.getParameter("address");
		String state = req.getParameter("state");
		String country = req.getParameter("country");
		
		DepartmentModel department = new DepartmentModel(id, deptName, address, state, country);
		Boolean status = departmentDao.updateDepartment(department);
		if(status) {
			String output = "<script type='text/javascript'>\n"
				 	  + "alert('Successful update department info.');\n"
				 	  + "window.close();\n"
				 	  + "window.opener.location='" + req.getContextPath() + "/v2/admin/view-department';\n"
				 	  + "</script>";

			out.println(output);
		} else {
			String output = "<script type='text/javascript'>\n"
				 	  + "alert('Failed to update department info.');\n"
				 	  + "window.close();\n"
				 	  + "window.opener.location='" + req.getContextPath() + "/v2/admin/view-department';\n"
				 	  + "</script>";

			out.println(output);
		}
	}
	
	private void submitUpdateProfile(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		
		int id = Integer.valueOf(req.getParameter("id"));
		String fullname = req.getParameter("fullname");
		String gender = req.getParameter("gender");
		int age = Integer.valueOf(req.getParameter("age"));
		String martialStatus = req.getParameter("martial-status");
		String education = req.getParameter("education");
		String address = req.getParameter("address");
		String state = req.getParameter("state");
		String country = req.getParameter("country");
		String phone = req.getParameter("phone");
		String email = req.getParameter("email");

		ManagerModel admin = new ManagerModel(id, fullname, gender, age, martialStatus, education, address, state, country, phone, email);
		Boolean status = managerDao.updateManager(admin);
		if(status) {
			String output = "<script type='text/javascript'>\n"
				 	  + "alert('Successful update profile.');\n"
				 	  + "location='" + req.getContextPath() + "/v2/admin/profile?id=" + id + "';\n"
				 	  + "</script>";

			out.println(output);
		} else {
			String output = "<script type='text/javascript'>\n"
				 	  + "alert('Failed to update profile. Please try again.');\n"
				 	  + "location='" + req.getContextPath() + "/v2/admin/profile?id=" + id + "';\n"
				 	  + "</script>";

			out.println(output);
		}
	}
	
	private void updateProfilePassword(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		HttpSession session = req.getSession();
		
		int id = Integer.valueOf(req.getParameter("id"));
		String username = session.getAttribute("username").toString();
		String oldPassword = req.getParameter("old_password");
		String newPassword = req.getParameter("new_password");
		String c_password = req.getParameter("c_password");
		
		if(newPassword.equals(c_password)) {
			LocalDateTime nowDateTime = LocalDateTime.now();
			String dateChanged = nowDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
			
			AccountModel account = accountDao.getPasswordKey(username);
			Boolean validatePassword = PasswordEncription.verifyUserPassword(oldPassword, account.getPassword(), account.getKey());
			
			String salt = PasswordEncription.getSaltvalue(30);
	    	String hashedPassword = PasswordEncription.generateSecurePassword(newPassword, salt);
	    	
			if(validatePassword) {
				Boolean status = accountDao.changePassword(username, hashedPassword, salt, dateChanged);
				if(status) {
					String output = "<script type='text/javascript'>\n"
						 	  + "alert('Modify success. Re-login to made changed.');\n"
						 	  + "location='" + req.getContextPath() + "/user-login';\n"
						 	  + "</script>";
		
					out.println(output);
				} else {
					String output = "<script type='text/javascript'>\n"
						 	  + "alert('Failed to modify password.');\n"
						 	  + "location='" + req.getContextPath() + "/v2/admin/profile?id=" + id + "';\n"
						 	  + "</script>";
		
					out.println(output);
				}
			} else {
				String output = "<script type='text/javascript'>\n"
					 	  + "alert('Wrong old password, please try again.');\n"
					 	  + "location='" + req.getContextPath() + "/v2/admin/profile?id=" + id + "';\n"
					 	  + "</script>";

				out.println(output);
			}
		} else {
			String output = "<script type='text/javascript'>\n"
				 	  + "alert('New password and confirmed password are not equal.');\n"
				 	  + "location='" + req.getContextPath() + "/v2/admin/profile?id=" + id + "';\n"
				 	  + "</script>";

			out.println(output);
		}	
	}
}
