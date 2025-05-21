package com.udemy.basic.functional.demo;

public class ImpureFunction {

	private int value = 0;

	public int add(int maxValue) {
		this.value = maxValue;
		return this.value;
	}
}
