package com.design.analysis.concurrent.thread.runing;

import java.util.concurrent.atomic.AtomicBoolean;

public class CompAndSwapByAtomic implements Runnable {
	private AtomicBoolean locked = new AtomicBoolean(false);

	public boolean lock() {
		return locked.compareAndSet(false, true);
	}

	@Override
	public void run() {
		String str = Thread.currentThread().getName();
		System.out.println(str + " ::" + lock());
	}
}
