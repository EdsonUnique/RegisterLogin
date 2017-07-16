package service.impl;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import service.BusinessSovle;
import sun.misc.BASE64Encoder;
import utils.Encoder;
import utils.daoUtil;
import utils.xmlUtils;
import dao.Access2db;
import dao.impl.Access2dbImpl;
import dao.impl.Jdbc2dbImpl;
import domain.User;
import exception.UserExistsException;

/**
 * 提供给web层的服务
 * @author Edson121
 *
 */
public class BusinessSovleImp implements BusinessSovle{
	
	private static Access2db dao=daoUtil.getDao();

	public void register(User user) throws UserExistsException{
		
		if(dao.find(user.getUname())){//若用户存在则抛出一个编译时异常给web层
			throw new UserExistsException();
		}else{//若用户不存在则将用户密码加密后加入数据库
			if(user.getPassword()!=null){
				user.setPassword(Encoder.encoder(user.getPassword()));
				dao.add(user);
			}
		}	
	}
	
	public User login(String uname,String password){
		
		String str=Encoder.encoder(password);//加密后再在数据库中寻找
		
		return dao.find(uname, str);
	}
	
	
	
}
