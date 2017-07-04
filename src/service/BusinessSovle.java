package service;

import java.security.NoSuchAlgorithmException;

import domain.User;
import exception.UserExistsException;

public interface BusinessSovle {

	/**
	 * 注册
	 * @param user 用户
	 * @throws UserExistsException 若用户存在抛出用户已存在异常
	 */
	public void register(User user) throws UserExistsException;

	/**
	 * 登录
	 * @param uname 用户名
	 * @param password 用户密码
	 * @return 若在数据库中找到则返回用户，表示登陆成功，若没找到返回null，登录失败
	 */
	public User login(String uname, String password);

}