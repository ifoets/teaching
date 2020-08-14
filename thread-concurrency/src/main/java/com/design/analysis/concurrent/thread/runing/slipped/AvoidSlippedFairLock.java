package com.design.analysis.concurrent.thread.runing.slipped;

import java.util.ArrayList;
import java.util.List;

import com.design.analysis.concurrent.thread.runing.starvationfairness.QueueObject;

public class AvoidSlippedFairLock {
	private boolean isLocked = false;
	private Thread lockingThread = null;
	private List<QueueObject> waitingThreads = new ArrayList<QueueObject>();

	public void lock() throws InterruptedException {
		QueueObject queueObject = new QueueObject();

		synchronized (this) {
			waitingThreads.add(queueObject);
		}

		boolean mustWait = true;
		while (mustWait) {

			synchronized (this) {
				mustWait = isLocked || waitingThreads.get(0) != queueObject;
				if (!mustWait) {
					waitingThreads.remove(queueObject);
					isLocked = true;
					lockingThread = Thread.currentThread();
					return;
				}
			}

			synchronized (queueObject) {
				if (mustWait) {
					try {
						queueObject.wait();
					} catch (InterruptedException e) {
						waitingThreads.remove(queueObject);
						throw e;
					}
				}
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
			QueueObject queueObject = waitingThreads.get(0);
			synchronized (queueObject) {
				queueObject.notify();
			}
		}
	}
}
