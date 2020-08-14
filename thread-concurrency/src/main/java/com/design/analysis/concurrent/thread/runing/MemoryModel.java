package com.design.analysis.concurrent.thread.runing;

public class MemoryModel implements Runnable {

	public void run() {
		methodOne();
	}

	public void methodOne() {
		@SuppressWarnings("unused")
		int localVariable1 = 45;

		@SuppressWarnings("unused")
		MySharedObject localVariable2 = MySharedObject.sharedInstance;

		// ... do more with local variables.

		methodTwo();
	}

	@SuppressWarnings("unused")
	public void methodTwo() {
		@SuppressWarnings("deprecation")
		Integer localVariable1 = new Integer(99);

		// ... do more with local variable.
	}
}
