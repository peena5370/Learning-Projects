package v2.com.company.payroll.dao;

import java.io.IOException;
import java.util.List;

import v2.com.company.payroll.model.TrainingModel;

public interface TrainingDao {
	
	/**
	 * @return	List<Training>
	 * */
	List<TrainingModel> getListByManager() throws IOException;
	
	/**
	 * @param	name Employee name
	 * @return	List<Training>
	 * */
	List<TrainingModel> getListByEmployee(String name) throws IOException;
	
	/**
	 * @param	training
	 * @return	Boolean
	 * */
	Boolean insertTraining(TrainingModel training) throws IOException;
	
	/**
	 * @param	training
	 * @return	Boolean
	 * */
	Boolean updateStatusByEmployee(TrainingModel training) throws IOException;
}
