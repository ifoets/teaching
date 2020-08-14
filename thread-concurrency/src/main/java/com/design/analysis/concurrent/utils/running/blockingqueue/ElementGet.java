package com.design.analysis.concurrent.utils.running.blockingqueue;

import java.util.concurrent.BlockingDeque;

public class ElementGet implements Runnable {
	public BlockingDeque<String> bd;
	int count = 0;

	public ElementGet(BlockingDeque<String> bd) {
		this.bd = bd;
	}

	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			try {
				bd.put("A" + i);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
