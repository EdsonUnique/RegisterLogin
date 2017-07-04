package service;

import java.security.NoSuchAlgorithmException;

import domain.User;
import exception.UserExistsException;

public interface BusinessSovle {

	/**
	 * ע��
	 * @param user �û�
	 * @throws UserExistsException ���û������׳��û��Ѵ����쳣
	 */
	public void register(User user) throws UserExistsException;

	/**
	 * ��¼
	 * @param uname �û���
	 * @param password �û�����
	 * @return �������ݿ����ҵ��򷵻��û�����ʾ��½�ɹ�����û�ҵ�����null����¼ʧ��
	 */
	public User login(String uname, String password);

}