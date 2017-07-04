package utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import sun.misc.BASE64Encoder;

/**
 * Base64������ܣ�ʹ��MD5�㷨
 * @author Edson121
 *
 */
public class Encoder {

	public static String encoder(String str) {
		
		MessageDigest d;
		try {
			d = MessageDigest.getInstance("md5");
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
		byte message[]=d.digest(str.getBytes());
		
		return new BASE64Encoder().encode(message);
	}
}
