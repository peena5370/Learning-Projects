package v2.com.company.payroll.service;

import java.util.List;

import v2.com.company.payroll.model.Department;

public interface DepartmentService {
	List<Department> queryDepartmentList();
	
	List<Department> queryDepartmentInfo();
	
	String queryDepartmentName(int id);
	
	Integer addNewDepartment(Department department);
	
	Integer updateDepartmentInfo(Department department);
	
	Integer deleteDepartment(int id);
}
