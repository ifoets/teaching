package com.design.analysis.concurrent.thread.runing.readwritelock;

import java.util.HashMap;
import java.util.Map;

public class ReadWriteReadToWriteReentrance {
	private Map<Thread, Integer> readingThreads = new HashMap<Thread, Integer>();

	private int writeAccesses = 0;
	@SuppressWarnings("unused")
	private int writeRequests = 0;
	private int readers = 0;
	private Thread writingThread = null;

	public synchronized void lockWrite() throws InterruptedException {
		writeRequests++;
		Thread callingThread = Thread.currentThread();
		while (!canGrantReadAccess(callingThread)) {
			wait();
		}
		writeRequests--;
		writeAccesses++;
		writingThread = callingThread;
	}

	public synchronized void unlockWrite() throws InterruptedException {
		writeAccesses--;
		if (writeAccesses == 0) {
			writingThread = null;
		}
		notifyAll();
	}

	private boolean canGrantReadAccess(Thread callingThread) {
		if (isWriter(callingThread))
			return true;
		if (writingThread != null)
			return false;
		if (isReader(callingThread))
			return true;
		if (writeRequests > 0)
			return false;
		return true;
	}

	@SuppressWarnings("unused")
	private boolean hasReaders() {
		return readingThreads.size() > 0;
	}

	private boolean isWriter(Thread callingThread) {
		return writingThread == callingThread;
	}

	@SuppressWarnings("unused")
	private boolean isOnlyReader(Thread callingThread) {
		return readers == 1 && readingThreads.get(callingThread) != null;
	}

	private boolean isReader(Thread callingThread) {
		return readingThreads.get(callingThread) != null;
	}
}
