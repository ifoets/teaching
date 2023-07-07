package com.design.analysis.core.algo.divideandconquer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.design.analysis.core.algo.array.ArrayUtil;
import com.design.analysis.core.algo.utils.AlgoUtils;

public class BinarySearchBasedImpl implements IBinarySearchBased {

	public static void main(String[] args) {

	//System.out.println(m1("sanjay"));
	hackNumber("We love to hackonhackerearth","hack",'Y',0);
	
	hackNumber("We love to hack on hackerearth","hack",'Y',14);
	hackNumber("We love to hack on hackerearth","hack",'N',14);
	}

	
	public static String m1(String s)
	{
		StringBuffer sb= new StringBuffer();
		
		int a[]=new int[26];
		char [] charArr=s.toCharArray();
		Set<Character> set= new HashSet<>();
		
		for(int i=0;i<s.length();a[s.charAt(i)-97]++,i++);
		
		for(int i=0;i<s.length();i++)
		{
			if (!set.contains(charArr[i]))
			{
				sb.append(charArr[i] + "" + a[s.charAt(i) - 97]);
				set.add(charArr[i]);
			}
		}
			
		return sb.toString();
		
		
	}
	
	public static void hackNumber(String s1, String s2, char C, int l) {
		
		char firstCharOfS2 = s2.charAt(0);
		int N = s1.length();

		if (C == 'Y') {
			for (int i = l; i < N; i++) {

				if (firstCharOfS2 == s1.charAt(i) ) {
					if (i == 0||s1.charAt(i-1)==' ' && isRight(s1,i)) {
						System.out.println(i);
						return;
					}
					
				}
			}
			System.out.println("Goodbye wiston");
		}

		else if (C == 'N') {
			for (int i = l+1; i < N; i++) {
				if (firstCharOfS2 == s1.charAt(i)) {
					System.out.println(i);
					return;
				}
			}
			System.out.println("Goodbye wiston");
		}

		
	}

	public static  boolean isRight(String s1, int i)
	{
		
		// checking right space after matching
		for (int j = i + 1; j < s1.length(); j++) {
			if (s1.charAt(j) == ' ' || i ==s1.length() - 1) {
				return true;
			}
		}
		return false;
	}
	/*public void hackNumber(String s1, String s2, int l, char C) {
		boolean isSpaceLeft = false;
		char firstCharOfS2 = s2.charAt(0);
		int N = s1.length();

		if (C == 'Y') {
			for (int i = 0; i < N; i++) {
				if (s1.charAt(i) == ' ')
					isSpaceLeft = true;

				if (firstCharOfS2 == s1.charAt(i)) {
					if (isSpaceLeft || i == 0) {
						System.out.println(i);
						return;
					}
					// checking right space after matching
					for (int j = i + 1; j < N; j++) {
						if (s1.charAt(j) == ' ' || i == N - 1) {
							System.out.println(i);
							return;
						}
					}
				}
			}
		}

		else if (C == 'N') {
			for (int i = l; i < N; i++) {
				if (firstCharOfS2 == s1.charAt(i)) {
					System.out.println(i);
					return;
				}
			}
		}

		System.out.println("Goodbye wiston");
	}*/

	/**
	 * 1. Median of two sorted arrays having equal size
	 **/
	public int medianOfTwoSottedArr(int a[], int b[]) {

		// this is for equal size of a and b
		if (a.length != b.length)
			return -1;
		int i, j, m1, m2, cnt;
		int n = a.length;
		m1 = m2 = -1;
		i = j = 0;

		for (cnt = 0; cnt <= n; cnt++) {

			// if all element of a is smallar then b[0]
			if (i == n) {
				m1 = m2;
				m2 = b[0];
				break;
			}
			// if all element of b is smallar then a[0]
			if (j == n) {
				m1 = m2;
				m2 = a[0];
				break;
			}
			if (a[i] < b[j]) {
				m1 = m2;
				m2 = a[i++];
			} else {
				m1 = m2;
				m2 = b[j++];
			}
		}
		return (m1 + m2) / 2;
	}

	/* get median of an array */
	public int getMedian(int arr[], int l, int h) {
		if ((h - l) % 2 == 0)
			return arr[l + (h - l) / 2];
		else
			return (arr[l + (h - l) / 2] + arr[l + (h - l) / 2 + 1]) / 2;
	}

	/* by log(n) complexity */
	public int getMedianOf2Array(int a[], int l1, int h1, int b[], int l2, int h2) {

		int mid1 = (h1 + l1) / 2;
		int mid2 = (h2 + l2) / 2;

		if (h1 - l1 == 1)
			return (Math.max(a[l1], b[l2]) + Math.min(a[h1], b[h2])) / 2;
		else if (a[mid1] > b[mid2])
			return getMedianOf2Array(a, l1, mid1, b, mid2, h2);
		else
			return getMedianOf2Array(a, mid1, h1, b, l2, mid2);
	}

	/** 2. Median of two sorted arrays of different sizes **/
	/* by O(1) worst case O(n) when size equal ...complexity */
	public int getMedianOfDiffSize2Array(int a[], int l1, int h1, int b[], int l2, int h2) {

		// when one array is always greater than other array element O(1)
		if (a[h1] < b[l2] || b[h2] < a[l1]) {
			if (h1 - l1 > h2 - l2) {
				return getMedian(a, h2 - l2 + 1, h1);
			} else
				return getMedian(b, h1 - l1 + 1, h2);
		}

		// below case remove one by one greatest and smallest element O(n+m)
		Set<Integer> set1 = new HashSet<>();
		Set<Integer> set2 = new HashSet<>();
		for (int i = 0; i <= h1; i++)
			set1.add(a[i]);
		for (int j = 0; j <= h2; j++)
			set2.add(b[j]);

		while (set1.size() + set2.size() != 2 && set1.size() + set2.size() != 1) {
			if (a[l1] < b[l2]) {
				set1.remove(a[l1]);
				l1++;
			} else {
				set2.remove(b[l2]);
				l2++;
			}
			if (a[h1] < b[h2]) {
				set2.remove(b[h2]);
				h2--;
			} else {
				set1.remove(a[h1]);
				h1--;
			}
		}
		List<Integer> list1 = new ArrayList<>(set1);
		List<Integer> list2 = new ArrayList<>(set2);
		if (list1.size() == 1 && list2.size() == 1)
			return (list1.get(0) + list2.get(0)) / 2;
		else if (list1.size() == 2)
			return (list1.get(0) + list1.get(1)) / 2;
		else if (list2.size() == 2)
			return list2.get(0) + list2.get(1) / 2;
		else if (list1.size() == 1)
			return list1.get(0);
		else if (list2.size() == 1)
			return list2.get(0);
		return -1;
	}

	// GuruJi 2 sorted array
	public int getMedianOf2AnySizeArray(int a[], int b[]) {

		int n1 = a.length;
		int n2 = b.length;
		int N = n1 + n2;

		for (int i = 0; i < N; i++) {
			for (int j = i + 1; j < N; j++) {
				if (i < n1) {
					if (j < n1) {
						if (a[i] > a[j])
							ArrayUtil.swapArr(a, i, j);
					} else {
						if (a[i] > b[j - n1])
							ArrayUtil.swapIn2Arr(a, i, b, j - n1);
					}
				} else {
					if (b[i - n1] > b[j - n1])
						ArrayUtil.swapArr(b, i - n1, j - n1);
				}
			}
		}
		return getMedianOfTwoSortedArray(a, b);
	}

	/// GuruJi 2 sorted array O(n) and SO(n) /n=n1+n2
	public int getMedianOf2AnySizeArrayX(int a[], int b[]) {
		int n1 = a.length;
		int n2 = b.length;
		int max1 = AlgoUtils.max(a);
		int max2 = AlgoUtils.max(b);
		int max = max1 > max2 ? max1 : max2;

		int c[] = new int[max + 1];
		int i = 0;
		int j = 0;
		while (i < n1 && j < n2) {
			c[a[i++]]++;
			c[b[j++]]++;
		}
		while (i < n1)
			c[a[i++]]++;
		while (j < n2)
			c[b[j++]]++;
		int k = 0;
		for (i = 0; i < c.length; i++) {
			for (j = 0; j < c[i]; j++) {
				if (k < n1)
					a[k++] = i;
				else
					b[k++ - n1] = i;
			}
		}
		return getMedianOfTwoSortedArray(a, b);
	}

	// special sorted here all elements in a[] are greater than all elements of b[]
	public int getMedianOfTwoSortedArray(int a[], int b[]) {
		int n1 = a.length;
		int n2 = b.length;
		int N = n1 + n2;
		int m1 = 0;
		int m2 = 0;
		if (n1 == n2) {
			m1 = a[n1 - 1];
			m2 = b[0];
		}
		if (N % 2 == 0) {
			if (n1 > n2) {
				m1 = a[N / 2 - 1];
				m2 = a[N / 2];
			} else {
				m1 = b[N / 2 - 1 - n1];
				m2 = b[N / 2 - n1];
			}
		} else {
			if (n1 > n2)
				return a[N / 2];
			return b[N / 2 - n1];
		}
		return (m1 + m2) / 2;
	}

	/**
	 * 3.Check for Majority Element in a sorted array ie check x appear more than
	 * n/2 times or not
	 **/

	@Override
	public int binarySearchFirstOccurance(int a[], int l, int h, int x) {

		if (l <= h) {
			int mid = l + (h - l) / 2;

			if ((mid == 0 || x > a[mid - 1]) && (x == a[mid]))
				return mid;
			else if (x > a[mid])
				return binarySearchFirstOccurance(a, mid + 1, h, x);
			else
				return binarySearchFirstOccurance(a, l, mid - 1, x);
		}
		return -1;
	}

	@Override
	public boolean majorityElemInSortedArr(int a[], int x) {
		int n = a.length;
		/* Find the index of first occurrence of x in arr[] */
		int i = binarySearchFirstOccurance(a, 0, n - 1, x);

		/* If element is not present at all, return false */
		if (i == -1)
			return false;

		/* check if the element is present more than n/2 times */
		if (((i + n / 2) <= (n - 1)) && a[i + n / 2] == x)
			return true;
		else
			return false;
	}

	/**
	 * 4. Count number of occurrences (or frequency) in a sorted array O(Logn) not
	 * O(n)
	 **/
	@Override
	public int binarySearchLastOccurance(int a[], int l, int h, int x) {

		if (l <= h) {
			int mid = l + (h - l) / 2;

			if ((mid == a.length - 1 || x < a[mid + 1]) && (x == a[mid])) {
				return mid;
			} else if (x < a[mid])
				return binarySearchLastOccurance(a, l, mid - 1, x);
			else
				return binarySearchLastOccurance(a, mid + 1, h, x);
		}
		return -1;
	}

	@Override
	public int frequecnyOfElement(int a[], int x) {

		return binarySearchLastOccurance(a, 0, a.length - 1, x) - binarySearchFirstOccurance(a, 0, a.length - 1, x) + 1;
	}

	/** 5. Find a Fixed Point may be -ve no may preset **/
	public int findFixedPoint(int a[], int l, int h) {
		if (l <= h) {
			int mid = (h + l) / 2;

			if (mid == a[mid])
				return mid;
			if (mid > a[mid])
				return findFixedPoint(a, mid + 1, h);
			else
				return findFixedPoint(a, l, mid - 1);
		}
		return -1;
	}

	/** 6. Find a peak element in a given array **/
	// O(nlog(n))
	public int findOnlyPickElemet(int a[], int l, int r, int n) {

		int mid = (l + r) / 2;
		if ((mid == 0 || a[mid - 1] <= a[mid]) && (mid == n - 1 || a[mid + 1] <= a[mid]))
			return mid;
		else if (mid > 0 && a[mid - 1] > a[mid])
			return findOnlyPickElemet(a, l, mid - 1, n);
		return findOnlyPickElemet(a, mid + 1, r, n);
	}

	// TOD
	public int findAllPickElemtnt(int a[], int l, int r, int n) {
		return 0;
	}

	/** 20. Find the index of clogest corss of element in sorted array **/
	// Testing TODO
	public int findCrossOver(int arr[], int low, int high, int x) {
		// Base cases
		if (arr[high] <= x) // x is greater than all
			return high;
		if (arr[low] > x) // x is smaller than all
			return low;

		// Find the middle point
		int mid = (low + high) / 2; /* low + (high - low)/2 */

		/* If x is same as middle element, then return mid */
		if (arr[mid] <= x && arr[mid + 1] > x)
			return mid;

		/*
		 * If x is greater than arr[mid], then either arr[mid + 1] is ceiling of x or
		 * ceiling lies in arr[mid+1...high]
		 */
		if (arr[mid] < x)
			return findCrossOver(arr, mid + 1, high, x);

		return findCrossOver(arr, low, mid - 1, x);
	}

	/**
	 * 21. Search in allmost sorted array ie 1 element is displaced left or right 1
	 * position
	 **/

	public int binarySearchInAllmostSoted(int arr[], int l, int r, int x) {
		if (r >= l) {
			int mid = l + (r - l) / 2;

			// If the element is present at one of the middle
			// 3 positions
			if (arr[mid] == x)
				return mid;
			if (mid > l && arr[mid - 1] == x)
				return (mid - 1);
			if (mid < r && arr[mid + 1] == x)
				return (mid + 1);

			// If element is smaller than mid, then it can only
			// be present in left subarray
			if (arr[mid] > x)
				return binarySearchInAllmostSoted(arr, l, mid - 2, x);

			// Else the element can only be present in right subarray
			return binarySearchInAllmostSoted(arr, mid + 2, r, x);
		}

		// We reach here when element is not present in array
		return -1;
	}

	@Override
	public int findOnlyPickElemet(int[] a, int l, int r) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int findAllPickElemtnt(int[] a, int l, int r) {
		// TODO Auto-generated method stub
		return 0;
	}
}
