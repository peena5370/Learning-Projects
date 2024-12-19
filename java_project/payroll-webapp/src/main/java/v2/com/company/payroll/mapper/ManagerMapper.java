package v2.com.company.payroll.mapper;

import java.time.LocalDate;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import v2.com.company.payroll.model.Manager;

@Repository
public interface ManagerMapper {
	List<Manager> getManagerList();
	
	Manager getManagerById(@Param(value="account_id") int id);
	
	Manager getManagerInfo(@Param(value="id") int id);
	
	List<Manager> getManagerAccountInfo();
	
	Integer addManager(Manager manager);
	
	Integer updateManager(Manager manager);
	
	Integer updateManagerQuitDate(@Param(value="dateQuit") LocalDate dateQuit, 
								  @Param(value="fullname") String fullname);
	
	Integer updateManagerTitle(@Param(value="title") String title, 
							   @Param(value="fullname") String fullname);
	
	Integer deleteManager(@Param(value="id") int id);
}
