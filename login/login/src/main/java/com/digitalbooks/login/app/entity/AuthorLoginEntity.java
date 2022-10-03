package com.digitalbooks.login.app.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class AuthorLoginEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "userid")
	private int userId;
	
	@Column(name = "username")
	private String userName;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "create_time")
	private Timestamp createdTime;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Timestamp getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Timestamp createdTime) {
		this.createdTime = createdTime;
	}
	
	
}
