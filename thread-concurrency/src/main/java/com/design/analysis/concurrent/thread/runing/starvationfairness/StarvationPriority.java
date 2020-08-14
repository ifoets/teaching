package com.design.analysis.concurrent.thread.runing.starvationfairness;

public class StarvationPriority implements Runnable {

	public synchronized void A() throws InterruptedException {
		System.out.println("Priority " + Thread.currentThread().getPriority());
		for (int i = 0; i < 100; i++)
			;
	}

	@Override
	public void run() {
		try {
			A();
		} catch (InterruptedException e) {
		}
	}

}
