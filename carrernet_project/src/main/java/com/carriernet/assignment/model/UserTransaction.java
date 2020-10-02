package com.carriernet.assignment.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.carriernet.assignment.utils.TransactionTypeEnum;

@Entity
@Table(name = "user_transaction")
public class UserTransaction implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "wallet_id")
	private Integer walletId;

	@Column(name = "ac_from")
	private String acFrom;

	@Column(name = "ac_To")
	private String acTo;

	@Column(name = "transfer_amount")
	private double transferAmount;

	@Column(name = "charge")
	private double charge;

	@Column(name = "commision")
	private double commision;

	@Column(name = "total_amount")
	private double totalAmount;

	@Enumerated(value = EnumType.STRING)
	@Column(name = "trans_type")
	private TransactionTypeEnum transType;

	@Column(name = "trans_time")
	private Timestamp transTime;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getWalletId() {
		return walletId;
	}

	public void setWalletId(Integer walletId) {
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

	public double getTotalAmount() {
		return totalAmount;
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

	/*
	 * CONSTRAINT FK_tranactionWallet FOREIGN KEY (walletId) REFERENCES
	 * user_wallet(id), CONSTRAINT FK_tranactionWalletAccount FOREIGN KEY (walletId)
	 * REFERENCES user_wallet(id)
	 */

}
