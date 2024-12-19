package v2.com.company.payroll.dao;

import java.io.IOException;
import java.util.List;

import v2.com.company.payroll.model.TitleModel;

public interface TitleDao {
	
	/**
	 * @return	List<Title>
	 * */
	List<TitleModel> getAllTitleList() throws IOException;
	
	/**
	 * @param	id
	 * @return	titleName
	 * */
	String getTitleNameById(int id) throws IOException;
	
	/**
	 * @param	titleName
	 * @return	Boolean
	 * */
	Boolean addNewTitle(String titleName) throws IOException;
	
	/**
	 * @param	id, titleName
	 * @return	Boolean
	 * */
	Boolean updateTitleName(int id, String titleName) throws IOException;
	
	/**
	 * @param	id
	 * @return	Boolean
	 * */
	Boolean deleteTitle(int id) throws IOException;
}
