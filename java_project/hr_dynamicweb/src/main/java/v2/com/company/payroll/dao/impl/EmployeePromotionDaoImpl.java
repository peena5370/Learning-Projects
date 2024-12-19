package v2.com.company.payroll.dao.impl;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import v2.com.company.payroll.dao.EmployeePromotionDao;
import v2.com.company.payroll.model.EmployeePromotionModel;
import v2.com.company.payroll.services.Database;

public class EmployeePromotionDaoImpl implements EmployeePromotionDao {

	@Override
	public List<EmployeePromotionModel> getAllPromotion() throws IOException {
		SqlSession ss = Database.openSession();
		List<EmployeePromotionModel> promotion_list = ss.selectList("getAllPromotion");
		Database.closeSession();
		
		return promotion_list;
	}
	
	@Override
	public EmployeePromotionModel getPromotionById(int id) throws IOException {
		SqlSession ss = Database.openSession();
		EmployeePromotionModel promotion = ss.selectOne("getPromotionById", id);
		Database.closeSession();
		
		return promotion;
	}

	@Override
	public Boolean insertPromotion(EmployeePromotionModel promotion) throws IOException {
		Boolean bool = false;
		
		SqlSession ss = Database.openSession();
		int status = ss.insert("insertPromotion", promotion);
		if(status > 0) {
			bool = true;
		} else {
			bool = false;
		}
		Database.closeSession();
		
		return bool;
	}

	@Override
	public Boolean editPromotion(EmployeePromotionModel promotion) throws IOException {
		Boolean bool = false;
		
		SqlSession ss = Database.openSession();
		int status = ss.update("editPromotion", promotion);
		if(status > 0) {
			bool = true;
		} else {
			bool = false;
		}
		Database.closeSession();
		
		return bool;
	}

}
