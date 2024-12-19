package v2.com.company.payroll.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;

import v2.com.company.payroll.model.Account;
import v2.com.company.payroll.model.Employee;
import v2.com.company.payroll.model.EmployeeLeave;
import v2.com.company.payroll.model.EmployeeLoan;
import v2.com.company.payroll.model.EmployeePromotion;
import v2.com.company.payroll.model.EmployeeSalary;
import v2.com.company.payroll.model.Manager;
import v2.com.company.payroll.model.Payroll;
import v2.com.company.payroll.model.Resignation;
import v2.com.company.payroll.model.Training;
import v2.com.company.payroll.service.AccountService;
import v2.com.company.payroll.service.DepartmentService;
import v2.com.company.payroll.service.EmployeeLeaveService;
import v2.com.company.payroll.service.EmployeeLoanService;
import v2.com.company.payroll.service.EmployeePromotionService;
import v2.com.company.payroll.service.EmployeeSalaryService;
import v2.com.company.payroll.service.EmployeeService;
import v2.com.company.payroll.service.ManagerService;
import v2.com.company.payroll.service.PayrollService;
import v2.com.company.payroll.service.ResignationService;
import v2.com.company.payroll.service.TitleService;
import v2.com.company.payroll.service.TrainingService;
import v2.com.company.payroll.utils.PasswordEncription;

@Controller
@RequestMapping("/manager")
public class ManagerController {
	
	@Autowired
	private ManagerService managerService;
	
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private EmployeePromotionService employeePromotionService;
	
	@Autowired
	private EmployeeSalaryService employeeSalaryService;
	
	@Autowired
	private PayrollService payrollService;
	
	@Autowired
	private EmployeeLeaveService employeeLeaveService;
	
	@Autowired
	private EmployeeLoanService employeeLoanService;
	
	@Autowired
	private ResignationService resignationService;
	
	@Autowired
	private TrainingService trainingService;
	
	@Autowired
	private AccountService accountService;
	
	@Autowired
	private DepartmentService departmentService;
	
	@Autowired
	private TitleService titleService;
	
	@GetMapping("/main")
	public ModelAndView managerPage(ModelAndView mv, ModelMap model, HttpServletRequest req) throws IOException {
		HttpSession session = req.getSession();
		
		Integer id = Integer.valueOf(session.getAttribute("id").toString());
		Manager manager = managerService.queryInfoByAccountId(id);
		
		session.setAttribute("user", manager);
		model.addAttribute("employeeList", employeeService.queryEmployeeList());
		
		mv.addObject(model);
		mv.setViewName("manager/main");
		
		return mv;
	}
	
	@GetMapping("/addEmployee")
	public ModelAndView addEmployee(ModelAndView mv) {
		mv.addObject("deptList", departmentService.queryDepartmentList());
		mv.addObject("titleList", titleService.queryTitleList());
		mv.setViewName("manager/form-add-employee");
		return mv;
	}
	
	@PostMapping("/submitEmployee")
	@ResponseBody
	public String submitEmployee(HttpServletRequest req) {
		Map<String, Object> map = new HashMap<String, Object>();
		
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
	    	
	    	Account account = new Account(username, hashedPassword, salt, dateCreated);
	    	Integer accountStatus = accountService.insertAccount(account);
	    	if(accountStatus > 0) {
				Employee employee = new Employee(fullname, gender, age, martialStatus, education, address, state, country, phone, email, dateHired, null, 
															username, dept, hirer, title);
				
				Integer status = employeeService.addEmployee(employee);
				if(status > 0) {
					EmployeeSalary salary = new EmployeeSalary(baseSalary, annualSalary, fullname);
					Integer salaryStatus = employeeSalaryService.addSalary(salary);
					if(salaryStatus > 0) {
		    	    	map.put("status", "success");
		    	    	map.put("msg", "Add new employee successful.");
					} else {
						map.put("status", "failed");
		    			map.put("msg", "Failed to add employee information.");
					}
	    		} else {
	    			map.put("status", "failed");
	    			map.put("msg", "Failed to add employee information.");
	    		}
	    	} else {
	    		map.put("status", "failed");
	    		map.put("msg", "Failed to add user account.");
	    	}
		} else {
			map.put("status", "failed");
    		map.put("msg", "Password and confirmed password is not equal.");
		}
    	
		String result = new Gson().toJson(map);
		return result;
	}
	
	@GetMapping("/updateEmployee")
	public ModelAndView updateEmployee(@RequestParam("id") int id, ModelAndView mv) {
		mv.addObject("updateEmployee", employeeService.queryInfoById(id));
		mv.setViewName("manager/form-edit-employee");
		return mv;
	}
	
	@PostMapping("/submitUpdateEmployee")
	@ResponseBody
	public String submitUpdateEmployee(HttpServletRequest req) {
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
	    	map.put("msg", "Update information successful.");
	    	map.put("httpUrl", "/manager/main");
		} else {
			map.put("status", "failed");
			map.put("msg", "Failed to update manager information.");
			map.put("httpUrl", "");
		}
		
		String result = new Gson().toJson(map);
		return result;
	}
	
	@GetMapping("/deleteEmployee")
	public String deleteEmployee(@RequestParam("id") int id) {
		employeeService.deleteEmployee(id);
		
		return "redirect:/manager/main";
	}
	
	@GetMapping("/promotionsection")
	public ModelAndView promotionSection(ModelAndView mv) {
		mv.addObject("promotionList", employeePromotionService.queryPromotionList());
		mv.setViewName("manager/view-promotion");
		
		return mv;
	}
	
	@GetMapping("/promoteEmployee")
	public ModelAndView promoteEmployee(ModelAndView mv) {
		mv.addObject("titleList", titleService.queryTitleList());
		mv.setViewName("manager/form-add-promotion");
		
		return mv;
	}
	
	@PostMapping("/submitPromotion")
	@ResponseBody
	public String submitPromotion(HttpServletRequest req) {
		Map<String, Object> map = new HashMap<String, Object>();

		String name = req.getParameter("employee-name");
		String promoter = req.getParameter("manager-name");
		String title = req.getParameter("promote-title");
		Double previousSalary = Double.valueOf(req.getParameter("previous-salary"));
		Double promoteSalary = Double.valueOf(req.getParameter("promote-salary"));
		LocalDate promoteDate = LocalDate.parse(req.getParameter("promote-date").toString(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		
		EmployeePromotion promotion = new EmployeePromotion(previousSalary, promoteSalary, promoteDate, title, name, promoter);
		
		Integer status = employeePromotionService.addPromotion(promotion);
		if(status > 0) {
			Double annualSalary = promoteSalary * 13;
			EmployeeSalary salary = new EmployeeSalary(promoteSalary, annualSalary, name);
			
			Integer salaryStatus = employeeSalaryService.updateSalary(salary);
			if(salaryStatus > 0) {
				map.put("status", "success");
				map.put("msg", "Information submitted.");
				map.put("httpUrl", "/manager/promotionsection");
			} else {
				map.put("status", "failed");
				map.put("msg", "Failed to submit promotion information.");
				map.put("httpUrl", "");
			}
		} else {
			map.put("status", "failed");
			map.put("msg", "Failed to submit promotion information.");
			map.put("httpUrl", "");
		}
		
		String result = new Gson().toJson(map);
		return result;
	}
	
	@GetMapping("/updatePromotion")
	public ModelAndView updatePromotion(@RequestParam("id") int id, ModelAndView mv) {
		mv.addObject("updatePromotion", employeePromotionService.queryPromotionById(id));
		mv.setViewName("manager/form-edit-promotion");
		
		return mv;
	}
	
	@PostMapping("/submitUpdatePromotion")
	@ResponseBody
	public String submitUpdatePromotion(HttpServletRequest req) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		int id = Integer.valueOf(req.getParameter("id"));
		String name = req.getParameter("employee-name");
		String promoter = req.getParameter("manager-name");
		String title = req.getParameter("promote-title");
		Double previousSalary = Double.valueOf(req.getParameter("previous-salary"));
		Double promoteSalary = Double.valueOf(req.getParameter("promote-salary"));
		LocalDate promoteDate = LocalDate.parse(req.getParameter("promote-date").toString(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		
		EmployeePromotion promotion = new EmployeePromotion(id, previousSalary, promoteSalary, promoteDate, title, name, promoter);
		Integer status = employeePromotionService.editPromotion(promotion);
		if(status > 0) {
			Double annualSalary = promoteSalary * 13;
			EmployeeSalary salary = new EmployeeSalary(promoteSalary, annualSalary, name);
			
			Integer salaryStatus = employeeSalaryService.updateSalary(salary);
			if(salaryStatus > 0) {
				map.put("status", "success");
				map.put("msg", "Information updated.");
				map.put("httpUrl", "/manager/promotionsection");
			} else {
				map.put("status", "failed");
				map.put("msg", "Failed to update promotion information.");
				map.put("httpUrl", "");
			}
		} else {
			map.put("status", "failed");
			map.put("msg", "Failed to update promotion information.");
			map.put("httpUrl", "");
		}
		
		String result = new Gson().toJson(map);
		return result;
	}
	
	@GetMapping("/salarysection")
	public ModelAndView salarySection(ModelAndView mv) {
		mv.addObject("salaryList", employeeSalaryService.querySalaryList());
		mv.setViewName("manager/view-salary");
		
		return mv;
	}

	@GetMapping("/payrollsection")
	public ModelAndView payrollSection(ModelAndView mv) {
		mv.addObject("payrollList", payrollService.queryListByManager());
		mv.setViewName("manager/view-payroll");
		
		return mv;
	}
	
	@GetMapping("/issueSalary")
	public String issueSalary() {
		return "manager/form-add-salary";
	}
	
	@PostMapping("/submitSalary")
	@ResponseBody
	public String submitSalary(HttpServletRequest req) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		String name = req.getParameter("employee-name");
		String managerName = req.getParameter("manager-name");
		Double overtime = Double.valueOf(req.getParameter("overtimepay"));
		Double deduction = Double.valueOf(req.getParameter("deduction"));
		Double baseSalary = Double.valueOf(req.getParameter("base-salary"));
		LocalDate issueDate = LocalDate.parse(req.getParameter("issue-date").toString(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		
		Double totalSalary = baseSalary + overtime - deduction;
		Payroll payroll = new Payroll(overtime, deduction, totalSalary, baseSalary, issueDate, name, managerName);
		Integer status = payrollService.insertPayroll(payroll);
		if(status > 0) {
			map.put("status", "success");
			map.put("msg", "Payroll submitted.");
			map.put("httpUrl", "/manager/payrollsection");
		} else {
			map.put("status", "failed");
			map.put("msg", "Failed to submit payroll information.");
			map.put("httpUrl", "");
		}
		String result = new Gson().toJson(map);
		return result;
	}
	
	@GetMapping("/leavesection")
	public ModelAndView leaveSection(ModelAndView mv) {
		mv.addObject("leaveList", employeeLeaveService.queryLeaveList());
		mv.setViewName("manager/view-leave");
		
		return mv;
	}
	
	@GetMapping("/updateEmployeeLeave")
	public String updateEmployeeLeave(@RequestParam("id") int id, @RequestParam("status") String status, @RequestParam("by") String approver) {
		EmployeeLeave leave = new EmployeeLeave(id, status, approver);
		employeeLeaveService.updateLeaveStatus(leave);
		
		return "redirect:/manager/leavesection";
	}
	
	@GetMapping("/loansection")
	public ModelAndView loanSection(ModelAndView mv) {
		mv.addObject("loanList", employeeLoanService.queryLoanList());
		mv.setViewName("manager/view-loan");
		
		return mv;
	}
	
	@GetMapping("/updateEmployeeLoan")
	public String updateEmployeeLoan(@RequestParam("id") int id, @RequestParam("status") String status, @RequestParam("by") String approver) {
		EmployeeLoan loan = new EmployeeLoan(id, status, approver);
		employeeLoanService.updateLoanStatus(loan);
		
		return "redirect:/manager/loansection";
	}
	
	@GetMapping("/resignsection")
	public ModelAndView resignSection(ModelAndView mv) {
		mv.addObject("resignList", resignationService.queryResignList());
		mv.setViewName("manager/view-resign");
		
		return mv;
	}
	
	@GetMapping("/issueResignation")
	public String issueResignation() {
		return "manager/form-add-resign";
	}
	
	@PostMapping("/submitResignation")
	@ResponseBody
	public String submitResignation(HttpServletRequest req) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		String name = req.getParameter("employee-name");
		String issuer = req.getParameter("manager-name");
		String reasons = req.getParameter("reasons");
		LocalDate date = LocalDate.parse(req.getParameter("issue-date").toString(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		
		Resignation resign = new Resignation(reasons, date, name, issuer);
		Integer status = resignationService.insertResignInfo(resign);
		if(status > 0) {
			Integer updateQuitDate = employeeService.updateQuitDate(name, date);
			if(updateQuitDate > 0) {
				map.put("status", "success");
				map.put("msg", "Information submitted.");
				map.put("httpUrl", "/manager/resignsection");
			} else {
				map.put("status", "failed");
				map.put("msg", "Failed to submit resign information.");
				map.put("httpUrl", "");
			}
		} else {
			map.put("status", "failed");
			map.put("msg", "Failed to submit resign information.");
			map.put("httpUrl", "");
		}
		
		String result = new Gson().toJson(map);
		return result;
	}
	
	@GetMapping("/trainingsection")
	public ModelAndView trainingSection(ModelAndView mv) {
		mv.addObject("trainingList", trainingService.queryListByManager());
		mv.setViewName("manager/view-training");

		return mv;
	}
	
	@GetMapping("/issueTraining")
	public String issueTraining() {
		return "manager/form-add-training";
	}
	
	@PostMapping("/submitTraining")
	@ResponseBody
	public String submitTraining(HttpServletRequest req) {
		Map<String, Object> map = new HashMap<String, Object>();
		
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
		
		Training training = new Training(info, startDateTime, endDateTime, trainingStatus, name, issuer);
		Integer status = trainingService.addTrainingInfo(training);
		if(status > 0) {
			map.put("status", "success");
			map.put("msg", "Information submitted.");
			map.put("httpUrl", "/manager/trainingsection");
		} else {
			map.put("status", "failed");
			map.put("msg", "Failed to submit training information.");
			map.put("httpUrl", "");
		}
		
		String result = new Gson().toJson(map);
		return result;
	}
	
	@GetMapping("/profile")
	public ModelAndView profileSection(@RequestParam("id") int id, ModelAndView mv) {
		mv.addObject("user", managerService.queryInfoById(id));
		mv.setViewName("manager/profile");
		
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

		Manager admin = new Manager(id, fullname, gender, age, martialStatus, education, address, state, country, phone, email);
		Integer status = managerService.updateManager(admin);
		if(status > 0) {
	    	map.put("status", "success");
	    	map.put("msg", "Update successful.");
	    	map.put("httpUrl", "/manager/profile?id=" + id);
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

}
