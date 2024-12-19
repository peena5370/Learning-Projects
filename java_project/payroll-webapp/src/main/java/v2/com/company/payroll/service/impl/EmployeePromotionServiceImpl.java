package v2.com.company.payroll.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import v2.com.company.payroll.mapper.EmployeePromotionMapper;
import v2.com.company.payroll.model.EmployeePromotion;
import v2.com.company.payroll.service.EmployeePromotionService;

@Service
public class EmployeePromotionServiceImpl implements EmployeePromotionService {

	@Autowired
	private EmployeePromotionMapper employeePromotionMapper;
	
	@Override
	public List<EmployeePromotion> queryPromotionList() {
		return employeePromotionMapper.getAllPromotion();
	}

	@Override
	public EmployeePromotion queryPromotionById(int id) {
		return employeePromotionMapper.getPromotionById(id);
	}

	@Override
	public Integer addPromotion(EmployeePromotion promotion) {
		return employeePromotionMapper.insertPromotion(promotion);
	}

	@Override
	public Integer editPromotion(EmployeePromotion promotion) {
		return employeePromotionMapper.editPromotion(promotion);
	}

}
