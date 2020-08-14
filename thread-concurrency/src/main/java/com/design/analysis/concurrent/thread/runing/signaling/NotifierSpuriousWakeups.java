package com.design.analysis.concurrent.thread.runing.signaling;

public class NotifierSpuriousWakeups implements Runnable {
	private Message msg;

	public NotifierSpuriousWakeups(Message msg) {
		this.msg = msg;
	}

	@Override
	public void run() {
		String name = Thread.currentThread().getName();
		System.out.println(name + " started");
		try {
			Thread.sleep(0);
			synchronized (msg) {
				msg.setMsg(name + " Notifier work done");
				if (!msg.isNotifyAll())
					msg.notify();
				else
					msg.notifyAll();

				msg.setWasSignalled(true);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
