package com.design.analysis.core.algo.greedyalgorithms.model;

public class HuffmanNode {

	public int data;
	public char c;
	public HuffmanNode lt, rt;

	public HuffmanNode(int data, char c) {
		this.data = data;
		this.c = c;
		this.lt = this.rt = null;
	}

}
