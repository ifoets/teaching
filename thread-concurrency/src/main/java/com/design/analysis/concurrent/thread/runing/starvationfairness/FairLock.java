package com.design.analysis.concurrent.thread.runing.starvationfairness;

import java.util.ArrayList;
import java.util.List;

//TODO for well understanding
public class FairLock {
	private boolean isLocked = false;
	private Thread lockingThread = null;
	private List<FairLocalLockUse> waitingThreads = new ArrayList<FairLocalLockUse>();

	public void lock() throws InterruptedException {
		FairLocalLockUse queueObject = new FairLocalLockUse();
		boolean isLockedForThisThread = true;
		synchronized (this) {
			waitingThreads.add(queueObject);
		}

		while (isLockedForThisThread) {
			synchronized (this) {
				isLockedForThisThread = isLocked || waitingThreads.get(0) != queueObject;
				if (!isLockedForThisThread) {
					isLocked = true;
					waitingThreads.remove(queueObject);
					lockingThread = Thread.currentThread();
					return;
				}
			}
			try {
				queueObject.doWait();
			} catch (InterruptedException e) {
				synchronized (this) {
					waitingThreads.remove(queueObject);
				}
				throw e;
			}
		}
	}

	public synchronized void unlock() {
		if (this.lockingThread != Thread.currentThread()) {
			throw new IllegalMonitorStateException("Calling thread has not locked this lock");
		}
		isLocked = false;
		lockingThread = null;
		if (waitingThreads.size() > 0) {
			waitingThreads.get(0).doNotify();
		}
	}
}
