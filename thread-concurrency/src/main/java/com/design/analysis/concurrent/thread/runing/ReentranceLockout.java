package com.design.analysis.concurrent.thread.runing;

public class ReentranceLockout implements Runnable {

	ReLockoutLock lock = new ReLockoutLock();

	public synchronized void outer(String thread) throws InterruptedException {
		lock.lock();
		System.out.println(thread + ":: int outer()");
		inner(thread);
		lock.unlock();
	}

	public synchronized void inner(String thread) throws InterruptedException {
		lock.lock();
		System.out.println(thread + ":: int inner()");
		lock.unlock();
	}

	@Override
	public void run() {
		String str = Thread.currentThread().getName();

		try {
			switch (str) {
			case "a":
				outer(str);
				break;
			case "b":
				outer(str);
				break;
			case "c":
				outer(str);
				break;
			case "d":
				outer(str);
				break;
			case "e":
				outer(str);
				break;
			}
		} catch (InterruptedException e) {
		}
	}
}

class ReLockoutLock {
	private boolean isLocked = false;

	public synchronized void lock() throws InterruptedException {
		while (isLocked) {
			wait();
		}
		isLocked = true;
	}

	public synchronized void unlock() {
		isLocked = false;
		notify();
	}
}