package v2.com.company.payroll.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import v2.com.company.payroll.mapper.EmployeeSalaryMapper;
import v2.com.company.payroll.model.EmployeeSalary;
import v2.com.company.payroll.service.EmployeeSalaryService;

@Service
public class EmployeeSalaryServiceImpl implements EmployeeSalaryService {
	
	@Autowired
	private EmployeeSalaryMapper employeeSalaryMapper;

	@Override
	public List<EmployeeSalary> querySalaryList() {
		return employeeSalaryMapper.getAllEmployeeSalary();
	}

	@Override
	public EmployeeSalary getInfoByName(String fullname) {
		return employeeSalaryMapper.getSalaryByName(fullname);
	}

	@Override
	public Integer addSalary(EmployeeSalary salary) {
		return employeeSalaryMapper.insertEmployeeSalary(salary);
	}

	@Override
	public Integer updateSalary(EmployeeSalary salary) {
		return employeeSalaryMapper.updateEmployeeSalary(salary);
	}

}
