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
import v2.com.company.payroll.dao.EmployeePromotionDao;
import v2.com.company.payroll.dao.EmployeeSalaryDao;
import v2.com.company.payroll.dao.ManagerDao;
import v2.com.company.payroll.dao.PayRollDao;
import v2.com.company.payroll.dao.ResignationDao;
import v2.com.company.payroll.dao.TrainingDao;
import v2.com.company.payroll.dao.impl.AccountDaoImpl;
import v2.com.company.payroll.dao.impl.EmployeeDaoImpl;
import v2.com.company.payroll.dao.impl.EmployeeLeaveDaoImpl;
import v2.com.company.payroll.dao.impl.EmployeeLoanDaoImpl;
import v2.com.company.payroll.dao.impl.EmployeePromotionDaoImpl;
import v2.com.company.payroll.dao.impl.EmployeeSalaryDaoImpl;
import v2.com.company.payroll.dao.impl.ManagerDaoImpl;
import v2.com.company.payroll.dao.impl.PayRollDaoImpl;
import v2.com.company.payroll.dao.impl.ResignationDaoImpl;
import v2.com.company.payroll.dao.impl.TrainingDaoImpl;
import v2.com.company.payroll.model.AccountModel;
import v2.com.company.payroll.model.EmployeeLeaveModel;
import v2.com.company.payroll.model.EmployeeLoanModel;
import v2.com.company.payroll.model.EmployeeModel;
import v2.com.company.payroll.model.EmployeePromotionModel;
import v2.com.company.payroll.model.EmployeeSalaryModel;
import v2.com.company.payroll.model.ManagerModel;
import v2.com.company.payroll.model.PayRollModel;
import v2.com.company.payroll.model.ResignationModel;
import v2.com.company.payroll.model.TrainingModel;

public class ManagerPostForm extends HttpServlet {
	private static final long serialVersionUID = 1121369662630876940L;
	
	private EmployeeDao employeeDao = new EmployeeDaoImpl();
	private EmployeeLeaveDao leaveDao = new EmployeeLeaveDaoImpl();
	private EmployeeLoanDao loanDao = new EmployeeLoanDaoImpl();	
	private AccountDao accountDao = new AccountDaoImpl();
	private EmployeeSalaryDao salaryDao = new EmployeeSalaryDaoImpl();
	private EmployeePromotionDao promotionDao = new EmployeePromotionDaoImpl();
	private PayRollDao payrollDao = new PayRollDaoImpl();
	private ResignationDao resignDao = new ResignationDaoImpl();
	private TrainingDao trainingDao = new TrainingDaoImpl();
	private ManagerDao managerDao = new ManagerDaoImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pathInfo = req.getPathInfo();
		
		switch(pathInfo) {
		case "/deleteEmployee":
			deleteEmployee(req, resp);
			break;
		case "/updateEmployeeLeave":
			updateEmployeeLeave(req, resp);
			break;
		case "/updateEmployeeLoan":
			updateEmployeeLoan(req, resp);
			break;
		default:
			break;
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pathInfo = req.getPathInfo();

		switch(pathInfo) {
			case "/submitEmployee":
				submitEmployee(req, resp);
				break;
			case "/submitUpdateEmployee":
				submitUpdateEmployee(req, resp);
				break;
			case "/submitPromotion":
				submitPromotion(req, resp);
				break;
			case "/submitUpdatePromotion":
				submitUpdatePromotion(req, resp);
				break;
			case "/submitSalary":
				submitPayRoll(req, resp);
				break;
			case "/submitResignation":
				submitResignation(req, resp);
				break;
			case "/submitTraining":
				submitTraining(req, resp);
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
	
	private void deleteEmployee(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		
		int id = Integer.valueOf(req.getParameter("id"));
		Boolean status = employeeDao.deleteEmployee(id);
		if(status) {
			String output = "<script type='text/javascript'>\n"
				 	  + "alert('Successful delete user.');\n"
				 	  + "location='" + req.getContextPath() + "/v2/manager/view-employee';\n"
				 	  + "</script>";

			out.println(output);
		} else {
			String output = "<script type='text/javascript'>\n"
				 	  + "alert('Failed to delete user. Please try again.');\n"
				 	  + "location='" + req.getContextPath() + "/v2/manager/view-employee';\n"
				 	  + "</script>";

			out.println(output);
		}
	}
	
	private void updateEmployeeLeave(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		
		int id = Integer.valueOf(req.getParameter("id"));
		String leaveStatus = req.getParameter("status");
		String approver = req.getParameter("by");
		EmployeeLeaveModel leave = new EmployeeLeaveModel(id, leaveStatus, approver);
		Boolean status = leaveDao.updateStatus(leave);
		if(status) {
			String output = "<script type='text/javascript'>\n"
				 	  + "alert('Successful update status.');\n"
				 	  + "location='" + req.getContextPath() + "/v2/manager/view-leave';\n"
				 	  + "</script>";

			out.println(output);
		} else {
			String output = "<script type='text/javascript'>\n"
				 	  + "alert('Failed to update status.');\n"
				 	  + "location='" + req.getContextPath() + "/v2/manager/view-leave';\n"
				 	  + "</script>";

			out.println(output);
		}
	}

	private void updateEmployeeLoan(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		
		int id = Integer.valueOf(req.getParameter("id"));
		String loanStatus = req.getParameter("status");
		String approver = req.getParameter("by");
		EmployeeLoanModel loan = new EmployeeLoanModel(id, loanStatus, approver);
		Boolean status = loanDao.updateStatus(loan);
		if(status) {
			String output = "<script type='text/javascript'>\n"
				 	  + "alert('Successful update status.');\n"
				 	  + "location='" + req.getContextPath() + "/v2/manager/view-loan';\n"
				 	  + "</script>";

			out.println(output);
		} else {
			String output = "<script type='text/javascript'>\n"
				 	  + "alert('Failed to update status.');\n"
				 	  + "location='" + req.getContextPath() + "/v2/manager/view-loan';\n"
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
		Double baseSalary = Double.valueOf(req.getParameter("base-salary"));
		Double annualSalary = baseSalary * 13;
		
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
					EmployeeSalaryModel salary = new EmployeeSalaryModel(baseSalary, annualSalary, fullname);
					Boolean salaryStatus = salaryDao.insertEmployeeSalary(salary);
					if(salaryStatus) {
						String output = "<script type='text/javascript'>\n"
							 	  + "alert('Successful added new user.');\n"
							 	  + "location='" + req.getContextPath() + "/v2/manager/view-employee';\n"
							 	  + "</script>";
			
						out.println(output);
					} else {
						String output = "<script type='text/javascript'>\n"
							 	  + "alert('Failed to add user. Please try again.');\n"
							 	  + "location='" + req.getContextPath() + "/v2/manager/view-employee';\n"
							 	  + "</script>";
			
						out.println(output);
					}
				} else {
					String output = "<script type='text/javascript'>\n"
						 	  + "alert('Failed to add user. Please try again.');\n"
						 	  + "location='" + req.getContextPath() + "/v2/manager/view-employee';\n"
						 	  + "</script>";
		
					out.println(output);
				}
			} else {
				String output = "<script type='text/javascript'>\n"
					 	  + "alert('Failed to add account.');\n"
					 	  + "location='" + req.getContextPath() + "/v2/manager/view-employee';\n"
					 	  + "</script>";

				out.println(output);
			}
		} else {
			String output = "<script type='text/javascript'>\n"
				 	  + "alert('Password and confirmed password are not equal.');\n"
				 	  + "location='" + req.getContextPath() + "/v2/manager/view-employee';\n"
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
				 	  + "location='" + req.getContextPath() + "/v2/manager/view-employee';\n"
				 	  + "</script>";

			out.println(output);
		} else {
			String output = "<script type='text/javascript'>\n"
				 	  + "alert('Failed to update user. Please try again.');\n"
				 	  + "location='" + req.getContextPath() + "/v2/manager/view-employee';\n"
				 	  + "</script>";

			out.println(output);
		}
	}
	
	private void submitPromotion(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		
		String name = req.getParameter("employee-name");
		String promoter = req.getParameter("manager-name");
		String title = req.getParameter("promote-title");
		Double previousSalary = Double.valueOf(req.getParameter("previous-salary"));
		Double promoteSalary = Double.valueOf(req.getParameter("promote-salary"));
		LocalDate promoteDate = LocalDate.parse(req.getParameter("promote-date").toString(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		
		EmployeePromotionModel promotion = new EmployeePromotionModel(previousSalary, promoteSalary, promoteDate, title, name, promoter);
		Boolean status = promotionDao.insertPromotion(promotion);
		if(status) {
			Double annualSalary = promoteSalary * 13;
			EmployeeSalaryModel salary = new EmployeeSalaryModel(promoteSalary, annualSalary, name);
			Boolean salaryStatus = salaryDao.updateEmployeeSalary(salary);
			if(salaryStatus) {
				String output = "<script type='text/javascript'>\n"
					 	  + "alert('Successful submitted promotion info.');\n"
					 	  + "window.close();\n"
					 	  + "window.opener.location='" + req.getContextPath() + "/v2/manager/view-promotion';\n"
					 	  + "</script>";
	
				out.println(output);
			} else {
				String output = "<script type='text/javascript'>\n"
					 	  + "alert('Failed to submit promotion info.');\n"
					 	  + "window.close();\n"
					 	  + "window.opener.location='" + req.getContextPath() + "/v2/manager/view-promotion';\n"
					 	  + "</script>";
	
				out.println(output);
			}
		} else {
			String output = "<script type='text/javascript'>\n"
				 	  + "alert('Failed to submit promotion info.');\n"
				 	  + "window.close();\n"
				 	  + "window.opener.location='" + req.getContextPath() + "/v2/manager/view-promotion';\n"
				 	  + "</script>";

			out.println(output);
		}
	}
	
	private void submitUpdatePromotion(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		
		int id = Integer.valueOf(req.getParameter("id"));
		String name = req.getParameter("employee-name");
		String promoter = req.getParameter("manager-name");
		String title = req.getParameter("promote-title");
		Double previousSalary = Double.valueOf(req.getParameter("previous-salary"));
		Double promoteSalary = Double.valueOf(req.getParameter("promote-salary"));
		LocalDate promoteDate = LocalDate.parse(req.getParameter("promote-date").toString(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		
		EmployeePromotionModel promotion = new EmployeePromotionModel(id, previousSalary, promoteSalary, promoteDate, title, name, promoter);
		Boolean status = promotionDao.editPromotion(promotion);
		if(status) {
			Double annualSalary = promoteSalary * 13;
			EmployeeSalaryModel salary = new EmployeeSalaryModel(promoteSalary, annualSalary, name);
			Boolean salaryStatus = salaryDao.updateEmployeeSalary(salary);
			if(salaryStatus) {
				String output = "<script type='text/javascript'>\n"
					 	  + "alert('Successful submitted promotion info.');\n"
					 	  + "window.close();\n"
					 	  + "window.opener.location='" + req.getContextPath() + "/v2/manager/view-promotion';\n"
					 	  + "</script>";
	
				out.println(output);
			} else {
				String output = "<script type='text/javascript'>\n"
					 	  + "alert('Failed to submit promotion info.');\n"
					 	  + "window.close();\n"
					 	  + "window.opener.location='" + req.getContextPath() + "/v2/manager/view-promotion';\n"
					 	  + "</script>";
	
				out.println(output);
			}
		} else {
			String output = "<script type='text/javascript'>\n"
				 	  + "alert('Failed to update promotion info.');\n"
				 	  + "window.close();\n"
				 	  + "window.opener.location='" + req.getContextPath() + "/v2/manager/view-promotion';\n"
				 	  + "</script>";

			out.println(output);
		}
	}
	
	private void submitPayRoll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		
		String name = req.getParameter("employee-name");
		String managerName = req.getParameter("manager-name");
		Double overtime = Double.valueOf(req.getParameter("overtimepay"));
		Double deduction = Double.valueOf(req.getParameter("deduction"));
		Double baseSalary = Double.valueOf(req.getParameter("base-salary"));
		LocalDate issueDate = LocalDate.parse(req.getParameter("issue-date").toString(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		
		Double totalSalary = baseSalary + overtime - deduction;
		PayRollModel payroll = new PayRollModel(overtime, deduction, totalSalary, baseSalary, issueDate, name, managerName);
		Boolean status = payrollDao.issuePayroll(payroll);
		if(status) {
			String output = "<script type='text/javascript'>\n"
				 	  + "alert('Successful submitted payroll info.');\n"
				 	  + "window.close();\n"
				 	  + "window.opener.location='" + req.getContextPath() + "/v2/manager/view-payroll';\n"
				 	  + "</script>";

			out.println(output);
		} else {
			String output = "<script type='text/javascript'>\n"
				 	  + "alert('Failed to submit payroll info.');\n"
				 	  + "window.close();\n"
				 	  + "window.opener.location='" + req.getContextPath() + "/v2/manager/view-payroll';\n"
				 	  + "</script>";

			out.println(output);
		}
	}
	
	private void submitResignation(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		
		String name = req.getParameter("employee-name");
		String issuer = req.getParameter("manager-name");
		String reasons = req.getParameter("reasons");
		LocalDate date = LocalDate.parse(req.getParameter("issue-date").toString(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		ResignationModel resign = new ResignationModel(reasons, date, name, issuer);
		Boolean status = resignDao.insertResignation(resign);
		if(status) {
			// TODO not yet implement for update manager quit date if manager resign
			Boolean updateQuitDate = employeeDao.updateEmployeeQuitDate(name, date);
			if(updateQuitDate) {
				String output = "<script type='text/javascript'>\n"
					 	  + "alert('Successful submitted resign info.');\n"
					 	  + "window.close();\n"
					 	  + "window.opener.location='" + req.getContextPath() + "/v2/manager/view-resign';\n"
					 	  + "</script>";
	
				out.println(output);
			} else {
				String output = "<script type='text/javascript'>\n"
					 	  + "alert('Failed to submit resign info.');\n"
					 	  + "window.close();\n"
					 	  + "window.opener.location='" + req.getContextPath() + "/v2/manager/view-resign';\n"
					 	  + "</script>";
	
				out.println(output);
			}
		} else {
			String output = "<script type='text/javascript'>\n"
				 	  + "alert('Failed to submit resign info.');\n"
				 	  + "window.close();\n"
				 	  + "window.opener.location='" + req.getContextPath() + "/v2/manager/view-resign';\n"
				 	  + "</script>";

			out.println(output);
		}
	}
	
	private void submitTraining(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		
		String name = req.getParameter("employee-name");
		String issuer = req.getParameter("manager-name");
		String info = req.getParameter("info");
		LocalDate startDate = LocalDate.parse(req.getParameter("start-date").toString(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		String startTime = req.getParameter("start-time");
		String startDateTime = startDate + " " + startTime;
		LocalDate endDate = LocalDate.parse(req.getParameter("end-date").toString(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		String endTime = req.getParameter("end-time");
		String endDateTime = endDate + " " + endTime;
		String trainingStatus = "PENDING";
		
		TrainingModel training = new TrainingModel(info, startDateTime, endDateTime, trainingStatus, name, issuer);
		Boolean status = trainingDao.insertTraining(training);
		if(status) {
			String output = "<script type='text/javascript'>\n"
				 	  + "alert('Successful submitted training info.');\n"
				 	  + "window.close();\n"
				 	  + "window.opener.location='" + req.getContextPath() + "/v2/manager/view-training';\n"
				 	  + "</script>";

			out.println(output);
		} else {
			String output = "<script type='text/javascript'>\n"
				 	  + "alert('Failed to submit training info.');\n"
				 	  + "window.close();\n"
				 	  + "window.opener.location='" + req.getContextPath() + "/v2/manager/view-training';\n"
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

		ManagerModel manager = new ManagerModel(id, fullname, gender, age, martialStatus, education, address, state, country, phone, email);
		Boolean status = managerDao.updateManager(manager);
		if(status) {
			String output = "<script type='text/javascript'>\n"
				 	  + "alert('Successful update profile.');\n"
				 	  + "location='" + req.getContextPath() + "/v2/manager/profile?id=" + id + "';\n"
				 	  + "</script>";

			out.println(output);
		} else {
			String output = "<script type='text/javascript'>\n"
				 	  + "alert('Failed to update profile. Please try again.');\n"
				 	  + "location='" + req.getContextPath() + "/v2/manager/profile?id=" + id + "';\n"
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
						 	  + "window.close();\n"
						 	  + "location='" + req.getContextPath() + "/user-login';\n"
						 	  + "</script>";
		
					out.println(output);
				} else {
					String output = "<script type='text/javascript'>\n"
						 	  + "alert('Failed to modify password.');\n"
						 	  + "location='" + req.getContextPath() + "/v2/manager/profile?id=" + id + "';\n"
						 	  + "</script>";
		
					out.println(output);
				}
			} else {
				String output = "<script type='text/javascript'>\n"
					 	  + "alert('Wrong old password, please try again.');\n"
					 	  + "location='" + req.getContextPath() + "/v2/manager/profile?id=" + id + "';\n"
					 	  + "</script>";

				out.println(output);
			}
		} else {
			String output = "<script type='text/javascript'>\n"
				 	  + "alert('New password and confirmed password are not equal.');\n"
				 	  + "location='" + req.getContextPath() + "/v2/manager/profile?id=" + id + "';\n"
				 	  + "</script>";

			out.println(output);
		}	
	}
}
