package domain;

import java.util.Date;
/**
 *  保存用户信息的javabean
 * @author Edson121
 *
 */

public class User {
	
	private String id;
	private String uname;
	private String password;
	private String email;
	private Date birthday;
	private String nickname;
	
	
	public User() {
		super();
	}
	public User(String id, String uname, String password, String email,
			Date birthday, String nickname) {
		super();
		this.id = id;
		this.uname = uname;
		this.password = password;
		this.email = email;
		this.birthday = birthday;
		this.nickname = nickname;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	
}
