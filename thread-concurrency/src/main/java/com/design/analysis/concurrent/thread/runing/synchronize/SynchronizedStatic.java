package com.design.analysis.concurrent.thread.runing.synchronize;

public class SynchronizedStatic implements Runnable {

	@Override
	public void run() {
		log1();
		log2();
		log3();
		log4();

	}

	public static synchronized void log1() {
		System.out.println("log1() :" + Thread.currentThread().getName());
	}

	public static void log2() {
		synchronized (SynchronizedStatic.class) {
			System.out.println("log2() :" + Thread.currentThread().getName());
		}
	}

	public static synchronized void log3() {
		System.out.println("log3() :" + Thread.currentThread().getName());
	}

	public static void log4() {
		synchronized (SynchronizedStatic.class) {
			System.out.println("log4() :" + Thread.currentThread().getName());
		}
	}
}
