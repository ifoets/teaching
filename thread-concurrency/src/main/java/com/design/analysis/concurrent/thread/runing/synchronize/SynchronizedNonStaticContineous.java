package com.design.analysis.concurrent.thread.runing.synchronize;

public class SynchronizedNonStaticContineous implements Runnable {
	@Override
	public void run() {
		log1();

	}

	public synchronized void log1() {
		System.out.println("log1() :" + Thread.currentThread().getName());
		log2();
	}

	public void log2() {
		synchronized (this) {
			System.out.println("log2() :" + Thread.currentThread().getName());
			log3();
		}
	}

	public synchronized void log3() {
		System.out.println("log3() :" + Thread.currentThread().getName());
		log4();
	}

	public void log4() {
		synchronized (this) {
			System.out.println("log4() :" + Thread.currentThread().getName());
		}
	}
}
