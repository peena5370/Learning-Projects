package com.company.payroll.test.mapper;

import java.time.LocalDate;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import v2.com.company.payroll.model.EmployeeLoan;
import v2.com.company.payroll.service.EmployeeLoanService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="/spring/spring-mybatis.xml")
public class LoanTest {

	@Autowired
	private EmployeeLoanService employeeLoanService;
	
	@Test
	public void getList() {
		List<EmployeeLoan> list = employeeLoanService.queryLoanList();
		
		for(EmployeeLoan loan : list) {
			System.out.printf("id: %d\treasons: %s\tamount: %.2f\tdate: %s\tstatus: %s\tname: %s\tapprover: %s\n", loan.getId(), loan.getReasons(), loan.getAmount(), loan.getIssueDate(),
							  loan.getStatus(), loan.getEmployeeName(), loan.getApprover());
		}
	}
	
	@Test
	public void getListByName() {
		List<EmployeeLoan> list = employeeLoanService.queryLoanListByEmployee("Tan Min Lee");
		for(EmployeeLoan loan : list) {
			System.out.printf("id: %d\treasons: %s\tamount: %.2f\tdate: %s\tstatus: %s\tapprover: %s\n", loan.getId(), loan.getReasons(), loan.getAmount(), loan.getIssueDate(), 
							  loan.getStatus(), loan.getApprover());
		}
	}
	
	@Test
	public void insert() {
		LocalDate date = LocalDate.of(2022, 04, 19);
		EmployeeLoan loan = new EmployeeLoan("for test reasons", 1234.67, date, "PENDING", "Tan Min Lee");
		
		Integer stat = employeeLoanService.insertLoan(loan);
		System.out.println("status: " + stat);
	}
	
	@Test
	public void update() {
		EmployeeLoan loan = new EmployeeLoan(5006, "APPROVED", "Khor Ming Guan");
		
		Integer stat = employeeLoanService.updateLoanStatus(loan);
		System.out.println("status: " + stat);
	}
}
