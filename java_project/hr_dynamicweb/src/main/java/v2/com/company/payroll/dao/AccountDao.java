package v2.com.company.payroll.dao;

import java.util.List;

import v2.com.company.payroll.model.AccountModel;

public interface AccountDao {
	
	/**
	 * @return	List<Account>
	 * */
	List<AccountModel> getAllAccount();
	
	/**
	 * @param	username
	 * @return	Account
	 * */
	AccountModel getPasswordKey(String username);
	
	/**
	 * @param	account
	 * @return	Boolean
	 * */
	Boolean addNewAccount(AccountModel account);
	
	/**
	 * @param	username, password, key, date
	 * @return	Boolean
	 * */
	Boolean changePassword(String username, String password, String key, String date);
	
	/**
	 * @param	username
	 * @return	Boolean
	 * */
	Boolean deleteAccount(String username);
}
