package v2.com.company.payroll.mapper;

import java.time.LocalDate;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import v2.com.company.payroll.model.Employee;

@Repository
public interface EmployeeMapper {
	
	/**
	 * @return	List<Employee>
	 * */
	List<Employee> getEmployeeList();
	
	/**
	 * @param	account_id	Account id
	 * @return	Employee model
	 * */
	Employee getEmployeeById(int id);
	
	/**
	 * @param	e_id	Employee id
	 * @return Employee model
	 * */
	Employee getEmployeeInfo(int id);
	
	/**
	 * @return	List<Employee>	Employee list with account username, date created and date changed
	 * */
	List<Employee> getEmployeeByAccount();
	
	/**
	 * @param	employee	Employee model
	 * @return	Integer		Status	
	 * */
	Integer addEmployee(Employee employee);
	
	/**
	 * @param	employee	Employee model
	 * @return	Integer		Status
	 * */
	Integer updateEmployee(Employee employee);
	
	/**
	 * @param	fullname	Employee name
	 * @param	dateQuit	Employee quit date
	 * @return	Integer		Status
	 * */
	Integer updateEmployeeQuitDate(@Param(value="fullname") String fullname, 
								   @Param(value="dateQuit") LocalDate dateQuit);
	
	/**
	 * @param	fullname	Employee name
	 * @param	title		Employee latest title
	 * @return	Integer		Status
	 * */
	Integer updateEmployeeTitle(@Param(value="fullname") String fullname, 
								@Param(value="title") String title);
	
	/**
	 * @param	id			Employee id
	 * @return	Integer		Status
	 * */
	Integer deleteEmployee(int id);
}
