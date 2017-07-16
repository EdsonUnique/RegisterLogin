package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import dao.Access2db;

/**
 * dao�㹤���ࣺͨ����ȡ�����ļ�����dao��ʹ��ʲô��ʽ��ȡʲô���͵����ݿ�
 * ����ģʽ
 * @author Acer
 *
 */
public class daoUtil {
	
	private static Access2db dao=null;
	
	private daoUtil(){
	
		InputStream in=daoUtil.class.getClassLoader().getResourceAsStream("dao.properties");
		Properties pro=new Properties();
		try {
			pro.load(in);
			String daoClass=pro.getProperty("dao_type");
			dao=(Access2db) Class.forName(daoClass).newInstance();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
		
	}
	
	private static final daoUtil du=new daoUtil();
	
	public static Access2db getDao(){
		
		return dao;
	}

}
