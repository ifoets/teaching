package com.design.analysis.concurrent.thread.runing.starvationfairness;

public class StarvationBlockedIndefinitely implements Runnable {

	public synchronized void A(int x) throws InterruptedException {
		System.out.println(Thread.currentThread().getName() + ":: value" + x);
		for (int i = 0; i < 100000; i++)
			;
	}

	@Override
	public void run() {
		String str = Thread.currentThread().getName();
		try {
			switch (str) {
			case "xy":
				for (int i = 0; i < 10; i++)
					A(i);
				break;
			case "yz":
				A(1);
			}
		} catch (InterruptedException e) {
		}
	}

}
