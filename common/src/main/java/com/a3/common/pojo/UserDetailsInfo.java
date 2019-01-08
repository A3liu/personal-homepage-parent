package com.a3.common.pojo;

import java.util.Date;

/**
 * 用户详细信息表
 * @author Donald 2019-01-05 00:16 
 *
 */
public class UserDetailsInfo extends BaseEntity{
	private static final long serialVersionUID = 1804180010573764833L;
	//id
	private long id;
	//昵称
	private String nickname;
	//email
	private String email;
	//状态
	private int  status;
	//创建时间
	private Date createTime;
	//修改时间
	private Date modifyTime;
	//最后登陆时间
	private Date lastloginTime;
	//个性签名
	private String signature;
	//博客等级
	private int bokeLevel;
	//性别
	private String  gender;
	//用户头像
	private String userImage;
	//用户年龄
	private int age;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getModifyTime() {
		return modifyTime;
	}
	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}
	public Date getLastloginTime() {
		return lastloginTime;
	}
	public void setLastloginTime(Date lastloginTime) {
		this.lastloginTime = lastloginTime;
	}
	public String getSignature() {
		return signature;
	}
	public void setSignature(String signature) {
		this.signature = signature;
	}
	public int getBokeLevel() {
		return bokeLevel;
	}
	public void setBokeLevel(int bokeLevel) {
		this.bokeLevel = bokeLevel;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getUserImage() {
		return userImage;
	}
	public void setUserImage(String userImage) {
		this.userImage = userImage;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "UserDetailsInfo [id=" + id + ", nickname=" + nickname + ", email=" + email + ", status=" + status
				+ ", createTime=" + createTime + ", modifyTime=" + modifyTime + ", lastloginTime=" + lastloginTime
				+ ", signature=" + signature + ", bokeLevel=" + bokeLevel + ", gender=" + gender + ", userImage="
				+ userImage + ", age=" + age + "]";
	}
	
}
