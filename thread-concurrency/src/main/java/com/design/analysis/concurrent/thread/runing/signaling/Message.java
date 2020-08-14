package com.design.analysis.concurrent.thread.runing.signaling;

public class Message {
	private String msg;
	private boolean isNotifyAll = false;
	private String myMonitorObject = "";
	private boolean wasSignalled;

	public Message(String str) {
		this.msg = str;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String str) {
		this.msg = str;
	}

	public boolean isNotifyAll() {
		return isNotifyAll;
	}

	public void setNotifyAll(boolean isNotifyAll) {
		this.isNotifyAll = isNotifyAll;
	}

	public String getMyMonitorObject() {
		return myMonitorObject;
	}

	public void setMyMonitorObject(String myMonitorObject) {
		this.myMonitorObject = myMonitorObject;
	}

	public boolean isWasSignalled() {
		return wasSignalled;
	}

	public void setWasSignalled(boolean wasSignalled) {
		this.wasSignalled = wasSignalled;
	}
}
