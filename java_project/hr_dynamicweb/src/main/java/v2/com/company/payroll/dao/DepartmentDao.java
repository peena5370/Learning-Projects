package v2.com.company.payroll.dao;

import java.io.IOException;
import java.util.List;

import v2.com.company.payroll.model.DepartmentModel;

public interface DepartmentDao {
	
	/**
	 * @return	List<Department>
	 * */
	List<DepartmentModel> getAllDepartment() throws IOException;
	
	/**
	 * @return	List<Department>
	 * */
	List<DepartmentModel> getDepartmentIdAndName() throws IOException;
	
	/**
	 * @param	id
	 * @return String departmentName
	 * */
	String getDepartmentName(int id) throws IOException;
	
	/**
	 * @param	departmentName, location, state, country
	 * @return	Boolean
	 * */
	Boolean addNewDepartment(DepartmentModel department) throws IOException;
	
	/**
	 * @param	id, departmentName, location, state, country
	 * @return	Boolean
	 * */
	Boolean updateDepartment(DepartmentModel department) throws IOException;
	
	/**
	 * @param	id
	 * @return	Boolean
	 * */
	Boolean deleteDepartment(int id) throws IOException;
}
