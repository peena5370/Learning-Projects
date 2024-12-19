package v2.com.company.payroll.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import v2.com.company.payroll.mapper.TrainingMapper;
import v2.com.company.payroll.model.Training;
import v2.com.company.payroll.service.TrainingService;

@Service
public class TrainingServiceImpl implements TrainingService {
	
	@Autowired
	private TrainingMapper trainingMapper;

	@Override
	public List<Training> queryListByManager() {
		return trainingMapper.getTrainingListByManager();
	}

	@Override
	public List<Training> queryListByEmployee(String fullname) {
		return trainingMapper.getTrainingListByEmployee(fullname);
	}

	@Override
	public Integer addTrainingInfo(Training training) {
		return trainingMapper.insertTraining(training);
	}

	@Override
	public Integer updateTrainingStatus(Training training) {
		return trainingMapper.updateStatusByEmployee(training);
	}

}
