package com.design.analysis.concurrent.thread.runing.semaphore;

public class CountingSemaphore implements Runnable {
	private int signals = 0;

	public synchronized void take() {

		System.out.println(Thread.currentThread().getName() + ":: take value" + ++this.signals);
		this.notify();
	}

	public synchronized void release() throws InterruptedException {
		while (this.signals == 0)
			wait();
		System.out.println(Thread.currentThread().getName() + ":: set value:" + --this.signals);
	}

	@Override
	public void run() {
		String str = Thread.currentThread().getName();

		try {
			switch (str) {
			case "a":
				release();
				break;
			case "b":
				take();
				break;
			case "c":
				release();
				break;
			case "d":
				take();
				break;
			}
		} catch (InterruptedException e) {
		}
	}
}
