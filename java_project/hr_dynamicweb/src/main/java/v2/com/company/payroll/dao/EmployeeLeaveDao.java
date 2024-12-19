package v2.com.company.payroll.dao;

import java.io.IOException;
import java.util.List;

import v2.com.company.payroll.model.EmployeeLeaveModel;

public interface EmployeeLeaveDao {
	
	/**
	 * 
	 * @return	List<EmployeeLeave>
	 * */
	List<EmployeeLeaveModel> getLeaveList() throws IOException;
	
	/**
	 * @return	List<EmployeeLeave>
	 * */
	List<EmployeeLeaveModel> getLeaveListByEmployee(String employeeName) throws IOException;
	
	/**
	 * @param	leave
	 * @return	Boolean
	 * */
	Boolean insertLeave(EmployeeLeaveModel leave) throws IOException;
	
	/**
	 * @param	leave
	 * @return	Boolean
	 * */
	Boolean updateStatus(EmployeeLeaveModel leave) throws IOException;
}
