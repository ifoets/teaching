package com.design.analysis.concurrent.thread.runing.synchronize;

public class SynchronizedStaticContineous implements Runnable {

	@Override
	public void run() {
		log1();

	}

	public static synchronized void log1() {
		System.out.println("log1() :" + Thread.currentThread().getName());
		log2();
	}

	public static void log2() {
		synchronized (SynchronizedStaticContineous.class) {
			System.out.println("log2() :" + Thread.currentThread().getName());
			log3();
		}
	}

	public static synchronized void log3() {
		System.out.println("log3() :" + Thread.currentThread().getName());
		log4();
	}

	public static void log4() {
		synchronized (SynchronizedStaticContineous.class) {
			System.out.println("log4() :" + Thread.currentThread().getName());
		}
	}
}
