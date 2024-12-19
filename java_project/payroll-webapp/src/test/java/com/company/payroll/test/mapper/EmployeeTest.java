package com.company.payroll.test.mapper;

import java.time.LocalDate;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import v2.com.company.payroll.model.Employee;
import v2.com.company.payroll.service.EmployeeService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="/spring/spring-mybatis.xml")
public class EmployeeTest {
	
	@Autowired
	private EmployeeService employeeService;
	
	@Test
	public void getList() {
		List<Employee> list = employeeService.queryEmployeeList();
		
		for(Employee emp : list) {
			System.out.printf("id: %d\tname: %s\tgender: %s\tage: %d\tmartial: %s\teducation: %s\taddress: %s\tstate: %s\tcountry: %s\tphone: %s\tmail: %s\thired: %s"
					        + "\tquit: %s\tdept: %s\ttitle: %s\thirer: %s\n",emp.getId(), emp.getFullname(), emp.getGender(), emp.getAge(), emp.getMartialStatus(), emp.getEducation(), 
					        emp.getAddress(), emp.getState(), emp.getCountry(), emp.getPhone(), emp.getEmail(), emp.getDateHired(), emp.getDateQuit(), emp.getDepartment(), 
					        emp.getTitle(), emp.getHirer());
		}
	}
	
	@Test
	public void getInfoByAccountId() {
		Employee emp = employeeService.queryInfoByAccountId(10);
		System.out.printf("id: %d\tname: %s\tgender: %s\tage: %d\tmartial: %s\teducation: %s\taddress: %s\tstate: %s\tcountry: %s\tphone: %s\tmail: %s\thired: %s"
		        + "\tquit: %s\tdept: %s\ttitle: %s\thirer: %s\n",emp.getId(), emp.getFullname(), emp.getGender(), emp.getAge(), emp.getMartialStatus(), emp.getEducation(), 
		        emp.getAddress(), emp.getState(), emp.getCountry(), emp.getPhone(), emp.getEmail(), emp.getDateHired(), emp.getDateHired(), emp.getDepartment(), 
		        emp.getTitle(), emp.getHirer());
	}
	
	@Test
	public void getInfoByEmployeeId() {
		Employee emp = employeeService.queryInfoById(125417);
		System.out.printf("id: %d\tname: %s\tgender: %s\tage: %d\tmartial: %s\teducation: %s\taddress: %s\tstate: %s\tcountry: %s\tphone: %s\tmail: %s\thired: %s"
		        + "\tquit: %s\tdept: %s\ttitle: %s\thirer: %s\n",emp.getId(), emp.getFullname(), emp.getGender(), emp.getAge(), emp.getMartialStatus(), emp.getEducation(), 
		        emp.getAddress(), emp.getState(), emp.getCountry(), emp.getPhone(), emp.getEmail(), emp.getDateHired(), emp.getDateHired(), emp.getDepartment(), 
		        emp.getTitle(), emp.getHirer());
	}
	
	@Test
	public void getEmployeeWithAccountInfo() {
		List<Employee> list = employeeService.queryAccountInfo();
		for(Employee emp : list) {
			System.out.printf("id: %d\tname: %s\taccount id: %d\tusername: %s\tcreate: %s\tchange: %s\n", 
							emp.getId(), emp.getFullname(), emp.getAccount_id(), emp.getUsername(), emp.getDateCreated(), emp.getDateChanged());
		}
	}
	
	@Test
	public void addEmployee() {
		LocalDate date = LocalDate.now();
		Employee emp = new Employee("test fullname", "MALE", 28, "Married", "education", "123, test addr, address 123", "new state", "country", "012-3948571", "testmail@company.com", 
				date, null, "newaccname123", "Production", "Khor Ming Guan", "Production Technician I");
		Integer stat = employeeService.addEmployee(emp);
		System.out.println("status: " + stat);
	}
	
	@Test
	public void updateEmployee() {
		Employee emp = new Employee(125424, "new fullname 123", "MALE", 29, "MARRIED", "new education", "123, 456 address, 1234 addr", "Kedah", "Malaysia", "017-6059481", "newmail1234@company.com");
		Integer stat = employeeService.updateEmployee(emp);
		System.out.println("status: " + stat);
	}
	
	@Test
	public void updateQuitDate() {
		LocalDate date = LocalDate.of(2022, 04, 21);
		Integer stat = employeeService.updateQuitDate("new fullname 123", date);
		System.out.println("status: " + stat);
	}
	
	@Test
	public void updateTitle() {
		Integer stat = employeeService.updateEmployeeTitle("new fullname 123", "Production Technician II");
		System.out.println("status: " + stat);
	}
	
	@Test
	public void delete() {
		Integer stat = employeeService.deleteEmployee(125421);
		System.out.println("status: " + stat);
	}
}
