package com.design.analysis.algo.greedyalgorithms.model;

public class StockPrice implements Comparable<StockPrice> {

	public int day;
	public int money;

	public StockPrice(int day, int money) {
		this.day = day;
		this.money = money;
	}

	@Override
	public int compareTo(StockPrice o) {
		if (this.money == o.money)
			return o.day - this.day;
		return this.money - o.money;
	}

	@Override
	public String toString() {
		return "StockPrice [day=" + day + ", money=" + money + "]";
	}
	
	
}
