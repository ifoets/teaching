package com.design.analysis.concurrent.thread.runing.readwritelock;

public class ReadWriteLockUse implements Runnable {

	private ReadWriteLock lock = new ReadWriteLock();
	private int count = 0;

	public int write() throws InterruptedException {
		lock.lockWrite();
		int newCount = ++count;
		lock.unlockWrite();
		return newCount;
	}

	public int read() throws InterruptedException {
		lock.lockRead();
		int newCount = count;
		lock.unlockRead();
		return newCount;
	}

	@Override
	public void run() {
		String str = Thread.currentThread().getName();
		try {
			switch (str) {
			case "a":
				System.out.println(str + ": Read:" + read());
				break;
			case "b":
				System.out.println(str + ": Write:" + write());
				break;
			case "c":
				System.out.println(str + ": Read:" + read());
				break;
			case "d":
				System.out.println(str + ": Write:" + write());
				break;
			case "e":
				System.out.println(str + ": Read:" + read());
				break;
			}
		} catch (InterruptedException e) {
		}
	}
}
