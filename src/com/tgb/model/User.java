package com.tgb.model;

/**
 * 用户
 * @author liuying
 *
 */
public class User {

	private int id;
	private String age;
	private String userName;
	private String email;
	private String permission;
	private String password;
	
	public User(){
		super();
	}
	public User(int id, String age, String userName, String email,
			String permission, String password) {
		super();
		this.id = id;
		this.age = age;
		this.userName = userName;
		this.email = email;
		this.permission = permission;
		this.password = password;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPermission() {
		return permission;
	}
	public void setPermission(String permission) {
		this.permission = permission;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "User [age=" + age + ", email=" + email + ", id=" + id
				+ ", password=" + password + ", permission=" + permission
				+ ", userName=" + userName + "]";
	}
	
}
