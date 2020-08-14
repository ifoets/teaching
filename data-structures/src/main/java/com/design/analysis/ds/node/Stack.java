package com.design.analysis.ds.node;

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
