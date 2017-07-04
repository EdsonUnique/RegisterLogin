package dao;


import domain.User;
/**
 * 与数据库交互的接口
 * @author Edson121
 *
 */

public interface Access2db {

	/**
	 * 将一个用户信息加入xml数据库
	 * @param user 用户信息
	 */
	public void add(User user);
	/**
	 * 在xml数据库中查找指定用户信息并返回
	 * @param uname 用户名
	 * @param password 密码
	 * @return 保存用户信息的User
	 */
	public User find(String uname,String password);
	/**
	 * 判断是否存在该用户
	 * @param uname 用户名
	 * @return true|false
	 */
	public boolean find(String uname);
}
