package com.design.analysis.core.algo.array;

import java.util.List;

/*
 * 
 * @author GuruG
 * 
Array Rearrangement
	Recent articles on Array rearrangement
	1.	Rearrange an array such that arr[i] = i
	2.	Write a program to reverse an array or string
	3.	Rearrange array such that arr[i] >= arr[j] if i is even and arr[i]<=arr[j] if i is odd and j < i
	4.	Rearrange positive and negative numbers in O(n) time and O(1) extra space
	5.	Rearrange array in alternating positive & negative items with O(1) extra space | Set 1
	6.	Move all zeroes to end of array
	7.	Move all zeroes to end of array | Set-2 (Using single traversal)
	8.	Minimum swaps required to bring all elements less than or equal to k together
	9.	Rearrange positive and negative numbers using inbuilt sort function
	10.	Rearrange array such that even positioned are greater than odd
	11.	Rearrange an array in order � smallest, largest, 2nd smallest, 2nd largest, ..
	12.	Double the first element and move zero to end
	13.	Reorder an array according to given indexes
	14.	Rearrange positive and negative numbers with constant extra space
	15.	Arrange given numbers to form the biggest number
	16.	Rearrange an array such that �arr[j]� becomes �i� if �arr[i]� is �j�
	17.	Rearrange an array in maximum minimum form | Set 1
	18.	Rearrange an array in maximum minimum form | Set 2 (O(1) extra space)
	19.	Move all negative numbers to beginning and positive to end with constant extra space
	20.	Move all negative elements to end in order with extra space allowed
	21.	Rearrange array such that even index elements are smaller and odd index elements are greater
	22.	Positive elements at even and negative at odd positions
	23.	Replace every array element by multiplication of previous and next
	24.	Shuffle a given array
	25.	Segregate even and odd numbers
	26.	Segregate 0s and 1s in an array
	27.	Longest Bitonic Subsequence
	28.	Find a sorted subsequence of size 3 in linear time
	29.	Largest subarray with equal number of 0s and 1s
	30.	Maximum Product Sub-array
	31.	Replace every element with the greatest element on right side
	32.	Maximum circular subarray sum
	33.	Construction of Longest Increasing Subsequence (N log N)
	34.	Sort elements by frequency | Set 2
	35.	Maximize sum of consecutive differences in a circular array
	36.	Sort an array according to the order defined by another array
	37.	Find Index of 0 to be replaced with 1 to get longest continuous sequence of 1s in a binary array
	38.	Three way partitioning of an array around a given range
	39.	Generate all possible sorted arrays from alternate elements of two given sorted arrays
	40.	Minimum number of swaps required for arranging pairs adjacent to each other
	41.	Convert array into Zig-Zag fashion
	42.	Form minimum number from given sequence
	43.	Replace two consecutive equal values with one greater
	44.	Rearrange a binary string as alternate x and y occurrences
	45.	Distinct adjacent elements in an array
	46.	Shuffle 2n integers as a1-b1-a2-b2-a3-b3-..bn without using extra space
	47.	Merge k sorted arrays


 */
public interface IArrangeReArrange {
	/** 1. Rearrange an array such that arr[i] = i **/
	public void fixedAtIndex(int a[]);

	public void fixedAtIndexX(int a[]);

	/* for every type of -ve no and no should be in list */
	public void fixedAtIndexY(int a[]);

	/*using java 8*/
	public int[] fixedAtIndexZ(int a[]);

	/** 2. Write a program to reverse an array or string **/
	public void reverseArr(int a[]);

	/*using java 8 stream*/
	public List<Integer> reverseArrX(int a[]);
	/**
	 * 3. Rearrange array such that arr[i] >= arr[j] if i is even and arr[i]<=arr[j]
	 * if i is odd and j < i
	 **/
	public void evenPosIncrOddPosDecr(int arr[], int n);

	/** it realize it require wave form sorting start from low */
	public void evenPosIncrOddPosDecrX(int arr[], int n);

	public void evenPosIncrOddPosIncr(int arr[], int n);

	/* Just wave form */
	public void reArrageWaveForm(int a[]);

	// IDEA sort element with +2 take even and odd pos seperately

	/** 4. Rearrange positive and negative numbers in TC O(n) time and SC O(1) **/
	public void reArrangePosAndNeg(int a[]);

	/** 5. Rearrange array in alternating positive & negative items by T(n) S(1) **/
	public void alternativePosNevElem(int a[]);

	/** 6. Move all zeroes to end of array **/
	public void pushZerosToEnd(int a[]);

	/** 7. Move all zeroes to end of array | (Using single traversal) **/
	public void moveZerosToEnd(int a[]);

	/** 8. Minimum swaps bring all elements less than or equal to k together **/
	public int minSwapLessThanKElemTogether(int a[], int k);

	/** 9. Rearrange positive and negative numbers using inbuilt sort function **/
	// @See 4.
	/** 10. Rearrange array such that even positioned are greater than odd **/
	public void evenPosGreaterThanOddPos(int a[]);

	/**
	 * 11. Rearrange an array in order � smallest, largest, 2nd smallest, 2nd
	 * largest, ..
	 **/
	public void reArrangeSpecilly(int a[]);

	/** 12. Double the first element and move zero to end **/
	public void doubleFirstAndPushZeroEnd(int a[]);

	/** 13. Reorder an array according to given indexes **/
	public void reorderAccToGivenIndex(int a[], int ind[]);

	/** 14. Rearrange positive and negative numbers with constant extra space reArragePosAndNeg **/
	/** 15. Arrange given numbers to form the biggest number **/
	public String formBiggestNo(int n[]);

	/** 16. Rearrange an array such that �arr[j]� becomes �i� if �arr[i]� is �j� **/
	public void arrangeInSpecial(int a[]);

	/** 17. Rearrange an array in maximum minimum form | Set 1 */
	public void rearrangeMaxMinForm(int a[]);

	/** 18. Rearrange an array in maximum minimum form | Set 2 (O(1) space) **/
	public void segregateElements(int arr[]);

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
	public void modify(int arr[], int n);

	/** 24. Shuffle a given array **/
	public void shuffleArr(int arr[], int n);

	/** 25. Segregate even and odd numbers **/
	// @See 14 there +ve/-ve here odd/even

	/* 26. Segregate 0s and 1s in an array */
	public void segregate0sAnd1s(int a[]);

	/* 27. Longest Bitonic Subsequence */
	public int bitonicSubsequence(int a[]);

	/* 28. Find a sorted subsequence of size 3 in linear time */
	public List<Integer> find3Numbers(int a[]);

	/*
	 * 29. Largest subarray with equal number of 0s and 1s 30. Maximum Product
	 * Sub-array
	 */
	public int findMaxLength(int[] a);

	/*29.1 find the max sub array with equal no of 0s and 1s */
	public List<Integer> findMaxSubArray(int[] a);

	/*30.	Maximum Product Sub-array, this is modified to max sum sub-array*/
	public int maxProductSubArray(int a[]);
	
	/* 31. Replace every element with the greatest element on right side */
	public void replaceNextGreatest(int a[]);

	/* 32. Maximum circular subarray sum ,it is modified of min sum array version*/
	public int maxSumCircularSubArray(int a[]);

	/*min sum sub array indexes */
	public int[] minSumSubArrayIndexes(int a[]);

	/* 33. Construction of Longest Increasing Subsequence (N log N) */
	public List<Integer> consLongestIncrSubseq(int a[]);

	/* 34. Sort elements by frequency | Set 2 */
	public List<Integer> sortByFrequency(int a[], boolean incOrDec);

	/* 35. Maximize sum of consecutive differences in a circular array, re arrangement allowed */
	public  int maxSumConsecutiveDiffCirArray(int a[]);

	/* 36. Sort an array according to the order defined by another array */
	void sortByAnotherArray(int[] a, int[] b);
	/*
	 * 37. Find Index of 0 to be replaced with 1 to get the longest continuous sequence
	 * of 1s in a binary array
	 */
	int indexLongestContinuousOne(int[] a);

	/* 38. Three way partitioning of an array around a given range */
    void threeWayPartition(int a[], int lowVal, int hiVal);

	/*
	 * 39. Generate all possible sorted arrays from alternate elements of two given
	 * sorted arrays
	 */
	/*
	 * 40. Minimum number of swaps required for arranging pairs adjacent to each
	 * other
	 */
	/* 41. Convert array into Zig-Zag fashion */
	/* 42. Form minimum number from given sequence */
	/* 43. Replace two consecutive equal values with one greater */
	/* 44. Rearrange a binary string as alternate x and y occurrences */
	/* 45. Distinct adjacent elements in an array */
	/*
	 * 46. Shuffle 2n integers as a1-b1-a2-b2-a3-b3-..bn without using extra space
	 */
	/* 47. Merge k sorted arrays */

	/***********************************************************************************************************************************************************************/

	/** 3. Sort an array in wave form **/
	public void sortInWaveForm(int a[]);

	/** 5. Sort an array according to absolute difference with given value **/
	public void sortBasDiffwithX(int a[], int x);

	/** 6. Move all negative elements to end in order with extra space allowed **/
	public void allNegelemEndofArr(int a[]);

	/** 7. Three way partitioning of an array around a given range **/
	public void threeWayPartitioning(int a[], int x, int y);

	/** 8. Rearrange an array in maximum minimum form | Set 1 **/
	public int[] rearrangeInMaxMinForm(int a[]);

	/** 9. Rearrange an array in maximum minimum form | Set 2 (O(1) extra space) **/
	public int[] rearrangeInMaxMinFormX(int a[]);
	/* 10. Maximum Length Bitonic Subarray */
}
