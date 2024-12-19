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
import v2.com.company.payroll.model.Department;
import v2.com.company.payroll.model.Employee;
import v2.com.company.payroll.model.Manager;
import v2.com.company.payroll.model.Title;
import v2.com.company.payroll.service.AccountService;
import v2.com.company.payroll.service.DepartmentService;
import v2.com.company.payroll.service.EmployeeService;
import v2.com.company.payroll.service.ManagerService;
import v2.com.company.payroll.service.TitleService;
import v2.com.company.payroll.utils.PasswordEncription;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private ManagerService managerService;
	
	@Autowired
	private TitleService titleService;
	
	@Autowired
	private DepartmentService departmentService;
	
	@Autowired
	private AccountService accountService;
	
	@GetMapping("/main")
	public ModelAndView adminPage(ModelAndView mv, ModelMap model, HttpServletRequest req) throws IOException {
		HttpSession session = req.getSession();
		
		Integer id = Integer.valueOf(session.getAttribute("id").toString());
		Manager manager = managerService.queryInfoByAccountId(id);
		
		session.setAttribute("user", manager);
		model.addAttribute("managerList", managerService.queryManagerList());

		mv.addObject(model);
		mv.setViewName("admin/main");
		
		return mv;
	}
	
	@GetMapping("/employeesection")
	public ModelAndView employeeSection(ModelAndView mv) {
		mv.addObject("employeeList", employeeService.queryEmployeeList());
		mv.setViewName("admin/view-employee");
		
		return mv;
	}
	
	@GetMapping("/accountemployee")
	public ModelAndView accountEmployee(ModelAndView mv) {
		mv.addObject("accList", employeeService.queryAccountInfo());
		mv.setViewName("admin/view-account-employee");
		
		return mv;
	}
	
	@GetMapping("/accountmanager")
	public ModelAndView accountManager(ModelAndView mv) {
		mv.addObject("accList2", managerService.queryAccountInfo());
		mv.setViewName("admin/view-account-manager");
		
		return mv;
	}
	
	@GetMapping("/titlesection")
	public ModelAndView titleSection(ModelAndView mv) {
		mv.addObject("titleList", titleService.queryTitleList());
		mv.setViewName("admin/view-title");
		
		return mv;
	}
	
	@GetMapping("/departmentsection")
	public ModelAndView departmentSection(ModelAndView mv) {
		mv.addObject("deptList", departmentService.queryDepartmentList());
		mv.setViewName("admin/view-department");
		
		return mv;
	}
	
	@GetMapping("/profile")
	public ModelAndView profileSection(@RequestParam("id") int id, ModelAndView mv) {
		mv.addObject("user", managerService.queryInfoById(id));
		mv.setViewName("admin/profile");
		
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
	    	map.put("httpUrl", "/admin/profile?id=" + id);
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
	
	@GetMapping("/addManager")
	public ModelAndView addManager(ModelAndView mv) {
		mv.addObject("deptList", departmentService.queryDepartmentList());
		mv.addObject("titleList", titleService.queryTitleList());
		mv.setViewName("admin/form-add-manager");
		
		return mv;
	}
	
	@PostMapping("/submitManager")
	@ResponseBody
	public String submitManager(HttpServletRequest req) {
		Map<String, Object> map = new HashMap<String, Object>();
		
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
	    	Account account = new Account(username, hashedPassword, salt, dateCreated);
	    	
	    	Integer accountStatus = accountService.insertAccount(account);
	    	
	    	if(accountStatus > 0) {
	    		Manager manager = new Manager(fullname, role, gender, age, martialStatus, education, address, state, country, phone, email, dateHired, null,  
						username, dept, title);
	    		
	    		Integer status = managerService.addManager(manager);
	    		if(status > 0) {
	    	    	map.put("status", "success");
	    	    	map.put("msg", "Add new manager successful.");
	    		} else {
	    			map.put("status", "failed");
	    			map.put("msg", "Failed to add manager information.");
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
	
	@GetMapping("/updateManager")
	public ModelAndView updateManager(@RequestParam("id") int id, ModelAndView mv) {
		mv.addObject("manager", managerService.queryInfoById(id));
		mv.setViewName("admin/form-edit-manager");
		
		return mv;
	}
	
	@PostMapping("/submitUpdateManager")
	@ResponseBody
	public String submitUpdateManager(HttpServletRequest req) {
		Map<String, Object> map = new HashMap<String, Object>();
		
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
		
		Manager manager = new Manager(id, name, gender, age, martialStatus, education, address, state, country, phone, email);
		
		Integer status = managerService.updateManager(manager);		
		if(status > 0) {
	    	map.put("status", "success");
	    	map.put("msg", "Update information successful.");
	    	map.put("httpUrl", "/admin/main");
		} else {
			map.put("status", "failed");
			map.put("msg", "Failed to update manager information.");
			map.put("httpUrl", "");
		}
		
		String result = new Gson().toJson(map);
		return result;
	}
	
	@GetMapping("/deleteManager")
	public String deleteManager(@RequestParam("id") int id) {
		managerService.deleteManager(id);
		
		return "redirect:/admin/main";
	}
	
	@GetMapping("/addEmployee")
	public ModelAndView addEmployee(ModelAndView mv) {
		mv.addObject("deptList", departmentService.queryDepartmentList());
		mv.addObject("titleList", titleService.queryTitleList());
		mv.setViewName("admin/form-add-employee");
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
	    	    	map.put("status", "success");
	    	    	map.put("msg", "Add new employee successful.");
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
		mv.setViewName("admin/form-edit-employee");
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
	    	map.put("httpUrl", "/admin/employeesection");
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
		
		return "redirect:/admin/employeesection";
	}
	
	@GetMapping("/updateManagerPassword")
	public String updateManagerPassword() {
		return "admin/form-edit-manager-password";
	}
	
	@PostMapping("/submitManagerPassword")
	@ResponseBody
	public String submitManagerPassword(HttpServletRequest req) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		String username = req.getParameter("username");
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
	    	    	map.put("msg", "Password changed.");
	    	    	map.put("httpUrl", "/admin/accountmanager");
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
	
	@GetMapping("/updateEmployeePassword")
	public String updateEmployeePassword() {
		return "admin/form-edit-employee-password";
	}
	
	@PostMapping("/submitEmployeePassword")
	@ResponseBody
	public String submitEmployeePassword(HttpServletRequest req) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		String username = req.getParameter("username");
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
	    	    	map.put("msg", "Password changed.");
	    	    	map.put("httpUrl", "/admin/accountemployee");
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
	
	@GetMapping("/addTitle")
	public String addTitle() {
		return "admin/form-add-title";
	}
	
	@GetMapping("/updateTitle")
	public String updateTitle() {
		return "admin/form-edit-title";
	}
	
	@PostMapping("/submitTitle")
	@ResponseBody
	public String submitTitle(@RequestParam("title") String titleName) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		Integer status = titleService.addNewTitle(titleName);
		if(status > 0) {
			map.put("status", "success");
	    	map.put("msg", "Title added");
	    	map.put("httpUrl", "/admin/titlesection");
		} else {
			map.put("status", "failed");
    		map.put("msg", "Failed to submit title.");
    		map.put("httpUrl", "");
		}
		
		String result = new Gson().toJson(map);
		return result;
	}
	
	@PostMapping("/submitUpdateTitle")
	@ResponseBody
	public String submitUpdateTitle(HttpServletRequest req) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		int id = Integer.valueOf(req.getParameter("id"));
		String titleName = req.getParameter("title");
		Title title = new Title(id, titleName);
		
		Integer status = titleService.editTitle(title);
		if(status > 0) {
			map.put("status", "success");
	    	map.put("msg", "Title updated.");
	    	map.put("httpUrl", "/admin/titlesection");
		} else {
			map.put("status", "failed");
    		map.put("msg", "Failed to update title. Please try again.");
    		map.put("httpUrl", "");
		}
		
		String result = new Gson().toJson(map);
		return result;
	}
	
	@GetMapping("/addDepartment")
	public String addDepartment() {
		return "admin/form-add-department";
	}
	
	@GetMapping("/updateDepartment")
	public String updateDepartment() {
		return "admin/form-edit-department";
	}
	
	@PostMapping("/submitDepartment")
	@ResponseBody
	public String submitDepartment(HttpServletRequest req) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		String deptName = req.getParameter("dept-name");
		String address = req.getParameter("address");
		String state = req.getParameter("state");
		String country = req.getParameter("country");
		
		Department department = new Department(deptName, address, state, country);
		Integer status = departmentService.addNewDepartment(department);
		if(status > 0) {
			map.put("status", "success");
	    	map.put("msg", "Successful added department information.");
	    	map.put("httpUrl", "/admin/departmentsection");
		} else {
			map.put("status", "failed");
    		map.put("msg", "Failed to add department. Please try again");
    		map.put("httpUrl", "");
		}
		
		String result = new Gson().toJson(map);
		return result;
	}
	
	@PostMapping("/submitUpdateDepartment")
	@ResponseBody
	public String submitUpdateDepartment(HttpServletRequest req) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		int id = Integer.valueOf(req.getParameter("id"));
		String deptName = req.getParameter("dept-name");
		String address = req.getParameter("address");
		String state = req.getParameter("state");
		String country = req.getParameter("country");
		
		Department department = new Department(id, deptName, address, state, country);
		Integer status = departmentService.updateDepartmentInfo(department);
		if(status > 0) {
			map.put("status", "success");
	    	map.put("msg", "Successful update department information.");
	    	map.put("httpUrl", "/admin/departmentsection");
		} else {
			map.put("status", "failed");
    		map.put("msg", "Failed to update information. Please try again");
    		map.put("httpUrl", "");
		}
		
		String result = new Gson().toJson(map);
		return result;
	}

}
