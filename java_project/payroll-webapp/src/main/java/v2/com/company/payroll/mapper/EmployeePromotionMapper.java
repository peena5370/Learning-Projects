package v2.com.company.payroll.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import v2.com.company.payroll.model.EmployeePromotion;

@Repository
public interface EmployeePromotionMapper {
	/**
	 * @return Detailed list of employee promotion
	 * */
	List<EmployeePromotion> getAllPromotion();
	
	/**
	 * @param	id	Promotion id
	 * @return	Detailed list of employee promotion based on promotion id
	 * */
	EmployeePromotion getPromotionById(@Param(value="id") int id);
	
	/**
	 * @param	promotion	EmployeePromotion model
	 * @return	Integer status
	 * */
	Integer insertPromotion(EmployeePromotion promotion);
	
	/**
	 * @param	promotion	EmployeePromotion model
	 * @return	Integer status
	 * */
	Integer editPromotion(EmployeePromotion promotion);
}
