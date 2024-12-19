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
import v2.com.company.payroll.dao.EmployeeDao;
import v2.com.company.payroll.dao.EmployeeLeaveDao;
import v2.com.company.payroll.dao.EmployeeLoanDao;
import v2.com.company.payroll.dao.TrainingDao;
import v2.com.company.payroll.dao.impl.AccountDaoImpl;
import v2.com.company.payroll.dao.impl.EmployeeDaoImpl;
import v2.com.company.payroll.dao.impl.EmployeeLeaveDaoImpl;
import v2.com.company.payroll.dao.impl.EmployeeLoanDaoImpl;
import v2.com.company.payroll.dao.impl.TrainingDaoImpl;
import v2.com.company.payroll.model.AccountModel;
import v2.com.company.payroll.model.EmployeeLeaveModel;
import v2.com.company.payroll.model.EmployeeLoanModel;
import v2.com.company.payroll.model.EmployeeModel;
import v2.com.company.payroll.model.TrainingModel;

public class EmployeePostForm extends HttpServlet {
	private static final long serialVersionUID = 6205152869226848010L;
	
	private TrainingDao trainingDao = new TrainingDaoImpl();		
	private EmployeeLeaveDao leaveDao = new EmployeeLeaveDaoImpl();
	private EmployeeLoanDao loanDao = new EmployeeLoanDaoImpl();
	private EmployeeDao employeeDao = new EmployeeDaoImpl();
	private AccountDao accountDao = new AccountDaoImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pathInfo = req.getPathInfo();

		switch(pathInfo) {
			case "/submitTraining":
				submitTraining(req, resp);
				break;
			default:
				break;
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pathInfo = req.getPathInfo();
		
		switch(pathInfo) {
			case "/submitLeave":
				submitLeave(req, resp);
				break;
			case "/submitLoan":
				submitLoan(req, resp);
				break;
			case "/submitUpdateEmployee":
				submitUpdateEmployee(req, resp);
				break;
			case "/updateEmployeePassword":
				updateProfilePassword(req, resp);
				break;
			default:
				break;
		}
	}
	
	private void submitTraining(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {	
		PrintWriter out = resp.getWriter();
		
		int id = Integer.valueOf(req.getParameter("id"));
		String status = req.getParameter("status");
		String name = req.getParameter("name");
		
		TrainingModel training = new TrainingModel(id, status, name);
		Boolean updateTrainingStatus = trainingDao.updateStatusByEmployee(training);
		if(updateTrainingStatus) {
			String output = "<script type='text/javascript'>\n"
				 	  + "alert('Successful update status.');\n"
				 	  + "location='" + req.getContextPath() + "/v2/employee/view-training';\n"
				 	  + "</script>";

			out.println(output);
		} else {
			String output = "<script type='text/javascript'>\n"
				 	  + "alert('Failed update status.');\n"
				 	  + "location='" + req.getContextPath() + "/v2/employee/view-training';\n"
				 	  + "</script>";

			out.println(output);
		}
	}
	
	private void submitLeave(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		
		String name = req.getParameter("employee-name");
		String reasons = req.getParameter("reasons");
		String leaveType = req.getParameter("leave-type");
		LocalDate startDate = LocalDate.parse(req.getParameter("start-date").toString(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		String startTime = req.getParameter("start-time");
		String startDateTime = startDate + " " + startTime;
		LocalDate endDate = LocalDate.parse(req.getParameter("end-date").toString(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		String endTime = req.getParameter("end-time");
		String endDateTime = endDate + " " + endTime;
		String leaveStatus = "PENDING";
		
		EmployeeLeaveModel leave = new EmployeeLeaveModel(reasons, startDateTime, endDateTime, leaveType, leaveStatus, name);
		Boolean status = leaveDao.insertLeave(leave);
		if(status) {
			String output = "<script type='text/javascript'>\n"
				 	  + "alert('Successful submit leave form.');\n"
				 	  + "window.close();\n"
				 	  + "window.opener.location='" + req.getContextPath() + "/v2/employee/view-leave';\n"
				 	  + "</script>";

			out.println(output);
		} else {
			String output = "<script type='text/javascript'>\n"
				 	  + "alert('Failed to submit leave form.');\n"
				 	  + "window.close();\n"
				 	  + "window.opener.location='" + req.getContextPath() + "/v2/employee/view-leave';\n"
				 	  + "</script>";

			out.println(output);
		}
	}
	
	private void submitLoan(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		
		String name = req.getParameter("employee-name");
		String reasons = req.getParameter("reasons");
		Double amount = Double.valueOf(req.getParameter("loan-amount"));
		LocalDate date = LocalDate.parse(req.getParameter("apply-date").toString(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		String loanStatus = "PENDING";
		
		EmployeeLoanModel loan = new EmployeeLoanModel(reasons, amount, date, loanStatus, name);
		Boolean status = loanDao.insertLoan(loan);
		if(status) {
			String output = "<script type='text/javascript'>\n"
				 	  + "alert('Successful submit loan application form.');\n"
				 	  + "window.close();\n"
				 	  + "window.opener.location='" + req.getContextPath() + "/v2/employee/view-loan';\n"
				 	  + "</script>";

			out.println(output);
		} else {
			String output = "<script type='text/javascript'>\n"
				 	  + "alert('Failed to submit loan application form.');\n"
				 	  + "window.close();\n"
				 	  + "window.opener.location='" + req.getContextPath() + "/v2/employee/view-loan';\n"
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
				 	  + "alert('Successful update profile.');\n"
				 	  + "location='" + req.getContextPath() + "/v2/employee/profile?id=" + id + "';\n"
				 	  + "</script>";

			out.println(output);
		} else {
			String output = "<script type='text/javascript'>\n"
				 	  + "alert('Failed to update profile. Please try again.');\n"
				 	  + "location='" + req.getContextPath() + "/v2/employee/profile?id=" + id + "';\n"
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
						 	  + "location='" + req.getContextPath() + "/v2/employee/profile?id=" + id + "';\n"
						 	  + "</script>";
		
					out.println(output);
				}
			} else {
				String output = "<script type='text/javascript'>\n"
					 	  + "alert('Wrong old password, please try again.');\n"
					 	  + "location='" + req.getContextPath() + "/v2/employee/profile?id=" + id + "';\n"
					 	  + "</script>";

				out.println(output);
			}
		} else {
			String output = "<script type='text/javascript'>\n"
				 	  + "alert('New password and confirmed password are not equal.');\n"
				 	  + "location='" + req.getContextPath() + "/v2/employee/profile?id=" + id + "';\n"
				 	  + "</script>";

			out.println(output);
		}
		
	}
}
