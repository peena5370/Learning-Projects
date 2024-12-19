package v2.com.company.payroll.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import v2.com.company.payroll.model.EmployeeLeave;

@Repository
public interface EmployeeLeaveMapper {
	/**
	 * 
	 * @return	List<EmployeeLeave>
	 * */
	List<EmployeeLeave> getLeaveList();
	
	/**
	 * @return	List<EmployeeLeave>
	 * */
	List<EmployeeLeave> getLeaveListByEmployee(@Param(value="employeeName") String fullname);
	
	/**
	 * @param	leave
	 * @return	Boolean
	 * */
	Integer insertLeave(EmployeeLeave leave);
	
	/**
	 * @param	leave
	 * @return	Boolean
	 * */
	Integer updateStatus(EmployeeLeave leave);
}
