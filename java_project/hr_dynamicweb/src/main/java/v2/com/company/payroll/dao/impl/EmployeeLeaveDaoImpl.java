package v2.com.company.payroll.dao.impl;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import v2.com.company.payroll.dao.EmployeeLeaveDao;
import v2.com.company.payroll.model.EmployeeLeaveModel;
import v2.com.company.payroll.services.Database;

public class EmployeeLeaveDaoImpl implements EmployeeLeaveDao {

	@Override
	public List<EmployeeLeaveModel> getLeaveList() throws IOException {
		SqlSession ss = Database.openSession();
		List<EmployeeLeaveModel> leave_list = ss.selectList("getLeaveList");
	    Database.closeSession();
	    
	    return leave_list;
	}

	@Override
	public List<EmployeeLeaveModel> getLeaveListByEmployee(String employeeName) throws IOException {
		SqlSession ss = Database.openSession();
		List<EmployeeLeaveModel> leave_list = ss.selectList("getLeaveListByEmployee", employeeName);
	    Database.closeSession();
	    
	    return leave_list;
	}

	@Override
	public Boolean insertLeave(EmployeeLeaveModel leave) throws IOException {
		Boolean bool = false;
		
		SqlSession ss = Database.openSession();
		int status = ss.insert("insertLeave", leave);
		if(status > 0) {
			bool = true;
		} else {
			bool = false;
		}
		Database.closeSession();
		
		return bool;
	}

	@Override
	public Boolean updateStatus(EmployeeLeaveModel leave) throws IOException {
		Boolean bool = false;
		
		SqlSession ss = Database.openSession();
		int status = ss.update("updateStatus", leave);
		if(status > 0) {
			bool = true;
		} else {
			bool = false;
		}
		Database.closeSession();
		
		return bool;
	}

}
