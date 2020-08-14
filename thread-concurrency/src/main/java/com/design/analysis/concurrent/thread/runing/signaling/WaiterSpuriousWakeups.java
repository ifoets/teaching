package com.design.analysis.concurrent.thread.runing.signaling;

public class WaiterSpuriousWakeups implements Runnable {

	private Message msg;

	public WaiterSpuriousWakeups(Message m) {
		this.msg = m;
	}

	@Override
	public void run() {
		String name = Thread.currentThread().getName();
		synchronized (msg) {
			while (!msg.isWasSignalled()) {
				try {
					System.out.println(name + " waiting to get notified at time:" + System.currentTimeMillis());
					msg.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			// clear signal and continue running.
			msg.setWasSignalled(false);
			System.out.println(name + " waiter thread got notified at time:" + System.currentTimeMillis());
			// process the message now
			System.out.println(name + " processed: " + msg.getMsg());
		}
	}

}
