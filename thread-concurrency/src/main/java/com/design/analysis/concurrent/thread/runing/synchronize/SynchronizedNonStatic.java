package com.design.analysis.concurrent.thread.runing.synchronize;

public class SynchronizedNonStatic implements Runnable {
	@Override
	public void run() {
		log1();
		log2();
		log3();
		log4();
	}

	public synchronized void log1() {
		System.out.println("log1() :" + Thread.currentThread().getName());
	}

	public void log2() {
		synchronized (this) {
			System.out.println("log2() :" + Thread.currentThread().getName());
		}
	}

	public synchronized void log3() {
		System.out.println("log3() :" + Thread.currentThread().getName());
	}

	public void log4() {
		synchronized (this) {
			System.out.println("log4() :" + Thread.currentThread().getName());
		}
	}
}
