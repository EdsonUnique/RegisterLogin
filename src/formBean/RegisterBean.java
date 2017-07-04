package formBean;

import java.util.*;

import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;


/**
 * 将表单的数据封装到一个对象中，并在该对象中提供对表单数据校验的方法
 * @author Edson121
 *
 */
public class RegisterBean {

	private String uname;
	private String password;//输入密码
	private String password1;//确认密码
	private String email;
	private String birthday;
	private String nickname;//客户提交过来的都是String类型
	
	private boolean isOk=true;//判断表单数据是否合法的标识
	private Map<String,String>error=new HashMap<String,String>();//存放表单数据错误的原因
	
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
	
	//校验表单数据
	public boolean checkForm(){
		
		if(uname==null || uname.trim().equals("")){
			isOk=false;
			error.put("uname", "用户名不能为空");
		}
		
		if(password==null){
			isOk=false;
			error.put("password", "密码不能为空");
		}else if(!password.matches("[A-Za-z0-9]{6,12}")){
			isOk=false;
			error.put("password", "密码必须为6-12位字母或数字");
		}
		
		if(password1==null){
			isOk=false;
			error.put("password1", "确认输入密码不能为空");
		}else if(!password.equals(password1)){
			isOk=false;
			error.put("password1", "确认密码错误");
		}
		
		if(email==null){
			isOk=false;
			error.put("email", "邮箱不能为空");
		}else if(!email.matches("\\d+@[\\dA-Za-z]+\\.[\\dA-Za-z]+")){
			isOk=false;
			error.put("email","邮箱格式错误");
		}
		
		if(birthday!=null && !birthday.trim().equals("")){
			try{
				DateLocaleConverter converter=new DateLocaleConverter();//判断日期是否合法
				converter.convert(birthday,"yyyy-MM-dd");
			}catch(Exception e){
				isOk=false;
				error.put("birthday", "生日填写格式错误：年-月-日");
			}
			
		}
		
		if(nickname==null){
			isOk=false;
			error.put("nickname", "昵称不能为空");
		}else if(!nickname.matches("[\u4e00-\u9fa5]+")){//匹配汉字
			isOk=false;
			error.put("nickname", "昵称必须为汉字");
		}
		
		return isOk;
	}
	
	
}
