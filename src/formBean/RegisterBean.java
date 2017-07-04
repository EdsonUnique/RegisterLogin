package formBean;

import java.util.*;

import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;


/**
 * ���������ݷ�װ��һ�������У����ڸö������ṩ�Ա�����У��ķ���
 * @author Edson121
 *
 */
public class RegisterBean {

	private String uname;
	private String password;//��������
	private String password1;//ȷ������
	private String email;
	private String birthday;
	private String nickname;//�ͻ��ύ�����Ķ���String����
	
	private boolean isOk=true;//�жϱ������Ƿ�Ϸ��ı�ʶ
	private Map<String,String>error=new HashMap<String,String>();//��ű����ݴ����ԭ��
	
	public String getPassword1() {
		return password1;
	}
	public void setPassword1(String password1) {
		this.password1 = password1;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public Map<String, String> getError() {
		return error;
	}
	
	//У�������
	public boolean checkForm(){
		
		if(uname==null || uname.trim().equals("")){
			isOk=false;
			error.put("uname", "�û�������Ϊ��");
		}
		
		if(password==null){
			isOk=false;
			error.put("password", "���벻��Ϊ��");
		}else if(!password.matches("[A-Za-z0-9]{6,12}")){
			isOk=false;
			error.put("password", "�������Ϊ6-12λ��ĸ������");
		}
		
		if(password1==null){
			isOk=false;
			error.put("password1", "ȷ���������벻��Ϊ��");
		}else if(!password.equals(password1)){
			isOk=false;
			error.put("password1", "ȷ���������");
		}
		
		if(email==null){
			isOk=false;
			error.put("email", "���䲻��Ϊ��");
		}else if(!email.matches("\\d+@[\\dA-Za-z]+\\.[\\dA-Za-z]+")){
			isOk=false;
			error.put("email","�����ʽ����");
		}
		
		if(birthday!=null && !birthday.trim().equals("")){
			try{
				DateLocaleConverter converter=new DateLocaleConverter();//�ж������Ƿ�Ϸ�
				converter.convert(birthday,"yyyy-MM-dd");
			}catch(Exception e){
				isOk=false;
				error.put("birthday", "������д��ʽ������-��-��");
			}
			
		}
		
		if(nickname==null){
			isOk=false;
			error.put("nickname", "�ǳƲ���Ϊ��");
		}else if(!nickname.matches("[\u4e00-\u9fa5]+")){//ƥ�人��
			isOk=false;
			error.put("nickname", "�ǳƱ���Ϊ����");
		}
		
		return isOk;
	}
	
	
}
