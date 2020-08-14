package com.design.analysis.concurrent.thread.runing.slipped;

public class SlippedLock {
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
		}

		synchronized (this) {
			isLocked = true;
		}
	}

	public synchronized void unlock() {
		isLocked = false;
		this.notify();
	}
}
