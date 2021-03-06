package com.design.analysis.concurrent.thread.runing.slipped;

public class AvoidSlippedFairLockUse implements Runnable {

	AvoidSlippedFairLock lock = new AvoidSlippedFairLock();

	public void A() throws InterruptedException {
		lock.lock();
		System.out.println(Thread.currentThread().getName() + "::  used lock");
		lock.unlock();
	}

	@Override
	public void run() {
		String str = Thread.currentThread().getName();
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
