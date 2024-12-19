package v2.com.company.payroll.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import v2.com.company.payroll.model.Account;
import v2.com.company.payroll.model.Employee;
import v2.com.company.payroll.model.Manager;
import v2.com.company.payroll.service.AccountService;
import v2.com.company.payroll.service.EmployeeService;
import v2.com.company.payroll.service.ManagerService;
import v2.com.company.payroll.utils.PasswordEncription;

@Controller
public class LoginController {
	
	@Autowired
	private AccountService accountService;
	
	@Autowired
	private ManagerService managerService;
	
	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/main")
	public String login() {
		return "login";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/main";
	}
	
	@PostMapping("/user-login")
	@ResponseBody
	public String validate(@RequestParam("username") String username, @RequestParam("password") String password, ModelMap model, HttpSession session) {
		Account account = accountService.queryPasswordKey(username);
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		if(account != null) {
			Boolean validatePassword = PasswordEncription.verifyUserPassword(password, account.getPassword(), account.getKey());
			session.setAttribute("username", username);
			
			if(validatePassword==true) {
				int id = account.getId();
				session.setAttribute("id", id);
				Manager manager = managerService.queryInfoByAccountId(id);
				Employee employee = employeeService.queryInfoByAccountId(id);
				
				if(manager != null) {
					String role = manager.getRole();
					
					switch(role) {
						case "Administrator":
							map.put("code", 102);
							map.put("msg", "");
							map.put("httpUrl", "/admin/main");
							break;
						case "Manager":
							map.put("code", 102);
							map.put("msg", "");
							map.put("httpUrl", "/manager/main");
							break;
						default:
							break;
					}
				} else if(employee != null) {
					map.put("code", 102);
					map.put("msg", "");
					map.put("httpUrl", "/employee/main/" + employee.getId());
				} else {
					map.put("code", 104);
					map.put("msg", "No such user, please get further assistance from administrator.");
					map.put("httpUrl", "");
				}
			} else {
				map.put("code", 103);
				map.put("msg", "Wrong password, please try again");
				map.put("httpUrl", "");
			}	
		} else {
			map.put("code", 100);
			map.put("msg", "Wrong user name or password, please try again.");
			map.put("httpUrl", "");
		}
		
		String result = new Gson().toJson(map);
		return result;
	}

}
