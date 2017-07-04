package JuitTest;

import java.util.Date;

import org.junit.Test;

import service.BusinessSovle;
import service.impl.BusinessSovleImp;

import domain.User;
import exception.UserExistsException;

public class TestService {
	@Test
	public void testRegister(){
		
		User user=new User();
		user.setBirthday(new Date());
		user.setId("111");
		user.setUname("ccc");
		user.setPassword("12345642");
		user.setEmail("21344@qq.com");
		user.setNickname("山光水色");
		
		BusinessSovle service=new BusinessSovleImp();
		try {
			service.register(user);
			System.out.println("注册成功");
		} catch (UserExistsException e) {
			System.out.println("用户已存在");
		}
	}
	@Test
	public void testLogin(){
		BusinessSovle service=new BusinessSovleImp();
		System.out.println(service.login("ccc", "12345642"));
	}
}












