package com.company.payroll.test.mapper;

import java.time.LocalDate;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import v2.com.company.payroll.model.Resignation;
import v2.com.company.payroll.service.ResignationService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="/spring/spring-mybatis.xml")
public class ResignationTest {

	@Autowired
	private ResignationService resignationService;
	
	@Test
	public void getList() {
		List<Resignation> list = resignationService.queryResignList();
		
		for(Resignation resign : list) {
			System.out.printf("id: %d\treasons: %s\tdate: %s\tname: %s\tapprover: %s\n", resign.getId(), resign.getReasons(), resign.getDate(), resign.getEmployeeName(), resign.getApprover());
		}
	}
	
	@Test
	public void insert() {
		LocalDate date = LocalDate.of(2022, 04, 21);
		Resignation resign = new Resignation("new reasons reasons...", date, "new fullname 123", "Khor Ming Guan");
		
		Integer stat = resignationService.insertResignInfo(resign);
		System.out.println("status: " + stat);
	}
}
