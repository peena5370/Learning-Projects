package v2.com.company.payroll.service;

import java.util.List;

import v2.com.company.payroll.model.Title;

public interface TitleService {
	List<Title> queryTitleList();
	
	String queryTitleName(int id);
	
	Integer addNewTitle(String titleName);
	
	Integer editTitle(Title title);
	
	Integer deleteTitle(int id);
}
