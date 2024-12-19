package v2.com.company.payroll.dao.impl;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import v2.com.company.payroll.dao.EmployeeSalaryDao;
import v2.com.company.payroll.model.EmployeeSalaryModel;
import v2.com.company.payroll.services.Database;

public class EmployeeSalaryDaoImpl implements EmployeeSalaryDao {

	@Override
	public List<EmployeeSalaryModel> getAllEmployeeSalary() throws IOException {
		SqlSession ss = Database.openSession();
		List<EmployeeSalaryModel> salary_list = ss.selectList("getAllEmployeeSalary");
		Database.closeSession();
		
		return salary_list;
	}

	@Override
	public EmployeeSalaryModel getSalaryByEmployeeName(String name) throws IOException {
		SqlSession ss = Database.openSession();
		EmployeeSalaryModel salary = ss.selectOne("getSalaryByEmployee", name);
		Database.closeSession();
		
		return salary;
	}
	@Override
	public Boolean insertEmployeeSalary(EmployeeSalaryModel salary) throws IOException {
		Boolean bool = false;
		
		SqlSession ss = Database.openSession();
		int status = ss.insert("insertEmployeeSalary", salary);
		if(status > 0) {
			bool = true;
		} else {
			bool = false;
		}
		Database.closeSession();
		
		return bool;
	}
	
	@Override
	public Boolean updateEmployeeSalary(EmployeeSalaryModel salary) throws IOException {
		Boolean bool = false;
		
		SqlSession ss = Database.openSession();
		int status = ss.update("updateEmployeeSalary", salary);
		if(status > 0) {
			bool = true;
		} else {
			bool = false;
		}
		Database.closeSession();
		
		return bool;
	}

}
