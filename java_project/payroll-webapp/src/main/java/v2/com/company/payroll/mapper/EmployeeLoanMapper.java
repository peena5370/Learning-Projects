package v2.com.company.payroll.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import v2.com.company.payroll.model.EmployeeLoan;

@Repository
public interface EmployeeLoanMapper {
	/**
	 * @return	Detailed loan info list
	 * */
	List<EmployeeLoan> getLoanList();
	
	/**
	 * @param	fullname				Employee name
	 * @return	Loan info list based on employee name
	 * */
	List<EmployeeLoan> getLoanListByEmployee(@Param(value="employeeName") String fullname);
	
	/**
	 * @param	loan		EmployeeLoan model
	 * @return	Integer		Status
	 * */
	Integer insertLoan(EmployeeLoan loan);
	
	/**
	 * @param	loan		EmployeeLoan model
	 * @return	Integer		Status
	 * */
	Integer updateLoanStatus(EmployeeLoan loan);
}
