package v2.com.company.payroll.dao.impl;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import v2.com.company.payroll.dao.ManagerDao;
import v2.com.company.payroll.model.ManagerModel;
import v2.com.company.payroll.services.Database;

public class ManagerDaoImpl implements ManagerDao {

	@Override
	public List<ManagerModel> getAllManagerList() throws IOException {
		SqlSession ss = Database.openSession();
		List<ManagerModel> manager_list = ss.selectList("getManagerList");
		Database.closeSession();
		
		return manager_list;
	}

	@Override
	public ManagerModel getManagerById(int id) throws IOException {
		SqlSession ss = Database.openSession();
		ManagerModel manager = ss.selectOne("getManagerById", id);
		Database.closeSession();
		
		return manager;
	}
	
	@Override
	public ManagerModel getManagerByManagerId(int id) throws IOException {
		SqlSession ss = Database.openSession();
		ManagerModel manager = ss.selectOne("getManagerByManagerId", id);
		Database.closeSession();
		
		return manager;
	}

	@Override
	public List<ManagerModel> getManagerAccountInfo() throws IOException {
		SqlSession ss = Database.openSession();
		List<ManagerModel> account_list = ss.selectList("getManagerAccountInfo");
		Database.closeSession();
		
		return account_list;
	}
	
	@Override
	public Boolean addManager(ManagerModel manager) throws IOException {
		Boolean bool = false;
		
		SqlSession ss = Database.openSession();
		int status = ss.insert("addManager", manager);
		if(status > 0) {
			bool = true;
		} else {
			bool = false;
		}
		Database.closeSession();
		
		return bool;
	}

	@Override
	public Boolean updateManager(ManagerModel manager) throws IOException {
		Boolean bool = false;
		
		SqlSession ss = Database.openSession();
		int status = ss.update("updateManager", manager);
		if(status > 0) {
			bool = true;
		} else {
			bool = false;
		}
		Database.closeSession();
		
		return bool;
	}

	@Override
	public Boolean updateManagerQuitDate(String fullname, LocalDate dateQuit) throws IOException {
		Boolean bool = false;
		
		SqlSession ss = Database.openSession();
		ManagerModel manager = new ManagerModel();
		manager.setFullname(fullname);
		manager.setDateQuit(dateQuit);
		int status = ss.update("updateQuitDate", manager);
		if(status > 0) {
			bool = true;
		} else {
			bool = false;
		}
		Database.closeSession();
		
		return bool;
	}

	@Override
	public Boolean updateTitle(String fullname, String title) throws IOException {
		Boolean bool = false;
		
		SqlSession ss = Database.openSession();
		ManagerModel manager = new ManagerModel();
		manager.setFullname(fullname);
		manager.setTitle(title);
		int status = ss.update("updateTitle", manager);
		if(status > 0) {
			bool = true;
		} else {
			bool = false;
		}
		Database.closeSession();
		
		return bool;
	}

	@Override
	public Boolean deleteManager(int id) throws IOException {
		Boolean bool = false;
		
		SqlSession ss = Database.openSession();
		int status = ss.delete("deleteManager", id);
		if(status > 0) {
			bool = true;
		} else {
			bool = false;
		}
		Database.closeSession();
		
		return bool;
	}

}
