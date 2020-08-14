package com.design.analysis.concurrent.thread.runing;

public class CounterThread extends Thread {

	protected SchCounter counter = null;

	public CounterThread(SchCounter counter) {
		this.counter = counter;
	}

	@Override
	public void run() {
		counter.add(0);
	}
}
