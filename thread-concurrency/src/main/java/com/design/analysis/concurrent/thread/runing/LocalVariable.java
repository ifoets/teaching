package com.design.analysis.concurrent.thread.runing;

public class LocalVariable implements Runnable {

	@Override
	public void run() {
		int i = 5;
		i++;
		System.out.println(i);

	}

	public void loacalVariable() {
		int i = 0;
		i++;
		System.out.println(i);
	}

}
