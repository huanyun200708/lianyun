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
	public boolean saveAccount(Account a) {
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

	public void updateAccount(Account a) {
		String sql = "update  huangqidb.account "
				+ " set accountid=?, name=?, password=?, age=?, address=?, email=?, phone=?, message=? "
				+ "where accountid=?";
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
			ps.setString(9, a.getAccountid());
			ps.executeUpdate();
			dao.closeStatement(ps);
			Dao.releaseConnection(connection);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteAccount(Account u) {
		System.out.println("user deleted!");
	}


	@Override
	public List<Account> queryAccountByName(String name) {
		List<Account> accountList = new ArrayList<Account>();
		String sql = "";
		if(!StringUtil.isEmpty(name)){
			sql = "SELECT accountid,name,password,age,address,email,phone,message FROM huangqidb.account where  name=?";
		}else{
			return accountList;
		}
		if(dao.dbFlag.equals("Common")){
			sql = sql.replaceAll("huangqidb\\.", "");
		}
		Connection connection =  dao.getDBConnection();
		PreparedStatement  ps;
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				String accountid = rs.getString(1);
		        String password = rs.getString(3);
		        int age = rs.getInt(4);
		        String address = rs.getString(5);
		        String email = rs.getString(6);
		        String phone = rs.getString(7);
		        String message = rs.getString(8);
		        Account a = new Account();
		        a.setAccountid(accountid);
		        a.setName(name);
		        a.setPassWord(password);
		        a.setAge(age);
		        a.setAddress(address);
		        a.setEmail(email);
		        a.setPhone(phone);
		        a.setMessage(message);
		        accountList.add(a);
		    }
			dao.closeResultSet(rs);
			dao.closeStatement(ps);
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
			sql = "SELECT accountid,name,password,age,address,email,phone,message FROM huangqidb.account where accountid= ?";
		}else{
			return accountList;
		}
		if(dao.dbFlag.equals("Common")){
			sql = sql.replaceAll("huangqidb\\.", "");
		}
		Connection connection =  dao.getDBConnection();
		PreparedStatement  ps;
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, accountId);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				String accountid = rs.getString(1);
		        String name = rs.getString(2);
		        String password = rs.getString(3);
		        int age = rs.getInt(4);
		        String address = rs.getString(5);
		        String email = rs.getString(6);
		        String phone = rs.getString(7);
		        String message = rs.getString(8);
		        Account a = new Account();
		        a.setAccountid(accountid);
		        a.setName(name);
		        a.setPassWord(password);
		        a.setAge(age);
		        a.setAddress(address);
		        a.setEmail(email);
		        a.setPhone(phone);
		        a.setMessage(message);
		        accountList.add(a);
		    }
			dao.closeResultSet(rs);
			dao.closeStatement(ps);
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

	@Override
	public List<String> queryAuthorityById(String accountId) {

		List<String> auList = new ArrayList<String>();
		String sql = "";
		if(!StringUtil.isEmpty(accountId)){
			sql = "SELECT roleid FROM huangqidb.authority where accountid= ?";
		}else{
			return auList;
		}
		if(dao.dbFlag.equals("Common")){
			sql = sql.replaceAll("huangqidb\\.", "");
		}
		Connection connection =  dao.getDBConnection();
		PreparedStatement  ps;
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, accountId);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				String au = rs.getString(1);
		        auList.add(au);
		    }
			dao.closeResultSet(rs);
			dao.closeStatement(ps);
			Dao.releaseConnection(connection);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return auList;
	}
	
}
