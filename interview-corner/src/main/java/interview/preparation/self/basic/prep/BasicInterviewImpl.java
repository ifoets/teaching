package interview.preparation.self.basic.prep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class BasicInterviewImpl implements IBasicInterview {

	/* Search element in array in fastest way */
	public int advSearch(int a[], int x) {

		int N = a.length;
		// searies 5,25,125.625.search in chunk by chunk
		// you can put base 2,3,4,5 any thing here base is 5
		int n = (int) Math.pow(N, 1 / 5);
		if (a[0] == x)
			return 0;

		for (int i = 1; i < n;) {
			int result = search(a, x, i, 5);
			if (result != -1)
				return result;
			else
				i++;
		}
		// for last iteration
		for (int i = n; i < N; i++) {
			if (a[i] == x)
				return i;
		}
		return -1;
	}

	public int search(int a[], int x, int power, int base) {
		for (int i = (int) Math.pow(base, power - 1); i < Math.pow(base, power); i++) {
			if (a[i] == x)
				return i;
		}
		return -1;
	}

	/*
	 * Question 1 : How to reverse a String in java? Can you write a program without
	 * using any java inbuilt methods?
	 */
	@Override
	public String recursiveReverse(String str) {

		if (str.length() == 1)
			return str;
		else
			return str.charAt(str.length() - 1) + recursiveReverse(str.substring(0, str.length() - 1));
	}

	/*
	 * Question 2 : Write a java program to check if two Strings are anagram in
	 */
	@Override
	public boolean checkAnagram(String str1, String str2) {

		if (str1.length() != str2.length())
			return false;
		int a[] = new int[26];
		int b[] = new int[26];
		str1 = str1.toLowerCase();
		str2 = str2.toLowerCase();
		for (int i = 0; i < str1.length(); a[str1.charAt(i) - 97]++, b[str2.charAt(i) - 97]++, i++)
			;
		for (int i = 0; i < 26; i++) {
			if (a[i] != b[i])
				return false;
		}
		return true;
	}

	/*
	 * java? Question 3 : Write a program to check if String has all unique
	 * characters in java?
	 */
	@Override
	public boolean checkAllUniqueChar(String str) {

		int a[] = new int[26];
		str = str.toLowerCase();

		for (int i = 0; i < str.length(); a[str.charAt(i) - 97]++, i++)
			;

		for (int i = 0; i < 26; i++) {
			if (a[i] > 1)
				return false;
		}
		return true;
	}

	/*
	 * Question 4 : How to check if one String is rotation of another String in
	 * java?
	 */
	@Override
	public boolean checkStringRoation(String str1, String str2) {
		if (str1.length() != str2.length())
			return false;
		if (str1.concat(str1).contains(str2))
			return true;
		return false;
	}

	/*
	 * Question 5 : How to find duplicate characters in String in java?
	 */
	@Override
	public char[] duplicateChar(String str) {

		StringBuilder sb = new StringBuilder();
		int a[] = new int[26];

		str = str.toLowerCase();
		for (int i = 0; i < str.length(); a[str.charAt(i) - 97]++, i++)
			;
		for (int i = 0; i < 26; i++) {
			if (a[i] > 1)
				sb = sb.append((char) (i + 97));
		}
		return sb.toString().toCharArray();
	}

	/*
	 * Question 6 : Find first non repeated character in String in java? Question
	 */
	@Override
	public Character firstNonReptChar(String str) {
		str = str.toLowerCase();
		int a[] = new int[26];
		for (int i = 0; i < str.length(); a[str.charAt(i) - 97]++, i++)
			;

		for (int i = 0; i < str.length(); i++) {
			if (a[str.charAt(i) - 97] == 1)
				return str.charAt(i);
		}
		return null;
	}

	/*
	 * 7 : Find all substrings of String in java? Question
	 */
	@Override
	public List<String> allSubstr(String str) {
		int n = str.length();
		List<String> list = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j <= n; j++) {
				String st = (String) str.subSequence(i, j);
				list.add(st);
			}
		}
		return list;
	}

	/*
	 * 8 : Find length of String without using any inbuilt method in java?
	 */
	@SuppressWarnings("unused")
	@Override
	public int leng(String str) {
		int count = 0;
		for (char ch : str.toCharArray()) {
			count++;
		}
		return count;
	}

	/*
	 * Question 9 : Write a program to print all permutations of String in java?
	 */
	@Override
	public void permutationStr(String str, int l, int r) {

		if (l == r)
			System.out.println(str);
		else {
			for (int i = l; i <= r; i++) {
				str = swap(str, l, i);
				permutationStr(str, l + 1, r);
				str = swap(str, l, i);
			}
		}
	}

	public String swap(String str, int i, int j) {
		char chArr[] = str.toCharArray();
		char temp = chArr[i];
		chArr[i] = chArr[j];
		chArr[j] = temp;
		return String.valueOf(chArr);
	}

	/* Array */
	/*
	 * Question 10 : Write java Program to Find Smallest and Largest Element in an
	 * 
	 * Array.
	 */
	@Override
	public int[] smallestLagest(int a[]) {

		int b[] = new int[2];
		b[0] = Integer.MAX_VALUE;
		b[1] = Integer.MIN_VALUE;

		for (int i = 0; i < a.length; i++) {
			// for min
			if (b[0] > a[i])
				b[0] = a[i];
			if (b[1] < a[i])
				b[1] = a[i];
		}
		return b;
	}

	/*
	 * Question 11 : Find missing number in the array.
	 */
	@Override
	public int missingNo(int a[]) {
		int n = a.length;
		int N = n + 1;// one is missing
		int sum = 0;
		for (int i = 0; i < n; sum += a[i++])
			;
		return (int) (N * (N + 1) / 2 - sum);
	}

	/*
	 * Question 12 : Search an element in rotated and sorted array.
	 */
	@Override
	public int elemInSortedRotatedArr(int a[], int key) {

		int n = a.length;
		int pvt = findPivot(a, 0, n - 1);
		if (pvt == -1)
			binSearch(a, key, 0, n - 1);
		;
		if (key == a[pvt])
			return pvt;
		if (a[0] < key)
			return binSearch(a, key, 0, pvt);
		return binSearch(a, key, pvt + 1, n - 1);

	}

	public int findPivot(int a[], int l, int r) {
		if (l > r)
			return -1;
		if (l == r)
			return l;
		int m = (l + r) / 2;

		if (l < m && a[m] < a[m - 1])
			return m - 1;
		if (m < r && a[m + 1] < a[m])
			return m;
		if (a[l] >= a[m])
			return findPivot(a, l, m - 1);
		return findPivot(a, m + 1, r);

	}

	public int binSearch(int a[], int key, int l, int r) {
		if (l > r)
			return -1;
		else {
			int m = (l + r) / 2;
			if (key == a[m])
				return m;
			else if (key > a[m])
				return binSearch(a, key, m + 1, r);
			return binSearch(a, key, l, m - 1);
		}
	}

	/*
	 * public Question 13 : Find minimum element in a sorted and rotated array.
	 */
	@Override
	public int minSortedRotatedArr(int a[]) {

		int pvt = findPivot(a, 0, a.length - 1);
		return pvt == -1 ? a[0] : a[pvt + 1];
	}

	/*
	 * Question 14: Find second largest number in an array Question xth largest
	 * means n-x smallest
	 */
	@Override
	public int nLargest(int a[], int x) {

		for (int i = 0; i < x; i++) {
			for (int j = i + 1; j < a.length; j++) {
				if (a[i] < a[j]) {
					int temp = a[i];
					a[i] = a[j];
					a[j] = temp;
				}
			}
		}
		return a[x - 1];
	}

	/*
	 * *15 : Find the number occurring odd number of times in an array Question in
	 * single traverse
	 */
	@Override
	public int oddNumsInArr(int a[]) {
		int xor = 0;
		for (int i : a) {
			xor = xor ^ i;
		}
		return xor;
	}

	/*
	 * 16 : Find minimum number of platforms required for railway station
	 */
	public int minNoOfPlatform(int a[], int d[]) {
		// no meaning which train arr and which train departure
		int n = a.length;
		Arrays.sort(a);
		Arrays.sort(d);
		int plt = 1;
		int i = 1;
		int j = 0;
		int result = 1;

		while (i < n && j < n) {
			if (a[i] <= d[j]) {
				plt++;
				i++;
			} else if (a[i] > d[j]) {
				plt--;
				j++;
			}
			if (plt > result)
				result = plt;
		}
		return result;
	}

	/*
	 * Question 17 : Find a Pair Whose Sum is Closest to zero in Array Question
	 */
	@Override
	public int pariSumCloestToZero(int a[]) {

		// nlogn
		Arrays.sort(a);
		int l = 0;
		int r = a.length;
		int minSum = Integer.MAX_VALUE;

		while (l < r) {
			int sum = a[l] + a[r - 1];
			if (Math.abs(minSum) > Math.abs(sum)) {
				minSum = sum;
			}
			if (sum < 0)
				l++;
			else
				r--;
		}
		return minSum;
	}

	// clogest to zero the triple
	@Override
	public int tripleSumCloestToZero(int a[]) {
		// nlog(n)
		Map<Integer, Integer> map = new HashMap<>();
		Arrays.sort(a);
		int minSum = Integer.MAX_VALUE;
		int l = 0;
		int r = a.length - 1;
		int x, y, z;
		x = y = z = 0;

		// O(n)
		while (l <= r) {
			int sum = a[l] + a[r];
			if (Math.abs(minSum) > Math.abs(sum)) {
				minSum = sum;
				x = l;
				y = r;
			}
			if (sum < 0)
				l++;
			else
				r--;
		}
		System.out.println(a[x]);
		System.out.println(a[y]);
		// O(n)
		int nextMinSum = Integer.MAX_VALUE;
		for (int i = 1; i < a.length; i++) {
			if (i != x && i != y) {
				int sum = minSum + a[i];
				if (Math.abs(nextMinSum) > Math.abs(sum)) {
					nextMinSum = sum;
					z = i;
				}
			}
		}
		map.put(x, a[x]);
		map.put(y, a[y]);
		map.put(z, a[z]);
		System.out.println(map);
		return a[x] + a[y] + a[z];
	}

	/*
	 * 18 : Given a sorted array and a number x, find the pair in array whose sum is
	 * closest to x
	 */
	@Override
	public int[] pairClogest(int a[], int x) {
		// if array is not sorted Arrays.sort(a)
		int rs[] = new int[2];
		int l = 0;
		int r = a.length - 1;
		int minSum = Integer.MAX_VALUE;

		int n1 = 0;
		int n2 = 0;
		while (l <= r) {
			int sum = Math.abs(a[l] + a[r]);
			if (minSum > Math.abs(sum - x)) {
				n1 = a[l];
				n2 = a[r - 1];
				minSum = Math.abs(sum - x);
			}
			if (sum - x < 0)
				l++;
			else
				r--;
		}
		rs[0] = n1;
		rs[1] = n2;
		return rs;
	}

	/*
	 * Question 19 : Find all pairs of elements from an array whose sum is equal to
	 * given number
	 */
	@Override
	public Map<Integer, Integer> pairSumOfX(int a[], int x) {
		Arrays.sort(a);
		Map<Integer, Integer> map = new HashMap<>();
		int l = 0;
		int r = a.length - 1;
		while (l <= r) {
			int sum = a[l] + a[r];
			if (x == sum) {
				map.put(a[l], a[r]);
			}
			if (sum - x < 0)
				l++;
			else
				r--;
		}
		return map;
	}

	/*
	 * Question 20: Given an array of 0’s and 1’s in random order, you need to
	 * separate 0’s and 1’s in an array.
	 */
	@Override
	public void seperate01(int a[]) {
		int l = 0;
		int r = a.length - 1;
		while (l <= r) {
			if (a[l] == 1 && a[r] == 0) {
				int temp = a[l];
				a[l] = a[r];
				a[r] = temp;
			}
			if (a[l] == 0)
				l++;
			if (a[r] == 1)
				r--;
		}
	}

	/*
	 * Question 21 : Separate odd and even numbers in an array Question 22
	 */
	@Override
	public void seperateOddEven(int a[]) {
		int l = 0;
		int r = a.length - 1;
		while (l <= r) {
			if (a[l] % 2 == 0 && a[r] % 2 == 1) {
				int temp = a[l];
				a[l] = a[r];
				a[r] = temp;
			}
			if (a[l] % 2 == 1)
				l++;
			if (a[r] % 2 == 0)
				r--;
		}
	}

	/*
	 * : Given an array containing zeroes, ones and twos only. Write a function to
	 * sort the given array in O(n) time complexity.
	 */
	@Override
	public void sort012(int a[], int n) {
		int x[] = new int[n];
		for (int i : a) {
			x[i]++;
		}
		int k = 0;
		for (int i = 0; i < n; i++) {
			while (x[i]-- > 0)
				a[k++] = i;
		}
	}

	/*
	 * Question 23 : Find local minima in array
	 */
	@Override
	public int localMinima(int a[], int l, int r, int n) {

		int mid = (l + r) / 2;

		if (mid == 0 || a[mid - 1] > a[mid] && a[mid] < a[mid + 1] || mid == n - 1)
			return a[mid];
		else if (mid > 0 && a[mid - 1] < a[mid])
			return localMinima(a, l, mid - 1, n);
		return localMinima(a, mid + 1, r, n);
	}

	/*
	 * Question 24 : Sliding window maximum in java Question
	 */
	@Override
	public List<Integer> slidingWindowMax(int a[], int k) {

		List<Integer> list = new ArrayList<>();
		int n = a.length;

		for (int i = 0; i <= n - k; i++) {
			int max = a[i];
			for (int j = 1; j < k; j++) {
				if (max < a[i + j])
					max = a[i + j];
			}
			list.add(max);
		}
		return list;
	}

	/*
	 * 25 : Count number of occurrences (or frequency) of each element in a sorted
	 * array
	 */
	@Override
	public int frequencyOfItems(int a[], int k) {

		int freq = 0;
		int index = binSearch(a, k, 0, a.length - 1);
		if (index < 0)
			return 0;
		int i = index;
		while (i < a.length && a[i++] == a[index])
			freq++;
		i = index;
		while (i >= 0 && a[i--] == a[index])
			freq++;
		// 2 extra get added in first comparison
		return freq - 1;

	}

	/* Question 29 : Count 1’s in sorted Binary Array. */

	public int binSearchBinary(int a[], int key, int l, int r) {
		if (l > r)
			return -1;
		else {
			int m = (l + r) / 2;
			if (key == a[m])
				return m;
			// for increasing
			return binSearch(a, key, m + 1, r);
			// for decreasing arr
			// return binSearch(a, key, l, m-1);
		}
	}

	@Override
	public int count1sInSortedBinaryArr(int a[]) {
		int freq = 0;
		int index = binSearchBinary(a, 1, 0, a.length - 1);
		if (index < 0)
			return 0;
		int i = index;
		while (i < a.length && a[i++] == a[index])
			freq++;
		i = index;
		while (i >= 0 && a[i--] == a[index])
			freq++;
		// 2 extra get added in first comparison
		return freq - 1;
	}

	/* Question 30 : Find first repeating element in an array of integers. */
	@Override
	public int firstRepetating(int a[]) {
		Set<Integer> set = new HashSet<>();
		List<Integer> l = new ArrayList<>();
		for (int i = 0; i < a.length; i++) {
			if (set.contains(a[i]))
				l.add(a[i]);
			else
				set.add(a[i]);
		}
		for (Integer x : l) {
			for (int i = 0; i < a.length; i++) {
				if (x == a[i])
					return x;
			}
		}
		return -1;
	}

	@Override
	public int firstMinMaxRpetation(int a[], int minMax) {
		int n = a.length;
		int max = a[0];
		for (int i = 1; i < n; i++) {
			if (max < a[i])
				max = a[i];
		}
		int b[] = new int[max + 1];
		for (int i = 0; i < n; b[a[i++]]++)
			;
		if (minMax == 0) {
			for (int i = 0; i <= max; i++) {
				if (b[i] > 1)
					return i;
			}
		} else {
			for (int i = max; i >= 0; i--) {
				if (b[i] > 1)
					return i;
			}
		}
		return -1;
	}

	/* Question 31 : Check if Array Elements are Consecutive. */
	@Override
	public boolean checkConsecutive(int a[]) {
		int n = a.length;
		int min = a[0];
		int max = a[0];

		for (int i = 1; i < n; i++) {
			if (max < a[i])
				max = a[i];
			if (min > a[i])
				min = a[i];
		}
		int b[] = new int[max - min + 1];
		for (int i = 0; i < b.length; b[a[i++] - min]++)
			;
		for (int j = 0; j < b.length - 1; j++) {
			if (b[j] != 1)
				return false;
		}
		return true;
	}

	/* Question 32 : Permutations of array in java. */
	@Override
	public void permutation(List<Integer> arr, int k) {

		for (int i = k; i < arr.size(); i++) {
			Collections.swap(arr, i, k);
			permutation(arr, k + 1);
			Collections.swap(arr, k, i);
		}
		if (k == arr.size() - 1) {
			System.out.println(java.util.Arrays.toString(arr.toArray()));
		}
	}

	/* Question 33 : Rotate an array by K positions. */
	public void reverse(int a[], int l, int r) {
		while (l < r) {
			int temp = a[l];
			a[l] = a[r];
			a[r] = temp;
			l++;
			r--;
		}
	}

	@Override
	public void rotateKpos(int a[], int k) {

		int r = a.length - 1;
		int d = r - k;
		reverse(a, 0, d);
		reverse(a, d + 1, r);
		reverse(a, 0, r);
	}

	/* Question 34 : Stock Buy Sell to Maximize Profit. */
	@Override
	public int stockSellMaxPofit(int a[]) {
return -1;
	}
}