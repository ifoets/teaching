package com.design.analysis.concurrent.thread.runing.semaphore;

public class BoundedSemaphore implements Runnable {

	private int signals = 0;
	private int bound = 0;

	public BoundedSemaphore(int upperBound) {
		this.bound = upperBound;
	}

	public synchronized void take() throws InterruptedException {
		while (this.signals == bound)
			wait();
		this.signals++;
		System.out.println(Thread.currentThread().getName() + ":: take value" + this.signals);
		this.notify();
	}

	public synchronized void release() throws InterruptedException {
		while (this.signals == 0)
			wait();
		this.signals--;
		System.out.println(Thread.currentThread().getName() + ":: set value:" + this.signals);
		this.notify();
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
			case "e":
				release();
				break;
			case "f":
				take();
				break;
			}
		} catch (InterruptedException e) {
		}
	}
}
