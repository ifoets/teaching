package com.design.analysis.concurrent.thread.runing.nestedmonitor;

public class NestedMointorFairLockUse implements Runnable {

	NestedMonitorFairLock lock = new NestedMonitorFairLock();

	private boolean isNotified = false;

	public synchronized void doWait() throws InterruptedException {
		while (!isNotified) {
			this.wait();
		}
		this.isNotified = false;
	}

	public synchronized void doNotify() {
		this.isNotified = true;
		this.notify();
	}

	public boolean equals(Object o) {
		return this == o;
	}

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
