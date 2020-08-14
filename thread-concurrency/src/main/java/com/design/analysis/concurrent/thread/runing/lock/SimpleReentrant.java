package com.design.analysis.concurrent.thread.runing.lock;

public class SimpleReentrant implements Runnable {

	int counter = 0;
	Lock lock = new Lock();

	public void outer() throws InterruptedException {
		lock.lock();
		inner();
		lock.unlock();
	}

	public synchronized void inner() throws InterruptedException {
		//lock.lock();
		counter++;
		System.out.println(Thread.currentThread().getName() + ":: " + counter);
		//lock.unlock();
	}

	@Override
	public void run() {
		try {
			outer();
		} catch (InterruptedException e) {
		}
	}
}
