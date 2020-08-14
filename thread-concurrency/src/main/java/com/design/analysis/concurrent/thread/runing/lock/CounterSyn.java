package com.design.analysis.concurrent.thread.runing.lock;

public class CounterSyn implements Runnable {

	private int count = 0;

	public int inc() {
		synchronized (this) {
			return ++count;
		}
	}

	@Override
	public void run() {
		String str = Thread.currentThread().getName();
		System.out.println(str + " :: " + inc());
	}
}
