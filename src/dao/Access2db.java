package dao;


import domain.User;
/**
 * �����ݿ⽻���Ľӿ�
 * @author Edson121
 *
 */

public interface Access2db {

	/**
	 * ��һ���û���Ϣ����xml���ݿ�
	 * @param user �û���Ϣ
	 */
	public void add(User user);
	/**
	 * ��xml���ݿ��в���ָ���û���Ϣ������
	 * @param uname �û���
	 * @param password ����
	 * @return �����û���Ϣ��User
	 */
	public User find(String uname,String password);
	/**
	 * �ж��Ƿ���ڸ��û�
	 * @param uname �û���
	 * @return true|false
	 */
	public boolean find(String uname);
}
