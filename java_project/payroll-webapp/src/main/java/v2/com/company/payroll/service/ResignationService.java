package v2.com.company.payroll.service;

import java.util.List;

import v2.com.company.payroll.model.Resignation;

public interface ResignationService {

	List<Resignation> queryResignList();
	
	Integer insertResignInfo(Resignation resign);
}
