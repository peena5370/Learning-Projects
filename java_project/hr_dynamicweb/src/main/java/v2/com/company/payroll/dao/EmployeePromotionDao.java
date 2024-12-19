package v2.com.company.payroll.dao;

import java.io.IOException;
import java.util.List;

import v2.com.company.payroll.model.EmployeePromotionModel;

public interface EmployeePromotionDao {
	
	/**
	 * @return List<EmployeePromotion>
	 * */
	List<EmployeePromotionModel> getAllPromotion() throws IOException;
	
	/**
	 * @param	id
	 * @return	EmployeePromotion
	 * */
	EmployeePromotionModel getPromotionById(int id) throws IOException;
	
	/**
	 * @param	promotion
	 * @return	Boolean
	 * */
	Boolean insertPromotion(EmployeePromotionModel promotion) throws IOException;
	
	/**
	 * @param	promotion
	 * @return	Boolean
	 * */
	Boolean editPromotion(EmployeePromotionModel promotion) throws IOException;
}
