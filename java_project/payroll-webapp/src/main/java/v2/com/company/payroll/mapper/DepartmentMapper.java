package v2.com.company.payroll.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import v2.com.company.payroll.model.Department;

@Repository
public interface DepartmentMapper {
	/**
	 * @return	List<Department>	Get all department list
	 * */
	List<Department> getAllDepartment();
	
	/**
	 * @return	List<Department>	Get department list with id and department name
	 * */
	List<Department> getIdAndName();
	
	/**
	 * @param	id	Department id
	 * @return	String 	Department name
	 * */
	String getDepartmentById(int id);
	
	/**
	 * @param	department	Department model
	 * @return	Integer		Add status
	 * */
	Integer addDepartment(Department department);
	
	/**
	 * @param	department	Department model
	 * @return	Integer		Update status
	 * */
	Integer updateDepartment(Department department);
	
	/**
	 * @param	id			Department id
	 * @return	Integer		Delete status
	 * */
	Integer deleteDepartment(int id);
}
