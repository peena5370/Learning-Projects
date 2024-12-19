package v2.com.company.payroll.dao;

import java.io.IOException;
import java.util.List;

import v2.com.company.payroll.model.ResignationModel;

public interface ResignationDao {
	
	/**
	 * @return	List<Resignation>
	 * */
	List<ResignationModel> getResignationList() throws IOException;
	
	/**
	 * @param	resignation
	 * @return	Boolean
	 * */
	Boolean insertResignation(ResignationModel resignation) throws IOException;
}
