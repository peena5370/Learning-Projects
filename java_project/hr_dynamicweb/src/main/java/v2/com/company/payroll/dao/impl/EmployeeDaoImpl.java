package v2.com.company.payroll.dao.impl;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import v2.com.company.payroll.dao.EmployeeDao;
import v2.com.company.payroll.model.EmployeeModel;
import v2.com.company.payroll.services.Database;

public class EmployeeDaoImpl implements EmployeeDao {
	
	@Override
	public List<EmployeeModel> listAllEmployee() throws IOException {
		SqlSession ss = Database.openSession();
		List<EmployeeModel> employee_list = ss.selectList("getEmployeeList");
		Database.closeSession();
		
		return employee_list;
	}

	@Override
	public EmployeeModel getEmployeeById(int id) throws IOException {
		SqlSession ss = Database.openSession();
		EmployeeModel employee = ss.selectOne("getEmployeeById", id);
		Database.closeSession();
		
		return employee;
	}
	
	@Override
	public EmployeeModel getEmployeeByEmployeeId(int id) throws IOException {
		SqlSession ss = Database.openSession();
		EmployeeModel employee = ss.selectOne("getEmployeeByEmployeeId", id);
		Database.closeSession();
		
		return employee;
	}

	@Override
	public List<EmployeeModel> getEmployeeAccountInfo() throws IOException {
		SqlSession ss = Database.openSession();
		List<EmployeeModel> account_list = ss.selectList("getEmployeeAccountInfo");
		Database.closeSession();
		
		return account_list;
	}
	@Override
	public Boolean addEmployee(EmployeeModel employee) throws IOException {
		Boolean bool = false;
		
		SqlSession ss = Database.openSession();
		int status = ss.insert("addEmployee", employee);
		if(status > 0) {
			bool = true;
		} else {
			bool = false;
		}
		Database.closeSession();
		
		return bool;
	}

	@Override
	public Boolean updateEmployee(EmployeeModel employee) throws IOException {
		Boolean bool = false;
		
		SqlSession ss = Database.openSession();
		int status = ss.update("updateEmployee", employee);
		if(status > 0) {
			bool = true;
		} else {
			bool = false;
		}
		Database.closeSession();
		
		return bool;
	}

	@Override
	public Boolean updateEmployeeQuitDate(String fullname, LocalDate dateQuit) throws IOException {
		Boolean bool = false;
		
		SqlSession ss = Database.openSession();
		EmployeeModel employee = new EmployeeModel();
		employee.setFullname(fullname);
		employee.setDateQuit(dateQuit);
		int status = ss.update("updateEmployeeQuitDate", employee);
		if(status > 0) {
			bool = true;
		} else {
			bool = false;
		}
		Database.closeSession();
		
		return bool;
	}
	
	@Override
	public Boolean updateEmployeeTitle(String fullname, String title) throws IOException {
		Boolean bool = false;
		
		SqlSession ss = Database.openSession();
		EmployeeModel employee = new EmployeeModel();
		employee.setFullname(fullname);
		employee.setTitle(title);
		int status = ss.update("updateTitle", employee);
		if(status > 0) {
			bool = true;
		} else {
			bool = false;
		}
		Database.closeSession();
		
		return bool;
	}
	
	@Override
	public Boolean deleteEmployee(int id) throws IOException {
		Boolean bool = false;
		
		SqlSession ss = Database.openSession();
		int status = ss.delete("deleteEmployee", id);
		if(status > 0) {
			bool = true;
		} else {
			bool = false;
		}
		Database.closeSession();
		
		return bool;
	}


}
