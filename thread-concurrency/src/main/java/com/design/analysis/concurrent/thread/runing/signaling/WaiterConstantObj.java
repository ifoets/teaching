package com.design.analysis.concurrent.thread.runing.signaling;

public class WaiterConstantObj implements Runnable {
	public String myMonitorObject = "";
	public static boolean wasSignalled = false;
	private Message msg;

	public WaiterConstantObj(Message m) {
		this.msg = m;
	}

	@Override
	public void run() {
		String name = Thread.currentThread().getName();
		synchronized (msg.getMyMonitorObject()) {
			while (!msg.isNotifyAll()) {
				try {
					System.out.println(name + " waiting to get notified at time:" + System.currentTimeMillis());
					msg.getMyMonitorObject().wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			// clear signal and continue running.
			msg.setNotifyAll(false);
			System.out.println(name + " waiter thread got notified at time:" + System.currentTimeMillis());
			// process the message now
			System.out.println(name + " processed: " + msg.getMsg());
		}
	}

}
