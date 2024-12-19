package v2.com.company.payroll.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import v2.com.company.payroll.mapper.AccountMapper;
import v2.com.company.payroll.model.Account;
import v2.com.company.payroll.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {
	
	@Autowired
	private AccountMapper accountMapper;

	public List<Account> queryUserAccount() {
		return accountMapper.getAllAccount();
	}

	@Override
	public Account queryPasswordKey(String username) {
		return accountMapper.getPasswordKey(username);
	}

	@Override
	public Integer insertAccount(Account account) {
		return accountMapper.addAccount(account);
	}

	@Override
	public Integer updatePassword(String username, String password, String key, String date) {
		return accountMapper.changePassword(username, password, key, date);
	}

	@Override
	public Integer deleteAccount(String username) {
		return accountMapper.deleteAccount(username);
	}

}
