package v2.com.company.payroll.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import v2.com.company.payroll.mapper.PayrollMapper;
import v2.com.company.payroll.model.Payroll;
import v2.com.company.payroll.service.PayrollService;

@Service
public class PayrollServiceImpl implements PayrollService {
	
	@Autowired
	private PayrollMapper payrollMapper;
	
	@Override
	public List<Payroll> queryListByManager() {
		return payrollMapper.getListByManager();
	}

	@Override
	public List<Payroll> queryListByEmployee(String fullname) {
		return payrollMapper.getListByEmployee(fullname);
	}

	@Override
	public Integer insertPayroll(Payroll payroll) {
		return payrollMapper.insertPayroll(payroll);
	}
}
