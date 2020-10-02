package com.carriernet.assignment.vo;

import java.io.Serializable;
import java.sql.Timestamp;

import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;

public class UserAccountDto implements Serializable {

	private static final long serialVersionUID = 1L;

	public UserAccountDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	int id;

	private String userName;

	private String userPassword;

	private Timestamp loginTime;

	private boolean login;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public Timestamp getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(Timestamp loginTime) {
		this.loginTime = loginTime;
	}

	public boolean isLogin() {
		return login;
	}

	public void setLogin(boolean login) {
		this.login = login;
	}

	public static void main(String[] args) throws JSONException {

		JSONObject js = new JSONObject();
		
		js.put("accountId", "1");
		js.put("acno", "12345");
		js.put("amount", 5000.00);
		System.out.println(js.toString());
	}
}
