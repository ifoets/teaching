package com.carriernet.assignment.vo;

import java.io.Serializable;
import java.sql.Timestamp;

import com.carriernet.assignment.utils.TransactionTypeEnum;

public class UserTransactionDto implements Serializable {

	private static final long serialVersionUID = 1L;

	public UserTransactionDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserTransactionDto(int walletId, String acFrom, String acTo, double charge, double commision, double transferAmount ,
			double totalAmount, TransactionTypeEnum transType, Timestamp transTime) {
		super();
		this.walletId = walletId;
		this.acFrom = acFrom;
		this.acTo = acTo;
		this.charge = charge;
		this.commision = commision;
		this.transferAmount  = transferAmount ;
		this.totalAmount = totalAmount;
		this.transType = transType;
		this.transTime = transTime;
	}

	private int walletId;

	private String acFrom;

	private String acTo;

	private double charge;

	private double commision;

	private double transferAmount ;

	private double totalAmount;

	private TransactionTypeEnum transType;

	private Timestamp transTime;

	public int getWalletId() {
		return walletId;
	}

	public void setWalletId(int walletId) {
		this.walletId = walletId;
	}

	public String getAcFrom() {
		return acFrom;
	}

	public void setAcFrom(String acFrom) {
		this.acFrom = acFrom;
	}

	public String getAcTo() {
		return acTo;
	}

	public void setAcTo(String acTo) {
		this.acTo = acTo;
	}

	public double getTransferAmount() {
		return transferAmount;
	}

	public void setTransferAmount(double transferAmount) {
		this.transferAmount = transferAmount;
	}

	public double getCharge() {
		return charge;
	}

	public void setCharge(double charge) {
		this.charge = charge;
	}

	public double getCommision() {
		return commision;
	}

	public void setCommision(double commision) {
		this.commision = commision;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	
	public TransactionTypeEnum getTransType() {
		return transType;
	}

	public void setTransType(TransactionTypeEnum transType) {
		this.transType = transType;
	}

	public Timestamp getTransTime() {
		return transTime;
	}

	public void setTransTime(Timestamp transTime) {
		this.transTime = transTime;
	}

	@Override
	public String toString() {
		return "UserTransactionDto [acFrom=" + acFrom + ", acTo=" + acTo + ", charge=" + charge + ", commision="
				+ commision + ", transferAmount=" + transferAmount + ", totalAmount=" + totalAmount + ", transType=" + transType
				+ ", transTime=" + transTime + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((acFrom == null) ? 0 : acFrom.hashCode());
		result = prime * result + ((acTo == null) ? 0 : acTo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserTransactionDto other = (UserTransactionDto) obj;
		if (acFrom == null) {
			if (other.acFrom != null)
				return false;
		} else if (!acFrom.equals(other.acFrom))
			return false;
		if (acTo == null) {
			if (other.acTo != null)
				return false;
		} else if (!acTo.equals(other.acTo))
			return false;
		return true;
	}

}
