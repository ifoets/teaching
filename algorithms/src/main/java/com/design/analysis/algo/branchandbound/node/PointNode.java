package com.design.analysis.algo.branchandbound.node;

import com.design.analysis.algo.branchandbound.model.Point;

public class PointNode {

	public Point p;
	public int level;
	public double dist; // distance between points

	public PointNode(Point p) {
		this.level = -1;
		this.p = p;
		this.dist = Integer.MAX_VALUE;
	}
}
