package com.design.analysis.core.ds.node;

//here data is int but it can be any custome object
public class USLinkListNode {

	public int size;
	public int arr[];// it is better to use ArrayList it will save the space too
	public USLinkListNode next;

	public USLinkListNode(int size, int[] arr) {
		super();
		this.size = size;
		this.arr = arr;
		this.next = null;
	}

	public USLinkListNode(int size) {
		super();
		this.size = size;
		this.arr = new int[size];
		this.next = null;
	}
}
