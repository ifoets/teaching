package com.design.analysis.concurrent.thread.runing;

public class VolatileVar implements Runnable {

	public volatile int val = 0;

	@Override
	public void run() {
		System.out.println(val);
	}

	public void update(int val) {
		this.val = val;
	}
}
