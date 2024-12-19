package v2.com.company.payroll.service;

import java.util.List;

import v2.com.company.payroll.model.EmployeeLeave;

public interface EmployeeLeaveService {
	List<EmployeeLeave> queryLeaveList();
	
	List<EmployeeLeave> queryLeaveListByEmployee(String fullname);
	
	Integer insertLeave(EmployeeLeave leave);
	
	Integer updateLeaveStatus(EmployeeLeave leave);
}
