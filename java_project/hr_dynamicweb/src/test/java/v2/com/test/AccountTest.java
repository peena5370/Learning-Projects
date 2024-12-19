package v2.com.test;

import java.io.IOException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;


import v2.com.company.payroll.dao.AccountDao;
import v2.com.company.payroll.dao.EmployeeDao;
import v2.com.company.payroll.dao.impl.AccountDaoImpl;
import v2.com.company.payroll.dao.impl.EmployeeDaoImpl;
import v2.com.company.payroll.model.EmployeeModel;
import v2.com.company.payroll.model.AccountModel;

public class AccountTest {
	private static final Logger log = LogManager.getLogger(AccountTest.class);

	
	@Test
	public void getAccountList() {
//		New date time formatter
//		LocalDate now = LocalDate.now();
//		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//		String formattedDate = now.format(formatter);
//		LocalDate parsedDate = LocalDate.parse(formattedDate, formatter);
		log.info("info message");
		log.error("error message");
		
		AccountDao dao = new AccountDaoImpl();
		List<AccountModel> model = dao.getAllAccount();
		for(AccountModel acc : model) {
			System.out.printf("id: %d\tname: %s\thash: %s\tkey: %s\n", acc.getId(), acc.getUsername(), acc.getPassword(), acc.getKey());
		}
	}

	@Test
	public void getEmployeeList() throws IOException {
		EmployeeDao dao = new EmployeeDaoImpl();
		List<EmployeeModel> list = dao.listAllEmployee();
		
		for(EmployeeModel emp : list) {
			System.out.printf("id: %d\tname: %s\tgender: %s\tage: %d\tmartial: %s\teducation: %s\taddress: %s\tstate: %s\tcountry: %s\tphone: %s\temail: %s\thired: %s\tquit: %s\tdepartment: %s\ttitle: %s\thirer: %s\n", 
					emp.getId(), emp.getFullname(), emp.getGender(), emp.getAge(), emp.getMartialStatus(), emp.getEducation(), emp.getAddress(), emp.getState(), emp.getCountry(), emp.getPhone(),
					emp.getEmail(), emp.getDateHired(), emp.getDateQuit(), emp.getDepartment(), emp.getTitle(), emp.getHirer());
		}
	}
}
