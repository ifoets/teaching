package com.design.analysis.core.ds.node;

public class Stack {
	public int top;
	public int size;
	public char[] arr;

	public Stack(int size) {
		super();
		this.size = size;
		arr = new char[size];
		top = -1;
	}
}
