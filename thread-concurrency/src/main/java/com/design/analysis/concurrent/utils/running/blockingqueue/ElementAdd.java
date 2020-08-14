package com.design.analysis.concurrent.utils.running.blockingqueue;

import java.util.concurrent.BlockingDeque;

public class ElementAdd implements Runnable {
	public BlockingDeque<String> bd;
	int count = 0;

	public ElementAdd(BlockingDeque<String> bd) {
		this.bd = bd;
	}

	@Override
	public void run() {
		for (;;) {
			try {
				String s = bd.take();
				System.out.println("Element received is: " + s);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
