package v2.com.company.payroll.service;

import java.time.LocalDate;
import java.util.List;

import v2.com.company.payroll.model.Employee;

public interface EmployeeService {
	List<Employee> queryEmployeeList();
	
	Employee queryInfoByAccountId(int id);
	
	Employee queryInfoById(int id);
	
	List<Employee> queryAccountInfo();
	
	Integer addEmployee(Employee employee);
	
	Integer updateEmployee(Employee employee);
	
	Integer updateQuitDate(String fullname, LocalDate dateQuit);
	
	Integer updateEmployeeTitle(String fullname, String title);
	
	Integer deleteEmployee(int id);
}
