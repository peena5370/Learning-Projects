package v2.com.company.payroll.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import v2.com.company.payroll.model.Resignation;

@Repository
public interface ResignationMapper {

	List<Resignation> getResignationList();
	
	Integer insertResignation(Resignation resign);
}
