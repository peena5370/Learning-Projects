package com.company.payroll.test.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import v2.com.company.payroll.model.Training;
import v2.com.company.payroll.service.TrainingService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="/spring/spring-mybatis.xml")
public class TrainingTest {
	
	@Autowired
	private TrainingService trainingService;
	
	@Test
	public void getList() {
		List<Training> list = trainingService.queryListByManager();
		
		for(Training training : list) {
			System.out.printf("id: %d\tinfo: %s\tstart: %s\tend: %s\tstatus: %s\tname: %s\tissuer: %s\n", training.getId(), training.getInfo(), training.getStartDate(), training.getEndDate(), 
							  training.getStatus(), training.getEmployeeName(), training.getIssuer());
		}
	}
	
	@Test
	public void getListByEmployee() {
		List<Training> list = trainingService.queryListByEmployee("Tan Min Lee");
		
		for(Training training : list) {
			System.out.printf("id: %d\tinfo: %s\tstart: %s\tend: %s\tstatus: %s\tissuer: %s\n", training.getId(), training.getInfo(), training.getStartDate(), training.getEndDate(), 
							  training.getStatus(), training.getIssuer());
		}
	}
	
	@Test
	public void add() {
		Training training = new Training("new training info", "2022-04-18 08:00:00", "2022-04-20 16:00:00", "PENDING", "Tan Min Lee", "Khor Ming Guan");
		
		Integer stat = trainingService.addTrainingInfo(training);
		System.out.println("status: " + stat);
	}
	
	@Test
	public void update() {
		Training training = new Training(7, "COMPLETED", "Tan Min Lee");
		
		Integer stat = trainingService.updateTrainingStatus(training);
		System.out.println("status: " + stat);
	}

}
