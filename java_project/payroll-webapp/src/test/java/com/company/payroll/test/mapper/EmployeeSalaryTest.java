package com.company.payroll.test.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import v2.com.company.payroll.model.EmployeeSalary;
import v2.com.company.payroll.service.EmployeeSalaryService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="/spring/spring-mybatis.xml")
public class EmployeeSalaryTest {
	
	@Autowired
	private EmployeeSalaryService employeeSalaryService;
	
	@Test
	public void getList() {
		List<EmployeeSalary> list = employeeSalaryService.querySalaryList();
		
		for(EmployeeSalary salary : list) {
			System.out.printf("id: %d\tmonthly: %.2f\tannual: %.2f\tname: %s\n", salary.getId(), salary.getMonthlySalary(), salary.getAnnualSalary(), salary.getEmployeeName());
		}
	}
	
	@Test
	public void getInfoByName() {
		EmployeeSalary salary = employeeSalaryService.getInfoByName("Tan Min Lee");
		System.out.printf("monthly: %.2f\tannual: %.2f", salary.getMonthlySalary(), salary.getAnnualSalary());
	}
	
	@Test
	public void addSalary() {
		EmployeeSalary salary = new EmployeeSalary(2200.00, 28600.00, "new fullname 123");
		
		Integer stat = employeeSalaryService.addSalary(salary);
		System.out.println("status: " + stat);
	}
	
	@Test
	public void updateSalary() {
		EmployeeSalary salary = new EmployeeSalary(2400.00, 31200.00, "new fullname 123");
		
		Integer stat = employeeSalaryService.updateSalary(salary);
		System.out.println("status: " + stat);
	}

}
