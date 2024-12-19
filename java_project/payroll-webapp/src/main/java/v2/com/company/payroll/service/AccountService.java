package v2.com.company.payroll.service;

import java.util.List;

import v2.com.company.payroll.model.Account;

public interface AccountService {
	List<Account> queryUserAccount();
	
	Account queryPasswordKey(String username);
	
	Integer insertAccount(Account account);
	
	Integer updatePassword(String username, String password, String key, String date);
	
	Integer deleteAccount(String username);
}
