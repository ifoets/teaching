package com.design.analysis.core.algo.string.node;

public class Node {
	public char dt;
	public Node lt, rt;

	public Node(char dt) {
		this.dt = dt;
		this.lt = null;
		this.rt = null;
	}
}
