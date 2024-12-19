package com.company.payroll.test.mapper;

import java.time.LocalDate;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import v2.com.company.payroll.model.Payroll;
import v2.com.company.payroll.service.PayrollService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="/spring/spring-mybatis.xml")
public class PayrollTest {

	@Autowired
	private PayrollService payrollService;
	
	@Test
	public void getListByManager() {
		List<Payroll> list = payrollService.queryListByManager();
		
		for(Payroll payroll : list) {
			System.out.printf("id: %d\tbase: %.2f\tot: %.2f\tdeduct: %.2f\ttotal: %.2f\tdate: %s\tname: %s\tapprover: %s\n", payroll.getId(), payroll.getBaseSalary(), payroll.getOvertimepay(), 
							  payroll.getDeduction(), payroll.getTotal(), payroll.getIssueDate(), payroll.getEmployeeName(), payroll.getApprover());
		}
	}
	
	@Test
	public void getListByEmployee() {
		List<Payroll> list = payrollService.queryListByEmployee("Tan Min Lee");
		
		for(Payroll payroll : list) {
			System.out.printf("id: %d\tbase: %.2f\tot: %.2f\tdeduct: %.2f\ttotal: %.2f\tdate: %s\tapprover: %s\n", payroll.getId(), payroll.getBaseSalary(), payroll.getOvertimepay(), 
							  payroll.getDeduction(), payroll.getTotal(), payroll.getIssueDate(), payroll.getApprover());
		}
	}
	
	@Test
	public void insertPayroll() {
		LocalDate date = LocalDate.of(2020, 04, 30);
		Payroll payroll = new Payroll(123.45, 22.33, 3901.12, 3800.00, date, "Tan Min Lee", "Khor Ming Guan");
		
		Integer stat = payrollService.insertPayroll(payroll);
		System.out.println("status: " + stat);
	}
}
