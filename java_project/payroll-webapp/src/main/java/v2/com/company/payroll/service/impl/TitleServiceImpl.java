package v2.com.company.payroll.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import v2.com.company.payroll.mapper.TitleMapper;
import v2.com.company.payroll.model.Title;
import v2.com.company.payroll.service.TitleService;

@Service
public class TitleServiceImpl implements TitleService {
	
	@Autowired
	private TitleMapper titleMapper;

	@Override
	public List<Title> queryTitleList() {
		return titleMapper.getTitleList();
	}

	@Override
	public String queryTitleName(int id) {
		return titleMapper.getTitleById(id);
	}

	@Override
	public Integer addNewTitle(String titleName) {
		return titleMapper.addTitle(titleName);
	}

	@Override
	public Integer editTitle(Title title) {
		return titleMapper.updateTitle(title);
	}

	@Override
	public Integer deleteTitle(int id) {
		return titleMapper.deleteTitle(id);
	}

}
