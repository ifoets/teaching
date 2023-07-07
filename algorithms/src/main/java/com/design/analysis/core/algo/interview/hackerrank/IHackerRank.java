package com.design.analysis.core.algo.interview.hackerrank;

public interface IHackerRank {

	/**
	 * find the number n who satisfy n = sqr(a)+sqr(b), n= sqr(c)+2*sqr(d) and
	 * n=sqr(e)+2*sqr(f)
	 */

	public int countSpecialNo(int n);

	public boolean specialNumber(int n);

	public boolean firstConstrant(int n, int N);

	public boolean secondConstrant(int n, int N);

	public boolean thirdConstrant(int n, int N);

	public boolean fourthConstrant(int n, int N);
}
