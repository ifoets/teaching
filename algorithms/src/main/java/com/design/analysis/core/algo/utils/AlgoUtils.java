package com.design.analysis.core.algo.utils;

import com.design.analysis.core.algo.node.Point;

public class AlgoUtils {

	public static void swap(int a, int b) {
		a = a + b;
		b = a - b;
		a = a - b;
	}

	// area of tringle
	public static double areaTringle(Point a, Point b, Point c) {
		int x1 = a.x;
		int y1 = a.y;
		int x2 = b.x;
		int y2 = b.y;
		int x3 = c.x;
		int y3 = c.y;
		return Math.abs((x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2)) / 2.0);
	}

	// distance between tow points
	public static int getDistance(Point p1, Point p2) {
		return (p2.x - p1.x) * (p2.x - p1.x) + (p2.y - p1.y) * (p2.y - p1.y);
	}

//  return array [d, a, b] such that d = gcd(p, q), ap + bq = d
	public static int[] extendedGcd(int p, int q) {
		if (q == 0)
			return new int[] { p, 1, 0 };

		int[] vals = extendedGcd(q, p % q);
		int d = vals[0];
		int a = vals[2];
		int b = vals[1] - (p / q) * vals[2];
		return new int[] { d, a, b };
	}

	public static int binomialCoeff(int n, int k) {
		// Base Cases
		if (k == 0 || k == n)
			return 1;
		// Recurrence relation
		return binomialCoeff(n - 1, k - 1) + binomialCoeff(n - 1, k);
	}

	/* swap values in two arrays having both indexes) */
	public static void swapValArrays(int a[], int b[], int i, int j) {
		int temp = a[i];
		a[i] = b[j];
		b[j] = temp;
	}

	// used for +ve integer and max element is not so far from no of element
	public static void sortByN(int a[]) {
		int max = a[0];
		for (int i = 1; i < a.length; i++) {
			if (a[i] > max)
				max = a[i];
		}
		int b[] = new int[max + 1];
		for (int i = 0; i < a.length; i++)
			b[a[i]] = a[i];

		for (int i = 0, k = 0; i < b.length; i++) {
			if (b[i] != 0)
				a[k++] = b[i];
		}
	}

	public static long gcd(long a, long b) {
		if (a == 0)
			return b;
		return gcd(b % a, a);
	}

	public static int gcd(int n1, int n2) {
		int gcd = 1;
		if ((n1 != 0 && Math.abs(n1) != 1) && (n2 != 0 && Math.abs(n2) != 1)) {
			for (int i = 1; i <= n1 && i <= n2; i++) {
				if (n1 % i == 0 && n2 % i == 0) {
					gcd = i;
				}
			}
		}
		return gcd;
	}

	public static int countSetBitsUtil(int x) {
		if (x <= 0)
			return 0;
		else
			return (x % 2 == 0 ? 0 : 1) + countSetBitsUtil(x / 2);
	}

	public static int max(int a[]) {

		int max = Integer.MIN_VALUE;
		for (int i = 0; i < a.length; i++) {
			if (max < a[i])
				max = a[i];
		}
		return max;
	}

	public static int min(int a[]) {

		int max = Integer.MAX_VALUE;
		for (int i = 0; i < a.length; i++) {
			if (max > a[i])
				max = a[i];
		}
		return max;
	}

	public static int minGreaterThanK(int a[], int k) {

		int max = Integer.MAX_VALUE;
		for (int i = 0; i < a.length; i++) {
			if (max > a[i] && a[i] > k)
				max = a[i];
		}
		return max == Integer.MAX_VALUE ? 0 : max;
	}

	public static int maxIndex(int a[], int n) {
		int max = Integer.MIN_VALUE;
		int index = 0;
		for (int i = 0; i < n; i++) {
			if (max < a[i]) {
				index = i;
				max = a[i];
			}
		}
		return index;
	}

	public static int min(int a, int b, int c) {
		return min(min(a, b), c);
	}

	public static int min(int a, int b) {
		return a > b ? b : a;
	}

	public static int max(int a, int b, int c) {
		return max(max(a, b), c);
	}

	public static int max(int a, int b) {
		return a > b ? a : b;
	}

	public static int numOfDigit(int num) {
		int n = 1;
		while (num / 10 > 0) {
			n++;
			num /= 10;
		}
		return n;
	}

	// number of continuous element filled in array except 0
	public static int numOfDigitInArray(int arr[]) {
		int i = 0;
		int count = 0;
		while (arr[i++] > 0) {
			count++;
			if (i == arr.length)
				break;
		}
		return count;
	}

	public static void copyArray(int src[], int initSrcPos, int dest[], int initDestPos, int len) {
		try {
			if (len > src.length || len > dest.length) {
				throw new Exception("length of copy is greater");
			}
			for (int i = initSrcPos; i < len; i++) {
				if (initSrcPos == src.length || initDestPos == dest.length)
					throw new Exception("lenghth of copy is greater");
				dest[initDestPos++] = src[initSrcPos++];
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/*
	 * public static Object XOR(Object obj1, Object obj2) { Object obj = new
	 * Object(); obj =obj1 ^ obj2; return (Object) obj1 ^ obj2; }
	 */

	/*
	 * A utility function to return precedence of a given operator Higher returned
	 * value means higher precedence
	 */
	public static int precedence(char ch) {

		switch (ch) {

		case '+':
		case '-':
			return 1;

		case '*':
		case '/':
			return 2;

		case '^':
			return 3;
		}
		return -1;
	}

	// A utility function to check if the given character is operand
	public static boolean isOperand(char ch) {
		return (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z');
	}

	public static void swapChar(char[] chars, int fplace, int splace) {
		char temp = chars[fplace];
		chars[fplace] = chars[splace];
		chars[splace] = temp;
	}

	public static void swap(int arr[], int x, int y) {
		int temp = arr[x];
		arr[x] = arr[y];
		arr[y] = temp;
	}

	public static int binarySearch(int arr[], int low, int high, int key) {
		if (high < low)
			return -1;
		int mid = (low + high) / 2;
		if (key == arr[mid])
			return mid;
		if (key > arr[mid])
			return binarySearch(arr, (mid + 1), high, key);
		return binarySearch(arr, low, (mid - 1), key);
	}

	public static int binarySearchGreaterKey(int arr[], int low, int high, int key) {
		if (high < low)
			return -1;
		int mid = (low + high) / 2;
		if (key == arr[mid] || arr[mid - 1] < key && key < arr[mid])
			return mid;
		if (key > arr[mid])
			return binarySearch(arr, (mid + 1), high, key);
		return binarySearch(arr, low, (mid - 1), key);
	}

	public static int findCrossOver(int arr[], int low, int high, int x) {
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

	public static int binarySearchFirstOccurence(int arr[], int low, int high, int x) {
		if (high >= low) {
			int mid = (low + high) / 2; /* low + (high - low)/2; */

			/*
			 * Check if arr[mid] is the first occurrence of x. arr[mid] is first occurrence
			 * if x is one of the following is true: (i) mid == 0 and arr[mid] == x (ii)
			 * arr[mid-1] < x and arr[mid] == x
			 */
			if ((mid == 0 || x > arr[mid - 1]) && (arr[mid] == x))
				return mid;
			else if (x > arr[mid])
				return binarySearchFirstOccurence(arr, (mid + 1), high, x);
			else
				return binarySearchFirstOccurence(arr, low, (mid - 1), x);
		}
		return -1;
	}

	/* Function to reverse arr[] from index start to end */
	public static void rvereseArray(int arr[], int start, int end) {
		int temp;
		while (start < end) {
			temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;
			start++;
			end--;
		}
	}

	/* Function to swap the array of 2 part of same length */
	public static void swapArrPart(int arr[], int l1, int r1, int l2, int r2) {
		if (r2 - l2 == r1 - l1) {
			int temp;
			for (int i = l1, j = l2; i <= r1; i++, j++) {
				temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
	}

	/*
	 * This function swaps d elements starting at index fi with d elements starting
	 * at index si
	 */
	public static void swapXelem(int arr[], int fi, int si, int d) {
		int i, temp;
		for (i = 0; i < d; i++) {
			temp = arr[fi + i];
			arr[fi + i] = arr[si + i];
			arr[si + i] = temp;
		}
	}

	/* insetion sort using left and right index of array */
	public static void insertionSort(int a[], int l, int r) {

		for (int i = l + 1; i <= r; i++) {
			int temp = a[i];
			int j = i - 1;
			while (a[j] > temp && j >= l) {
				a[j + 1] = a[j];
				j--;
			}
			a[j + 1] = temp;
		}
	}

	public static void mergeTwoPartSorted(int a[], int l, int m, int r) {
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

	public static int binarySearchJustGreaterOrLess(int arr[], int l, int r, int x, boolean bigOrSmall)
	{
		while (l <= r) {
			int m = l + (r - l) / 2;
			// Check if x is present at mid
			if ( (m ==0 || arr[m-1] < x) && x < arr[m] )
				return bigOrSmall ? m : m-1;
			else if((m == r || arr[m] > x) && x > arr[m -1])
				return bigOrSmall ? m : m-1;
			// If x greater, ignore left half
			if (arr[m] < x)
				l = m + 1;
				// If x is smaller, ignore right half
			else
				r = m - 1;
		}

		// If we reach here, then element was
		// not present
		return -1;
	}
	public static int CeilIndex(int A[], int l, int r, int key)
	{
		while (r - l > 1) {
			int m = l + (r - l) / 2;
			if (A[m] >= key)
				r = m;
			else
				l = m;
		}

		return r;
	}

    public static void reversePart(int []a, int i, int j)
    {
         while (i<j)
         {
             int temp = a[i];
             a[i]=a[j];
             a[j]=temp;
             i++;
             j--;
         }
    }
    public static void swapAlternative(int []a)
    {
        int i=0;
        while(i+1<a.length)
        {
            int temp = a[i];
            a[i]=a[i+1];
            a[i+1]=temp;
            i+=2;
        }
    }
    public static int searchGreaterInSorted(int []a, int x)
    {
        for (int j : a) {
            if (j > x)
                return j;
        }
        return -1;
    }

    public static int searchIndex(int []a, int x)
    {
        for(int i=0;i<a.length;i++)
        {
            if(a[i]==x)
                return i;
        }
        return -1;
    }
}
