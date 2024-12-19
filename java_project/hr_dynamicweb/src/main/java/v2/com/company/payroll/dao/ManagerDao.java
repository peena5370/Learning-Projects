package v2.com.company.payroll.dao;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import v2.com.company.payroll.model.ManagerModel;

public interface ManagerDao {

	/**
	 * @return	List<Manager>
	 * */
	List<ManagerModel> getAllManagerList() throws IOException;
	
	/**
	 * @param	account_id
	 * @return	Manager
	 * */
	ManagerModel getManagerById(int id) throws IOException;
	
	/**
	 * @param	manager_id
	 * @return	Manager
	 * */
	ManagerModel getManagerByManagerId(int id) throws IOException;
	
	/**
	 * @return	List<Manager>
	 * */
	List<ManagerModel> getManagerAccountInfo() throws IOException;
	
	/**
	 * @param	manager
	 * @return	Boolean
	 * */
	Boolean addManager(ManagerModel manager) throws IOException;
	
	/**
	 * @param	manager
	 * @return	Boolean
	 * */
	Boolean updateManager(ManagerModel manager) throws IOException;
	
	/**
	 * @param	fullname, dateQuit
	 * @return	Boolean
	 * */
	Boolean updateManagerQuitDate(String fullname, LocalDate dateQuit) throws IOException;
	
	/**
	 * @param	fullname, title
	 * @return	Boolean
	 * */
	Boolean updateTitle(String fullname, String title) throws IOException;
	
	/**
	 * @param	id
	 * @return	Boolean
	 * */
	Boolean deleteManager(int id) throws IOException;
}
