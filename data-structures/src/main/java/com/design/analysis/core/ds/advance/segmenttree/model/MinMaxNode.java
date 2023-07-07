package com.design.analysis.core.ds.advance.segmenttree.model;

public class MinMaxNode {

	public int min;
	public int max;

	public MinMaxNode(int min, int max) {
		this.min = min;
		this.max = max;
	}

	@Override
	public String toString() {
		return "MinMaxNode [min=" + min + ", max=" + max + "]";
	}
}
