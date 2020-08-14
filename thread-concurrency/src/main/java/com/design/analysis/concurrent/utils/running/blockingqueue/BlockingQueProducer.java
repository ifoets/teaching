package com.design.analysis.concurrent.utils.running.blockingqueue;

import java.util.concurrent.BlockingQueue;

public class BlockingQueProducer implements Runnable {

	protected BlockingQueue<String> queue = null;

	public BlockingQueProducer(BlockingQueue<String> queue) {
		this.queue = queue;
	}

	public void run() {
		try {
			queue.put("1");
			Thread.sleep(1000);
			queue.put("2");
			Thread.sleep(1000);
			queue.put("3");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
