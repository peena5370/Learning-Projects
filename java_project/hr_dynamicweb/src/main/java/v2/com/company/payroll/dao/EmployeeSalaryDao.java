package v2.com.company.payroll.dao;

import java.io.IOException;
import java.util.List;

import v2.com.company.payroll.model.EmployeeSalaryModel;

public interface EmployeeSalaryDao {

	/**
	 * @return	List<EmployeeSalary>
	 * */
	List<EmployeeSalaryModel> getAllEmployeeSalary() throws IOException;
	
	/**
	 * @param	name Employee name
	 * @return EmployeeSalary
	 * */
	EmployeeSalaryModel getSalaryByEmployeeName(String name) throws IOException;
	
	/**
	 * @param	salary
	 * @return	Boolean
	 * */
	Boolean insertEmployeeSalary(EmployeeSalaryModel salary) throws IOException;
	
	/**
	 * @param	salary
	 * @return	Boolean
	 * */
	Boolean updateEmployeeSalary(EmployeeSalaryModel salary) throws IOException;
}
