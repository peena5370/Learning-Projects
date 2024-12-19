package v2.com.company.payroll.dao;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import v2.com.company.payroll.model.EmployeeModel;

public interface EmployeeDao {
	
	/**
	 * @return	List<Employee>
	 * */
	List<EmployeeModel> listAllEmployee() throws IOException;
	
	/**
	 * @param	account_id
	 * @return	Employee
	 * */
	EmployeeModel getEmployeeById(int id) throws IOException;
	
	/**
	 * @param	e_id employee id
	 * @return Employee
	 * */
	EmployeeModel getEmployeeByEmployeeId(int id) throws IOException;
	
	/**
	 * @return	List<Employee>
	 * */
	List<EmployeeModel> getEmployeeAccountInfo() throws IOException;
	
	/**
	 * @param	EmployeeModel
	 * @return	Boolean
	 * */
	Boolean addEmployee(EmployeeModel employee) throws IOException;
	
	/**
	 * @param	EmployeeModel
	 * @return	Boolean
	 * */
	Boolean updateEmployee(EmployeeModel employee) throws IOException;
	
	/**
	 * @param	Date
	 * @return	Boolean
	 * */
	Boolean updateEmployeeQuitDate(String fullname, LocalDate dateQuit) throws IOException;
	
	/**
	 * @param	fullname, title
	 * @return	Boolean
	 * */
	Boolean updateEmployeeTitle(String fullname, String title) throws IOException;
	
	/**
	 * @param	id
	 * @return	Boolean
	 * */
	Boolean deleteEmployee(int id) throws IOException;
}
