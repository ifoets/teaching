package com.design.analysis.concurrent.thread.runing.lock;

public class UnlockFromFinallyBlock implements Runnable {

	private Lock lock = new Lock();
	private int count = 0;

	public int inc() {
		int newCount = 0;
		try {
			lock.lock();
			newCount = ++count;
		} catch (InterruptedException e) {
		} finally {
			lock.unlock();
		}
		return newCount;
	}

	@Override
	public void run() {
		String str = Thread.currentThread().getName();

		System.out.println(str + " :: " + inc());
	}
}
