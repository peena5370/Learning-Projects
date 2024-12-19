package v2.com.company.payroll.dao.impl;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import v2.com.company.payroll.dao.AccountDao;
import v2.com.company.payroll.model.AccountModel;
import v2.com.company.payroll.services.Database;

public class AccountDaoImpl implements AccountDao {
	private static final Logger log = LogManager.getLogger(AccountDaoImpl.class);
	
	@Override
	public List<AccountModel> getAllAccount() {
		List<AccountModel> account_list = null;

		try {
			SqlSession ss = Database.openSession();
		    account_list = ss.selectList("getAll");
		    Database.closeSession();
		} catch(IOException e) {
			e.printStackTrace();
			log.error("Get account error. cause: {}", e);
		}
	    
	    return account_list;
	}
	
	@Override
	public AccountModel getPasswordKey(String username){
		AccountModel account = null;
		try {
			SqlSession ss = Database.openSession();
			account = ss.selectOne("getPasswordKey", username);
			Database.closeSession();
		} catch(IOException e) {
			e.printStackTrace();
			log.error("Get password key error. Username: {}, cause: {}", username, e);
		}
		
		return account;	
	}
	
	@Override
	public Boolean addNewAccount(AccountModel account){
		Boolean bool = false;
		
		try {
			SqlSession ss = Database.openSession();
			int status = ss.insert("addAccount", account);
			if(status > 0) {
				bool = true;
			} else {
				bool = false;
			}
			Database.closeSession();
		} catch(IOException e) {
			e.printStackTrace();
			log.error("Add account error. Object: {}, cause: {}", account.hashCode(), e);
		}
		
		return bool;
	}
	
	@Override
	public Boolean changePassword(String username, String password, String key, String date){
		Boolean bool = false;

		try {
			SqlSession ss = Database.openSession();
			AccountModel account = new AccountModel();
			account.setUsername(username);
			account.setPassword(password);
			account.setKey(key);
			account.setDateChanged(date);
			
			int status = ss.update("changePassword", account);
			if(status > 0) {
				bool = true;
			} else {
				bool = false;
			}
			Database.closeSession();
		} catch(IOException e) {
			e.printStackTrace();
			log.error("Update password error. Cause: {}", e);
		}
		
		return bool;
	}
	
	@Override
	public Boolean deleteAccount(String username){
		Boolean bool = false;
		
		try {
			SqlSession ss = Database.openSession();
			int status = ss.delete("deleteAccount", username);
			if(status > 0) {
				bool = true;
			} else {
				bool = false;
			}
			Database.closeSession();
		} catch(IOException e) {
			e.printStackTrace();
			log.error("Delete Account error. Username: {}, cause: {}", username, e);
		}
		
		return bool;
	}
}
