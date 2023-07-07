package com.design.analysis.core.algo.matheticalalgorithms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PrimeFactAndDivisorImpl implements IPrimeFactAndDivisor {

	/** 1. Prime factors **/
	@Override
	public List<Integer> primeFactors(int n) {

		List<Integer> list = new ArrayList<>();
		for (int i = 2; i <= n / 2; i++) {
			if (n % i == 0) {
				list.add(i);
				n = n / i;
			}
		}
		if (n > 1)
			list.add(n);
		return list;
	}

	/** 2. Smith Numbers **/
	@Override
	public boolean isSmithNumber(int n) {

		List<Integer> list = primeFactors(n);
		int sum = 0;
		while (n > 0) {
			sum += n % 10;
			n /= 10;
		}
		for (Integer in : list) {
			if (in > 10) {

				while (in > 0) {
					sum -= in % 10;
					in /= 10;
				}
			} else {
				sum -= in;
			}
		}
		return sum == 0;
	}

	/** 3. Sphenic Number **/
	@Override
	public boolean isSphenicNumber(int n) {

		List<Integer> list = primeFactors(n);
		Set<Integer> set = new HashSet<>(list);
		if (list.size() == 3 && set.size() == 3) {
			for (Integer in : list)
				n = n / in;
		}
		return n == 1;
	}

	/** 4. Hoax Number **/
	@Override
	public boolean hoaxNumber(int n) {
		List<Integer> list = primeFactors(n);
		Set<Integer> set = new HashSet<>(list);
		list = new ArrayList<>(set);
		// since no is composite
		if (list.size() < 2)
			return false;

		int sum = 0;
		while (n > 0) {
			sum += n % 10;
			n /= 10;
		}
		for (Integer in : list) {
			if (in > 10) {

				while (in > 0) {
					sum -= in % 10;
					in /= 10;
				}
			} else {
				sum -= in;
			}
		}
		return sum == 0;
	}

	/** 7. Prime Factorization using Sieve O(log n) for multiple queries **/
	static final int MAXN = 100001;

	// stores smallest prime factor for every number
	static int spf[] = new int[MAXN];

	@Override
	public List<Integer> primeFactorization(int n) {

		List<Integer> list = new ArrayList<>();
		spf[1] = 1;
		for (int i = 2; i < MAXN; i++)

			// marking smallest prime factor for every
			// number to be itself.
			spf[i] = i;

		// separately marking spf for every even
		// number as 2
		for (int i = 4; i < MAXN; i += 2)
			spf[i] = 2;

		for (int i = 3; i * i < MAXN; i++) {
			// checking if i is prime
			if (spf[i] == i) {
				// marking SPF for all numbers divisible by i
				for (int j = i * i; j < MAXN; j += i)

					// marking spf[j] if it is not
					// previously marked
					if (spf[j] == j)
						spf[j] = i;
			}
		}

		while (n != 1) {
			list.add(spf[n]);
			n = n / spf[n];
		}
		return list;
	}

	/** 8. Find politeness of a number **/
	@Override
	public int politenessOfNum(int n) {

		int result = 1;

		// Eliminate all even prime factor of number of n
		while (n % 2 == 0)
			n /= 2;

		// n must be odd at this point, so iterate
		// for only odd numbers till sqrt(n)
		for (int i = 3; i * i <= n; i += 2) {
			int divCount = 0;

			// if i divides n, then start counting of
			// Odd divisors
			while (n % i == 0) {
				n /= i;
				++divCount;
			}
			result *= divCount + 1;
		}
		// If n odd prime still remains then count it
		if (n > 2)
			result *= 2;
		return result - 1;
	}
}
