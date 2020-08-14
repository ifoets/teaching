package com.design.analysis.concurrent.thread.runing;

public class SimpleComAndSwap implements Runnable {

	private boolean locked = false;

	public synchronized boolean lock() {
		System.out.println(Thread.currentThread().getName() + " :: " + locked);
		if (!locked) {
			locked = true;
			return true;
		}
		return false;
	}

	@Override
	public void run() {
		locked = lock();
	}
}
