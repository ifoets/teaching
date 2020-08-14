package com.design.analysis.algorithms.interview.java8;

interface I1 {
	public default void show() {
		System.out.println("I1");
	}
}

interface I2 {
	public default void show() {
		System.out.println("I2");
	}
}

public class Dimond implements I1, I2 {

	public void show() {
		System.out.println("Dimond");
	}

	public static void main(String[] args) {

		I1 i1 = new Dimond();
		i1.show();
		I2 i2 = new Dimond();
		i2.show();
		Dimond d = new Dimond();
		d.show();
	}
}
