
package com.design.analysis.core.algo.array;

import java.util.*;
import java.util.stream.Collectors;

import com.design.analysis.core.algo.utils.AlgoUtils;

public class ArrangeReArrangeImpl implements IArrangeReArrange {

	/** 1. Rearrange an array such that arr[i] = i **/
	@Override
	public void fixedAtIndex(int a[]) {

		int n = a.length;
		for (int i = 0; i < n; i++) {

			if (a[i] != -1 && a[i] != i) {
				int x = a[i];
				// find the correct index
				while (a[x] != -1 && a[x] != x) {
					int y = a[x];
					a[x] = x;
					x = y;
				}
				// place at correct index
				a[x] = x;

				// if correect index not set by while loop
				if (a[i] != i) {
					a[i] = -1;
				}
			}
		}
	}

	/* another apporach with O(n) both SC and TC */
	@Override
	public void fixedAtIndexX(int a[]) {
		int n = a.length;
		int b[] = new int[n];
		Arrays.fill(b, -1);
		for (int i = 0; i < n; i++) {
			if (a[i] > 0)
				b[a[i]] = a[i];
		}
		for (int i = 0; i < n; a[i] = b[i], i++)
			;
	}

	/* for every type of -ve/+ve and no should be in list */
	@Override
	public void fixedAtIndexY(int a[]) {
		for (int i = 0; i < a.length; i++) {
			if (a[i] > 0 && a[i] != i) {
				int x = a[a[i]];
				a[a[i]] = a[i];
				a[i] = x;
				i--;
			}
		}
	}

	/*using java 8*/
	public int[] fixedAtIndexZ(int a[])
	{
		int b[] = new int[a.length];
		Arrays.stream(a).map( e->
		{
			if(e>0)
				b[e]=e;
			return e;
		}).toArray();
		return b;
	}
	/** 2. Write a program to reverse an array or string **/
	@Override
	public void reverseArr(int a[]) {
		int i, j, temp;

		i = 0;
		j = a.length - 1;
		while (i < j) {
			temp = a[i];
			a[i] = a[j];
			a[j] = temp;
			i++;
			j--;
		}
	}
	/*using java 8 stream*/
	@Override
	public List<Integer> reverseArrX(int a[]){
		List<Integer> list = Arrays.stream(a).boxed().collect(Collectors.toList());
		Collections.reverse(list);
		return list.stream().toList().stream().toList();
	}
	/**
	 * 3. Rearrange array such that arr[i] >= arr[j] if i is even and arr[i]<=arr[j]
	 * if i is odd and j < i
	 **/
	/*
	 * elements at even positions are greater than all elements before it and
	 * elements at odd positions are less than all elements before it.
	 */
	public void evenPosIncrOddPosDecr(int arr[], int n) {

		// TODO keep evern as it is and reverse the odd fi find both side for i an j
		int evenPos = n / 2;
		int oddPos = n - evenPos;

		int[] tempArr = new int[n];

		for (int i = 0; i < n; i++)
			tempArr[i] = arr[i];
		Arrays.sort(tempArr);

		int j = oddPos - 1;

		// fill up odd position in original array
		for (int i = 0; i < n; i += 2) {
			arr[i] = tempArr[j];
			j--;
		}

		j = oddPos;

		// fill up even positions in original array
		for (int i = 1; i < n; i += 2) {
			arr[i] = tempArr[j];
			j++;
		}
	}

	/** it realize it require wave form sorting start from low */
	@Override
	public void evenPosIncrOddPosDecrX(int arr[], int n) {
		int b[] = Arrays.copyOfRange(arr, 0, n);
		Arrays.sort(b);
		if (n % 2 == 0) {
			for (int i = 0; i < n / 2; i++) {
				arr[2 * i] = b[i];
				arr[n - (2 * i + 1)] = b[n - (i + 1)];
			}
		} else {
			for (int i = 0; i < n / 2 + 1; i++) {
				if (i != n / 2) {
					arr[2 * i] = b[i];
					arr[n - (2 * i + 2)] = b[n - (i + 1)];
				} else {
					arr[n - 1] = b[i];
				}
			}
		}

		// System.out.println(Arrays.toString(arr));
	}

	/* Just wave form */
	// @Idea except 1 element swap on interval of 2
	@Override
	public void reArrageWaveForm(int a[]) {
		Arrays.sort(a);
		int n = a.length;
		int m = n % 2 == 0 ? n : n - 1;
		for (int i = 0; i < m; i += 2) {
			int temp = a[i];
			a[i] = a[i + 1];
			a[i + 1] = temp;
		}
	}

	/*
	 * elements at odd positions are greater than all elements before it and
	 * elements at even positions are less than all elements before it.
	 * 
	 */
	public void evenPosIncrOddPosIncr(int arr[], int n) {
		int evenPos = n / 2;
		int oddPos = n - evenPos;

		int[] tempArr = new int[n];

		for (int i = 0; i < n; i++)
			tempArr[i] = arr[i];
		Arrays.sort(tempArr);

		int j = oddPos - 1;

		// fill up even positions in original array
		for (int i = 0; i < n; i += 2) {
			arr[i] = tempArr[j];
			j++;
		}

		j = oddPos - 2;

		// fill up odd position in original array
		for (int i = 1; i < n; i += 2) {
			arr[i] = tempArr[j];
			j--;
		}

	}

	/** 4. Rearrange positive and negative numbers in TC O(n) time and SC O(1) **/
	// @Idea check left +ve & right -ve together exchange, just move on with left
	// -ve, right +ve just
	@Override
	public void reArrangePosAndNeg(int a[]) {

		int i = 0;
		int j = a.length - 1;
		while (i < j) {
			if (a[i] > 0 && a[j] < 0) {
				int temp = a[i];
				a[i] = a[j];
				a[j] = temp;
				i++;
				j--;
			}
			if (a[i] < 0)
				i++;
			if (a[j] > 0)
				j--;
		}
	}

	/** 5. Rearrange array in alternating positive & negative items by T(n) S(1) **/
	// @Idea partition left -ve and right +ve and swap neg=0 to pos+1 +ve with
	// pos++and neg+=2
	@Override
	public void alternativePosNevElem(int a[]) {
		int n = a.length;
		// make partition of -ve and +ve element
		int i = -1;
		for (int j = 0; j < n; j++) {
			if (a[j] < 0) {
				i++;
				AlgoUtils.swap(a, i, j);
			}
		}
		int pos = i + 1;
		int neg = 0;

		while (pos < n && neg < pos && a[neg] < 0) {
			AlgoUtils.swap(a, neg, pos);
			pos++;
			neg += 2;
		}
	}

	/**
	 * 6. Move all zeroes to end of array
	 **/
	public void pushZerosToEnd(int a[]) {
		int n = a.length;
		int count = 0;
		for (int i = 0; i < n; i++)
			if (a[i] != 0)
				a[count++] = a[i];

		while (count < n)
			a[count++] = 0;
	}

	/** 7. Move all zeroes to end of array | (Using single traversal) **/
	public void moveZerosToEnd(int a[]) {
		int n = a.length;
		int count = 0;

		for (int i = 0; i < n; i++)
			if (a[i] != 0)
				AlgoUtils.swap(a, count++, i);
	}

	/** 8. Minimum swaps bring all elements less than or equal to k together **/
	// IDEA arrange like seperate +ve/-ve together just a[i]-k>0 at the place of
	// a[i]>0
	// to push 0 at the end of array
	// @Idea count <=k elements
	public int minSwapLessThanKElemTogether(int a[], int k) {
		int n = a.length;
		int count = 0;

		for (int i = 0; i < n; i++)
			if (a[i] <= k)
				AlgoUtils.swap(a, count++, i);
		return count;
	}

	/** 9. Rearrange positive and negative numbers using inbuilt sort function **/
	// @See 4.
	/** 10. Rearrange array such that even positioned are greater than odd **/
	public void evenPosGreaterThanOddPos(int a[]) {
		int n = a.length;
		Arrays.sort(a);

		int ans[] = new int[n];
		int p = 0, q = n - 1;
		for (int i = 0; i < n; i++) {

			// Assign even indexes with maximum elements
			if ((i + 1) % 2 == 0)
				ans[i] = a[q--];
			// Assign odd indexes with remaining elements
			else
				ans[i] = a[p++];
		}
		for (int i = 0; i < n; a[i] = ans[i], i++)
			;
	}

	/**
	 * 11. Rearrange an array in order � smallest, largest, 2nd smallest, 2nd
	 * largest, ..
	 **/
	@Override
	public void reArrangeSpecilly(int a[]) {

		int n = a.length;
		int j = a.length - 1;
		int i = 0;
		int k = 0;
		int b[] = new int[n];
		Arrays.sort(a);

		while (i < j && k < n) {
			b[k++] = a[i++];
			b[k++] = a[j--];
		}
		// for odd lenght ar
		if (i == j)
			b[k++] = a[i];
		for (i = 0; i < n; a[i] = b[i], i++)
			;
	}

	/** 12. Double the first element(if a[i]==a[i+1]) and move zero to end **/
	/*
	 * Convert the array in such a way that if both current and next element is
	 * valid and both have same value then double current value and replace the next
	 * number with 0. After the modification, rearrange the array such that all 0�s
	 * shifted to the end.
	 */
	@Override
	public void doubleFirstAndPushZeroEnd(int a[]) {
		int n = a.length;
		if (n == 1)
			return;

		// traverse the array
		for (int i = 0; i < n - 1; i++) {
			// if true, perform the required modification
			if ((a[i] != 0) && (a[i] == a[i + 1])) {
				// double current index value
				a[i] = 2 * a[i];
				// put 0 in the next index
				a[i + 1] = 0;
				// increment by 1 so as to move two
				// indexes ahead during loop iteration
				i++;
			}
		}
		pushZerosToEnd(a);
	}

	/** 13. Reorder an array according to given indexes **/
	// O(n) and auxiliary space O(1)
	@Override
	public void reorderAccToGivenIndex(int a[], int ind[]) {

		int n = a.length;
		if (n != ind.length)
			return;
		int temp[] = new int[n];
		for (int i = 0; i < n; temp[ind[i]] = a[i], i++)
			;
		for (int i = 0; i < n; a[i] = temp[i], i++)
			;
	}

	/** 15. Arrange given numbers to form the biggest number **/

	public String formBiggestNo(int a[]) {
		class BigestInt {
			String num;

			public BigestInt(String num) {
				super();
				this.num = num;
			}

			@Override
			public String toString() {
				return num;
			}

		}

		List<BigestInt> numList = new ArrayList<BigestInt>();
		// comparison algorithm tell before and other each others for decreasing order
		for (int i : a) {
			numList.add(new BigestInt(String.valueOf(i)));
		}

		Collections.sort(numList, new Comparator<BigestInt>() {
			@Override
			public int compare(BigestInt o1, BigestInt o2) {
				String st1 = o1.num;
				String st2 = o2.num;
				int n1 = st1.length();
				int n2 = st2.length();

				int i = 0;
				int j = 0;

				if (st1.equals(st2))
					return 0;
				while (i != n1 && j != n2) {
					if (st1.charAt(i) == st2.charAt(j)) {
						if (i != n1 - 1)
							i++;
						if (j != n2 - 1)
							j++;
					} else {
						return st2.charAt(j) - st1.charAt(i);
					}
				}
				return 0;
			}
		});

		StringBuilder sbr = new StringBuilder();
		for (BigestInt num : numList)
			sbr.append(num.num);
		return sbr.toString();
	}

	/**
	 * 16. Rearrange an array such that �arr[j]� becomes �i� if �arr[i]� is �j�
	 **/
	public void arrangeInSpecial(int a[]) {
		// n perfect no
		int n = a.length;
		int temp[] = new int[n];
		for (int i = 0; i < n; temp[a[i]] = i, i++)
			;
		for (int i = 0; i < n; a[i] = temp[i], i++)
			;
	}

	/** 17. Rearrange an array in maximum minimum form | Set 1 */
	// Expected time complexity is O(n). sorted array
	@Override
	public void rearrangeMaxMinForm(int a[]) {
		int n = a.length;
		int temp[] = new int[n];
		int small = 0, large = n - 1;
		boolean flag = true;

		// Store result in temp[]
		for (int i = 0; i < n; i++) {
			if (flag)
				temp[i] = a[large--];
			else
				temp[i] = a[small++];

			flag = !flag;
		}
		// Copy temp[] to arr[]
		for (int i = 0; i < n; a[i] = temp[i], i++)
			;
	}

	/** 18. Rearrange an array in maximum minimum form | Set 2 (O(1) space) **/
	@Override
	public void segregateElements(int arr[]) {

		int n = arr.length;
		int temp[] = new int[n];
		int j = 0; // index of temp

		for (int i = 0; i < n; i++)
			if (arr[i] >= 0)
				temp[j++] = arr[i];

		// If array contains all positive or all
		// negative.
		if (j == n || j == 0)
			return;

		// Store -ve element in temp array
		for (int i = 0; i < n; i++)
			if (arr[i] < 0)
				temp[j++] = arr[i];

		// Copy contents of temp[] to arr[]
		for (int i = 0; i < n; i++)
			arr[i] = temp[i];
	}
	/**
	 * 19. Move all negative numbers to beginning and positive to end with constant
	 * extra space
	 **/
	// @See 14.
	/** 20. Move all negative elements to end in order with extra space allowed **/
	// @See 14.
	/**
	 * 21. Rearrange array such that even index elements are smaller and odd index
	 * elements are greater
	 **/
	// @See 17.

	/** 22. Positive elements at even and negative at odd positions **/
	// @See 5.
	/** 23. Replace every array element by multiplication of previous and next **/
	@Override
	public void modify(int arr[], int n) {
		// Nothing to do when array size is 1
		if (n <= 1)
			return;
		// store current value of arr[0] and update it
		int prev = arr[0];
		arr[0] = arr[0] * arr[1];

		// Update rest of the array elements
		for (int i = 1; i < n - 1; i++) {
			// Store current value of next interation
			int curr = arr[i];
			// Update current value using previos value
			arr[i] = prev * arr[i + 1];
			// Update previous value
			prev = curr;
		}
		// Update last array element
		arr[n - 1] = prev * arr[n - 1];
	}

	/** 24. Shuffle a given array **/
	@Override
	public void shuffleArr(int arr[], int n) {
		// Creating a object for Random class
		Random r = new Random();
		// Start from the last element and swap one by one. We don't
		// need to run for the first element that's why i > 0
		for (int i = n - 1; i > 0; i--) {
			// Pick a random index from 0 to i
			int j = r.nextInt(i);
			// Swap arr[i] with the element at random index
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
		}
	}

	/** 25. Segregate even and odd numbers **/
	// @See 14 there +ve/-ve here odd/even

	/* 26. Segregate 0s and 1s in an array */
	@Override
	public void segregate0sAnd1s(int a[]) {

		int i = 0;
		int j = a.length - 1;
		while (i < j) {
			if (a[i] == 0)
				i++;
			if (a[j] == 1)
				j--;
			if (a[i] == 1 && a[j] == 0) {
				ArrayUtil.swapArr(a, i, j);
				i++;
				j--;
			}

		}
	}

	/* 27. Longest Bitonic Subsequence */
	@SuppressWarnings("unused")
	// @Idea find LIS(longest increasing subsequence) form both side then the max
	// of(lis1+lis2-1) since one element is common in both
	// @TODO Need to clear once again
	@Override
	public int bitonicSubsequence(int arr[]) {
		int n = arr.length;
		int i, j;

		/*
		 * Allocate memory for LIS[] and initialize LIS values as 1 for all indexes
		 */
		int[] lis = new int[n];
		for (i = 0; i < n; i++)
			lis[i] = 1;

		/* Compute LIS values from left to right */
		for (i = 1; i < n; i++)
			for (j = 0; j < i; j++)
				if (arr[i] > arr[j] && lis[i] < lis[j] + 1)
					lis[i] = lis[j] + 1;

		/*
		 * Allocate memory for lds and initialize LDS values for all indexes
		 */
		int[] lds = new int[n];
		for (i = 0; i < n; i++)
			lds[i] = 1;

		/* Compute LDS values from right to left */
		for (i = n - 2; i >= 0; i--)
			for (j = n - 1; j > i; j--)
				if (arr[i] > arr[j] && lds[i] < lds[j] + 1)
					lds[i] = lds[j] + 1;

		/* Return the maximum value of lis[i] + lds[i] - 1 */
		int max = lis[0] + lds[0] - 1;
		for (i = 1; i < n; i++)
			if (lis[i] + lds[i] - 1 > max)
				max = lis[i] + lds[i] - 1;

		return max;
	}

	/* 28. Find a sorted subsequence of size 3 in linear time */
	// @Idea find min<max and then max<a[i]
	@Override
	public List<Integer> find3Numbers(int a[]) {
		int n = a.length;
		List<Integer> result = new ArrayList<>();
		int min = a[0];
		int store_min = min;
		int max = Integer.MAX_VALUE;

		for (int i = 1; i < n; i++) {
			if (a[i] == min)
				continue;
			else if (a[i] < min) {
				min = a[i];
				continue;
			} else if (a[i] < max) {
				max = a[i];
				store_min = min;
			} else if (a[i] > max) {
				result.add(store_min);
				result.add(max);
				result.add(a[i]);
				break;
			}

		}
		return result;
	}

	/*
	 * 29. Largest subarray with equal number of 0s and 1s 30. Maximum Product
	 * Sub-array
	 */
	@Override
	public int findMaxLength(int[] a) {

		Map<Integer, Integer> map = new HashMap<>();
		int count = 0;
		int maxlen = 0;

		for (int i = 0, n = a.length; i < n; i++) {
			count += a[i] == 1 ? 1 : -1;

			if (count == 0) {
				maxlen = Math.max(maxlen, i + 1);
			}

			if (map.containsKey(count)) {
				maxlen = Math.max(maxlen, i - map.get(count));
			} else
				map.put(count, i);
		}
		return maxlen;
	}

	/* 29.1 find the max sub array with equal no of 0s and 1s */
	public List<Integer> findMaxSubArray(int[] a) {
		Map<Integer, Integer> map = new HashMap<>();
		int count = 0;
		int iniPos = 0;
		int finPos = 0;
		int check = 0;
		List<Integer> list = new ArrayList<>();
		for (int i = 0, n = a.length; i < n; i++) {
			count += a[i] == 1 ? 1 : -1;

			if (count == 0) {
				iniPos = 0;
				finPos = i;
			}

			if (map.containsKey(count)) {
				check = 0;
				for (int j = -count; j <= i; j++) {
					check += a[i] == 1 ? 1 : -1;
				}
				if (check == 0) {
					iniPos = -count;
					finPos = i;
				}
			} else
				map.put(count, i);
		}
		for (int i = iniPos; i <= finPos; list.add(a[i]), i++)
			;
		System.out.println("Initial Pos: " + iniPos + "\n Final Pos: " + finPos);
		return list;
	}

	/*30.	Maximum Product Sub-array, this is modified to max sum sub-array*/
	@Override
	public int maxProductSubArray(int a[])
	{
		int maxPSoFar = Integer.MIN_VALUE,start=0,end=0,s=0;
		int currentPro = 1;

		for(int i=0;i < a.length ;i++)
		{
			currentPro *= a[i];

			if(maxPSoFar < currentPro)
			{
				maxPSoFar = currentPro;
				end = i;
				start = s;
			}
			if(currentPro == 0)
			{
				currentPro = 1;
				s = i + 1;
			}
		}
		System.out.println("Start :"+start +"\nEnd :"+end);
		return maxPSoFar;
	}

	/* 31. Replace every element with the greatest element on right side */
	@Override
	public void replaceNextGreatest(int a[])
	{
          int N=a.length, maxFromRight = a[N-1];
		  a[N-1] = -1; //no right to this

		for(int i = N-2 ;i >=0; i--)
		{
			int temp = a[i];
			a[i] = maxFromRight;
			if(maxFromRight < temp )
			{
				maxFromRight = temp;
			}
		}
	}

	/* 32. Maximum circular subarray sum, it is modified of min sum array version */
	@Override
	public int maxSumCircularSubArray(int a[])
	{
      int b[] = minSumSubArrayIndexes(a);
	  int sum = 0;
	  for(int i=0 ; i< a.length ;i++)
	  {
		  sum+= (i>=b[0] && i <= b[1]) ? 0 :a[i];
	  }
	  return sum;
	}
	/*min sum sub array indexes */
	@Override
	public int[] minSumSubArrayIndexes(int a[]){
		int rs[] = new int[2];
		int minSumSoFar = Integer.MAX_VALUE,start=0,end=0,s=0;
		int currentSum = 0;

		for(int i=0;i < a.length ;i++)
		{
			currentSum += a[i];

			if(minSumSoFar > currentSum)
			{
				minSumSoFar = currentSum;
				end = i;
				start = s;
			}
			if(currentSum > 0)
			{
				currentSum = 0;
				s = i + 1;
			}
		}
		rs[0] = start;
		rs[1] = end;
		System.out.println("Start :"+start +"\nEnd :"+end);
		return rs;

	}

	/* 33. Construction of Longest Increasing Subsequence (N log N) */
	@Override
	public List<Integer> consLongestIncrSubseq(int a[]){
		   int N=a.length,k=1;
           int b[] = new int[N];
			b[0]= a[0];
		for(int i = 1 ;i < N; i++)
		   {
			   if(b[k-1] < a[i])
				   b[k++]=a[i];
			   else {
				   b[AlgoUtils.binarySearchJustGreaterOrLess(b,0,k,a[i],true)]=a[i];
			   }
		   }
		return Arrays.stream(b).filter(e -> e!=0).boxed().toList();
	}
	/* 34. Sort elements by frequency | Set 2 */
	@Override
	public List<Integer> sortByFrequency(int a[], boolean incOrDec){
		int N = a.length;
		Map<Integer, Integer> map = new HashMap<>();
		List<Integer> list = new ArrayList<>();

		for(int i =0 ;i<N ;i++)
		{
			if(map.containsKey(a[i]))
				map.put(a[i], map.get(a[i])+1);
			else map.put(a[i],1);
		}

		map.entrySet().stream().sorted(incOrDec ? Map.Entry.<Integer, Integer>comparingByValue().thenComparing(Map.Entry.<Integer, Integer>comparingByKey())
						: Collections.reverseOrder(Map.Entry.<Integer, Integer>comparingByValue()))
				.forEach( entry -> {
					for( int i=0 ;i<entry.getValue() ; list.add(entry.getKey()),i++);
				});
		return list;
	}
	/* 35. Maximize sum of consecutive differences in a circular array, re arrangement allowed */
	@Override
	public int maxSumConsecutiveDiffCirArray(int a[]){
       Arrays.sort(a);//or sort in wave form and go for consecutive diff
	   int sum=0, N=a.length;
	   for(int i=0;i<N/2;i++)
	   {
		   sum-=(2*a[i]);
		   sum+=(2*a[N-1-i]);
	   }
	   return sum;
	}
	/***********************************************************************************************************************************************************************/

	/** 3. Sort an array in wave form **/
	@Override
	public void sortInWaveForm(int arr[]) {
		// Traverse all even elements
		int n = arr.length;
		for (int i = 0; i < n; i += 2) {
			// If current even element is smaller than previous
			if (i > 0 && arr[i - 1] > arr[i])
				AlgoUtils.swap(arr, i, i - 1);

			// If current even element is smaller than next
			if (i < n - 1 && arr[i] < arr[i + 1])
				AlgoUtils.swap(arr, i, i + 1);
		}
	}

	/** 5. Sort an array according to absolute difference with given value **/
	@Override
	public void sortBasDiffwithX(int a[], int x) {
		// use bst tree insert with cmparision bas(a[i]-x)<abs(n.dt-x)
		// and travell preorder
	}

	/** 6. Move all negative elements to end in order with extra space allowed **/
	@Override
	public void allNegelemEndofArr(int a[]) {
		int i = 0;
		int j = a.length - 1;
		while (i < j) {
			if (a[i] < 0 && a[j] > 0) {
				int temp = a[i];
				a[i] = a[j];
				a[j] = temp;
				i++;
				j--;
			}
			if (a[i] > 0)
				i++;
			if (a[j] < 0)
				j--;
		}
	}

	/** 7. Three way partitioning of an array around a given range **/
	@Override
	public void threeWayPartitioning(int a[], int x, int y) {

		int i = 0;
		int j = a.length - 1;
		int st, end;
		st = 0;
		end = j;
		int temp;
		for (i = 0; i < end;) {

			if (a[i] < x) {
				temp = a[st];
				a[st] = a[i];
				a[i] = temp;
				st++;
				i++;
			} else if (a[i] > y) {
				temp = a[end];
				a[end] = a[i];
				a[i] = temp;
				end--;
			} else
				i++;
		}
	}

	/** 8. Rearrange an array in maximum minimum form | Set 1 **/
	@Override // arr is sorted
	public int[] rearrangeInMaxMinForm(int a[]) {

		int i, j, k;
		j = a.length - 1;
		int b[] = new int[a.length];
		for (i = 0, k = 0; i <= j;) {
			if (k % 2 == 0) {
				b[k++] = a[j];
				j--;
			} else {
				b[k++] = a[i];
				i++;
			}
		}
		return b;
	}

	/** 9. Rearrange an array in maximum minimum form | Set 2 (O(1) extra space) **/
	@Override
	public int[] rearrangeInMaxMinFormX(int a[]) {
		return null;
	}

}
