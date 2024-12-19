package com.company.payroll.test.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import v2.com.company.payroll.model.EmployeeLeave;
import v2.com.company.payroll.service.EmployeeLeaveService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="/spring/spring-mybatis.xml")
public class LeaveTest {
	
	@Autowired
	private EmployeeLeaveService employeeLeaveService;
	
	@Test
	public void getList() {
		List<EmployeeLeave> list = employeeLeaveService.queryLeaveList();
		
		for(EmployeeLeave leave : list) {
			System.out.printf("id: %d\treasons: %s\tfrom: %s\tto: %s\ttype: %s\tstatus: %s\tname: %s\tapprover: %s\n", leave.getId(), leave.getReasons(), leave.getDateFrom(),
							  leave.getDateTo(), leave.getType(), leave.getStatus(), leave.getEmployeeName(), leave.getApprover());
		}
	}
	
	@Test
	public void getListByEmployee() {
		List<EmployeeLeave> list = employeeLeaveService.queryLeaveListByEmployee("Tan Min Lee");
		for(EmployeeLeave leave : list) {
			System.out.printf("id: %d\treasons: %s\tfrom: %s\tto: %s\ttype: %s\tstatus: %s\tapprover: %s\n", leave.getId(), leave.getReasons(), leave.getDateFrom(),
							  leave.getDateTo(), leave.getType(), leave.getStatus(), leave.getApprover());
		}
	}
	
	@Test
	public void insertLeave() {
		EmployeeLeave leave = new EmployeeLeave("testing reasons", "2022-04-19 08:00:00", "2022-04-20 18:00:00", "UNPAID LEAVE", "PENDING", "Tan Min Lee");
		Integer stat = employeeLeaveService.insertLeave(leave);
		System.out.println("status: " + stat);
	}
	
	@Test
	public void updateLeave() {
		EmployeeLeave leave = new EmployeeLeave(9, "APPROVED", "Khor Ming Guan");
		Integer stat = employeeLeaveService.updateLeaveStatus(leave);
		System.out.println("status: " + stat);
	}
}
