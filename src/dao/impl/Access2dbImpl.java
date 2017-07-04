package dao.impl;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;

import utils.xmlUtils;
import dao.Access2db;
import domain.User;

public class Access2dbImpl implements Access2db {

	public void add(User user) {
		try {
			Document doc=xmlUtils.getDocument();
			Element root=doc.getRootElement();
			Element ele=root.addElement("user");
			
			ele.setAttributeValue("id",user.getId());
			ele.setAttributeValue("uname",user.getUname());
			ele.setAttributeValue("password",user.getPassword());
			ele.setAttributeValue("email",user.getEmail());
			ele.setAttributeValue("birthday",user.getBirthday()==null?"":user.getBirthday().toLocaleString());
			ele.setAttributeValue("nickname",user.getNickname());
			
			xmlUtils.write2Document(doc);
			
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public User find(String uname, String password) {
		try {
			Document doc=xmlUtils.getDocument();
			
			Element ele=(Element) doc.selectSingleNode("//user[@uname='"+uname+"' and @password='"+password+"']");
			
			if(ele==null){
				return null;
			}else{
				User user=new User();
				user.setId(ele.attributeValue("id"));
				user.setUname(ele.attributeValue("uname"));
				user.setPassword(ele.attributeValue("password"));
				user.setEmail(ele.attributeValue("email"));
				
				if(ele.attributeValue("birthday")!=null && ele.attributeValue("birthday")!=""){
					DateFormat format=new SimpleDateFormat("yyyy-MM-dd");
					Date date=format.parse(ele.attributeValue("birthday"));
					user.setBirthday(date);
				}
				
				user.setNickname(ele.attributeValue("nickname"));
				
				return user;
				
			}
			
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		} 
		
	}

	public boolean find(String uname) {
		Document doc;
		try {
			doc = xmlUtils.getDocument();
			Element ele=(Element) doc.selectSingleNode("//user[@uname='"+uname+"']");
			
			if(ele==null){
				return false;
			}
			
			return true;
			
		} catch (DocumentException e) {
			throw new RuntimeException(e);
		}
		
		
	}

}
