package v2.com.company.payroll.dao.impl;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import v2.com.company.payroll.dao.DepartmentDao;
import v2.com.company.payroll.model.DepartmentModel;
import v2.com.company.payroll.services.Database;

public class DepartmentDaoImpl implements DepartmentDao {

	public List<DepartmentModel> getAllDepartment() throws IOException {
		SqlSession ss = Database.openSession();
		List<DepartmentModel> dept_list = ss.selectList("getAllDepartment");
		Database.closeSession();
		
		return dept_list;
	}
	
	public List<DepartmentModel> getDepartmentIdAndName() throws IOException {
		SqlSession ss = Database.openSession();
		List<DepartmentModel> dept_list = ss.selectList("getIdAndName");
		Database.closeSession();
		
		return dept_list;
	}
	
	public String getDepartmentName(int id) throws IOException {
		SqlSession ss = Database.openSession();
		DepartmentModel dept =  ss.selectOne("getDepartmentById", id);
		Database.closeSession();
		
		return dept.getDepartmentName();
	}
	
	public Boolean addNewDepartment(DepartmentModel department) throws IOException {
		Boolean bool = false;
		
		SqlSession ss = Database.openSession();
		int status = ss.insert("addDepartment", department);
		if(status > 0) {
			bool = true;
		} else {
			bool = false;
		}
		Database.closeSession();
		
		return bool;
	}
	
	public Boolean updateDepartment(DepartmentModel department) throws IOException {
		Boolean bool = false;
		
		SqlSession ss = Database.openSession();
		int status = ss.update("updateDepartment", department);
		if(status > 0) {
			bool = true;
		} else {
			bool = false;
		}
		Database.closeSession();
		
		return bool;
	}
	
	public Boolean deleteDepartment(int id) throws IOException {
		Boolean bool = false;
		
		SqlSession ss = Database.openSession();
		int status = ss.delete("deleteDepartment", id);
		if(status > 0) {
			bool = true;
		} else {
			bool = false;
		}
		Database.closeSession();
		
		return bool;
	}
}
