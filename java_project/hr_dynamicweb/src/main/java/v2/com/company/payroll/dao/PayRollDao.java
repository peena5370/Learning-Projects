package v2.com.company.payroll.dao;

import java.io.IOException;
import java.util.List;

import v2.com.company.payroll.model.PayRollModel;

public interface PayRollDao {
	
	/**
	 * @return	List<PayRoll>
	 * */
	List<PayRollModel> getListByManager() throws IOException;
	
	/**
	 * @param	name Employee name
	 * @return	List<PayRoll>
	 * */
	List<PayRollModel> getListByEmployee(String name) throws IOException;
	
	/**
	 * @param	payroll
	 * @return	Boolean
	 * */
	Boolean issuePayroll(PayRollModel payroll) throws IOException;
}
