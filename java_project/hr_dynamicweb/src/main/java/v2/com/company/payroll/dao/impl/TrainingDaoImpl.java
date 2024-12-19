package v2.com.company.payroll.dao.impl;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import v2.com.company.payroll.dao.TrainingDao;
import v2.com.company.payroll.model.TrainingModel;
import v2.com.company.payroll.services.Database;

public class TrainingDaoImpl implements TrainingDao {

	@Override
	public List<TrainingModel> getListByManager() throws IOException {
		SqlSession ss = Database.openSession();
		List<TrainingModel> training_list = ss.selectList("getTrainingListByManager");
		Database.closeSession();
		
		return training_list;
	}

	@Override
	public List<TrainingModel> getListByEmployee(String name) throws IOException {
		SqlSession ss = Database.openSession();
		List<TrainingModel> training_list = ss.selectList("getTrainingListByEmployee", name);
		Database.closeSession();
		
		return training_list;
	}

	@Override
	public Boolean insertTraining(TrainingModel training) throws IOException {
		Boolean bool = false;
		
		SqlSession ss = Database.openSession();
		int status = ss.insert("insertTraining", training);
		if(status > 0) {
			bool = true;
		} else {
			bool = false;
		}
		Database.closeSession();
		
		return bool;
	}

	@Override
	public Boolean updateStatusByEmployee(TrainingModel training) throws IOException {
Boolean bool = false;
		
		SqlSession ss = Database.openSession();
		int status = ss.update("updateStatusByEmployee", training);
		if(status > 0) {
			bool = true;
		} else {
			bool = false;
		}
		Database.closeSession();
		
		return bool;
	}

}
