package com.design.analysis.concurrent.utils.running.blockingqueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadLocalRandom;

public class PriorityBlockingProducer implements Runnable {
	BlockingQueue<Integer> queue;

	public PriorityBlockingProducer(BlockingQueue<Integer> queue) {
		this.queue = queue;
	}

	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			try {
				queue.put(ThreadLocalRandom.current().nextInt(0, 1000));
			} catch (Exception e) {
			}
		}
	}
}
