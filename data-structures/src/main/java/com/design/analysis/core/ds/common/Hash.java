package com.design.analysis.core.ds.common;

public class Hash {
	
	public int size; // size of bucket
	public AdjHashList[] array;

	public Hash(int size) {
		super();
		this.size = size;
		array = new AdjHashList[size];
		for (int i = 0; i < size; i++) {
			array[i] = new AdjHashList();
			array[i].head = null;
		}
	}
}
