package com.design.analysis.company.hakarrank.goldmansachs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GoldmanSachsImpl implements IGoldmanSachs {

	/** Bank Accounts **/
	public String feeOrUpfront(int n, int k, int x, int d, int[] p) {

		int maxPay = 0;
		for (int i = 0; i < p.length; i++)
			maxPay += Math.max(k, (int) p[i] * x / (100));
		if (maxPay <= d)
			return "free";
		return "upfront";
	}

	/** Buy Maximum Stocks ..max i stock by on ith day **/
	public int buyMaximumProducts(int n, long k, int[] a) {
		int count = 0;
		for (int i = 0; i < n; i++) {

			if (k >= (i + 1) * a[i]) {
				k -= (i + 1) * a[i];
				count += (i + 1);
			} else {
				for (int j = 0; j <= i; j++) {
					if (k >= a[i]) {
						k -= a[i];
						count++;
					} else
						return count;
				}
			}
		}
		return count;
	}

	/** max profit get the stocker in k transaction*F */
	@Override
	public long traderProfit(int a[], int k) {
		int N = a.length;
		if (k > N / 2)
			k = N / 2;

		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < N; i++)
			list.add(a[i]);

		Collections.sort(list);
		List<Integer> smL = new ArrayList<>();
		for (int i = 0; i < k; i++)
			smL.add(list.get(i));

		// maxTotalProfit
		int maxTP = 0;
		for (int i = 0; i < k; i++) {
			int j = indexOfNo(list.get(i), a);
			int t = j + 1;
			int maxProfit = 0;
			while (t < N && !smL.contains(a[t]) && a[t] - a[j] > 0) {
				if (maxProfit < a[t] - a[j])
					maxProfit = a[t] - a[j];
				t++;
			}
			maxTP += maxProfit;
		}
		return maxTP;
	}

	public int indexOfNo(int x, int a[]) {
		for (int i = 0; i < a.length; i++)
			if (a[i] == x)
				return i;
		return -1;
	}

	/** Time Series Queries **/
	/*
	 * 1 .For type 1, given a value , when was the first time that the price of the
	 * stock was at least v? 2. For type 2, given a value , what's the maximum price
	 * of the stock at a time greater or equal to v?
	 */
	public int query(int t[], int p[], int type, int v) {
		int N = p.length;
		if (type == 1) {
			for (int i = 0; i < N; i++) {
				if (p[i] >= v)
					return t[i];
			}
		} else if (type == 2) {
			int max = 0;
			int x = 0;
			while (v > t[x])
				x++;
			for (int i = x; i < N; i++) {
				if (max < p[i])
					max = p[i];
			}
			return max;
		}
		return -1;
	}

	// **hackerran test question*/
	/** Non reapeating digits in producct **/
	/*
	 * Given a number x and a range y to z please find the count of all the numers n
	 * that range such that the porduct of the number n and x does not contian any
	 * digit from the number n
	 */
	@Override
	public long nonRepeatingDigitProductCount(int x, int y, int z) {

		long count = 0;
		long prd;
		for (long i = y; i <= z; i++) {
			prd = x * i;
			if (!findDigit(i, prd)) {
				count++;
			}
		}
		return count;
	}

	@Override
	public boolean findDigit(long n, long prd) {
		List<Long> lPrd = new ArrayList<>();
		List<Long> ln = new ArrayList<>();
		while (n > 0) {
			ln.add(n % 10);
			n = n / 10;
		}
		while (prd > 0) {
			lPrd.add(prd % 10);
			prd = prd / 10;
		}
		for (Long l : lPrd) {
			if (ln.contains(l))
				return true;
		}
		return false;
	}

	/** Number Patterns & finding the the possible smallest numeric value **/
	@Override
	public long smallest(String pattern) {
		pattern = pattern.toLowerCase();
		char[] arr = pattern.toCharArray();
		int l = pattern.length();
		boolean bool[] = new boolean[l];
		long initVal = 1;
		long maxVal = l + 1;
		for (int i = 0; i < l; i++) {
			initVal = initVal * 10 + (i + 2);
			maxVal = maxVal * 10 + (l - i);
			if (arr[i] == 'm')
				bool[i] = true;
			else if (arr[i] == 'n')
				bool[i] = false;
		}
		long min = Integer.MAX_VALUE;
		int N = l + 1;

		for (long i = initVal; i <= maxVal; i++) {

			if (diffInt(i, N)) {
				String newS = new String(i + "");
				if (satisfyCondition(bool, newS)) {
					if (min > i)
						min = i;
				}
			}
		}
		return min;
	}

	@Override
	public boolean diffInt(long i, int N) {

		List<Integer> list = new ArrayList<>();
		while (i > 0) {
			list.add((int) i % 10);
			i = i / 10;
		}
		for (int j = 1; j <= N; j++) {
			if (!list.contains(j))
				return false;
		}
		return true;
	}

	@Override
	public boolean satisfyCondition(boolean c[], String s) {
		boolean found = true;
		for (int i = 0; i < c.length; i++) {
			char a = s.charAt(i);
			char b = s.charAt(i + 1);
			found = found && (c[i] && a < b);
			if (c[i] && a > b)
				found = true;
			else if (!c[i] && a < b)
				found = true;
			else
				return false;
		}
		return found;
	}

	/** live coding round **/
	/** find average in two sorted array */
	public double findAverage(int a[], int b[]) {

		/*if (a == null && b == null || a.length == 0 && b.length == 0)
			return -1;
		else {// TODO
			int i = 0;  Current index of input array ar1[] 
		    int j = 0;  Current index of input array ar2[] 
		    int count;  
		    int m1 = -1, m2 = -1;  
		  
		    // Since there are (n+m) elements,  
		    // There are following two cases 
		    // if n+m is odd then the middle  
		    //index is median i.e. (m+n)/2 
		    if((m + n) % 2 == 1) { 
		        for (count = 0; count <= (n + m)/2; count++) { 
		            if(i != n && j != m){ 
		            m1 = (ar1[i] > ar2[j]) ? ar2[j++] : ar1[i++]; 
		            } 
		            else if(i < n){ 
		            m1 = ar1[i++]; 
		            } 
		            // for case when j<m, 
		            else{ 
		            m1 = ar1[j++]; 
		            } 
		        } 
		        return m1; 
		    } 
		      
		    // median will be average of elements  
		    // at index ((m+n)/2 - 1) and (m+n)/2 
		    // in the array obtained after merging ar1 and ar2 
		    else { 
		        for (count = 0; count <= (n + m)/2; count++) { 
		            m2 = m1; 
		            if(i != n && j != m){ 
		            m1 = (ar1[i] > ar2[j]) ? ar2[j++] : ar1[i++]; 
		            } 
		            else if(i < n){ 
		            m1 = ar1[i++]; 
		            } 
		            // for case when j<m, 
		            else{ 
		            m1 = ar1[j++]; 
		            } 
		        } 
		        return (m1 + m2)/2; 
		    } 
		}
*/
		return -1;
	}

	/**
	 * Your task is ultimately to implement a function that takes in an array of
	 * non-negative numbers and an integer. You want to return the *LENGTH* of the
	 * shortest subarray whose sum is at least the integer,
	 **/
	public static void main(String[] args) {
		int a[] = { 1, 2, 3, 4 };
		minLength(a, 6);
	}

	// TODO
	public static int minLength(int a[], int target) {
		int N = a.length;
		for (int i = 0; i < N; i++) {
			for (int j = i + 1; j < N; j++) {
				System.out.println();
				for (int l = j + 1; l < N; l++) {
					System.out.print(a[i] + " ");
				}
			}
		}
		return -1;
		/*
		 * int N = a.length; int xor = 0; int b[] = null; int t; for (int i = 0; i <N;
		 * i++) { for (int j = i; j <N; j++) { System.out.println(); for (int k = i; k
		 * <= j; k++) { System.out.print(a[k] + " "); } } } return xor;
		 */
	}
}
