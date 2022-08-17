package com.design.analysis.algo.greedyalgorithms;

import java.util.Arrays;
import java.util.PriorityQueue;

import com.design.analysis.algo.utils.AlgoUtils;

public class ArraysGreedyAlgoImpl implements IArraysGreedyAlgo {

	/** 1. Minimum product subset of an array **/
	public int minProductSubArr(int a[]) {
		int n = a.length;
		if (n == 1)
			return a[0];

		int cnt0 = 0;
		int cntNe = 0;
		int maxNe = Integer.MIN_VALUE;
		int minPos = Integer.MAX_VALUE;
		int product = 1;

		for (int i = 0; i < n; i++) {
			if (a[i] == 0) {
				cnt0++;
				continue;
			}
			if (a[i] < 0) {
				maxNe = Math.max(a[i], maxNe);
				cntNe++;
			} else if (a[i] < minPos)
				minPos = a[i];
			product *= a[i];
		}

		// all r zero or no -ve and zero exists
		if (cnt0 == n || cntNe == 0 && cnt0 > 0)
			return 0;
		// if all r +ve integer
		if (cntNe == 0)
			return minPos;
		// ie even no of +ve exists
		if (cntNe != 0 && cntNe % 2 == 0)
			product /= maxNe;
		return product;
	}

	public int minProductSubArrX(int a[]) {
		int result = 0;
		Arrays.sort(a);
		int posMul, neMul;
		posMul = neMul = 1;

		int i = 0;
		int j = a.length - 1;
		if (a[i] == 0 && a[j] == 0)
			return result;

		while (a[i] < 0)
			neMul *= a[i++];

		while (a[j] > 0)
			posMul *= a[j--];

		if (i == 0)
			return a[0];

		if (neMul < 0)
			result = neMul * posMul;
		if (neMul > 0)
			result = (neMul / a[i - 1]) * posMul;
		return result;

	}

	/** 2. Maximum product subset of an array **/
	@Override

	public int maxProductSubArr(int a[]) {
		int n = a.length;
		if (n == 1)
			return a[0];

		int cnt0 = 0;
		int cntNe = 0;
		int maxNe = Integer.MIN_VALUE;
		int product = 1;

		for (int i = 0; i < n; i++) {
			if (a[i] == 0) {
				cnt0++;
				continue;
			}
			if (a[i] < 0) {
				maxNe = Math.max(a[i], maxNe);
				cntNe++;
			}
			product *= a[i];
		}

		// all r zero
		if (cnt0 == n)
			return 0;
		// ie even no of +ve exists
		if (cntNe != 0 && cntNe % 2 != 0)
			product /= maxNe;
		return product;
	}

	/** 3. Maximize array sum after k-negations | Set 1 **/
	@Override // O(nk)
	public int maxSumArrWithKNegationX(int a[], int k) {
		// Modify array K number of times
		int n = a.length;
		for (int i = 1; i <= k; i++) {
			int min = Integer.MAX_VALUE;
			int index = -1;

			// Find minimum element in array for
			// current operation and modify it
			// i.e; arr[j] --> -arr[j]
			for (int j = 0; j < n; j++) {
				if (a[j] < min) {
					min = a[j];
					index = j;
				}
			}

			// this the condition if we find 0 as
			// minimum element, so it will useless to
			// replace 0 by -(0) for remaining operations
			if (min == 0)
				break;

			// Modify element of array
			a[index] = -a[index];
		}

		// Calculate sum of array
		int sum = 0;
		for (int i = 0; i < n; i++)
			sum += a[i];
		return sum;
	}

	@Override
	public int maxSumArrWithKNegationZ(int a[], int k) {

		int b[] = new int[a.length];
		int sum = 0;
		for (int i = 0; i < a.length; i++) {
			if (a[i] < 0)
				b[Math.abs(a[i])] = Math.abs(a[i]);
			else
				sum += a[i];
		}
		for (int i = a.length - 1; i >= 0; i--) {
			if (b[i] != 0 && k > 0) {
				sum += b[i];
				k--;
			} else if (k == 0 && b[i] != 0)
				sum += -b[i];
		}
		return sum;

	}

	/* max sub array sum after k-negations */
	@Override
	public int maxSumSubArrWithKNegation(int a[], int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int x : a)
			pq.add(x);

		// Do k negations by removing a minimum element k times
		while (k-- > 0) {
			// Retrieve and remove min element
			int temp = pq.poll();
			if (temp < 0)
				temp *= -1;
			pq.add(temp);
		}

		// Compute sum of all elements in priority queue.
		int sum = 0;
		for (int x : pq) {
			if (x > 0)
				sum += x;
		}
		return sum;
	}

	/** 4. Maximize array sum after k-negations | Set 2 **/
	@Override // O(n+k)
	public int maxSumArrWithKNegationY(int a[], int k) {

		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int x : a)
			pq.add(x);

		// Do k negations by removing a minimum element k times
		while (k-- > 0) {
			// Retrieve and remove min element
			int temp = pq.poll();
			temp *= -1;
			pq.add(temp);
		}

		// Compute sum of all elements in priority queue.
		int sum = 0;
		for (int x : pq)
			sum += x;
		return sum;
	}

	/** 5. Maximize the sum of arr[i]*i **/
	@Override
	public int maxSumOfElemMultiByIndex(int a[]) {

		Arrays.sort(a);
		// Finding the sum of arr[i]*i
		int sum = 0;
		for (int i = 0; i < a.length; i++)
			sum += (a[i] * i);
		return sum;
	}

	// all type of element
	public int maxSumOfElemMultiByIndexX(int a[]) {
		Arrays.sort(a);
		// Finding the sum of arr[i]*i
		int sum = 0;
		for (int i = 0; i < a.length; i++) {
			if (a[i] > 0)
				sum += (a[i] * i);
		}
		return sum;
	}

	/** 6. Maximum sum of increasing order elements from n arrays **/
	@Override
	public int maxSumIncrOrderFromNArrs(int a[][]) {

		// if we r not able to select an element from a row retun 0;
		int n = a.length;
		int m = a[0].length;
		// int max = a[n-1][m-1];
		int prevMax = Integer.MAX_VALUE;
		int maxInRow = 0;
		int maxSum = 0;
		boolean isSeleted = false;
		for (int i = n - 1; i >= 0; i--) {
			maxInRow = Integer.MIN_VALUE;
			isSeleted = false;
			for (int j = 0; j < m; j++) {
				if (maxInRow < a[i][j] && prevMax > a[i][j]) {
					maxInRow = a[i][j];
					isSeleted = true;
				}
			}
			if (!isSeleted)// no any element selected in row
				return 0;
			prevMax = maxInRow;
			maxSum += prevMax;
		}
		return maxSum;
	}

	@Override
	public int minSumIncrOrderFromNArrs(int a[][]) {

		int N = a.length;
		int minSum = 0;
		int currentMin = 0;
		for (int i = 0; i < N; i++) {
			if (i == 0) {
				currentMin = AlgoUtils.min(a[i]);
				minSum += currentMin;
			} else {
				currentMin = AlgoUtils.minGreaterThanK(a[i], currentMin);
				if (currentMin == 0)
					return minSum;
				minSum += currentMin;
			}
		}
		return minSum;
	}

	/** 7. Maximum sum of absolute difference of an array **/
	@Override
	public int maxSumOfAbsDiff(int a[]) {
		int n = a.length;
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				if (i % 2 == 0 && a[i] > a[j])
					AlgoUtils.swap(a, i, j);
				else if (i % 2 != 0 && a[i] < a[j])
					AlgoUtils.swap(a, i, j);
			}
		}
		// wave form created
		int maxAbsSum = 0;
		for (int i = 0; i < a.length; i++) {
			if (i == a.length - 1)
				maxAbsSum += Math.abs(a[i] - a[0]);
			else
				maxAbsSum += Math.abs(a[i] - a[i + 1]);
		}
		return maxAbsSum;
	}

	/** 8. Maximize sum of consecutive differences in a circular array **/
	public int maxSumOfConscutiveDiffInCircularArr(int a[]) {
		int sum = 0;
		int n = a.length;
		// Sorting the array.
		AlgoUtils.sortByN(a);

		// Subtracting a1, a2, a3,....., a(n/2)-1, an/2
		// twice and adding a(n/2)+1, a(n/2)+2, a(n/2)+3,.
		// ...., an - 1, an twice.
		for (int i = 0; i < n / 2; i++) {
			sum -= (2 * a[i]);
			sum += (2 * a[n - i - 1]);
		}

		return sum;
	}

	/** 9. Maximum height pyramid from the given array of objects **/
	public int maxHeightPyramid(int boxes[]) {
		// Total width of ith is less than (i + 1)th.
		// Total number of objects in the ith is less than (i + 1)th.
		Arrays.sort(boxes);

		int ans = 1; // Initialize result
		int prev_width = boxes[0];
		int prev_count = 1;

		int curr_count = 0;

		int curr_width = 0;
		for (int i = 1; i < boxes.length; i++) {

			curr_width += boxes[i];
			curr_count += 1;

			if (curr_width > prev_width && curr_count > prev_count) {

				prev_width = curr_width;
				prev_count = curr_count;

				curr_count = 0;
				curr_width = 0;

				ans++;
			}
		}
		return ans;
	}

	/**
	 * 10. Partition into two subarrays of lengths k and (N – k) such that the
	 * difference of sums is maximum
	 **/
	@Override
	public int partitionForMaxDiffSum(int a[], int k) {

		Arrays.sort(a);
		int maxSumDiff = 0;
		for (int i = k; i < a.length; i++)
			maxSumDiff += a[i];
		for (int i = 0; i < k; i++)
			maxSumDiff -= a[i];
		return maxSumDiff;
	}

	/**
	 * 11. Minimum sum of product of two arrays, k modification allowed on first
	 * array
	 **/
	@Override
	public int minSumOfProducts(int a[], int b[], int k) {

		int n = a.length;
		int diff = 0, res = 0;
		int temp = 0;
		for (int i = 0; i < n; i++) {

			// Find product of current elements
			// and update result.
			int pro = a[i] * b[i];
			res = res + pro;

			// If both product and b[i] are
			// negative, we must increase value
			// of a[i] to minimize result.
			if (pro < 0 && b[i] < 0)
				temp = (a[i] + 2 * k) * b[i];

			// If both product and a[i] are
			// negative, we must decrease value
			// of a[i] to minimize result.
			else if (pro < 0 && a[i] < 0)
				temp = (a[i] - 2 * k) * b[i];

			// Similar to above two cases
			// for positive product.
			else if (pro > 0 && a[i] < 0)
				temp = (a[i] + 2 * k) * b[i];
			else if (pro > 0 && a[i] > 0)
				temp = (a[i] - 2 * k) * b[i];

			// Check if current difference
			// becomes higher than the maximum
			// difference so far.
			int d = Math.abs(pro - temp);
			if (d > diff)
				diff = d;
		}
		return res - diff;
	}

	/** 12. Minimum sum by choosing minimum of pairs from array **/
	@Override
	public int minSumByChooseMinOfPair(int a[]) {

		int sum = 0;
		int n = a.length;
		for (int i = 0; i < n; i += 2) {
			sum += Math.min(a[i], a[i + 1]);
		}
		return sum;
	}

	/** 13. Minimum sum of absolute difference of pairs of two arrays **/
	@Override
	public int minSumAbsDiffOfTwoArrs(int a[], int b[]) {
		if (a.length != b.length)
			return 0;
		Arrays.sort(a);
		Arrays.sort(b);

		// Find sum of absolute differences
		int sum = 0;
		for (int i = 0; i < a.length; i++)
			sum += Math.abs(a[i] - b[i]);

		return sum;
	}

	/* Maximum sum of absolute difference of pairs of two arrays */
	@Override
	public int maxSumAbsDiffOfTwoArrs(int a[], int b[]) {
		if (a.length != b.length)
			return 0;
		Arrays.sort(a);
		Arrays.sort(b);

		// Find sum of absolute differences
		int sum = 0;
		for (int i = 0; i < a.length; i++)
			sum += Math.abs(a[a.length - 1 - i] - b[i]);
		return sum;
	}

	/** 14. Minimum operations to make GCD of array a multiple of k **/
	@Override // operation means increase/decrease by 1
	public int minOprToMakeGcdOfArrMultiOfK(int a[], int k) {

		int result = 0;
		int n = a.length;
		for (int i = 0; i < n; ++i) {

			if (a[i] != 1 && a[i] > k) {
				result = result + Math.min(a[i] % k, k - a[i] % k);
			} else {
				result = result + k - a[i];
			}
		}
		return result;
	}

	/** 15. Minimum sum of absolute difference of pairs of two arrays **/
	/* @See 13. */
	/* 16. Minimum sum of two numbers formed from digits of an array */
	// @Idea sort and make two num by pickup one by one and a+b
	@Override
	public int minSumOfTwoNummByArray(int arr[]) {
		int a = 0;
		int b = 0;
		Arrays.sort(arr);
		for (int i = 0; i < arr.length; i++) {
			if (i % 2 == 0)
				a = a * 10 + arr[i];
			else
				b = b * 10 + arr[i];
		}
		return a + b;
	}

	/* min product */
	// @idea sort and multiple by first no with rest of no building
	@Override
	public int minProdOfTwoNummByArray(int arr[]) {
		int a = 0;
		int b = 0;
		Arrays.sort(arr);
		for (int i = 0; i < arr.length; i++) {
			if (i == 0)
				a += arr[i];
			else
				b = b * 10 + arr[i];
		}
		return a * b;
	}
	/* 17. Minimum increment/decrement to make array non-Increasing */
	/* 18. Making elements of two arrays same with minimum increment/decrement */
	/* 19. Minimize sum of product of two arrays with permutation allowed */
	/* 20. Sorting array with reverse around middle */
	/* 21. Sum of Areas of Rectangles possible for an array */
	/* 22. Array element moved by k using single moves */
	/* 23. Find if k bookings possible with given arrival and departure times */
	/* 24. Lexicographically smallest array after at-most K consecutive swaps */
	/* 25. Largest lexicographic array with at-most K consecutive swaps */
}
