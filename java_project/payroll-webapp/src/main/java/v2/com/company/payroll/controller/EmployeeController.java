package v2.com.company.payroll.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import v2.com.company.payroll.model.Account;
import v2.com.company.payroll.model.Employee;
import v2.com.company.payroll.model.EmployeeLeave;
import v2.com.company.payroll.model.EmployeeLoan;
import v2.com.company.payroll.model.EventModel;
import v2.com.company.payroll.model.Training;
import v2.com.company.payroll.service.AccountService;
import v2.com.company.payroll.service.EmployeeLeaveService;
import v2.com.company.payroll.service.EmployeeLoanService;
import v2.com.company.payroll.service.EmployeeSalaryService;
import v2.com.company.payroll.service.EmployeeService;
import v2.com.company.payroll.service.PayrollService;
import v2.com.company.payroll.service.TrainingService;
import v2.com.company.payroll.utils.PasswordEncription;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private EmployeeSalaryService employeeSalaryService;
	
	@Autowired
	private PayrollService payrollService;
	
	@Autowired
	private TrainingService trainingService;
	
	@Autowired
	private EmployeeLeaveService employeeLeaveService;
	
	@Autowired
	private EmployeeLoanService employeeLoanService;
	
	@Autowired
	private AccountService accountService;
	
	@GetMapping("/main/{id}")
	public ModelAndView employeePage(@PathVariable("id") int id, ModelAndView mv, ModelMap model, HttpServletRequest req) throws IOException {
		HttpSession session = req.getSession();

		Employee employee = employeeService.queryInfoById(id);
		String fullname = employee.getFullname();
		
		session.setAttribute("user", employee);
//		model.addAttribute("userFullname", fullname);
		model.addAttribute("employeeSalary", employeeSalaryService.getInfoByName(fullname));
		model.addAttribute("payrollList", payrollService.queryListByEmployee(fullname));

		mv.addObject(model);
		mv.setViewName("employee/main");
		
		return mv;
	}
	
	@GetMapping("/training")
	public ModelAndView training(@RequestParam("name") String fullname, ModelAndView mv) throws IOException {
		mv.addObject("json", getTrainingEvent(fullname));
		mv.setViewName("employee/view-training");
		
		return mv;
	}
	
	@GetMapping("/submitTraining")
	public String submitTraining(@RequestParam("id") int id, @RequestParam("status") String status, @RequestParam("name") String fullname) {
		Training training = new Training(id, status, fullname);
		trainingService.updateTrainingStatus(training);
		
		return "redirect:/employee/training?name=" + fullname;
	}
	
	@GetMapping("/leave")
	public ModelAndView leave(@RequestParam("name") String fullname, ModelAndView mv) throws IOException {
		mv.addObject("json", getLeaveEvent(fullname));
		mv.setViewName("employee/view-leave");
		
		return mv;
	}
	
	@GetMapping("/applyLeave")
	public String applyLeave() {
		return "employee/form-add-leave";
	}
	
	@PostMapping("/submitLeave")
	@ResponseBody
	public String submitLeave(HttpServletRequest req) {
		Map<String, Object> map = new HashMap<String, Object>();
		
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
		
		EmployeeLeave leave = new EmployeeLeave(reasons, startDateTime, endDateTime, leaveType, leaveStatus, name);
		Integer status = employeeLeaveService.insertLeave(leave);
		if(status > 0) {
			map.put("status", "success");
			map.put("msg", "Leave submitted.");
			map.put("httpUrl", "/employee/leave?name=" + name);
		} else {
			map.put("status", "failed");
			map.put("msg", "Failed to submit leave information.");
			map.put("httpUrl", "");
		}
		
		String result = new Gson().toJson(map);
		return result;
	}
	
	@GetMapping("/loan")
	public ModelAndView loan(@RequestParam("name") String fullname, ModelAndView mv) {
		mv.addObject("loanList", employeeLoanService.queryLoanListByEmployee(fullname));
		mv.setViewName("employee/view-loan");
		
		return mv;
	}
	
	@GetMapping("/applyLoan")
	public String applyLoan() {
		return "employee/form-add-loan";
	}
	
	@PostMapping("/submitLoan")
	@ResponseBody
	public String submitLoan(HttpServletRequest req) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		String name = req.getParameter("employee-name");
		String reasons = req.getParameter("reasons");
		Double amount = Double.valueOf(req.getParameter("loan-amount"));
		LocalDate date = LocalDate.parse(req.getParameter("apply-date").toString(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		String loanStatus = "PENDING";
		
		EmployeeLoan loan = new EmployeeLoan(reasons, amount, date, loanStatus, name);
		Integer status = employeeLoanService.insertLoan(loan);
		if(status > 0) {
			map.put("status", "success");
			map.put("msg", "Information submitted.");
			map.put("httpUrl", "/employee/loan?name=" + name);
		} else {
			map.put("status", "failed");
			map.put("msg", "Failed to submit loan information.");
			map.put("httpUrl", "");
		}
		
		String result = new Gson().toJson(map);
		return result;
	}
	
	@GetMapping("/profile")
	public ModelAndView profile(@RequestParam("id") int id, ModelAndView mv) {
		mv.addObject("user", employeeService.queryInfoById(id));
		mv.setViewName("employee/profile");
		
		return mv;
	}
	
	@PostMapping("/submitUpdateProfile")
	@ResponseBody
	public String submitUpdateProfile(HttpServletRequest req) {
		Map<String, Object> map = new HashMap<String, Object>();
		
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

		Employee employee = new Employee(id, fullname, gender, age, martialStatus, education, address, state, country, phone, email);
		Integer status = employeeService.updateEmployee(employee);
		if(status > 0) {
	    	map.put("status", "success");
	    	map.put("msg", "Update successful.");
	    	map.put("httpUrl", "/employee/profile?id=" + id);
		} else {
			map.put("status", "failed");
			map.put("msg", "Failed to update information.");
			map.put("httpUrl", "");
		}
		
		String result = new Gson().toJson(map);
		return result;
	}
	
	@PostMapping("/updateProfilePassword")
	@ResponseBody
	public String submitUpdatePassword(HttpServletRequest req, HttpSession session) {
		Map<String, Object> map = new HashMap<String, Object>();

		String username = session.getAttribute("username").toString();
		String oldPassword = req.getParameter("old_password");
		String newPassword = req.getParameter("new_password");
		String c_password = req.getParameter("c_password");
		
		if(newPassword.equals(c_password)) {
			LocalDateTime nowDateTime = LocalDateTime.now();
			String dateChanged = nowDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
			
			Account account = accountService.queryPasswordKey(username);
			Boolean validatePassword = PasswordEncription.verifyUserPassword(oldPassword, account.getPassword(), account.getKey());
			
			String salt = PasswordEncription.getSaltvalue(30);
	    	String hashedPassword = PasswordEncription.generateSecurePassword(newPassword, salt);
	    	
			if(validatePassword) {
				Integer status = accountService.updatePassword(username, hashedPassword, salt, dateChanged);
				if(status > 0) {
					map.put("status", "success");
	    	    	map.put("msg", "Password changed. Re-login to made changes.");
	    	    	map.put("httpUrl", "/logout");
				} else {
					map.put("status", "failed");
		    		map.put("msg", "Failed to update password.");
		    		map.put("httpUrl", "");
				}
			} else {
				map.put("status", "failed");
	    		map.put("msg", "Wrong old password, please try again.");
	    		map.put("httpUrl", "");
			}
		} else {
			map.put("status", "failed");
    		map.put("msg", "Password and confirmed password is not equal.");
    		map.put("httpUrl", "");
		}
		
		String result = new Gson().toJson(map);
		return result;
	}
	
	private List<String> getTrainingEvent(String name) throws IOException {
		List<String> json_list = new ArrayList<String>();
		List<Training> training_list = trainingService.queryListByEmployee(name);
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		
		for(Training training : training_list) {
			String description = "Info: " + training.getInfo() + " Issuer: " + training.getIssuer() + " Status: " +  training.getStatus();
			EventModel event = new EventModel(training.getId(), training.getInfo() , description, training.getStartDate(), training.getEndDate());
			json_list.add(gson.toJson(event));
		}

		return json_list;
	}
	
	private List<String> getLeaveEvent(String name) throws IOException {
		List<String> json_list = new ArrayList<String>();
		List<EmployeeLeave> leave_list = employeeLeaveService.queryLeaveListByEmployee(name);
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		
		for(EmployeeLeave leave : leave_list) {
			String description = leave.getReasons();
			EventModel event = new EventModel(leave.getId(), leave.getStatus() , description, leave.getDateFrom(), leave.getDateTo());
			json_list.add(gson.toJson(event));
		}

		return json_list;
	}

}
