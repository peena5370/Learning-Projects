package v2.com.company.payroll.dao.impl;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import v2.com.company.payroll.dao.PayRollDao;
import v2.com.company.payroll.model.PayRollModel;
import v2.com.company.payroll.services.Database;

public class PayRollDaoImpl implements PayRollDao {

	@Override
	public List<PayRollModel> getListByManager() throws IOException {
		SqlSession ss = Database.openSession();
		List<PayRollModel> payroll_list = ss.selectList("getPayRollListByManager");
		Database.closeSession();
		
		return payroll_list;
	}

	@Override
	public List<PayRollModel> getListByEmployee(String name) throws IOException {
		SqlSession ss = Database.openSession();
		List<PayRollModel> payroll_list = ss.selectList("getPayRollListByEmployee", name);
		Database.closeSession();
		
		return payroll_list;
	}

	@Override
	public Boolean issuePayroll(PayRollModel payroll) throws IOException {
		Boolean bool = false;
		
		SqlSession ss = Database.openSession();
		int status = ss.insert("insertPayroll", payroll);
		if(status > 0) {
			bool = true;
		} else {
			bool = false;
		}
		Database.closeSession();
		
		return bool;
	}
}
