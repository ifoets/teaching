package com.design.analysis.concurrent.thread.runing;

public class NotThreadSafe {

	StringBuilder builder = new StringBuilder();

	public void add(String text) {
		this.builder.append(text);
	}

	public void printText() {
		System.out.println(builder.toString());
	}
}