package com.user.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "user")
public class Users {

	@Transient
	public static final String SEQUENCE_NAME = "user_sequence";
	private String username;
	private String email;
	private String password;

	public Users() {
	}

	public Users(String username, String email, String password) {
		super();

		this.username = username;
		this.email = email;
		this.password = password;
		
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	public static String getSequenceName() {
		return SEQUENCE_NAME;
	}

}