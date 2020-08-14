package com.design.analysis.concurrent.thread.runing.semaphore;

public class SimpleSemaphore implements Runnable {

	int value = 0;
	private boolean signal = false;

	public synchronized void take() {
		this.signal = true;
		this.notify();
		System.out.println(Thread.currentThread().getName() + ":: take value" + value);
		;
	}

	public synchronized void release() throws InterruptedException {
		while (!this.signal)
			wait();
		System.out.println(Thread.currentThread().getName() + ":: set value:" + ++value);
		this.signal = false;
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
