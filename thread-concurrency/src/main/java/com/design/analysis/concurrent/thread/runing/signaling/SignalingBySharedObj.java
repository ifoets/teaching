package com.design.analysis.concurrent.thread.runing.signaling;

public class SignalingBySharedObj implements Runnable {

	protected boolean hasDataToProcess = false;
	protected SignalingBySharedObj sharedSignal;

	int a[] = null;

	public SignalingBySharedObj() {
	}

	public SignalingBySharedObj(SignalingBySharedObj sharedSignal) {

		this.sharedSignal = sharedSignal;
	}

	public synchronized boolean hasDataToProcess() {
		return this.hasDataToProcess;
	}

	public synchronized void setHasDataToProcess(boolean hasData) {
		this.hasDataToProcess = hasData;
	}

	public void filldataAndSendSignal() {
		a = new int[10];
		for (int i = 0; i < a.length; i++)
			a[i] = i;
		setHasDataToProcess(true);
	}

	// busy waiting
	public void accessDataAfterGetSignla() {
		while (!sharedSignal.hasDataToProcess()) {
			System.out.println();
			for (int i = 0; i < a.length; i++)
				System.out.print(a[i]+"->");
		}
	}

	@Override
	public void run() {

		String str = Thread.currentThread().getName();

		switch (str) {
		case "xy":
			filldataAndSendSignal();
			break;
		case "yz":
			accessDataAfterGetSignla();
		}
	}
}
