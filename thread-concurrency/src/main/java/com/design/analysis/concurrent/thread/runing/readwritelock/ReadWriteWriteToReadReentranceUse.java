package com.design.analysis.concurrent.thread.runing.readwritelock;

import com.design.analysis.concurrent.thread.runing.lock.Lock;

public class ReadWriteWriteToReadReentranceUse implements Runnable{

	private Lock lock = new Lock();
	private int count = 0;

	public int inc() throws InterruptedException {
		lock.lock();
		int newCount = ++count;
		lock.unlock();
		return newCount;
	}

	@Override
	public void run() {
		String str = Thread.currentThread().getName();
		try {
			System.out.println(str + " :: " + inc());
		} catch (InterruptedException e) {
		}
	}
}
