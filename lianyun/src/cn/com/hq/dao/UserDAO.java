package cn.com.hq.dao;

import java.util.List;

import cn.com.hq.entity.Account;

public interface UserDAO {
	public boolean saveAccount(Account u);

	public void updateAccount(Account u);

	public void deleteAccount(Account u);

	public List<Account> queryAccountByName(String name);

	List<Account> queryAccountById(String accountId);

	List<Account> queryAllAccountBy();
}
