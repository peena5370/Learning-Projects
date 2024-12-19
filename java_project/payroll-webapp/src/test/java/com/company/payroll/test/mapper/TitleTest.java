package com.company.payroll.test.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import v2.com.company.payroll.model.Title;
import v2.com.company.payroll.service.TitleService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="/spring/spring-mybatis.xml")
public class TitleTest {
	@Autowired
	private TitleService titleService;
	
	@Test
	public void getList() {
		List<Title> list = titleService.queryTitleList();
		
		for(Title title : list) {
			System.out.printf("id: %s\ttitle: %s\n", title.getId(), title.getTitleName());
		}
	}
	
	@Test
	public void getTitle() {
		String title = titleService.queryTitleName(1029);
		
		System.out.println("title: " + title);
	}
	
	@Test
	public void add() {
		Integer stat = titleService.addNewTitle("New Title Name IV");
		System.out.println("status: " + stat);
	}
	
	@Test
	public void update() {
		Title title = new Title(1035, "New Title Name III");
		
		Integer stat = titleService.editTitle(title);
		System.out.println("status: " + stat);
	}
	
	@Test
	public void delete() {
		Integer stat = titleService.deleteTitle(1036);
		System.out.println("status: " + stat);
	}
}
