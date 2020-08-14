package com.design.analysis.concurrent.utils.running;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchWaiter implements Runnable {

	CountDownLatch latch = null;

	public CountDownLatchWaiter(CountDownLatch latch) {
		this.latch = latch;
	}

	@Override
	public void run() {
		try {
			latch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("Waiter Released");
	}
}
