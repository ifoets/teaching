package com.design.analysis.concurrent.utils.running.blockingqueue;

import java.util.concurrent.BlockingQueue;

public class PriorityBlockingConsumer implements Runnable {
	BlockingQueue<Integer> queue;

	public PriorityBlockingConsumer(BlockingQueue<Integer> queue) {
		this.queue = queue;
	}

	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			try {
				System.out.println(queue.take());
			} catch (Exception e) {
			}
		}
	}
}
