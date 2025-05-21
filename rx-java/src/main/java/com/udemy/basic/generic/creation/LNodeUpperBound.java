package com.udemy.basic.generic.creation;

public class LNodeUpperBound<E> {

	private E data;

	private LNodeUnbounded<? extends Number> next;

	public LNodeUpperBound(E data, LNodeUnbounded<? extends Number> next) {
		super();
		this.data = data;
		this.next = next;
	}

	public E getData() {
		return data;
	}

	public void setData(E data) {
		this.data = data;
	}

	public LNodeUnbounded<? extends Number> getNext() {
		return next;
	}

	public void setNext(LNodeUnbounded<? extends Number> next) {
		this.next = next;
	}

	@Override
	public String toString() {
		return "LNode [data=" + data + ", next=" + next + "]";
	}

}
