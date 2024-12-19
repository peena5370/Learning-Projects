package v2.com.company.payroll.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import v2.com.company.payroll.model.Training;

@Repository
public interface TrainingMapper {

	List<Training> getTrainingListByManager();
	
	List<Training> getTrainingListByEmployee(@Param(value="employeeName") String fullname);
	
	Integer insertTraining(Training training);
	
	Integer updateStatusByEmployee(Training training);
}
