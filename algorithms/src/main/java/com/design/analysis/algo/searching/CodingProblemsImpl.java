package com.design.analysis.algo.searching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

import com.design.analysis.algo.array.ArrayRotationImpl;
import com.design.analysis.algo.array.ArrayUtil;
import com.design.analysis.algo.array.IArrayRotation;
import com.design.analysis.algo.divideandconquer.BinarySearchBasedImpl;
import com.design.analysis.algo.divideandconquer.IBinarySearchBased;
import com.design.analysis.algo.searching.model.FreqWord;
import com.design.analysis.algo.utils.AlgoUtils;

public class CodingProblemsImpl implements ICodingProblems {

	/** 1. Find the Missing Number **/
	public int missNumber(int a[]) {
		int n = a.length;
		int sum = 0;
		for (int i = 0; i < a.length; i++)
			sum += a[i];
		int realNoSum = n * (n + 1) / 2;
		return realNoSum - sum;
	}

	/** 2. Search an element in a sorted and rotated array **/
	public int searchInSortedAndRotatedArr(int a[], int x) {
		IArrayRotation iar = new ArrayRotationImpl();
		return iar.searchInSortedRotatedArr(a, x);
	}

	/** 3. Median of two sorted arrays O(log(n)). **/
	public int medianOfTwoSortedArr(int a[], int b[]) {
		IBinarySearchBased ibsb = new BinarySearchBasedImpl();
		return ibsb.medianOfTwoSottedArr(a, b);
	}

	/** 4. Two elements whose sum is closest to zero **/
	public int[] sumCloseToZero(int a[]) {
		// combination of max,min +ve/-ve
		int rs[] = new int[2];
		Arrays.sort(a);
		if (a[0] > 0) // ie all no are +ve
		{
			rs[0] = a[0];
			rs[1] = a[1];
			return rs;
		}

		int i = 0;
		int j = a.length;
		while (i < j && a[i] < 0)
			i++;

		// min -ve and max +ve combination
		int min = Math.abs(a[0] + a[a.length - 1]);
		rs[0] = a[0];
		rs[1] = a[a.length - 1];
		// max -ve and min +ve combination
		if (Math.abs(a[i - 1] + a[i]) < min) {
			min = a[i - 1] + a[i];
			rs[0] = a[i - 1];
			rs[1] = a[i];
		}
		// min -ve and min +ve combination
		if (Math.abs(a[0] + a[i]) < min) {
			rs[0] = a[0];
			rs[1] = a[i];
		}
		// max -ve and max +ve combination
		if (Math.abs(a[i - 1] + a[a.length - 1]) < min) {
			rs[0] = a[i - 1];
			rs[1] = a[a.length - 1];
		}
		return rs;
	}

	/** 6. Maximum and minimum of an array using minimum number of comparisons **/
	// O(2n-1)
	public int[] maxMinInMinComparision(int a[]) {
		int N = a.length;
		int rs[] = new int[2];

		if (N == 1) {
			rs[0] = rs[1] = a[0];
			return rs;
		}

//selection && bubble sort combination for i=0
		for (int j = 0; j < N - 1; j++) {
			if (a[0] > a[j + 1])
				ArrayUtil.swapArr(a, 0, j+1);

			if (a[j] > a[j + 1])
				ArrayUtil.swapArr(a, j, j + 1);
		}
		rs[0] = a[0];
		rs[1] = a[N - 1];
		return rs;
	}

	/** 8. Ceiling in a sorted array **/
	@Override
	public int ceillingInSortedArr(int a[], int x, int l, int h) {
		// first call need to check
		if (l == 0 && h == a.length - 1) {
			if (x < a[0])
				return a[0];
			if (x > a[h])
				return -1;
		}
		if (l <= h) {
			int mid = l + (h - l) / 2;

			if (x == a[mid])
				return a[mid];
			else if (x <= a[mid] && x > a[mid - 1])
				return a[mid];
			else if (x > a[mid])
				return ceillingInSortedArr(a, x, mid + 1, h);
			else
				return ceillingInSortedArr(a, x, l, mid - 1);
		}
		return -1;
	}

	public int floorInSortedArr(int a[], int x, int l, int h) {
		// first call need to check
		if (l == 0 && h == a.length - 1) {
			if (x < a[0])
				return -1;
			if (x > a[h])
				return a[h];
		}
		if (l <= h) {
			int mid = l + (h - l) / 2;

			if (x == a[mid])
				return a[mid];
			else if (a[mid - 1] < x && x < a[mid])
				return a[mid - 1];
			else if (x > a[mid])
				return floorInSortedArr(a, x, mid + 1, h);
			else
				return floorInSortedArr(a, x, l, mid - 1);
		}
		return -1;
	}
	/** 9. Count number of occurrences (or frequency) in a sorted array **/
	/* Refer @IBinarySearchBased.java...point @4. sub program */

	/** 10. Find the repeating and the missing | Added 3 new methods **/
	public int[] missingAndRepeatingInNNatural(int a[]) {
		int n = a.length;
		int rs[] = new int[2];
		int sum = 0;
		int x = 0;// misNo;
		int y = 0;// repNo;
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < n; i++) {
			sum += a[i];
			if (set.contains(a[i]))
				y = a[i];
			else
				set.add(a[i]);
		}
		x = Math.abs(n * (n + 1) / 2 - sum + y);
		rs[0] = y;
		rs[1] = x;
		return rs;
	}

	public int[] missingAndRepeatingInNNaturalX(int a[]) {

		int n = a.length;
		int rs[] = new int[2];
		int b[] = new int[n];

		for (int i = 0; i < n; b[a[i] - 1]++, i++)
			;

		for (int i = 0; i < n; i++) {
			if (b[i] > 1)
				rs[0] = i + 1;
			if (b[i] == 0)
				rs[1] = i + 1;
		}
		return rs;
	}

	/** 11. Find a Fixed Point in a given array(sorted) **/
	@Override
	public int fixedPoint(int a[], int l, int h) {
		if (l <= h) {
			int mid = l + (h - l) / 2;

			if (mid == a[mid])
				return mid;
			else if (mid > a[mid])
				return fixedPoint(a, mid + 1, h);
			else
				return fixedPoint(a, l, mid - 1);
		}
		return -1;
	}

	/** 12. max element in array which is first increasing and then decreasing **/
	// this is nothing but find the max element in array O(log(n))
	@Override
	public int healInArray(int arr[], int low, int high) {
		/* Base Case: Only one element is present in arr[low..high] */
		if (low == high)
			return arr[low];

		/*
		 * If there are two elements and first is greater then the first element is
		 * maximum
		 */
		if ((high == low + 1) && arr[low] >= arr[high])
			return arr[low];

		/*
		 * If there are two elements and second is greater then the second element is
		 * maximum
		 */
		if ((high == low + 1) && arr[low] < arr[high])
			return arr[high];

		int mid = (low + high) / 2; /* low + (high - low)/2; */

		/*
		 * If we reach a point where arr[mid] is greater than both of its adjacent
		 * elements arr[mid-1] and arr[mid+1], then arr[mid] is the maximum element
		 */
		if (arr[mid] > arr[mid + 1] && arr[mid] > arr[mid - 1])
			return arr[mid];

		/*
		 * If arr[mid] is greater than the next element and smaller than the previous
		 * element then maximum lies on left side of mid
		 */
		if (arr[mid] > arr[mid + 1] && arr[mid] < arr[mid - 1])
			return healInArray(arr, low, mid - 1);
		else // when arr[mid] is greater than arr[mid-1] and smaller than arr[mid+1]
			return healInArray(arr, mid + 1, high);
	}

	public int healInArrayX(int arr[], int l, int h) {

		if (l <= h) {
			int mid = (l + h) / 2;
			if (arr[mid] > arr[mid + 1] && arr[mid] > arr[mid - 1])
				return arr[mid];

			/*
			 * If arr[mid] is greater than the next element and smaller than the previous
			 * element then maximum lies on left side of mid
			 */
			if (arr[mid] > arr[mid + 1] && arr[mid] < arr[mid - 1])
				return healInArray(arr, l, mid - 1);
			else // when arr[mid] is greater than arr[mid-1] and smaller than arr[mid+1]
				return healInArray(arr, mid + 1, h);
		}
		return -1;

	}

	/** 13. Find a pair with the given difference **/
	@Override
	public int[] pairHaveXDiff(int a[], int x) {
		int rs[] = new int[2];
		Set<Integer> set = new HashSet<Integer>();

		for (int i = 0; i < a.length; i++) {
			if (set.contains(a[i])) {
				rs[0] = a[i] - x;
				rs[1] = a[i];
				return rs;
			} else {
				set.add(a[i] + x);
			}
		}
		return rs;
	}

	/** 14. Find the k most frequent words from a file **/
	@Override
	public List<FreqWord> kMostFrequent(String str[], int k) {
		List<FreqWord> rsList = new ArrayList<>();
		Map<String, Integer> map = new HashMap<>();
		for (int i = 0; i < str.length; i++) {
			if (map.containsKey(str[i])) {
				map.put(str[i], map.get(str[i]) + 1);
			} else
				map.put(str[i], 1);
		}

		List<FreqWord> words = new ArrayList<>();
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			words.add(new FreqWord(entry.getKey(), entry.getValue()));
		}
		Collections.sort(words);
		for (int i = 0; i < k; i++)
			rsList.add(words.get(i));
		return rsList;
	}

	/** 15. Median of two sorted arrays of different sizes **/
	/* @See IBinarySearchBased.java @ 2...program */
	// having space O(n) but for any tow arrays
	public int medianOfTwoSortedArrX(int a[], int b[]) {
		int N = a.length;
		int M = b.length;
		int c[] = new int[M + N];
		int k = 0;
		int i = 0;
		int j = 0;
		while (i < N && j < M) {
			if (a[i] <= b[j])
				c[k++] = a[i++];
			else
				c[k++] = b[j++];
		}
		while (i < N)
			c[k++] = a[i++];
		while (j < M)
			c[k++] = b[j++];

		int n = (M + N) / 2;
		if ((M + N) % 2 == 1)
			return c[n];
		else
			return (c[n - 1] + c[n]) / 2;
	}

	/** 16. Find a peak element **/
	@Override
	public int pickElement(int a[], int l, int h, int n) {

		int mid = (l + h) / 2;

		if ((mid == 0 || a[mid] >= a[mid - 1]) && (mid == n - 1 || a[mid] >= a[mid + 1]))
			return a[mid];
		else if (mid > 0 && a[mid] < a[mid - 1])
			return pickElement(a, l, mid - 1, n);
		else
			return pickElement(a, mid + 1, h, n);
	}

	/**
	 * 17. Given an array of of size n and a number k, find all elements that appear
	 * more than n/k times
	 **/
	@Override
	public List<Integer> elemMoreThanKTimes(int a[], int k) {
		List<Integer> rsList = new ArrayList<>();
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < a.length; i++) {
			if (map.containsKey(a[i])) {
				map.put(a[i], map.get(a[i]) + 1);
			} else
				map.put(a[i], 1);
		}

		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if (entry.getValue() > a.length / k)
				rsList.add(entry.getKey());
		}
		return rsList;
	}

	/** 18. Find the minimum element in a sorted and rotated array **/
	/*
	 * @see IArrayRotation.java...@ 5....a[findPivot(...)+1] ie next to poivot index
	 */
	/**
	 * 19. Kth smallest element in a row-wise and column-wise sorted 2D array | Set
	 * 1
	 */
	/* @see @IOrderStatistics.java ...@2. program */

	/** 20. Find k closest elements to a given value sorted arr **/
	@Override
	public int[] kClogestElemInSotedArr(int a[], int val, int k) {
		int n = a.length;
		int rs[] = new int[k];
		int i, j, l;
		l = 0;
		// O(log(n))
		// first find the val in arry if not found then fid the clogest one
		int ind = AlgoUtils.binarySearch(a, 0, n - 1, val);
		if (ind == -1) {
			ind = AlgoUtils.findCrossOver(a, 0, n - 1, val);
			rs[k++] = a[ind];
			l++;
		}
		// k+logn
		i = ind - 1;
		j = ind + 1;

		while (l < k && j < a.length && i > 0) {
			if (val - a[i] > a[j] - val) {
				rs[l++] = a[j];
				j++;
			} else {
				rs[l++] = a[i];
				i--;
			}
		}
		// if one end is over
		if (i == 0) {
			while (l < k && j < a.length)
				rs[l++] = a[j++];
		}
		if (j == n) {
			while (i > 0 && l < k)
				rs[l++] = a[i--];
		}
		return rs;
	}

	/** 21. Search in an almost sorted array **/
	public int searchInAlmostSotedArr(int a[], int x) {
		return new BinarySearchBasedImpl().binarySearchInAllmostSoted(a, 0, a.length - 1, x);
	}

	/** 23. Find the first repeating element in an array of integers **/
	@Override
	public int firstRepetingElem(int a[]) {
		Map<Integer, Integer> map = new HashMap<>();
		int minInd = Integer.MAX_VALUE;
		for (int i = 0; i < a.length; i++) {
			if (map.containsKey(a[i])) {
				{
					if (map.get(a[i]) < minInd)
						minInd = map.get(a[i]);
				}
			} else
				map.put(a[i], i);
		}
		return minInd != Integer.MAX_VALUE ? a[minInd] : minInd;
	}

	/** 24. Find common elements in three sorted arrays **/
	@Override
	public List<Integer> commonIn3Arrs(int a[], int b[], int c[]) {
		int n1 = a.length;
		int n2 = b.length;
		int n3 = c.length;
		int i, j, k;
		i = j = k = 0;
		// O(n1+n2+n3)
		List<Integer> list = new ArrayList<>();

		while (i < n1 && j < n2 && k < n3) {
			if (a[i] == b[j] && b[j] == c[k]) {
				list.add(a[i]);
				i++;
				j++;
				k++;
			} else if (a[i] < b[j])
				i++;
			else if (b[j] < c[k])
				j++;
			else
				k++;
		}
		return list;
	}

	/** 25. Count 1’s in a sorted binary array **/
	@Override // sorted in non-increasing order
	public int countOneInBinaryArr(int a[], int l, int h) {
		if (l <= h) {
			// get the middle index
			int mid = l + (h - l) / 2;

			// check if the element at middle index is last 1
			if ((mid == h || a[mid + 1] == 0) && (a[mid] == 1))
				return mid + 1;

			// If element is not last 1, recur for right side
			if (a[mid] == 1)
				return countOneInBinaryArr(a, (mid + 1), h);
			// else recur for left side
			return countOneInBinaryArr(a, l, (mid - 1));
		}
		return 0;
	}

	/**
	 * 26. Given a sorted array and a number x, find the pair in array whose sum is
	 * closest to x
	 **/
	@Override
	public List<Integer> sumCLogestToX(int a[], int x) {

		List<Integer> list = new ArrayList<>();
		int ind1, ind2;
		ind1 = ind2 = 0;
		int i = 0;
		int j = a.length - 1;
		int diff = Integer.MAX_VALUE;
		while (i < j) {
			if (Math.abs(a[i] + a[j] - x) < diff) {
				ind1 = i;
				ind2 = j;
				diff = Math.abs(a[i] + a[j] - x);
				i++;
				j--;
			}
			// If this pair has more sum, move to smaller values.
			else if (a[i] + a[j] > x)
				j--;
			else // Move to larger values
				i++;
		}
		list.add(a[ind1]);
		list.add(a[ind2]);
		return list;
	}

	/** 27. Find the closest pair from two sorted arrays **/
	@Override
	public List<Integer> sumCLogestToX(int a[], int b[], int x) {
		int n1 = a.length;
		int j = b.length - 1;

		int i = 0;

		int diff = Integer.MAX_VALUE;
		int ind1 = 0;
		int ind2 = 0;
		// O(n1+n2+n3)
		List<Integer> list = new ArrayList<>();

		while (i < n1 && j >= 0) {
			if (Math.abs(a[i] + b[j] - x) < diff) {
				diff = Math.abs(a[i] + b[j] - x);
				ind1 = i;
				ind2 = j;
				i++;
				j--;
			} else if (a[i] + a[j] > x)
				j--;
			else
				i++;
		}
		list.add(a[ind1]);
		list.add(b[ind2]);
		return list;
	}
	/** 28. K’th Smallest/Largest Element in Unsorted Array | Set 1 **/
	/**
	 * 29. K’th Smallest/Largest Element in Unsorted Array | Set 2 (Expected Linear
	 * Time)
	 **/
	/**
	 * 30. K’th Smallest/Largest Element in Unsorted Array | Set 3 (Worst Case
	 * Linear Time)
	 **/
	/* all above are common for minimum complxity O(k*n) */
	/* @see @IOrderStatistics.java.. 1....program */

	/** 31. Find position of an element in a sorted array of infinite numbers **/
	@Override // @Amazn
	public int posInInfiniteLenArr(int a[], int x, int siseCheck, int sizeLimit) {
		// infinite menas length is unknown
		// try for first for last index 1000,2000 etc
		int l = 0;
		int h = 0;
		int i = 0;
		try {
			for (i = 0; i < sizeLimit; i += siseCheck) {
				if (a[i] <= x && x <= a[i + siseCheck]) {
					l = i;
					h = i + siseCheck;
					return AlgoUtils.binarySearch(a, l, h, x);
				}
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			return posInInfiniteLenArr(a, x, siseCheck / 10, i + siseCheck);
		}
		return -1;
	}

	/**
	 * 32. Given a sorted and rotated array, find if there is a pair with a given
	 * sum
	 **/
	/* in single array */
	@Override
	public List<Integer> sumEqualToX(int a[], int x) {
		int j = a.length - 1;
		int i = 0;
		int ind1 = 0;
		int ind2 = 0;
		// O(n1+n2+n3)
		List<Integer> list = new ArrayList<>();

		while (i < j) {
			if (Math.abs(a[i] + a[j] - x) == 0) {
				ind1 = i;
				ind2 = j;
				break;
			} else if (a[i] + a[j] > x)
				j--;
			else
				i++;
		}
		if (i != j) {// ie . if found
			list.add(a[ind1]);
			list.add(a[ind2]);
		}
		return list;
	}

	/* in two array */
	@Override
	public List<Integer> sumEqualToX(int a[], int b[], int x) {
		int n1 = a.length;
		int j = b.length - 1;
		int i = 0;
		int ind1 = 0;
		int ind2 = 0;
		// O(n1+n2+n3)
		List<Integer> list = new ArrayList<>();

		while (i < n1 && j >= 0) {
			if (Math.abs(a[i] + b[j] - x) == 0) {
				ind1 = i;
				ind2 = j;
				break;
			} else if (a[i] + b[j] > x)
				j--;
			else
				i++;
		}

		if (i != n1 && j != -1) {// ie. if found
			list.add(a[ind1]);
			list.add(b[ind2]);
		}
		return list;
	}

	/** 33. Find the largest pair sum in an unsorted array **/
	@Override
	public List<Integer> largestPair(int a[]) {

		List<Integer> list = new ArrayList<>();
		int firstMax = 0;
		int secondMax = 0;
		if (a[0] > a[1]) {
			firstMax = a[0];
			secondMax = a[1];
		} else {
			firstMax = a[1];
			secondMax = a[0];
		}
		for (int i = 2; i < a.length; i++) {
			if (a[i] > firstMax) {
				secondMax = firstMax;
				firstMax = a[i];
			}
		}

		list.add(firstMax);
		list.add(secondMax);
		return list;
	}

	/** 34. Find the nearest smaller numbers on left side in an array **/
	@Override // O(n)
	public int[] nearestSmallrOnLeftSideArr(int a[]) {

		int n = a.length;
		int b[] = new int[n];
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < n; i++) {
			while (!stack.isEmpty() && stack.peek() > a[i])
				stack.pop();
			if (!stack.isEmpty())
				b[i] = stack.peek();
			stack.push(a[i]);
		}
		return b;
	}

	/** 35. K’th largest element in a stream **/
	/* @see @IOrderStatistics.java....3....program8 */

	/** 36. Find a pair with maximum product in array of Integers **/
	/* this is same max sum pair just use the product without absloute */

	/** 37. Find the element that appears once in a sorted array O(logn) **/
	@Override
	public int uniqueElement(int a[], int l, int h) {

		if (l <= h) {
			if (h == l)
				return a[h];
			int mid = (l + h) / 2;
			int x = -1;
			if (mid % 2 == 0) {
				if (a[mid] == a[mid + 1])
					x = uniqueElement(a, mid + 2, h);
				if (x != -1)
					return x;
				else
					x = uniqueElement(a, l, mid);
				if (x != -1)
					return x;
			} else {
				if (a[mid] == a[mid - 1])
					x = uniqueElement(a, mid + 1, h);
				if (x != -1)
					return x;
				else
					x = uniqueElement(a, l, mid - 1);
				if (x != -1)
					return x;
			}
		}
		return -1;
	}

	/** 38. Find the odd appearing element in O(Log n) time non sorted **/
	/* logn in unsorted array TODO */
	@Override // it take O(n)
	public int searchIndex(int a[], int l, int h, int x) {

		if (l <= h) {
			int mid = (l + h) / 2;

			if (a[mid] == x) {
				return mid;
			} else {
				return Math.max(searchIndex(a, mid + 1, h, x), searchIndex(a, l, mid - 1, x));
			}
		}
		return -1;
	}

	@Override
	public int oddAppearing(int a[]) {
		return uniqueElement(a, 0, a.length - 1);
	}

	/** 39. Find the largest three elements in an array O(n) **/
	public int[] largestThreeElement(int a[]) {

		if (a.length < 3)
			return null;

		int b[] = new int[3];
		int i, first, second, third;

		third = first = second = Integer.MIN_VALUE;
		for (i = 0; i < a.length; i++) {
			/* If current element is smaller than first */
			if (a[i] > first) {
				third = second;
				second = first;
				first = a[i];
			}

			/* If arr[i] is in between first and second then update second */
			else if (a[i] > second) {
				third = second;
				second = a[i];
			}

			else if (a[i] > third)
				third = a[i];
		}
		b[0] = third;
		b[1] = second;
		b[2] = first;
		return b;
	}
}
