package com.design.analysis.concurrent.thread.runing.readwritelock;

public class ReadWriteLockWriteReentranceUse implements Runnable {

	private ReadWriteLockWriteReentrance lock = new ReadWriteLockWriteReentrance();
	private int count = 0;

	public int writeExtrnal() throws InterruptedException {
		lock.lockWrite();
		int newCount = ++count;
		lock.unlockWrite();
		return newCount;
	}

	public int writeInternal() throws InterruptedException {
		lock.lockWrite();
		int newCount = ++count;
		lock.unlockWrite();
		return newCount;
	}

	public int read() throws InterruptedException {
		return count;
	}

	@Override
	public void run() {
		String str = Thread.currentThread().getName();
		try {
			switch (str) {
			case "a":
				System.out.println(str + ": Read :" + read());
				break;
			case "b":
				System.out.println(str + ": Write External:" + writeExtrnal());
				break;
			case "c":
				System.out.println(str + ": Read :" + read());
				break;
			case "d":
				System.out.println(str + ": Write Internal:" + writeInternal());
				break;
			case "e":
				System.out.println(str + ": Read:" + read());
				break;
			}
		} catch (InterruptedException e) {
		}
	}
}
