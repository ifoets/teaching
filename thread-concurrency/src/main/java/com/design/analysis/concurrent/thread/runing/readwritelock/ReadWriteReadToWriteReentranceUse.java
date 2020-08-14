package com.design.analysis.concurrent.thread.runing.readwritelock;

public class ReadWriteReadToWriteReentranceUse implements Runnable {

	private ReadWriteReadToWriteReentrance lock = new ReadWriteReadToWriteReentrance();
	private int count = 0;

	public int write() throws InterruptedException {
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
				System.out.println(str + ": Read External:" + read());
				break;
			case "b":
				read();
				System.out.println(str + ": Write:" + write());
				break;
			case "c":
				System.out.println(str + ": Read:" + read());
				break;
			case "d":
				read();
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
