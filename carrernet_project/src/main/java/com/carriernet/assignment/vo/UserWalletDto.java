package com.carriernet.assignment.vo;

import java.io.Serializable;

public class UserWalletDto implements Serializable {

	private static final long serialVersionUID = 1L;

	public UserWalletDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	private Integer accountId;

	private String acno;

	private String userName;

	private double amount;

	public Integer getAccountId() {
		return accountId;
	}

	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}

	public String getAcno() {
		return acno;
	}

	public void setAcno(String acno) {
		this.acno = acno;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

}
