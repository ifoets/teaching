package com.udemy.basic.generic.creation;

public class LNodeLowerBound<E> {

	private E data;
	/*
	 * <? super X> Type parameter is either X or super type of X
	 */
	private LNodeUnbounded<? super Integer> next;

	public LNodeLowerBound(E data, LNodeUnbounded<? super Integer> next) {
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

	public LNodeUnbounded<? super Integer> getNext() {
		return next;
	}

	public void setNext(LNodeUnbounded<? super Integer> next) {
		this.next = next;
	}

	@Override
	public String toString() {
		return "LNode [data=" + data + ", next=" + next + "]";
	}

}
