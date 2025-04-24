package com.udemy.basic.generic.creation;

public class Bin<X, Y> {

	private X x;

	private Y y;

	public Bin(X x, Y y) {
		super();
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		return "Bin [x=" + x + ", y=" + y + "]";
	}

}
