package com.design.analysis.concurrent.thread.runing;

public class VarWithVolatile implements Runnable {

	public int years = 0;
	public int months = 0;
	public volatile int days = 0;

	public void update(int years, int months, int days) {
		this.years = years;
		this.months = months;
		this.days = days;
	}

	public int totalDays() {
		int total = this.days;
		total += months * 30;
		total += years * 365;
		return total;
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + "::" + totalDays());
	}
}
