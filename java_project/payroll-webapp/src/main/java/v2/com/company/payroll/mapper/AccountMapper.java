package v2.com.company.payroll.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import v2.com.company.payroll.model.Account;

@Repository
public interface AccountMapper {
	/**
	 * @return	List of accounts available inside database
	 * */
	List<Account> getAllAccount();
	
	/**
	 * @param	username Account username
	 * @return	Account model, which consists of id, password and key
	 * */
	Account getPasswordKey(String username);
	
	/**
	 * @param	account	Account model
	 * @return	Integer
	 * */
	Integer addAccount(Account account);
	
	/**
	 * @param	username	Account username
	 * @param	password	Password string
	 * @param	key			Password key
	 * @param	date		Date change password
	 * @return	Integer
	 * */
	Integer changePassword(@Param(value="username") String username, 
						   @Param(value="password") String password, 
						   @Param(value="key") String key, 
						   @Param(value="dateChanged") String date);
	
	/**
	 * @param	username Account username
	 * @return	Integer
	 * */
	Integer deleteAccount(String username);
}
