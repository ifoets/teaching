package com.design.analysis.concurrent.thread.runing;

public class ImmutableValue implements Runnable {

	private int value = 0;

	public ImmutableValue(int value) {
		this.value = value;
	}

	public int getValue() {
		return this.value;
	}

	public ImmutableValue add(int valueToAdd) {
		return new ImmutableValue(this.value + valueToAdd);
	}

	@Override
	public void run() {
		System.out.println(value);
	}
}
