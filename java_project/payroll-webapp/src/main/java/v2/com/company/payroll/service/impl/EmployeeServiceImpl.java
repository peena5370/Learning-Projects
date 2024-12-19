package v2.com.company.payroll.service.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import v2.com.company.payroll.mapper.EmployeeMapper;
import v2.com.company.payroll.model.Employee;
import v2.com.company.payroll.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeMapper employeeMapper;

	@Override
	public List<Employee> queryEmployeeList() {
		return employeeMapper.getEmployeeList();
	}

	@Override
	public Employee queryInfoByAccountId(int id) {
		return employeeMapper.getEmployeeById(id);
	}

	@Override
	public Employee queryInfoById(int id) {
		return employeeMapper.getEmployeeInfo(id);
	}

	@Override
	public List<Employee> queryAccountInfo() {
		return employeeMapper.getEmployeeByAccount();
	}

	@Override
	public Integer addEmployee(Employee employee) {
		return employeeMapper.addEmployee(employee);
	}

	@Override
	public Integer updateEmployee(Employee employee) {
		return employeeMapper.updateEmployee(employee);
	}

	@Override
	public Integer updateQuitDate(String fullname, LocalDate dateQuit) {
		return employeeMapper.updateEmployeeQuitDate(fullname, dateQuit);
	}

	@Override
	public Integer updateEmployeeTitle(String fullname, String title) {
		return employeeMapper.updateEmployeeTitle(fullname, title);
	}

	@Override
	public Integer deleteEmployee(int id) {
		return employeeMapper.deleteEmployee(id);
	}

}
