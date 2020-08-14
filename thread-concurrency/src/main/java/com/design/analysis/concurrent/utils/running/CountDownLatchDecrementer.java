package com.design.analysis.concurrent.utils.running;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDecrementer implements Runnable {
	CountDownLatch latch = null;

	public CountDownLatchDecrementer(CountDownLatch latch) {
		this.latch = latch;
	}

	@Override
	public void run() {
		try {
			Thread.sleep(1000);
			this.latch.countDown();
			System.out.println("1 count down");
			Thread.sleep(1000);
			this.latch.countDown();
			System.out.println("2 count down");
			Thread.sleep(1000);
			this.latch.countDown();
			System.out.println("3 count down");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
