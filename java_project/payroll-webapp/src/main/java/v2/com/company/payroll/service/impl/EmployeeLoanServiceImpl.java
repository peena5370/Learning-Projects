package v2.com.company.payroll.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import v2.com.company.payroll.mapper.EmployeeLoanMapper;
import v2.com.company.payroll.model.EmployeeLoan;
import v2.com.company.payroll.service.EmployeeLoanService;

@Service
public class EmployeeLoanServiceImpl implements EmployeeLoanService {
	
	@Autowired
	private EmployeeLoanMapper employeeLoanMapper;

	@Override
	public List<EmployeeLoan> queryLoanList() {
		return employeeLoanMapper.getLoanList();
	}

	@Override
	public List<EmployeeLoan> queryLoanListByEmployee(String fullname) {
		return employeeLoanMapper.getLoanListByEmployee(fullname);
	}

	@Override
	public Integer insertLoan(EmployeeLoan loan) {
		return employeeLoanMapper.insertLoan(loan);
	}

	@Override
	public Integer updateLoanStatus(EmployeeLoan loan) {
		return employeeLoanMapper.updateLoanStatus(loan);
	}

}
