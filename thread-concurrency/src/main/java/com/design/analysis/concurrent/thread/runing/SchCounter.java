package com.design.analysis.concurrent.thread.runing;

public class SchCounter {

	public int count = 0;

	public synchronized void add(long value) {
		for (int i = 0; i < 10; i++) {
			System.out.println(Thread.currentThread().getName() + " :: " + i);
		}
	}
}
