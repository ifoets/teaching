package com.design.analysis.concurrent.thread.runing.readwritelock;

public class ReadWriteLockReadReentranceUse implements Runnable {

	private ReadWriteLockReadReentrance lock = new ReadWriteLockReadReentrance();
	private int count = 0;

	public int write() throws InterruptedException {
		lock.lockWrite();
		int newCount = ++count;
		lock.unlockWrite();
		return newCount;
	}

	public int readExternal() throws InterruptedException {
		lock.lockRead();
		int newCount = readInternal();
		lock.unlockRead();
		return newCount;
	}

	public int readInternal() throws InterruptedException {
		lock.lockRead();
		int newCount = 1 + count;
		lock.unlockRead();
		return newCount;
	}

	@Override
	public void run() {
		String str = Thread.currentThread().getName();
		try {
			switch (str) {
			case "a":
				System.out.println(str + ": Read External:" + readExternal());
				break;
			case "b":
				System.out.println(str + ": Write:" + write());
				break;
			case "c":
				System.out.println(str + ": Read Internal:" + readInternal());
				break;
			case "d":
				System.out.println(str + ": Write:" + write());
				break;
			case "e":
				System.out.println(str + ": Read Exteranl:" + readExternal());
				break;
			}
		} catch (InterruptedException e) {
		}
	}
}
