package com.design.analysis.concurrent.utils.running.blockingqueue;

import java.util.concurrent.BlockingQueue;

public class BlockingQueConsumer implements Runnable {
	protected BlockingQueue<String> queue = null;

	public BlockingQueConsumer(BlockingQueue<String> queue) {
		this.queue = queue;
	}

	public void run() {
		try {
			System.out.println(queue.take());
			System.out.println(queue.take());
			System.out.println(queue.take());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
