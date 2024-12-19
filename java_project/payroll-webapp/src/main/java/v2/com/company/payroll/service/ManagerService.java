package v2.com.company.payroll.service;

import java.time.LocalDate;
import java.util.List;

import v2.com.company.payroll.model.Manager;

public interface ManagerService {
	List<Manager> queryManagerList();
	
	Manager queryInfoByAccountId(int id);
	
	Manager queryInfoById(int id);
	
	List<Manager> queryAccountInfo();
	
	Integer addManager(Manager manager);
	
	Integer updateManager(Manager manager);
	
	Integer updateQuitDate(LocalDate dateQuit, String fullname);
	
	Integer updateTitle(String title, String fullname);
	
	Integer deleteManager(int id);
}
