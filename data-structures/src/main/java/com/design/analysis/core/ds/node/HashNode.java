package com.design.analysis.core.ds.node;

public class HashNode {

	public int key;
	public String value;
	public HashNode next;

	public HashNode(int key, String value) {
		super();
		this.key = key;
		this.value = value;
		this.next = null;
	}

	@Override
	public String toString() {
		return "HashNode [key=" + key + ", value=" + value + "]";
	}
}
