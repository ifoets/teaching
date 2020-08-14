package com.design.analysis.concurrent.thread.runing.slipped;

public class SlippedlockUse implements Runnable {

	SlippedLock lock = new SlippedLock();

	public void A() throws InterruptedException {
		lock.lock();
		System.out.println(Thread.currentThread().getName() + "::  used lock");
		lock.unlock();
	}

	@Override
	public void run() {
		String str = Thread.currentThread().getName();
		//System.out.println(str + "  ::Thread called run()");
		try {
			switch (str) {
			case "xy":
				A();
				break;
			case "yz":
				A();
				break;
			case "zx":
				A();
			}
		} catch (InterruptedException e) {
		}
	}
}
