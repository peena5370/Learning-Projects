package v2.com.company.payroll.service;

import java.util.List;

import v2.com.company.payroll.model.Training;

public interface TrainingService {

	List<Training> queryListByManager();
	
	List<Training> queryListByEmployee(String fullname);
	
	Integer addTrainingInfo(Training training);
	
	Integer updateTrainingStatus(Training training);
}
