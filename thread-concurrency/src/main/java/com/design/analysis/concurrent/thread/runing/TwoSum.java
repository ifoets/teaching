package com.design.analysis.concurrent.thread.runing;

public class TwoSum implements Runnable {

	public int sum1 = 0;
	public int sum2 = 0;

	public Integer sum1Lock = 1;
	public Integer sum2Lock = 2;

	public void add(int val1, int val2) {
		synchronized (this.sum1Lock) {
			this.sum1 += val1;
		}
		synchronized (this.sum2Lock) {
			this.sum2 += val2;
		}
	}

	@Override
	public void run() {
		System.out.println("sum1: " + sum1);
		System.out.println("sum2: " + sum2);
	}

}
