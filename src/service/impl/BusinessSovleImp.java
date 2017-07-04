package service.impl;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import service.BusinessSovle;
import sun.misc.BASE64Encoder;
import utils.Encoder;
import utils.xmlUtils;
import dao.Access2db;
import dao.impl.Access2dbImpl;
import domain.User;
import exception.UserExistsException;

/**
 * �ṩ��web��ķ���
 * @author Edson121
 *
 */
public class BusinessSovleImp implements BusinessSovle{
	
	private static Access2db dao=new Access2dbImpl();

	public void register(User user) throws UserExistsException{
		
		if(dao.find(user.getUname())){//���û��������׳�һ������ʱ�쳣��web��
			throw new UserExistsException();
		}else{//���û����������û�������ܺ�������ݿ�
			if(user.getPassword()!=null){
				user.setPassword(Encoder.encoder(user.getPassword()));
				dao.add(user);
			}
		}	
	}
	
	public User login(String uname,String password){
		
		String str=Encoder.encoder(password);//���ܺ��������ݿ���Ѱ��
		
		return dao.find(uname, str);
	}
	
	
	
}
