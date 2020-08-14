package com.design.analysis.algo.node;

public class Point {

	public int x, y;

	public Point(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	@Override
	public int hashCode() {
		return x + y;
	}

	@Override
	public boolean equals(Object obj) {
		Point other = (Point) obj;
		return other.x == x && other.y == y;
	}
}
