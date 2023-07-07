package com.design.analysis.core.algo.matheticalalgorithms;

public class GcdAndLcmImpl implements IGcdAndLcm {

	/** 1. GCD and LCM **/
	/* gcd of two no */
	public int GCD(int a, int b) {
		// Everything divides 0
		if (a == 0 || b == 0)
			return 0;

		// base case
		if (a == b)
			return a;

		// a is greater
		if (a > b)
			return GCD(a - b, b);
		return GCD(a, b - a);
	}

	/* lcm of two no */
	public int LCM(int a, int b) {
		return (a * b) / GCD(a, b);
	}

	/** 2. LCM of array **/
	public int lcmOfArray(int arr[]) {
		int lcm = arr[0];
		for (int i = 1; i < arr.length; i++)
			lcm = LCM(lcm, arr[i]);
		return lcm;
	}

	/** 3. GCD of array **/
	public int gcdOfArray(int arr[]) {

		int gcd = arr[0];
		for (int i = 1; i < arr.length; i++)
			gcd = GCD(gcd, arr[i]);
		return gcd;
	}

	/** 4. Basic and Extended Euclidean algorithms **/
	public int gcd(int a, int b) {
		if (a == 0)
			return b;
		return gcd(b % a, a);
	}

	/** 5. Product of given N fractions in reduced form **/
	public int[] productOfNFraction(int num[], int den[]) {
		int pNum = 1;
		int pDen = 1;
		for (int i = 0; i < num.length; i++) {
			pNum *= num[i];
			pDen *= den[i];
		}
		int gcd = gcd(pNum, pDen);
		int res[] = new int[2];
		res[0] = pNum / gcd;
		res[1] = pDen / gcd;
		return res;
	}

	/** 6. GCD of two numbers when one of them can be very large **/
	@Override
	public int gcdWithVeryLargeNo(int a, String x) {

		// Initialize result
		int mod = 0;
		char[] b = x.toCharArray();
		// calculating mod of b with a to make
		// b like 0 <= b < a
		for (int i = 0; i < b.length; i++)
			mod = (mod * 10 + b[i] - '0') % a;

		return gcd(a, mod);
	}

	/** 7. Stein&rsquo;s Algorithm for finding GCD **/
	/* it is just finding the gcd by different apporach */
	/** 8. GCD, LCM and Distributive Property **/
	@Override
	public int gcdlcmAndDistributive(int x, int y, int z) {
		return gcd(LCM(x, y), LCM(x, z));
	}

	/** 9. Replace every matrix element with maximum of GCD of row or column **/
	@Override
	public void replaceElemByGcdOfRowOrColm(int a[][]) {
		int[] rgcd = new int[a.length];
		int[] cgcd = new int[a[0].length];

		// Calculating GCD of each row and each column in
		// O(mn) and store in arrays.
		for (int i = 0; i < rgcd.length; i++) {
			for (int j = 0; j < cgcd.length; j++) {
				rgcd[i] = gcd(rgcd[i], a[i][j]);
				cgcd[j] = gcd(cgcd[j], a[i][j]);
			}
		}
		// Replacing matrix element
		for (int i = 0; i < rgcd.length; i++)
			for (int j = 0; j < cgcd.length; j++)
				a[i][j] = Math.max(rgcd[i], cgcd[j]);
	}

	/** 10. GCD of two numbers formed by n repeating x and y times **/
	public int gcdFormByNrepeatinOFXAndY(int n, int x, int y) {

		int gcd = gcd(x, y);
		String rs = "";
		for (int i = 0; i < gcd; i++)
			rs = n + "";
		return Integer.valueOf(rs);
	}
}
