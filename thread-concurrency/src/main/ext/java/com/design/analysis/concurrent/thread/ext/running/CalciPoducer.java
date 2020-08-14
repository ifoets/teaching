package com.design.analysis.concurrent.thread.ext.running;

import java.util.concurrent.BlockingQueue;

public class CalciPoducer implements Runnable {

	public BlockingQueue<Integer> sharedQueue;
	
	public CalciPoducer(BlockingQueue<Integer> sharedQueue) {
		this.sharedQueue = sharedQueue;
	}

	@Override
	public void run() {

		while (true) {
			synchronized (this) {
				try {
					
					while (sharedQueue.size() == 0)
						wait();
					System.out.println("Your result is" + sharedQueue.take());
					notify();
					//Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
