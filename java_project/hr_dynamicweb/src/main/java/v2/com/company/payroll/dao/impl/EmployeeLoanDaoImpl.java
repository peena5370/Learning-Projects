package v2.com.company.payroll.dao.impl;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import v2.com.company.payroll.dao.EmployeeLoanDao;
import v2.com.company.payroll.model.EmployeeLoanModel;
import v2.com.company.payroll.services.Database;

public class EmployeeLoanDaoImpl implements EmployeeLoanDao {

	@Override
	public List<EmployeeLoanModel> getLoanList() throws IOException {
		SqlSession ss = Database.openSession();
		List<EmployeeLoanModel> loan_list = ss.selectList("getLoanList");
		Database.closeSession();
		
		return loan_list;
	}

	@Override
	public List<EmployeeLoanModel> getLoanListByEmployee(String employeeName) throws IOException {
		SqlSession ss = Database.openSession();
		List<EmployeeLoanModel> loan_list = ss.selectList("getLoanListByEmployee", employeeName);
		Database.closeSession();
		
		return loan_list;
	}

	@Override
	public Boolean insertLoan(EmployeeLoanModel loan) throws IOException {
		Boolean bool = false;
		
		SqlSession ss = Database.openSession();
		int status = ss.insert("insertLoan", loan);
		if(status > 0) {
			bool = true;
		} else {
			bool = false;
		}
		Database.closeSession();
		
		return bool;
	}

	@Override
	public Boolean updateStatus(EmployeeLoanModel loan) throws IOException {
		Boolean bool = false;
		
		SqlSession ss = Database.openSession();
		int status = ss.update("updateLoanStatus", loan);
		if(status > 0) {
			bool = true;
		} else {
			bool = false;
		}
		Database.closeSession();
		
		return bool;
	}

}
