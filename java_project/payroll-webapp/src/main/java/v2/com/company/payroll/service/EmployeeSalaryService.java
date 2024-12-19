package v2.com.company.payroll.service;

import java.util.List;

import v2.com.company.payroll.model.EmployeeSalary;

public interface EmployeeSalaryService {
	List<EmployeeSalary> querySalaryList();
	
	EmployeeSalary getInfoByName(String fullname);
	
	Integer addSalary(EmployeeSalary salary);
	
	Integer updateSalary(EmployeeSalary salary);
}
