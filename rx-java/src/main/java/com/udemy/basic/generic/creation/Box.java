package com.udemy.basic.generic.creation;

import java.util.List;

public class Box<T> {

	private List<T> a;

	public Box(List<T> a) {
		super();
		this.a = a;
	}

	public List<T> getA() {
		return a;
	}

	public void setA(List<T> a) {
		this.a = a;
	}

}
