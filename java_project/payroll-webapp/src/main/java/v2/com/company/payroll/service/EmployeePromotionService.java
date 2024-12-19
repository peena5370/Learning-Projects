package v2.com.company.payroll.service;

import java.util.List;

import v2.com.company.payroll.model.EmployeePromotion;

public interface EmployeePromotionService {
	List<EmployeePromotion> queryPromotionList();
	
	EmployeePromotion queryPromotionById(int id);
	
	Integer addPromotion(EmployeePromotion promotion);
	
	Integer editPromotion(EmployeePromotion promotion);
}
