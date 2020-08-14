package com.design.analysis.concurrent.thread.runing.signaling;

public class NotifierConstantObj implements Runnable {
	private Message msg;

	public NotifierConstantObj(Message msg) {
		this.msg = msg;
	}

	@Override
	public void run() {
		String name = Thread.currentThread().getName();
		System.out.println(name + " started");
		try {
			Thread.sleep(0);
			synchronized (msg.getMyMonitorObject()) {
				msg.setMsg(name + " Notifier work done");
				if (!msg.isNotifyAll())
					msg.getMyMonitorObject().notify();
				else
					msg.getMyMonitorObject().notifyAll();

				msg.setNotifyAll(true);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
