package com.design.analysis.algo.array.model;

public class SmallestSum implements Comparable<SmallestSum> {
	public int ae1; // arr1 element
	public int ae2; // arr2 element
	public int sum; // sum of ae1 and ae2

	public SmallestSum(int ae1, int ae2) {
		this.ae1 = ae1;
		this.ae2 = ae2;
		this.sum = this.ae1 + this.ae2;
	}

	@Override
	public int compareTo(SmallestSum arg0) {
		return this.sum - arg0.sum;
	}

	@Override
	public String toString() {
		return "(" + ae1 + "," + ae2 + ")";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ae1;
		result = prime * result + ae2;
		result = prime * result + sum;
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
		SmallestSum other = (SmallestSum) obj;
		if (ae1 != other.ae1)
			return false;
		if (ae2 != other.ae2)
			return false;
		if (sum != other.sum)
			return false;
		return true;
	}
}
