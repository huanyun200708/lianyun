package cn.com.hq.serviceimpl;

import java.util.List;

import cn.com.hq.dao.UserDAO;
import cn.com.hq.daoImpl.UserDAOImpl;
import cn.com.hq.entity.Account;

public class UserServiceimpl implements cn.com.hq.service.UserService {
	private UserDAO userDAO = new UserDAOImpl();
    
	@Override
	public List<Account> queryAccountByName(String name) {
		return userDAO.queryAccountByName(name);
	}
	
	@Override
	public List<Account> queryAccountById(String id) {
		return userDAO.queryAccountById(id);
	}
	
	@Override
	public void savaOrUpdateAccount(Account a) {
		if(userDAO.queryAccountById(a.getAccountid()).size()>0){
			userDAO.updateAccount(a);
		}else{
			userDAO.saveAccount(a);
		}
		
	}
	@Override
	public boolean  createAccount(Account a){
		return userDAO.saveAccount(a);
	}
	
	public UserDAO getUserDAO() {
		return userDAO;
	}
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	@Override
	public void updateAccount(Account account) {
		userDAO.updateAccount(account);
		
	}

	@Override
	public List<String> queryAuthorityById(String accountId) {
		return userDAO.queryAuthorityById(accountId);
	}
	
}
