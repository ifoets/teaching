package com.design.analysis.concurrent.thread.runing.slipped;

public class AvoidSlippedLock {
	private boolean isLocked = true;

	public void lock() {
		synchronized (this) {
			while (isLocked) {
				try {
					this.wait();
				} catch (InterruptedException e) {
					// do nothing, keep waiting
				}
			}
			isLocked = true;
		}
	}

	public synchronized void unlock() {
		isLocked = false;
		this.notify();
	}
}
