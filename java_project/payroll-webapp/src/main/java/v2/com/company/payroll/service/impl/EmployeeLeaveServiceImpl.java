package v2.com.company.payroll.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import v2.com.company.payroll.mapper.EmployeeLeaveMapper;
import v2.com.company.payroll.model.EmployeeLeave;
import v2.com.company.payroll.service.EmployeeLeaveService;

@Service
public class EmployeeLeaveServiceImpl implements EmployeeLeaveService {
	
	@Autowired
	private EmployeeLeaveMapper employeeLeaveMapper;

	@Override
	public List<EmployeeLeave> queryLeaveList() {
		return employeeLeaveMapper.getLeaveList();
	}

	@Override
	public List<EmployeeLeave> queryLeaveListByEmployee(String fullname) {
		return employeeLeaveMapper.getLeaveListByEmployee(fullname);
	}

	@Override
	public Integer insertLeave(EmployeeLeave leave) {
		return employeeLeaveMapper.insertLeave(leave);
	}

	@Override
	public Integer updateLeaveStatus(EmployeeLeave leave) {
		return employeeLeaveMapper.updateStatus(leave);
	}

}
