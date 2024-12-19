package v2.com.company.payroll.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import v2.com.company.payroll.mapper.ResignationMapper;
import v2.com.company.payroll.model.Resignation;
import v2.com.company.payroll.service.ResignationService;

@Service
public class ResignationServiceImpl implements ResignationService {
	
	@Autowired
	private ResignationMapper resignationMapper;

	@Override
	public List<Resignation> queryResignList() {
		return resignationMapper.getResignationList();
	}

	@Override
	public Integer insertResignInfo(Resignation resign) {
		return resignationMapper.insertResignation(resign);
	}

}
