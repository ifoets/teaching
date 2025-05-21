package com.udemy.basic.generic.creation;

public class LNodeUnbounded<E> {

	private E data;
	/*
	 * <? extends Y> means Type parameter either Y or sub type of Y
	 */
	private LNodeUnbounded<?> next;

	public LNodeUnbounded(E data, LNodeUnbounded<?> next) {
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

	public LNodeUnbounded<?> getNext() {
		return next;
	}

	public void setNext(LNodeUnbounded<?> next) {
		this.next = next;
	}

	@Override
	public String toString() {
		return "LNode [data=" + data + ", next=" + next + "]";
	}

}
