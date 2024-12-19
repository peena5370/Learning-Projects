package v2.com.company.payroll.dao;

import java.io.IOException;
import java.util.List;

import v2.com.company.payroll.model.EmployeeLoanModel;

public interface EmployeeLoanDao {
	
	/**
	 * @return	List<EmployeeLoan>
	 * */
	List<EmployeeLoanModel> getLoanList() throws IOException;
	
	/**
	 * @param	employeeName
	 * @return	List<EmployeeLoan>
	 * */
	List<EmployeeLoanModel> getLoanListByEmployee(String employeeName) throws IOException;
	
	/**
	 * @param	loan
	 * @return	Boolean
	 * */
	Boolean insertLoan(EmployeeLoanModel loan) throws IOException;
	
	/**
	 * @param	loan
	 * @return	Boolean
	 * */
	Boolean updateStatus(EmployeeLoanModel loan) throws IOException;
	
}
