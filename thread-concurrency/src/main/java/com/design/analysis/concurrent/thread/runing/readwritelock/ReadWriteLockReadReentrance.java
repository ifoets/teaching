package com.design.analysis.concurrent.thread.runing.readwritelock;

import java.util.HashMap;
import java.util.Map;

public class ReadWriteLockReadReentrance {
	private Map<Thread, Integer> readingThreads = new HashMap<Thread, Integer>();

	private int writers = 0;
	private int writeRequests = 0;

	public synchronized void lockRead() throws InterruptedException {
		Thread callingThread = Thread.currentThread();
		while (!canGrantReadAccess(callingThread)) {
			wait();
		}

		readingThreads.put(callingThread, (getReadAccessCount(callingThread) + 1));
	}

	public synchronized void unlockRead() {
		Thread callingThread = Thread.currentThread();
		int accessCount = getReadAccessCount(callingThread);
		if (accessCount == 1) {
			readingThreads.remove(callingThread);
		} else {
			readingThreads.put(callingThread, (accessCount - 1));
		}
		notifyAll();
	}

	public synchronized void lockWrite() throws InterruptedException {
		writeRequests++;

		while (readingThreads.size() > 0 || writers > 0) {
			wait();
		}
		writeRequests--;
		writers++;
	}

	public synchronized void unlockWrite() throws InterruptedException {
		writers--;
		notifyAll();
	}

	private boolean canGrantReadAccess(Thread callingThread) {
		if (writers > 0)
			return false;
		if (isReader(callingThread))
			return true;
		if (writeRequests > 0)
			return false;
		return true;
	}

	private int getReadAccessCount(Thread callingThread) {
		Integer accessCount = readingThreads.get(callingThread);
		if (accessCount == null)
			return 0;
		return accessCount.intValue();
	}

	private boolean isReader(Thread callingThread) {
		return readingThreads.get(callingThread) != null;
	}
}
