package v2.com.company.payroll.dao.impl;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import v2.com.company.payroll.dao.TitleDao;
import v2.com.company.payroll.model.TitleModel;
import v2.com.company.payroll.services.Database;

public class TitleDaoImpl implements TitleDao {

	public List<TitleModel> getAllTitleList() throws IOException {
		SqlSession ss = Database.openSession();
		List<TitleModel> title_list = ss.selectList("getAllTitle");
		Database.closeSession();
		
		return title_list;
	}

	public String getTitleNameById(int id) throws IOException {
		SqlSession ss = Database.openSession();
		TitleModel title = ss.selectOne("getTitleById", id);
		Database.closeSession();
		
		return title.getTitleName();
	}
	
	public Boolean addNewTitle(String titleName) throws IOException {
		Boolean bool = false;

		SqlSession ss = Database.openSession();
		TitleModel title = new TitleModel();
		title.setTitleName(titleName);
		int status = ss.insert("addTitle", title);
		if(status > 0) {
			bool = true;
		} else {
			bool = false;
		}
		Database.closeSession();
		
		return bool;
	}
	
	public Boolean updateTitleName(int id, String titleName) throws IOException {
		Boolean bool = false;
		
		SqlSession ss = Database.openSession();
		TitleModel title = new TitleModel(id, titleName);
		int status = ss.update("editTitle", title);
		if(status > 0) {
			bool = true;
		} else {
			bool = false;
		}
		Database.closeSession();
		
		return bool;
	}
	
	public Boolean deleteTitle(int id) throws IOException {
		Boolean bool = false;
		
		SqlSession ss = Database.openSession();
		int status = ss.delete("deleteTitleById", id);
		if(status > 0) {
			bool = true;
		} else {
			bool = false;
		}
		Database.closeSession();
		
		return bool;
	}
}
