package com.company.payroll.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.company.payroll.dao.EmployeeDao;
import com.company.payroll.dao.ManagerDao;
import com.company.payroll.dao.UserDao;
import com.company.payroll.model.AdminModel;
import com.company.payroll.model.EmployeeModel;
import com.company.payroll.model.ManagerModel;
import com.company.payroll.services.PasswordEncription;

public class DoLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// response.sendRedirect used for forward servlet address, i.e: redirect to /admin servlet with doGet() method.
		// suitable for doGet() method to redirect to page
		HttpSession session = request.getSession();
		session.invalidate();
		response.sendRedirect("index.html");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		HttpSession session = request.getSession();
		
		if(username.equals("administrator") && session!=null) {
			AdminModel admin = UserDao.adminAuth(username);
			Boolean validate = PasswordEncription.verifyUserPassword(password, admin.getPassword(), admin.getKey());
			if(validate==true && admin.getRole().equals("admin")) {
				List<ManagerModel> manager_list = ManagerDao.view();
				session.setAttribute("viewManager", manager_list);
				session.setAttribute("username", username);
				request.getRequestDispatcher("/WEB-INF/views/admin/admin.jsp").forward(request, response);
			} else {
				alertMsg(request, response);
			}
		} else if(username.matches("([0-9]{7})") && session!=null) {
			int id = Integer.parseInt(username);
			// TODO
			// bug when login with user id, when matches with regex user id, it will straight throw to sql and execute query.
			// will throw error at sql side due to validate id error
			ManagerModel manager = UserDao.managerAuth(id);
			if(id==manager.getId() && manager.getRole().equals("manager")) {
				Boolean validate = PasswordEncription.verifyUserPassword(password, manager.getPassword(), manager.getKey());
				if(validate==true) {
					List<EmployeeModel> employee_list = EmployeeDao.view();
			    	session.setAttribute("viewEmployee", employee_list);
					ManagerModel manager_name = ManagerDao.getFullName(id);
					session.setAttribute("id", id);
					session.setAttribute("username", manager_name.getFullname());
					request.getRequestDispatcher("/WEB-INF/views/manager/manager.jsp").forward(request, response);
				} else {
					alertMsg(request, response);
				}
			} else {
				EmployeeModel employee = UserDao.employeeAuth(id);
				Boolean validate = PasswordEncription.verifyUserPassword(password, employee.getPassword(), employee.getKey());
				if(id==employee.getId() && validate==true) {
					EmployeeModel emp_info = EmployeeDao.queryInfo(id);
					session.setAttribute("id", id);
					session.setAttribute("username", emp_info.getFullname());
					session.setAttribute("employee", emp_info);
					request.getRequestDispatcher("/WEB-INF/views/employee/employee.jsp").forward(request, response);
				} else {
					alertMsg(request, response);
				}
			}
		} else {
			alertMsg(request, response);
		}
	}
	
	private void alertMsg(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession();
		
		String alert_str = "<script type='text/javascript'>\n"
						 + "alert('Invalid username or password.');\n"
						 + "location='index.html';\n"
						 + "</script>";
		
		out.println(alert_str);
		session.invalidate();
	}

}
