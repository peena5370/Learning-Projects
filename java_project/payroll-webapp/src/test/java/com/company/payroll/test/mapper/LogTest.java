package com.company.payroll.test.mapper;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.context.WebApplicationContext;

import v2.com.company.payroll.model.Account;
import v2.com.company.payroll.service.AccountService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="/spring/spring-mybatis.xml")
public class LogTest {
	private static final Logger log = LogManager.getLogger(LogTest.class);
	
	@Autowired
	private AccountService accountService;
	
	@Test
	public void log() {
		log.info("info message");
		log.error("error message");
	}
	
	@Test
	public void testWeb() {
		WebApplicationContext ac = (WebApplicationContext) new ClassPathXmlApplicationContext("spring/spring-mvc.xml");
		System.out.println("path: " + ac.hashCode());
	}
	
	@Test
	public void getAccountList() {
//		AccountDao dao = new AccountDaoImpl();
//		ApplicationContext ac = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
//		System.out.println("path: " + ac.hashCode());
//		AccountService am = ac.getBean(AccountService.class);
		List<Account> model = accountService.queryUserAccount();
		for(Account acc : model) {
			System.out.printf("id: %d\tname: %s\thash: %s\tkey: %s\tcreate: %s\tchange: %s\n", acc.getId(), acc.getUsername(), acc.getPassword(), acc.getKey(), acc.getDateCreated(), acc.getDateChanged());
		}
	}
	
	@Test
	public void getPasswordKey() {
		Account acc = accountService.queryPasswordKey("uname123");
		System.out.println("id: " + acc.getId() + "\tpass: " + acc.getPassword() + "\tkey: " + acc.getKey());
	}
	
	@Test
	public void add() {
		Account acc = new Account("newmanager123", "asdpass123=", "key1234123", "2022-04-18 08:00:00");
		Integer stat = accountService.insertAccount(acc);
		System.out.println("status: " + stat);
	}
	
	@Test
	public void update() {
		Integer stat = accountService.updatePassword("newaccname123", "sdfpassasd45678=", "asdkey456789", "2022-04-09 17:00:00");
		System.out.println("status: " + stat);
	}
	
	@Test
	public void delete() {
		Integer stat = accountService.deleteAccount("name");
		System.out.println("status: " + stat);
	}
}
