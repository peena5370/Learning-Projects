package v2.com.company.payroll.service;

import java.util.List;

import v2.com.company.payroll.model.Payroll;

public interface PayrollService {

	List<Payroll> queryListByManager();
	
	List<Payroll> queryListByEmployee(String fullname);
	
	Integer insertPayroll(Payroll payroll);
}
