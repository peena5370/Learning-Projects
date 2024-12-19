package v2.com.company.payroll.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import v2.com.company.payroll.model.EmployeeSalary;

@Repository
public interface EmployeeSalaryMapper {

	List<EmployeeSalary> getAllEmployeeSalary();
	
	EmployeeSalary getSalaryByName(@Param(value="employeeName") String fullname);
	
	Integer insertEmployeeSalary(EmployeeSalary salary);
	
	Integer updateEmployeeSalary(EmployeeSalary salary);
}
