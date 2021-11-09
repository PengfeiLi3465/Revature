package com.revature.orderingsystem.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
@Entity
@Table(name = "`user`", schema = "project2")
//@Data
//public class User {
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//
//	private int userId;
//
//	private int usertypeId;
//
//	private String userEmail;
//
//	private String userName;
//
//	private String userPassword;
//
//}
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="user_id")
	private int userId;
	@Column(name="usertype_id")
	private int usertypeId;
	@Column(name="user_email")
	private String userEmail;
	@Column(name="user_name")
	private String userName;
	@Column(name="user_password")
	private String userPassword;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(int userId, int usertypeId, String userEmail, String userName, String userPassword) {
		super();
		this.userId = userId;
		this.usertypeId = usertypeId;
		this.userEmail = userEmail;
		this.userName = userName;
		this.userPassword = userPassword;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getUsertypeId() {
		return usertypeId;
	}
	public void setUsertypeId(int usertypeId) {
		this.usertypeId = usertypeId;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", usertypeId=" + usertypeId + ", userEmail=" + userEmail + ", userName="
				+ userName + ", userPassword=" + userPassword + "]";
	}

}
