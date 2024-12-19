package v2.com.company.payroll.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import v2.com.company.payroll.dao.EmployeeDao;
import v2.com.company.payroll.dao.EmployeeLeaveDao;
import v2.com.company.payroll.dao.EmployeeLoanDao;
import v2.com.company.payroll.dao.EmployeeSalaryDao;
import v2.com.company.payroll.dao.PayRollDao;
import v2.com.company.payroll.dao.TrainingDao;
import v2.com.company.payroll.dao.impl.EmployeeDaoImpl;
import v2.com.company.payroll.dao.impl.EmployeeLeaveDaoImpl;
import v2.com.company.payroll.dao.impl.EmployeeLoanDaoImpl;
import v2.com.company.payroll.dao.impl.EmployeeSalaryDaoImpl;
import v2.com.company.payroll.dao.impl.PayRollDaoImpl;
import v2.com.company.payroll.dao.impl.TrainingDaoImpl;
import v2.com.company.payroll.model.EmployeeLeaveModel;
import v2.com.company.payroll.model.EmployeeLoanModel;
import v2.com.company.payroll.model.EmployeeModel;
import v2.com.company.payroll.model.EmployeeSalaryModel;
import v2.com.company.payroll.model.EventModel;
import v2.com.company.payroll.model.PayRollModel;
import v2.com.company.payroll.model.TrainingModel;

// TODO	need clearer code for event method
public class Employee extends HttpServlet {
	private static final long serialVersionUID = -6906229676468666171L;
	
	private EmployeeDao employeeDao = new EmployeeDaoImpl();
	private EmployeeSalaryDao salaryDao = new EmployeeSalaryDaoImpl();
	private PayRollDao payrollDao = new PayRollDaoImpl();
	private TrainingDao trainingDao = new TrainingDaoImpl();
	private EmployeeLeaveDao leaveDao = new EmployeeLeaveDaoImpl();
	private EmployeeLoanDao loanDao = new EmployeeLoanDaoImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pathInfo = req.getPathInfo();
		
		HttpSession session = req.getSession();
		String name = session.getAttribute("userFullname").toString();
		
		switch(pathInfo) {
			case "/view-information":
				int id = Integer.valueOf(req.getParameter("id"));
				EmployeeModel employee = employeeDao.getEmployeeByEmployeeId(id);
				EmployeeSalaryModel salary = salaryDao.getSalaryByEmployeeName(name);
				List<PayRollModel> payroll_list = payrollDao.getListByEmployee(name);
				
				session.setAttribute("user", employee);
				session.setAttribute("employeeSalary", salary);
				session.setAttribute("payrollList", payroll_list);
				req.getRequestDispatcher("/WEB-INF/v2/views/employee/main.jsp").forward(req, resp);
				break;
			case "/view-training":
				List<String> training_list = getTrainingEvent(name);
				session.setAttribute("json", training_list);
				req.getRequestDispatcher("/WEB-INF/v2/views/employee/view-training.jsp").forward(req, resp);
				break;
			case "/view-leave":
				List<String> leave_list = getLeaveEvent(name);
				session.setAttribute("json2", leave_list);
				req.getRequestDispatcher("/WEB-INF/v2/views/employee/view-leave.jsp").forward(req, resp);
				break;
			case "/view-loan":
				List<EmployeeLoanModel> loan_list = loanDao.getLoanListByEmployee(name);
				session.setAttribute("loanList", loan_list);
				req.getRequestDispatcher("/WEB-INF/v2/views/employee/view-loan.jsp").forward(req, resp);
				break;
			case "/profile":
				int profileId = Integer.valueOf(req.getParameter("id"));
				EmployeeModel employeeProfile = employeeDao.getEmployeeByEmployeeId(profileId);
				session.setAttribute("user", employeeProfile);
				req.getRequestDispatcher("/WEB-INF/v2/views/employee/profile.jsp").forward(req, resp);
				break;
			default:
				break;
		}
	}
	
	private List<String> getTrainingEvent(String name) throws IOException {
		List<String> json_list = new ArrayList<String>();
		List<TrainingModel> training_list = trainingDao.getListByEmployee(name);
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		
		for(TrainingModel training : training_list) {
			String description = "Info: " + training.getInfo() + " Issuer: " + training.getIssuer() + " Status: " +  training.getStatus();
			EventModel event = new EventModel(training.getId(), training.getInfo() , description, training.getStartDate(), training.getEndDate());
			json_list.add(gson.toJson(event));
		}

		return json_list;
	}
	
	private List<String> getLeaveEvent(String name) throws IOException {
		List<String> json_list = new ArrayList<String>();
		List<EmployeeLeaveModel> leave_list = leaveDao.getLeaveListByEmployee(name);
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		
		for(EmployeeLeaveModel leave : leave_list) {
			String description = leave.getReasons();
			EventModel event = new EventModel(leave.getId(), leave.getStatus() , description, leave.getDateFrom(), leave.getDateTo());
			json_list.add(gson.toJson(event));
		}

		return json_list;
	}
	
}
