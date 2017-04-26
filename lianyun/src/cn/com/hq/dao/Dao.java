package cn.com.hq.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import cn.com.hq.util.PropertiesUtils;
public class Dao {
	public static String dbFlag = "Common";
	private static DataSource dataSource = null;
	
	 /**
     * 释放连接
     * @param connection
     */
    public static void releaseConnection(Connection connection){
           try {
                  if(connection != null ) {
                         connection.close();
                  }
           }catch (Exception e) {
                  e.printStackTrace();
           }
    }
	
	static{
        //dataSource资源只能初始化一次
        dataSource= new ComboPooledDataSource("lianyunDB");
	}
	
	public  Connection getDBConnection(){
		
//		String v = PropertiesUtils.getPropertyValueByKey("isDbConnectionSingleStatic");
		try {
        	return dataSource.getConnection();
            
        } catch (Exception e) {
        	 System.out.println("---CommonConnection DB failed!!!");
        	 e.printStackTrace();
        	 return null;
        }
	}
	
	public  void closeStatement(Statement statement){
		if(statement != null){
			try {
				statement.close();
			} catch (SQLException e) {
				statement = null;
			}
		}
	}
	
	public  void closeResultSet(ResultSet rs){
		if(rs != null){
			try {
				rs.close();
			} catch (SQLException e) {
				rs = null;
			}
		}
	}
}
