package com.design.analysis.concurrent.thread.runing;

public class ReentranceExample implements Runnable {

	public synchronized void outer(String thread) {
		System.out.println(thread + ":: int outer()");
		for (int i = 0; i < 1000; i++)
			;
		inner(thread);
	}

	public synchronized void inner(String thread) {
		System.out.println(thread + ":: int inner()");
		for (int i = 0; i < 1000; i++)
			;
	}

	@Override
	public void run() {
		String str = Thread.currentThread().getName();

		switch (str) {
		case "a":
			outer(str);
			break;
		case "b":
			outer(str);
			break;
		case "c":
			outer(str);
			break;
		case "d":
			outer(str);
			break;
		case "e":
			outer(str);
			break;
		}

	}

}
