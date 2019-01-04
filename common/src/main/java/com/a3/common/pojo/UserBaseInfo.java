package com.a3.common.pojo;

/**
 * 用户基本信息实体类
 * @author Donald 2019-01-05 00:07 
 *
 */
public class UserBaseInfo extends BaseEntity {

	private static final long serialVersionUID = -6428204380451520847L;
	//用户名
	private String username;
	//用户密码MD5
	private String password;
	//用户id
	private long id;
	//加密盐
	private String salt;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}
	@Override
	public String toString() {
		return "UserBaseInfo [username=" + username + ", password=" + password + ", id=" + id + ", salt=" + salt + "]";
	}
	
}
