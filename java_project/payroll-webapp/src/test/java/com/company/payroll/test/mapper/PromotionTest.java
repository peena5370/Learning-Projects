package com.company.payroll.test.mapper;

import java.time.LocalDate;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import v2.com.company.payroll.model.EmployeePromotion;
import v2.com.company.payroll.service.EmployeePromotionService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="/spring/spring-mybatis.xml")
public class PromotionTest {
	
	@Autowired
	private EmployeePromotionService employeePromotionService;
	
	@Test
	public void getList() {
		List<EmployeePromotion> list = employeePromotionService.queryPromotionList();
		
		for(EmployeePromotion promotion : list) {
			System.out.printf("id: %d\tprevious: %.2f\tpromote: %.2f\tdate: %s\ttitle: %s\tname: %s\tapprover: %s\n", promotion.getId(), promotion.getPreviousSalary(), promotion.getPromoteSalary(), 
								promotion.getPromoteDate(), promotion.getPromoteTitle(), promotion.getEmployeeName(), promotion.getApprover());
		}
	}
	
	@Test
	public void getInfoById() {
		EmployeePromotion promotion = employeePromotionService.queryPromotionById(1165);
		
		System.out.printf("id: %d\tprevious: %.2f\tpromote: %.2f\tdate: %s\ttitle: %s\tname: %s\tapprover: %s\n", promotion.getId(), promotion.getPreviousSalary(), promotion.getPromoteSalary(), 
				promotion.getPromoteDate(), promotion.getPromoteTitle(), promotion.getEmployeeName(), promotion.getApprover());
	}
	
	@Test
	public void addPromotion() {
		LocalDate date = LocalDate.of(2022, 04, 20);
		EmployeePromotion promotion = new EmployeePromotion(2400.00, 2800.00, date, "Production Technician IV", "Tan Min Lee", "Khor Ming Guan");
		
		Integer stat = employeePromotionService.addPromotion(promotion);
		System.out.println("status: " + stat);
	}
	
	@Test
	public void updatePromotion() {
		LocalDate date = LocalDate.of(2022, 04, 20);
		EmployeePromotion promotion = new EmployeePromotion(1171, 2400.00, 2800.00, date, "Production Engineer I", "Tan Min Lee", "Khor Ming Guan");
		
		Integer stat = employeePromotionService.editPromotion(promotion);
		System.out.println("status: " + stat);
	}
}
