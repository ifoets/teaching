package com.design.analysis.algo.dynamicprogramming.model;

public class WtJobScheduling implements Comparable<WtJobScheduling> {

	public int sTime;
	public int eTime;
	public int profit;

	public WtJobScheduling(int sTime, int eTime, int profit) {
		super();
		this.sTime = sTime;
		this.eTime = eTime;
		this.profit = profit;
	}

	@Override
	public int compareTo(WtJobScheduling arg0) {
		return this.eTime - arg0.eTime;
	}

}
