package com.design.analysis.algo.interview.hackerrank;

public class HackerRankImpl implements IHackerRank {

	public int countSpecialNo(int n) {
		int count = 0;
		for (int i = 193; i <= n; i++) {
			if (specialNumber(i)) {
				count++;
			}
		}
		return count;
	}

	public boolean specialNumber(int n) {
		int N = (int) Math.sqrt(n);
		if (fourthConstrant(n, N) && thirdConstrant(n, N) && secondConstrant(n, N) && firstConstrant(n, N))
			return true;
		return false;
	}

	public boolean firstConstrant(int n, int N) {

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= i; j++) {
				if (Math.pow(i, 2) + Math.pow(j, 2) == n)
					return true;
			}
		}
		return false;
	}

	public boolean secondConstrant(int n, int N) {

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= i; j++) {
				if (Math.pow(i, 2) + 2 * Math.pow(j, 2) == n || 2 * Math.pow(i, 2) + Math.pow(j, 2) == n)
					return true;
			}
		}
		return false;
	}

	public boolean thirdConstrant(int n, int N) {

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= i; j++) {
				if (Math.pow(i, 2) + 3 * Math.pow(j, 2) == n || 3 * Math.pow(i, 2) + Math.pow(j, 2) == n)
					return true;
			}
		}
		return false;
	}

	public boolean fourthConstrant(int n, int N) {

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= i; j++) {
				if (Math.pow(i, 2) + 7 * Math.pow(j, 2) == n || 7 * Math.pow(i, 2) + Math.pow(j, 2) == n)
					return true;
			}
		}
		return false;
	}
}
