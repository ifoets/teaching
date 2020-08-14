package com.design.analysis.concurrent.thread.runing;

public class Counter implements Runnable {

	protected long count = 0;

	@Override
	public void run() {
		System.out.println(count);
	}

	public void add(long value) {
		this.count = this.count + value;
	}
}
