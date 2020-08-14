package com.design.analysis.algo.divideandconquer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

import com.design.analysis.algo.divideandconquer.model.Point;

public class StandardAlgoImpl implements IStandardAlgo {

	/** 0.1 Find the element in non sorted array using D&C **/
	@Override
	public int serchInNonSortedArr(int a[], int x, int l, int r) {

		if (a == null)
			return -1;
		if (a[l] == x)
			return l;
		if (a[r] == x)
			return r;

		if (l < r) {
			int m = (l + r) / 2;
			if (a[m] == x)
				return m;
			return 1 + serchInNonSortedArr(a, x, l, m - 1) + serchInNonSortedArr(a, x, m + 1, r);
		}
		return -1;
	}

	/** 0.2 Find sum of even indexed element array using D&C **/
	@Override
	public int sumOfEvenLableIndexed(int a[], int l, int r, int sum) {

		if (a == null)
			return -1;
		if (r - l == 1) {
			if (l % 2 == 0) {
				return a[l];
			} else {
				return a[r];
			}
		}

		if (r - l == 2 && l % 2 == 0 && r % 2 == 0)
			return a[l] + a[r];

		if (r >= l) {
			int m = (l + r) / 2;
			int x = 0;
			if (m % 2 == 0)
				x = a[m];
			return x + sumOfEvenLableIndexed(a, l, m - 1, sum) + sumOfEvenLableIndexed(a, m + 1, r, sum);
		}
		return 0;
	}

	/** 0.3 Find sum of element array using D&C **/
	@Override
	public int sumOfArrElement(int a[], int l, int r) {

		if (a == null)
			return -1;

		if (l <= r) {
			int m = (l + r) / 2;
			return a[m] + sumOfArrElement(a, l, m - 1) + sumOfArrElement(a, m + 1, r);
		}
		return 0;
	}

	/** 1. Intoduction to Divide and Conquer **/
	/*
	 * 1. Divide: Break the given problem into subproblems of same type. 2.Conquer:
	 * Recursively solve these subproblems. 3. Combine: Appropriately combine the
	 * answers
	 */

	/** 2. Binary Search **/
	public Integer binarySearch(int a[], int l, int r, int x) {

		if (a == null || a.length == 0 || x < a[l] || a[r] < x)
			return null;
		if (a[l] == x)
			return l;
		if (a[r] == x)
			return r;

		if (r >= l) {
			int mid = l + (r - l) / 2;

			if (a[mid] == x)
				return mid;

			if (a[mid] > x)
				return binarySearch(a, l, mid - 1, x);
			else
				return binarySearch(a, mid + 1, r, x);
		}
		return null;
	}

	/** 3. Randomized Binary Search Algorithm **/
	public Integer randomizedBinarySearch(int a[], int l, int r, int x) {
		if (a == null || a.length == 0 || x < a[l] || a[r] < x)
			return null;
		if (a[l] == x)
			return l;
		if (a[r] == x)
			return r;

		if (r >= l) {

			Random rndm = new Random();
			int mid = rndm.nextInt((r - l) + 1) + l;

			if (a[mid] == x)
				return mid;

			if (a[mid] > x)
				return binarySearch(a, l, mid - 1, x);
			else
				return binarySearch(a, mid + 1, r, x);
		}
		return null;
	}

	/** 4. Merge Sort **/
	/* merging two sorted array */
	public void mergeTwoPartSorted(int a[], int l, int m, int r) {
		int n1 = m - l + 1;
		int n2 = r - m;

		int x[] = new int[n1];
		int y[] = new int[n2];

		for (int i = 0; i < n1; i++)
			x[i] = a[l + i];
		for (int j = 0; j < n2; j++)
			y[j] = a[m + 1 + j];

		/* Merge the temp arrays */

		// Initial indexes of first and second subarrays
		int i = 0, j = 0;
		int k = l;

		while (i < n1 && j < n2) {
			if (x[i] <= y[j]) {
				a[k] = x[i];
				i++;
			} else {
				a[k] = y[j];
				j++;
			}
			k++;
		}
		/* copy remaining of x[] */
		while (i < n1) {
			a[k] = x[i];
			k++;
			i++;
		}

		/* copy remaining of y[] */
		while (j < n2) {
			a[k] = y[j];
			k++;
			j++;
		}
	}

	/* merge sort */
	@Override
	public void mergeSort(int arr[], int l, int r) {
		if (l < r) {
			// Find the middle point
			int m = (l + r) / 2;

			// Sort first and second halves
			mergeSort(arr, l, m);
			mergeSort(arr, m + 1, r);

			// Merge the sorted halves
			mergeTwoPartSorted(arr, l, m, r);
		}
	}

	/** 5. Quick Sort **/
	@Override//TODO not give result  in many case
	public void quickSort(int[] a, int l, int h) {

		int pvt = l + (h - l) / 2;
		int i = l;
		int j = h;

		while (i <= j) {
			while (a[i] < a[pvt])
				i++;
			while (a[j] > a[pvt])
				j--;
			if (i <= j) {
				swap(a, i, j);
				i++;
				j--;
			}
		}
		if (l < j)
			quickSort(a, l, j);
		if (i < h)
			quickSort(a, i, h);
	}

	/** 6. Tiling Problem **/
	// initially m and n are equal since a and b is 2 to th power form
	public boolean fillMissingCellByLShapeSmallCell(int a[][], int xi, int yi, int xr, int yr, int b[][], int n) {
		// after rotation of small cell b, it become as square
		// of lenght b.lenght*b.length
		if (xr - xi > n && yr - yi > n) {
			int midi = (xr - xi) / 2;
			int midr = (yr - yi) / 2;

			// check at middle position then divide in 4 part
			if (midi >= n / 2 && midr >= n / 2) {
				for (int i = midi - n / 2; i < midi + n / 2; i++) {
					for (int j = midr - n / 2; j < midr + n / 2; j++) {
						if (a[i][j] == 1)// opposite to missing value
							return true;
					}
				}
			}

			return fillMissingCellByLShapeSmallCell(a, xi, yi, midi, midr, b, n)
					|| fillMissingCellByLShapeSmallCell(a, midi, yi, midi, midr, b, n)
					|| fillMissingCellByLShapeSmallCell(a, xi, midr, midi, yr, b, n)
					|| fillMissingCellByLShapeSmallCell(a, midi, midr, xr, yr, b, n);
		}

		return false;

	}

	/** 7. Count Inversions **/
	public int countIn3version(int arr[], int temp[], int l, int r) {
		int mid, inv_count = 0;
		if (r > l) {

			mid = (r + l) / 2;

			inv_count = countInversion(arr, temp, l, mid);
			inv_count += countInversion(arr, temp, mid + 1, r);

			/* Merge the two parts */
			inv_count += merge(arr, temp, l, mid, r);
		}
		return inv_count;
	}

	/** 8. Calculate pow(x, n) **/
	@Override
	public Float powerOfXtoN(int x, int n) {

		float y;
		if (n == 0)
			return 1f;
		y = powerOfXtoN(x, n / 2);

		if (n % 2 == 0)
			return y * y;
		else {
			if (n > 0)
				return x * y * y;
			else
				return (y * y) / x;
		}
	}

	/** 9. Closest Pair of Points **/
	/** 10. Closest Pair of Points | O(nlogn) Implementation **/
	public List<Point> clogestPoints(List<Point> lp) {
		List<Point> listP = new ArrayList<>();
		// nlogn
		Collections.sort(lp, new CompareXYDist());
		Point a = null;
		Point b = null;
		int minD = Integer.MAX_VALUE;
		// O(n)
		for (int i = 1; i < lp.size(); i++) {
			Point p1 = lp.get(i - 1);
			Point p2 = lp.get(i);
			if (Math.abs(p1.x - p2.x) + Math.abs(p1.y - p2.y) < minD) {
				minD = Math.abs(p1.x - p2.x) + Math.abs(p1.y - p2.y);
				a = p1;
				b = p2;
			}
		}
		listP.add(a);
		listP.add(b);
		
		
		return listP;
	}

	/** 11. Multiply two polynomials **/
	// O(n)
	public int[] multiplyTwoPolynomial(int a[], int b[]) {
		int n = a.length;
		int m = b.length;
		int x = (n - 1) + (m - 1) + 1;// since power will be add
		int c[] = new int[x];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++)
				c[i + j] += a[i] * b[j];
		}
		return c;
	}

	/** 12. Strassen’s Matrix Multiplication **/
	public int[][] matrixMultiplication(int a[][], int b[][]) {

		// not multiplicable
		// p*q and q*r = p*q
		if (a[0].length != b.length)
			return null;
		int c[][] = new int[a.length][b[0].length];

		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < b.length; j++) {
				c[i][j] = 0;
				for (int k = 0; k < a[0].length; k++) {
					c[i][j] += a[i][k] * b[k][j];
				}
			}
		}
		return c;
	}

	// TODO
	/** 13. The Skyline Problem **/

	/** 14. Maximum Subarray Sum **/
	public int maxSubArraySum(int a[], int l, int h) {
		// Base Case: Only one element
		if (l == h)
			return a[l];

		// Find middle point
		int m = (l + h) / 2;

		return Math.max(Math.max(maxSubArraySum(a, l, m), maxSubArraySum(a, m + 1, h)), maxCrossingSum(a, l, m, h));
	}
//TODO
	public int maxCrossingSum(int a[], int l, int m, int h) {
		// Include elements on left of mid.
		int sum = 0;
		int left_sum = Integer.MIN_VALUE;
		for (int i = m; i >= l; i--) {
			sum = sum + a[i];
			if (sum > left_sum)
				left_sum = sum;
		}

		// Include elements on right of mid
		sum = 0;
		int right_sum = Integer.MIN_VALUE;
		for (int i = m + 1; i <= h; i++) {
			sum = sum + a[i];
			if (sum > right_sum)
				right_sum = sum;
		}

		// Return sum of elements on left
		// and right of mid
		return left_sum + right_sum;
	}

	/** 15. Longest Common Prefix **/
	public String longestCommonPrefix(String arr[], int low, int high) {
		if (low == high)
			return (arr[low]);

		if (high > low) {
			// Same as (low + high)/2, but avoids overflow for
			// large low and high
			int mid = low + (high - low) / 2;

			String str1 = longestCommonPrefix(arr, low, mid);
			String str2 = longestCommonPrefix(arr, mid + 1, high);

			return (commonPrefixUtil(str1, str2));
		}
		return null;
	}

	public String commonPrefixUtil(String str1, String str2) {
		String result = "";
		int n1 = str1.length(), n2 = str2.length();

		for (int i = 0, j = 0; i <= n1 - 1 && j <= n2 - 1; i++, j++) {
			if (str1.charAt(i) != str2.charAt(j))
				break;
			result += str1.charAt(i);
		}
		return (result);
	}

	/** 16. Search in a Row-wise and Column-wise Sorted 2D Array **/
	//
	//TODO for well understanding
	public void search(int[][] mat, int fromRow, int toRow, int fromCol, int toCol, int key) {
// Find middle and compare with middle 
		int i = fromRow + (toRow - fromRow) / 2;
		int j = fromCol + (toCol - fromCol) / 2;
		if (mat[i][j] == key) // If key is present at middle
			System.out.println("Found " + key + " at " + i + " " + j);
		else {
			// right-up quarter of matrix is searched in all cases.
			// Provided it is different from current call
			if (i != toRow || j != fromCol)
				search(mat, fromRow, i, j, toCol, key);

			// Special case for iteration with 1*2 matrix
			// mat[i][j] and mat[i][j+1] are only two elements.
			// So just check second element
			if (fromRow == toRow && fromCol + 1 == toCol)
				if (mat[fromRow][toCol] == key)
					System.out.println("Found " + key + " at " + fromRow + " " + toCol);

			// If middle key is lesser then search lower horizontal
			// matrix and right hand side matrix
			if (mat[i][j] < key) {
				// search lower horizontal if such matrix exists
				if (i + 1 <= toRow)
					search(mat, i + 1, toRow, fromCol, toCol, key);
			}

			// If middle key is greater then search left vertical
			// matrix and right hand side matrix
			else {
				// search left vertical if such matrix exists
				if (j - 1 >= fromCol)
					search(mat, fromRow, toRow, fromCol, j - 1, key);
			}
		}
	}

	/** 17. Karatsuba algorithm for fast multiplication **/
	public int merge(int arr[], int temp[], int l, int mid, int r) {
		int i, j, k;
		int inv_count = 0;

		i = l; /* i is index for left subarray */
		j = mid + 1; /* j is index for right subarray */
		k = l; /* k is index for resultant merged subarray */
		while ((i <= mid) && (j <= r)) {
			if (arr[i] <= arr[j]) {
				temp[k++] = arr[i++];
			} else {
				temp[k++] = arr[j++];

				/* this is tricky */
				inv_count = inv_count + (mid + 1 - i);
			}
		}

		while (i <= mid)
			temp[k++] = arr[i++];

		while (j <= r)
			temp[k++] = arr[j++];

		/* Copy back the merged elements to original array */
		for (i = l; i <= r; i++)
			arr[i] = temp[i];

		return inv_count;
	}

	/**********************************************************************************************************************************************************************/
	/** swap two element of array **/
	public void swap(int a[], int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	class CompareXYDist implements Comparator<Point> {
		// Used for sorting in ascending order of
		// roll name
		public int compare(Point a, Point b) {
			return ((int) Math.pow(Math.abs(a.x), 2) + (int) Math.pow(Math.abs(a.y), 2))
					- ((int) Math.pow(Math.abs(b.x), 2) + (int) Math.pow(Math.abs(b.y), 2));
		}
	}

	@Override
	public int countInversion(int[] arr, int[] temp, int l, int r) {
		// TODO Auto-generated method stub
		return 0;
	}
}
