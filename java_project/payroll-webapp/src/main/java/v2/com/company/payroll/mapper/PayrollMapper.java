package v2.com.company.payroll.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import v2.com.company.payroll.model.Payroll;

@Repository
public interface PayrollMapper {

	List<Payroll> getListByManager();
	
	List<Payroll> getListByEmployee(@Param(value="employeeName") String fullname);
	
	Integer insertPayroll(Payroll payroll);
}
