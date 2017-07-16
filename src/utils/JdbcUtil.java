package utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;


public class JdbcUtil {
	
	private static String db_url=null;
	private static String username=null;
	private static String password=null;
	private static String db_type=null;
	
	static{
		 InputStream in=JdbcUtil.class.getClassLoader().getResourceAsStream("db.properties");
		
		Properties pro=new Properties();
		try {
			pro.load(in);
			db_url=pro.getProperty("db_url");
			username=pro.getProperty("username");
			password=pro.getProperty("password");
			db_type=pro.getProperty("db_type");
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		
	}
	
	public static Connection getConnection(){
		try {
			Class.forName(db_type);
			return DriverManager.getConnection(db_url,username,password);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
