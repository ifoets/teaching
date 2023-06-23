package com.design.analysis.algo.array;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.design.analysis.algo.utils.AlgoUtils;

public class ArrayRotationImpl implements IArrayRotation {
	/** 1. Program for array rotation **/
	/* by using temporary array, TC-O(n)- SC- O(n) */
	@Override
	public void arrayRotationByTemp(int a[], int k) {

		int n = a.length;
		int temp1[] = new int[k];
		int temp2[] = new int[n - k];
		int i, l = 0;
		for (i = n - k; i < n; i++)
			temp1[l++] = a[i];
		for (i = 0; i < n - k; i++)
			temp2[i] = a[i];
		for (i = 0; i < k; i++)
			a[i] = temp1[i];
		for (i = k, l = 0; i < n; i++)
			a[i] = temp2[l++];
	}

	/* by using temporary array, TC-O(kn)- SC- O(0) */
	public void arrayRotationByOneByOneRot(int a[], int k) {
		int i, j;
		int n = a.length;
		for (i = 0; i < k; i++) {
			int temp = a[a.length - 1];
			for (j = n - 2; j >= 0; j--)
				a[j + 1] = a[j];
			a[0] = temp;
		}
	}

	/** 2. Reversal algorithm for array rotation **/
	/* Function to left rotate arr[] of size n by d O(n) from start */
	public void arrayRotationByReversalStat(int arr[], int k) {
		int n = arr.length;
		AlgoUtils.rvereseArray(arr, 0, k - 1);
		AlgoUtils.rvereseArray(arr, k, n - 1);
		AlgoUtils.rvereseArray(arr, 0, n - 1);
	}

	@Test
	public void arrRoatByBlockSwap(int arr[], int n, int d) {
		int i, j;
		if (d == 0 || d == n)
			return;
		i = d;
		j = n - d;
		while (i != j) {
			if (i < j) /* A is shorter */
			{
				AlgoUtils.swapXelem(arr, d - i, d + j - i, i);
				j -= i;
			} else /* B is shorter */
			{
				AlgoUtils.swapXelem(arr, d - i, d, j);
				i -= j;
			}
			// printArray(arr, 7);
		}
		/* Finally, block swap A and B */
		AlgoUtils.swapXelem(arr, d - i, d, i);
	}

	/** 4. Program to cyclically rotate an array by one **/
	@Override
	public void cyclicRotation(int arr[]) {

		int n = arr.length;
		int x = arr[n - 1], i;
		for (i = n - 1; i > 0; i--)
			arr[i] = arr[i - 1];
		arr[0] = x;
	}

	/** 5. Search an element in a sorted and rotated array **/
	@Test
	public int findPivot(int arr[], int low, int high) {
		// base cases
		if (high < low)
			return -1;
		if (high == low)
			return low;

		/* low + (high - low)/2; */
		int mid = (low + high) / 2;
		if (mid < high && arr[mid] > arr[mid + 1])// mid < high && no need
			return mid;
		if (low < mid && arr[mid - 1] > arr[mid])// (mid > low && no need
			return (mid - 1);
		if (arr[low] >= arr[mid])
			return findPivot(arr, low, mid - 1);
		return findPivot(arr, mid + 1, high);
	}

	/* search element in sorted and rotated array O(log(n)) */
	public int searchInSortedRotatedArr(int a[], int key) {
		int n = a.length;
		int pivot = findPivot(a, 0, n - 1);

		// If we didn't find a pivot, then
		// array is not rotated at all
		if (pivot == -1)
			return AlgoUtils.binarySearch(a, 0, n - 1, key);
		if (a[pivot] == key)
			return pivot;
		if (a[0] <= key)
			return AlgoUtils.binarySearch(a, 0, pivot - 1, key);
		return AlgoUtils.binarySearch(a, pivot + 1, n - 1, key);
	}

	/** 6.sorted and rotated array, find if there is a pair with a given sum **/
	public List<List<Integer>> pariSumInSortedRottedArr(int a[], int sum) {

		int n = a.length;
		List<List<Integer>> liList = new ArrayList<>();
		List<Integer> list = null;
		int pivot = findPivot(a, 0, n - 1);
		for (int i = pivot + 1; i < n; i++) {
			int index = AlgoUtils.binarySearch(a, 0, pivot, sum - a[i]);
			if (index != -1) {
				list = new ArrayList<>();
				list.add(a[i]);
				list.add(a[index]);
				liList.add(list);
			}
		}
		return liList;
	}

	/**
	 * 7. Max value of Sum( i*arr[i]) with only rotations on given array allowed
	 **/
	@Override
	public int maxSumIndexIntoElem(int arr[]) {

		int n = arr.length;
		int arrSum = 0;
		int currVal = 0;
		for (int i = 0; i < n; i++) {
			arrSum = arrSum + arr[i];
			currVal = currVal + (i * arr[i]);
		}
		int maxVal = currVal;
		for (int j = 1; j < n; j++) {
			currVal = currVal + arrSum - n * arr[n - j];
			if (currVal > maxVal)
				maxVal = currVal;
		}
		return maxVal;
	}

	/** 8. Maximum sum of i*arr[i] among all rotations of a given array **/
	@Override
	public int maxSumByRotationIndexIntoElem(int arr[]) {
		int n = arr.length;
		// Compute sum of all array elements

		int cum_sum = 0;
		for (int i = 0; i < n; i++)
			cum_sum += arr[i];

		int curr_val = 0;
		for (int i = 0; i < n; i++)
			curr_val += i * arr[i];

		// Initialize result
		int res = curr_val;

		// Compute values for other iterations
		for (int i = 1; i < n; i++) {
			// Compute next value using previous
			// value in O(1) time
			int next_val = curr_val - (cum_sum - arr[i - 1]) + arr[i - 1] * (n - 1);
			// Update current value
			curr_val = next_val;
			// Update result if required
			res = Math.max(res, next_val);
		}
		return res;
	}

	/** 9. Find the Rotation Count in Rotated Sorted array **/
	@Override
	public int countRotationOfSortedArr(int a[]) {
		return a.length - (1 + findPivot(a, 0, a.length - 1));
	}

	/** 10. Quickly find multiple left rotations of an array **/
	@Override
	public void arryAfterKRotation(int a[], int n, int k) {
		int i, j;
		k = k % n;
		int b[] = new int[2 * n];
		for (i = 0; i < n; i++)
			b[i] = b[n + i] = a[i];
		for (i = k, j = 0; i < n + k; i++, j++)
			a[j] = b[i];
	}

	/** 11. Find the minimum element in a sorted and rotated array **/
	public int minInSortedAndRotatedArr(int a[]) {
		return a[findPivot(a, 0, a.length - 1) + 1];
	}

	/** 12. Reversal algorithm for right rotation of an array **/
	/* by using temporary array, TC-O(n)- SC- O(0) ..from end */
	@Override
	public void arrayRotationByReversalEnd(int arr[], int k) {
		int n = arr.length;
		int Y = arr.length - k;
		AlgoUtils.rvereseArray(arr, 0, Y - 1);
		AlgoUtils.rvereseArray(arr, Y, n - 1);
		AlgoUtils.rvereseArray(arr, 0, n - 1);
	}

	/** 13. Find a rotation with maximum hamming distance **/
	@Override
	public int maxHamming(int arr[], int n) {
		int brr[] = new int[2 * n + 1];
		for (int i = 0; i < n; i++)
			brr[i] = arr[i];
		for (int i = 0; i < n; i++)
			brr[n + i] = arr[i];

		int maxHam = 0;

		// check for every rotation form 1, 0 pos is always 0
		for (int i = 1; i < n; i++) {
			int currHam = 0;
			for (int j = i, k = 0; j < (i + n); j++, k++)
				if (brr[j] != arr[k])
					currHam++;
			// We can never get more than n.
			if (currHam == n)
				return n;

			maxHam = Math.max(maxHam, currHam);
		}

		return maxHam;
	}

	/** 14. Queries on Left and Right Circular shift on array **/
	// this use left and right rotation and find the sum form l index to r

	/** 15. Print left rotation of array in O(n) time and O(1) space **/
	@Override
	public void leftRotate(int arr[], int n, int k) {
		int mod = k % n;
		for (int i = 0; i < n; ++i)
			System.out.print(arr[(i + mod) % n] + " ");
		System.out.println();
	}

	/** 16. Find element at given index after a number of rotations **/
	@Override
	public int findElement(int[] arr, int[][] ranges, int rotations, int index) {
		for (int i = rotations - 1; i >= 0; i--) {
			// Range[left...right]
			int left = ranges[i][0];
			int right = ranges[i][1];

			// Rotation will not have any effect
			if (left <= index && right >= index) {
				if (index == left)
					index = right;
				else
					index--;
			}
		}
		// Returning new element
		return arr[index];
	}
}
