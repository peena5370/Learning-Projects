package v2.com.company.payroll.service;

import java.util.List;

import v2.com.company.payroll.model.EmployeeLoan;

public interface EmployeeLoanService {
	List<EmployeeLoan> queryLoanList();
	
	List<EmployeeLoan> queryLoanListByEmployee(String fullname);
	
	Integer insertLoan(EmployeeLoan loan);
	
	Integer updateLoanStatus(EmployeeLoan loan);
}
