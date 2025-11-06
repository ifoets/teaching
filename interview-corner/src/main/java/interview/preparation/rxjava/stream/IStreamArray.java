package interview.preparation.rxjava.stream;

import interview.preparation.rxjava.stream.model.ArrayStatics;

import java.util.List;
import java.util.Map;

public interface IStreamArray {
/* Category 1: Frequency & Counting (Fundamental Patterns)*/
    /**1.	Count frequency of each element in an array*/
    Map<Integer,Long> countFrequency(int []a);

    /** 2.	Find the most frequent element*/
    Integer mostFrequentElement(int []a);

    /**3.	Find the least frequent element*/
    Integer leastFrequentElement(int []a);

    /**4.	Find top K frequent elements*/
    List<Integer> topKFrequentItem(int []a, int k);

    /**5.	Count occurrences of a specific number*/
    Long countNo(int[] a, int k);

    /**6.	Group elements by frequency (Map<frequency, List<elements>>)*/
    Map<Integer, List<Integer>> groupByFrequency(int[] a);

    /**7.	Check if two arrays have the same frequency distribution*/
    boolean checkSameFrequency(int[] a,int []b);

    /**8.	Check if an array can be rearranged to form a palindrome**/
    boolean canArrangeInPalindrome(int []a);

    /**9.	Check if two arrays are permutations of each other**/
    boolean permutationOfEachOther(int[]a,int []b);

    /**10.	Find elements appearing more than n/3 times*/
    Integer appearsNByThreeTimes(int[] a);

/* *Category 2: Sorting, Merging & Transformations*/
    /**11.	Sort array in ascending/descending order using streams*/
   int[] sortArray(int[] a);

    /**12.	Sort array by frequency of elements**/
    int[] softByFrequency(int[] a);

    /**13.	Sort array by number of set bits in binary representation*/
    int [] sortBySetBits(int []a);

    /**14.	Merge two sorted arrays without duplicates*/
    int[] mergeTwoSortedArrayUniqueVal(int[]a, int[]b);

    /**15.	Merge multiple arrays into one sorted array**/
    int[] mergeMultipleArray(List<int[]> list);

    /**16.	Sort based on absolute values (e.g., distance from 0)*/
    int[] sortOnAbsoluteVal(int[]a);

    /**17.	Sort based on length (for String arrays)*/
    String[] sortOnLength(String[] s);

    /**18.	Sort based on frequency higher fist, then value (tie-breaker)*/
    int[] sortOnFrequencyThenByVal(int[]a);
    int[] sortOnFrequencyAndValAs(int[]a);

    /**19.	Rotate an array left/right by K positions*/
    int[] rotateLeftRight(int[]a, int k, boolean leftRight);

    /**20.	Zig-zag sort (alternate smaller and larger elements)*/
    int[] sortZigZag(int[]a);

/* *    Category 3: Numeric Operations & Aggregations*/
    /**21.	Find max, min, sum, average of array elements**/
    ArrayStatics getArrayStatics(int[] a);

    /**22.	Find second/kth largest and second smallest**/
    /**23.	Find Kth largest element **/
    Integer kthLargeSmall(int[] a, int k, boolean largeOrSmall);

    /**24.	Find missing number in 1…n sequence*/
    Integer missingNo(int[] a);

    /**25.	Find duplicate number in 1…n+1 sequence*/
    Integer duplicateNo(int []a);

    /**26.	Find intersection sum of two arrays**/
    Integer intersectionSum(int []a,int []b);
    Integer intersectionSumDuplicateAvail(int []a,int []b);

    /**27.	Check if subarray with sum = target exists**/
    Map<Integer,Integer> sumTargetSubarrayExists(int []a, int target);

    /**28.	Find subarray with maximum sum (Kadane’s Algorithm using streams idea)**/
    int[] maxSumSubArray(int []a);

    /**29.	Compute prefix sum and suffix sum arrays*/
    int[] prefixSuffixSumArr(int []a,boolean preSuffix);

    /**30.	Find equilibrium index (sum of left = sum of right)**/
    int equilibriumIndex(int[]a);

/* *Category 4: Searching & Set-Based Problems*/
    /**31.	Binary search using streams (custom implementation)**/
    Integer binarySearchStream(int[] a, int x);
    Integer binarySearchStreamX(int[] a, int x);

    /**32.	Linear search using anyMatch / filter**/
    boolean searchAnyMatch(int[]a, int x);

    /**33.	Find common elements between two arrays **/
     <T> List<T> findCommonElementsGeneric(T[] a1, T[] a2);

    /**34.	Find elements present in one but not the other (difference)*/
    <T> List<T> findUnCommonElementsGeneric(T[] a1, T[] a2);

    /**35.	Find elements that are unique to both arrays (symmetric difference)*/
    /* //@33
    //36.	Check if array contains duplicates
    //37.	Check if all elements are unique
    //38.	Find first repeating element
    //39.	Find first non-repeating element
    //40.	Find indexes of a given element using streams*/

/* *Category 5: Rearrangement & Partitioning**/

    /**41.	Move all zeroes to the end while maintaining order**/
    List<Integer> moveAllZerosToEndOnOrder(int[] a);

    /**42.	Partition array into evens and odds**/
    Map<Boolean,List<Integer>> evenOddPartition(int[]a);

    /**43.	Rearrange array to place positive and negative alternately**/
    Map<Boolean,List<Integer>> posNegPartition(int[]a);

    /**44.	Stable partition based on a predicate (e.g., divisible by 3)**/
    //@see 43 or 42
    /**45.	Shuffle array randomly**/
    int [] shuffleRandomly(int[] a);

    /**46.	Rearrange array in wave form (peak-valley-peak…)**/
    int [] waveForm(int[] a);

    /**47.	Segregate 0s, 1s, and 2s (Dutch national flag)**/
    int [] segregateOs1s2s(int[] a);

    /*48.	Rearrange array based on frequency parity (even/odd)*/
    int [] arrangeEvenOddFreq(int []a);

    /**49.	Group numbers by sign (positive, negative, zero)*/
    Map<String,List<Integer>> groupPosNevZero(int[]a);

    /**50.	Move prime numbers to front**/
    int[] movePrimeNoToFront(int[]a );

    //    Category 6: Combinatorial / Pair / Triplet Problems
    /**51.	Find all pairs with a given sum**/
    List<int[]> findAllPairSum(int[]a, int sum);

    /**52.	Find all unique triplets with a given sum (3-sum problem)**/
    List<List<Integer>> findAllTriplets(int[]a, int sum);
    List<Integer> closestTriplet(int[]a,int target);

    /**53.	Count pairs with sum divisible by K*/
    List<int[]> findAllPairDivisible(int[]a, int k);

    /**54.	Find pair with minimum absolute difference**/
    int[] pairMinAbsDiff(int[]a);

    /**55.	Find triplets with product = target**/
    List<int[]> findTripletsProductTarget(int[]a, int target);

    /**56.	Count pairs with XOR = target**/
    List<int[]> findPairsWithXOR(int []a,int target);

    /**57.	Find two elements closest to each other in array**/
    int[] twoClosestElem(int[]a);

    /**58.	Find all pairs whose difference is exactly K**/
    List<int[]> allPairsDiffK(int[]a, int k);

    /**59.	all pairs (i,j) where arr[i] > arr[j] (inversions)**/
    List<int[]> pairGoesDown(int[]a);

    /**59.	Count pairs (i,j) where arr[i] > arr[j] (inversions)**/
    long pairGoesDownCount(int[]a);

    /** 60.	Find quadruplets that sum to a target (4-sum)**/
    List<List<Integer>> quadrupletsSumTarget(int[]a, int target);

/* /Category 7: String Arrays / Conversion Problems**/
    /**61.	Convert int[] to List<Integer> and vice versa using streams**/
    List<Integer> toList(int[]a);
    int[] toArray(List<Integer> list);

    /**62.	Flatten 2D array to 1D using streams**/
    int[] twoDArrayTo1D(int[][]a);

    /**63.	Find longest string in String[] **/
    String longestStr(String[] strA);

    /**64.	Count frequency of words in a String[]**/
    Map<String,Long> countFrequency(String[] strA);

    /**65.	Remove duplicates from String[]**/
    String[] removeDuplicate(String[] strA);

    /**66.	Sort String[] by length / lexicographically using streams**/
    String[] sortByLength(String[] strA);

    /**67.	Group anagrams from String[] using streams**/
    Map<String,List<String>> groupAnagrams(String[] strA);

    /**68.	Find all palindromic strings in array**/
    List<String> allPalindromic(String[] strA);

    /**69.	Check if all strings are unique (case insensitive)**/
    boolean isAllStringUnique(String[] strA);

    /**70.	Merge two String arrays and remove duplicates**/
    List<String> mergeAndRemoveDuplicate(String[] strA, String[]strB);
/**---------------------------------------------------question comes in mind-------------------------------------------------------------------**/
    /** Reverse order of an array**/
    int [] reverseOrderOfArray(int[] a);

/* *    Category 8: Subarrays / Sliding Window / Intervals*/
    /**71.	Generate all subarrays using IntStream ranges**/
    List<int[]> generateAllSubArrays(int[]a);

    /**72.	Find subarray with maximum average of size K**/
    List<int[]> maxAvgSubArrayOfSizeK(int[]a, int k);

    /**73.	Find longest subarray with all distinct elements**/
    List<int[]> longestSubArrayDistinctElem(int[] a);

    /**74.	Find longest subarray with sum = target**/
    List<int[]> longestSubArrSumTarget(int[]a, int target);

    /**75.	Count number of subarrays with sum divisible by K**/
    long noOfSubarraySumDivByK(int[]a, int k);

    /**76.	Check if array has increasing triplet subsequence**/
    boolean checkIncreasingTriplet(int[]a);

    /**77.	Find longest increasing contiguous subarray**/
    List<int[]> longestIncreasingContiguousSubArr(int[]a);

    /**78.	Count number of subarrays with all elements even**/
    long noOfSubArrayAllElemEven(int[] a);

    /**79.	Check if array contains a subarray with 0 sum**/
    boolean checkSubArraysZeroSum(int[] a);

    /**80.	Find smallest subarray with sum >= target**/
    List<int[]> smallestSubArraySumGretThanTarget(int[]a, int target);

/* *   Category 9: Advanced Grouping / Partition Problems**/
    /**81.	Group elements by modulo value (e.g., % 3)**/
    Map<Integer,List<Integer>> groupByModulo(int[]a, int k);

    /**82.	Group numbers by number of digits**/
    Map<Integer,List<Integer>> groupByNoOfDigits(int[]a);

    /**83.	Group by even/odd index positions**/
    Map<Integer,List<Integer>> groupByIndexOddEvenPos(int[] a);

    /**84.	Group array into chunks of fixed size using streams**/
    Map<Integer,List<Integer>> groupIntoChunkOfFixedSize(int[] a, int k);

    /**85.	Partition array around a pivot value**/
    Map<Boolean,List<Integer>> partitionAroundPivotVal(int[]a, int pivotVal);

    /**86.	Group by frequency buckets (e.g., map<frequency, List>)**/
    //@See **6

    /**87.	Group by sorted characters (anagram grouping)**/
    //@see 67

    /**88.	Group by first digit of each number**/
    Map<Integer,List<Integer>> groupByFirstChar(int[]a);

    /**89.	Partition array into k equal-sum subsets (NP-hard → interesting to discuss)**/
    List<List<Integer>> partitionKEqualSum(int []a, int k);

    /**90.	Group integers by bit-count**/
    Map<Integer,List<Integer>> groupBitCount(int[]a);

/**    Category 10: Mixed / Tricky / Pattern Problems**/
    /**91.	Find majority element (> n/2) using streams**/
    int findMajorityElem(int[]a );

    /**92.	Find leader elements (greater than all to the right)**/
    List<Integer> findLeaderElem(int[]a );

    /**93.	Find peak elements using IntStream**/
    List<Integer> findPeakElem(int[]a );

    /**94.	Find elements appearing exactly twice**/
    List<Integer> findIfEleTwice(int[] a);

    /**95.	Check if array can be divided into pairs whose sum is divisible by K**/
    boolean checkPairsDivisibleByK(int[]a, int k);

    /**96.	Check if array elements form an arithmetic progression**/
    boolean checkElemFormArithmeticProgression(int[]a);

    /**97.	Check if array elements form a geometric progression**/
    boolean checkElemFormGeometricProgression(int[]a);

    /**98.	Find minimum jumps to reach the end (greedy + streams support)**/
    int minJumToReachEnd(int[]a);

    /**99.	Find length of longest consecutive sequence**/
    int findLongestConsecutiveSequence(int[]a );

    /**100.	Reconstruct array from pairwise sums**/
    List<Integer> reconstructArrayFromPairwiseSums(int []a);
}
