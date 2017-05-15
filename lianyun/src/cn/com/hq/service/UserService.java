package cn.com.hq.service;

import java.util.List;

import cn.com.hq.entity.Account;

public interface UserService {

	public void savaOrUpdateAccount(Account a);
	public List<Account> queryAccountByName(String name);
	public boolean createAccount(Account a);
	List<Account> queryAccountById(String id);
	public void updateAccount(Account account);
	public List<String> queryAuthorityById(String accountId);
}
