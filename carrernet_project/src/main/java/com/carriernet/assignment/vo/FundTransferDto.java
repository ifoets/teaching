package com.carriernet.assignment.vo;

import java.io.Serializable;

public class FundTransferDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private String fromAc;

	private String toAc;

	private double transferAmout;

	public FundTransferDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FundTransferDto(String fromAc, String toAc, double transferAmout) {
		super();
		this.fromAc = fromAc;
		this.toAc = toAc;
		this.transferAmout = transferAmout;
	}

	public String getFromAc() {
		return fromAc;
	}

	public void setFromAc(String fromAc) {
		this.fromAc = fromAc;
	}

	public String getToAc() {
		return toAc;
	}

	public void setToAc(String toAc) {
		this.toAc = toAc;
	}

	public double getTransferAmout() {
		return transferAmout;
	}

	public void setTransferAmout(double transferAmout) {
		this.transferAmout = transferAmout;
	}

}
