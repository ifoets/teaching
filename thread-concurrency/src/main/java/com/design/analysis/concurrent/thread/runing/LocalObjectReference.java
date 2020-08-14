package com.design.analysis.concurrent.thread.runing;

public class LocalObjectReference implements Runnable {

	@Override
	public void run() {
		someMethod();
	}

	public void someMethod() {

		LocalObject localObject = new LocalObject();
		method2(localObject);
		localObject.callMethod();
	}

	public void method2(LocalObject localObject) {
		localObject.setName("value");
	}
}

class LocalObject {

	public String name;

	public void callMethod() {
		System.out.println(name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
