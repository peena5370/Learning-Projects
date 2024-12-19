package com.company.payroll.test.mapper;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import v2.com.company.payroll.model.Department;
import v2.com.company.payroll.service.DepartmentService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="/spring/spring-mybatis.xml")
public class DepartmentTest {
	private static final Logger log = LogManager.getLogger(DepartmentTest.class);
	
	@Autowired
	private DepartmentService departmentService;
	
	@Test
	public void getList() {
		List<Department> list = departmentService.queryDepartmentList();
		
		for(Department dept : list) {
			System.out.println("id: " + dept.getId() + "\tname: " + dept.getDepartmentName() + "\tlocation: " + dept.getLocation() + "\tstate: " + 
							   dept.getState() + "\tcountry: " + dept.getCountry());
		}
	}
	
	@Test
	public void getDepartment() {
		List<Department> list = departmentService.queryDepartmentInfo();
		
		for(Department dept : list) {
			System.out.println("id: " + dept.getId() + "\tname: " + dept.getDepartmentName());
		}
	}
	
	@Test
	public void getDepartmentName() {
		String dept = departmentService.queryDepartmentName(2016);
		System.out.println("dept name: " + dept);
	}
	
	@Test
	public void addDepartment() {
		Department dept = new Department("new dept name", "new location222", "Kedah", "Malaysia");
		Integer stat = departmentService.addNewDepartment(dept);
		System.out.println("status: " + stat);
	}
	
	@Test
	public void updateDepartment() {
		Department dept = new Department(2021, "new dept name123", "new loc123", "new state", "Test");
		Integer stat = departmentService.updateDepartmentInfo(dept);
		System.out.println("status: " + stat);
	}
	
	@Test
	public void deleteDepartment() {
		Integer stat = departmentService.deleteDepartment(2021);
		System.out.println("status: " + stat);
	}
}
