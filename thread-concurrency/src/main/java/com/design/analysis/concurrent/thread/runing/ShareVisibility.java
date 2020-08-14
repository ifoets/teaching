package com.design.analysis.concurrent.thread.runing;

public class ShareVisibility implements Runnable {

	public int mayNonVisibleval = 1;
	public volatile int visibileVolatile = 1;

	public void update(int updateVal) {
		this.mayNonVisibleval += updateVal;
	}

	public void updateVolatile(int updateVal) {
		this.visibileVolatile += updateVal;
	}

	@Override
	public void run() {
		System.out.println("mayNonVisibleval: " + mayNonVisibleval);
		System.out.println("visibileVolatile: " + visibileVolatile);
	}
}
