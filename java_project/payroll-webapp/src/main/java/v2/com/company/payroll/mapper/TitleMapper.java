package v2.com.company.payroll.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import v2.com.company.payroll.model.Title;

@Repository
public interface TitleMapper {
	List<Title> getTitleList();
	
	String getTitleById(@Param(value="id") int id);
	
	Integer addTitle(@Param(value="titleName") String titleName);
	
	Integer updateTitle(Title title);
	
	Integer deleteTitle(@Param(value="id") int id);
	
}
