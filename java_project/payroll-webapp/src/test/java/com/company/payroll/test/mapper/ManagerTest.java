package com.company.payroll.test.mapper;

import java.time.LocalDate;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import v2.com.company.payroll.model.Manager;
import v2.com.company.payroll.service.ManagerService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="/spring/spring-mybatis.xml")
public class ManagerTest {
	
	@Autowired
	private ManagerService managerService;
	
	@Test
	public void getList() {
		List<Manager> list = managerService.queryManagerList();
		
		for(Manager manager : list) {
			System.out.printf("id: %d\tname: %s\trole: %s\tgender: %s\tage: %d\tmartial: %s\teducation: %s\taddress: %s\tstate: %s\tcountry: %s\tphone: %s\temail: %s\thired: %s\tquit: %s\ttitle: %s\tdept: %s\n", 
					          manager.getId(), manager.getFullname(), manager.getRole(), manager.getGender(), manager.getAge(), manager.getMartialStatus(), manager.getEducation(), manager.getAddress(), 
					          manager.getState(), manager.getCountry(), manager.getPhone(), manager.getEmail(), manager.getDateHired(), manager.getDateQuit(), manager.getTitle(), manager.getDepartment());
		}
	}
	
	@Test
	public void getInfoByAccount() {
		Manager manager = managerService.queryInfoByAccountId(2);
		
		System.out.printf("id: %d\tname: %s\trole: %s\tgender: %s\tage: %d\tmartial: %s\teducation: %s\taddress: %s\tstate: %s\tcountry: %s\tphone: %s\temail: %s\thired: %s\tquit: %s\ttitle: %s\tdept: %s", 
		          manager.getId(), manager.getFullname(), manager.getRole(), manager.getGender(), manager.getAge(), manager.getMartialStatus(), manager.getEducation(), manager.getAddress(), 
		          manager.getState(), manager.getCountry(), manager.getPhone(), manager.getEmail(), manager.getDateHired(), manager.getDateQuit(), manager.getTitle(), manager.getDepartment());
	}
	
	@Test
	public void getInfoById() {
		Manager manager = managerService.queryInfoById(3353);
		
		System.out.printf("id: %d\tname: %s\trole: %s\tgender: %s\tage: %d\tmartial: %s\teducation: %s\taddress: %s\tstate: %s\tcountry: %s\tphone: %s\temail: %s\thired: %s\tquit: %s\ttitle: %s\tdept: %s", 
		          manager.getId(), manager.getFullname(), manager.getRole(), manager.getGender(), manager.getAge(), manager.getMartialStatus(), manager.getEducation(), manager.getAddress(), 
		          manager.getState(), manager.getCountry(), manager.getPhone(), manager.getEmail(), manager.getDateHired(), manager.getDateQuit(), manager.getTitle(), manager.getDepartment());
	}
	
	@Test
	public void getAccountInfo() {
		List<Manager> list = managerService.queryAccountInfo();
		
		for(Manager manager : list) {
			System.out.printf("aid: %s\tusername: %s\tmid: %d\tname: %s\tcreated: %s\tchanged: %s\n", manager.getAccount_id(), manager.getUsername(), manager.getId(), manager.getFullname(), 
								manager.getDateCreated(), manager.getDateChanged());
		}
	}
	
	@Test
	public void add() {
		LocalDate date = LocalDate.of(2022, 04, 18);
		Manager manager = new Manager("new fullname", "Manager", "MALE", 38, "MARRIED", "Degree", "new addr, 1234 address new", "Kedah", "Malaysia", "012-6059681", 
									  "testmail1234@company.com", date, null, "newmanager123", "Facility", "Asistant Facility Manager");
		
		Integer stat = managerService.addManager(manager);
		System.out.println("status: " + stat);
	}
	
	@Test 
	public void update() {
		Manager manager = new Manager(3357, "new fullname 1234", "MALE", 38, "MARRIED", "Degree", "11223 addr, 12345 new address", "Perlis", "Malaysia", "017-5069481", "newmail2234@company.com");
		
		Integer stat = managerService.updateManager(manager);
		System.out.println("status: " + stat);
	}
	
	@Test
	public void udpateQuitDate() {
		LocalDate date = LocalDate.of(2022, 04, 20);
		Integer stat = managerService.updateQuitDate(date, "new fullname 1234");
		
		System.out.println("status: " + stat);
	}
	
	@Test
	public void updateTitle() {
		Integer stat = managerService.updateTitle("Facility Manager", "new fullname 1234");
		
		System.out.println("status: " + stat);
	}
	
	@Test
	public void delete() {
		Integer stat = managerService.deleteManager(3357);
		
		System.out.println("status: " + stat);
	}
}
