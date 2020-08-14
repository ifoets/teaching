package com.design.analysis.concurrent.thread.runing;

public class MyRunnableNoThreadSafe implements Runnable {

	NotThreadSafe instance = null;

	public MyRunnableNoThreadSafe(NotThreadSafe instance) {
		this.instance = instance;
	}

	public void run() {
		this.instance.add("some text");
	}
}
