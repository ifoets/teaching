package com.design.analysis.company.preparation.model;

public class LNode implements Comparable<LNode> {

	public int dt;
	public LNode next;

	public LNode(int dt, LNode next) {
		super();
		this.dt = dt;
		this.next = next;
	}

	@Override
	public int compareTo(LNode o) {
		return (this.next.equals(o.next) && this.dt == o.dt) ? 0 : -1;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + dt;
		result = prime * result + ((next == null) ? 0 : next.hashCode1());
		return result;
	}

	public int hashCode1() {
		final int prime = 31;
		int result = 1;
		result = prime * result + dt;
		result = prime * result;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LNode other = (LNode) obj;
		if (dt != other.dt)
			return false;
		if (next == null) {
			if (other.next != null)
				return false;
		} else if (!next.equals(other.next))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return dt + "->";
	}

}
