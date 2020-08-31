package com.design.analysis.hackerrank.algo.easy.warmup;

import java.util.Arrays;
import java.util.List;

public class EasyWarmupImpl implements IEasyWarmup {

	/** Compare the Triplets **/
	@Override
	public List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {
		Integer rl[] = new Integer[] { 0, 0 };
		for (int i = 0, n = a.size() == b.size() ? a.size() : 0; i < n; i++) {
			if (a.get(i) > b.get(i))
				rl[0]++;
			else if (a.get(i) < b.get(i))
				rl[1]++;
		}
		return Arrays.asList(rl);
	}

	/** A Very Big Sum **/
	@Override
	public long aVeryBigSum(long[] ar) {
		long sum = 0;
		for (long l : ar)
			sum += l;
		return sum;
	}

	@Override
	/** Diagonal Difference [n][m] */
	public int diagonalDifference(List<List<Integer>> arr) {

		int N = arr.size();
		int M = arr.get(0).size();
		int X = (N - 1 + N - 1) / 2;
		int d1 = 0;
		int d2 = 0;
		for (int i = 0; i < N; i++) {
			// no need iterate and check internal if without validation
			for (int j = 0; (i == j || i + j == X) || j < M; j++) {
				if (i == j)
					d1 += arr.get(i).get(j);
				if (i + j == X)
					d2 += arr.get(i).get(j);
			}
		}
		return (int) Math.abs(d1 - d2);
	}
}
