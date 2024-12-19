package v2.com.company.payroll.dao.impl;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import v2.com.company.payroll.dao.ResignationDao;
import v2.com.company.payroll.model.ResignationModel;
import v2.com.company.payroll.services.Database;

public class ResignationDaoImpl implements ResignationDao {

	@Override
	public List<ResignationModel> getResignationList() throws IOException {
		SqlSession ss = Database.openSession();
		List<ResignationModel> resign_list = ss.selectList("getResignationList");
		Database.closeSession();
		
		return resign_list;
	}

	@Override
	public Boolean insertResignation(ResignationModel resignation) throws IOException {
		Boolean bool = false;
		
		SqlSession ss = Database.openSession();
		int status = ss.insert("insertResignation", resignation);
		if(status > 0) {
			bool = true;
		} else {
			bool = false;
		}
		Database.closeSession();
		
		return bool;
	}
}
