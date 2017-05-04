package cn.com.hq.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cn.com.hq.dao.Dao;
import cn.com.hq.dao.UserDAO;
import cn.com.hq.entity.Account;
import cn.com.hq.util.PropertiesUtils;
import cn.com.hq.util.StringUtil;

public class UserDAOImpl implements UserDAO {
	private Dao dao = new Dao();
	public boolean saveUser(Account a) {
		String sql = "INSERT INTO  huangqidb.account(accountid, name, password, age, address, email, phone, message)"
				+ " VALUES (?,?,?,?,?,?,?,?)";
		Connection connection =  dao.getDBConnection();
		if(dao.dbFlag.equals("Common")){
			sql = sql.replaceAll("huangqidb\\.", "");
		}
		PreparedStatement  ps;
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, a.getAccountid());
			ps.setString(2, a.getName());
			ps.setString(3, a.getPassWord());
			ps.setInt(4, a.getAge());
			ps.setString(5, a.getAddress());
			ps.setString(6, a.getEmail());
			ps.setString(7, a.getPhone());
			ps.setString(8, a.getMessage());
			ps.executeUpdate();
			dao.closeStatement(ps);
			Dao.releaseConnection(connection);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public void updateUser(Account u) {
		
	}

	public void deleteUser(Account u) {
		System.out.println("user deleted!");
	}

	public Account getUser(Account u) {
		if ("admin".endsWith(u.getName()) && "admin123".equals(u.getPassWord())) {
			u.setAge(18);
			return u;
		}
		return null;
	}

	@Override
	public List<Account> queryAccountByName(String name) {
		List<Account> accountList = new ArrayList<Account>();
		String sql = "";
		if(!StringUtil.isEmpty(name)){
			sql = "SELECT accountid,name,message FROM huangqidb.account where name='"+name+"'";
		}else{
			return accountList;
		}
		if(dao.dbFlag.equals("Common")){
			sql = sql.replaceAll("huangqidb\\.", "");
		}
		Connection connection =  dao.getDBConnection();
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				 String accountid = rs.getString(1);
		        String accourtName = rs.getString(2);
		        String accourtMessage = rs.getString(3);
		        Account a = new Account();
		        a.setAccountid(accountid);
		        a.setName(accourtName);
		        a.setMessage(accourtMessage);
		        accountList.add(a);
		    }
			dao.closeResultSet(rs);
			dao.closeStatement(stmt);
			Dao.releaseConnection(connection);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return accountList;
	}
	
	@Override
	public List<Account> queryAccountById(String accountId) {
		List<Account> accountList = new ArrayList<Account>();
		String sql = "";
		if(!StringUtil.isEmpty(accountId)){
			sql = "SELECT accountid,name,message FROM huangqidb.account where accountid='"+accountId+"'";
		}else{
			return accountList;
		}
		if(dao.dbFlag.equals("Common")){
			sql = sql.replaceAll("huangqidb\\.", "");
		}
		Connection connection =  dao.getDBConnection();
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				 String accountid = rs.getString(1);
		        String accourtName = rs.getString(2);
		        String accourtMessage = rs.getString(3);
		        Account a = new Account();
		        a.setAccountid(accountid);
		        a.setName(accourtName);
		        a.setMessage(accourtMessage);
		        accountList.add(a);
		    }
			dao.closeResultSet(rs);
			dao.closeStatement(stmt);
			Dao.releaseConnection(connection);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return accountList;
	}
	
	@Override
	public List<Account> queryAllAccountBy() {
		List<Account> accountList = new ArrayList<Account>();
		String sql = "SELECT accountid,name,message FROM huangqidb.account";
		if(dao.dbFlag.equals("Common")){
			sql = sql.replaceAll("huangqidb\\.", "");
		}
		Connection connection =  dao.getDBConnection();
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				 String accountid = rs.getString(1);
		        String accourtName = rs.getString(2);
		        String accourtMessage = rs.getString(3);
		        Account a = new Account();
		        a.setAccountid(accountid);
		        a.setName(accourtName);
		        a.setMessage(accourtMessage);
		        accountList.add(a);
		    }
			dao.closeResultSet(rs);
			dao.closeStatement(stmt);
			Dao.releaseConnection(connection);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return accountList;
	}
	
}
