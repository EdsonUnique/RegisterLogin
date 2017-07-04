package JuitTest;

import java.util.Date;

import org.junit.Test;

import dao.Access2db;
import dao.impl.Access2dbImpl;
import domain.User;

public class TestAccess {
	
	public void testAdd(){
		User user=new User();
		user.setBirthday(new Date());
		user.setId("111");
		user.setUname("ccc");
		user.setPassword("12345642");
		user.setEmail("21344@qq.com");
		user.setNickname("山光水色");
		
		Access2db dao=new Access2dbImpl();
		dao.add(user);
	}
	@Test
	public void testFind(){
		Access2dbImpl dao=new Access2dbImpl();
		System.out.println(dao.find("ccc"));
		User user=dao.find("aaa","123456");
	}
}
