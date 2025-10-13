package interview.preparation.rxjava.stream;

import interview.preparation.rxjava.stream.model.ArrayStatics;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class IStreamArrayTest {

    private IStreamArray isa;

    @Before
    public void init()
    {
        isa = new StreamArrayImpl();
    }
/* Category 1: Frequency & Counting (Fundamental Patterns)*/
    /**1.	Count frequency of each element in an array*/
    @Test
    public void countFrequencyTest(){
        Map<Integer,Long> map= isa.countFrequency(new int[]{1,2,3,8,7,1,2,5,6,9,8,7});
        System.out.println(map);
        Assert.assertEquals(1, map.get(9).intValue());
        Assert.assertEquals(2, map.get(2).intValue());
        Assert.assertEquals(2, map.get(8).intValue());
    }

    /** 2.	Find the most frequent element*/
    @Test
    public void mostFrequentElementTest(){
        Assert.assertEquals(8,isa.mostFrequentElement(new int[]{1,2,3,8,7,1,2,5,6,9,8,7,8}).intValue());
    }

    /**3.	Find the least frequent element*/
    @Test
    public void leastFrequentElementTest(){
        Assert.assertEquals(3,isa.leastFrequentElement(new int[]{1,2,3,8,7,1,2,5,6,9,8,7,8}).intValue());
    }

    /**4.	Find top K frequent elements*/
    @Test
    public void topKFrequentItemTest(){
        int[] arr = {1, 1, 1, 2, 2, 3, 3, 3, 3, 4, 5};
        int k = 2;
       List<Integer> list = isa.topKFrequentItem(arr,2);
        Assert.assertEquals(2,list.size());
        Assert.assertEquals(3,list.get(0).intValue());
        Assert.assertEquals(1,list.get(1).intValue());
    }

    /**5.	Count occurrences of a specific number*/
    @Test
    public void countNoTest()
    {
        int[] arr = {1, 1, 1, 2, 2, 3, 3, 3, 3, 4, 5};
        int k = 2;
        List<Integer> list = isa.topKFrequentItem(arr,2);
        Assert.assertEquals(3,isa.countNo(arr,1).intValue());
        Assert.assertEquals(4,isa.countNo(arr,3).intValue());
        Assert.assertEquals(1,isa.countNo(arr,4).intValue());
    };

    /**6.	Group elements by frequency (Map<frequency, List<elements>>)*/
    @Test
    public void groupByFrequencyTest()
    {
        int[] arr = {1, 1, 1, 2, 2, 3, 3, 3, 3, 4, 5};
        Map<Integer, List<Integer>> map = isa.groupByFrequency(arr);
        Assert.assertEquals(3,map.get(1).size());
        Assert.assertEquals(4,map.get(3).size());
    }

    /**7.	Check if two arrays have the same frequency distribution*/
    @Test
    public void checkSameFrequencyTest(){
        int[] a = {1, 2, 2, 3, 3, 3};
        int[] b = {3, 3, 3, 2, 2, 1};
        int[] c = {3, 3, 3, 2, 2, 2};
        Assert.assertTrue(isa.checkSameFrequency(a,b));
        Assert.assertFalse(isa.checkSameFrequency(a,c));
    }

    /**8.	Check if an array can be rearranged to form a palindrome**/
    @Test
    public void canArrangeInPalindromeTest()
    {
        int[] a = {2, 2, 3, 3, 3};
        int[] b = {3, 3, 3, 2, 2, 1};
        int[] c = {3, 3, 3, 2, 2, 3};
        Assert.assertTrue(isa.canArrangeInPalindrome(a));
        Assert.assertFalse(isa.canArrangeInPalindrome(b));
    }

    /**9.	Check if two arrays are permutations of each other**/
    @Test
    public void permutationOfEachOtherTest()
    {
        int[] a = {1, 2, 2, 3, 3, 3};
        int[] b = {3, 3, 3, 2, 2, 1};
        int[] c = {3, 3, 3, 2, 2, 2};
        Assert.assertTrue(isa.permutationOfEachOther(a,b));
        Assert.assertFalse(isa.permutationOfEachOther(a,c));
    }

    /**10.	Find elements appearing more than n/3 times*/
    @Test
    public void appearsNByThreeTimesTest(){
        int a[]={1,2,3,4,5,5,6,7};
        int[] b = {3, 3, 3, 2, 2, 1};
        int[] c = {3, 3, 3, 2, 2, 3};
        Assert.assertEquals(5,isa.appearsNByThreeTimes(a).intValue());
        Assert.assertEquals(3,isa.appearsNByThreeTimes(b).intValue());
        Assert.assertEquals(3,isa.appearsNByThreeTimes(c).intValue());
    }

    /* *Category 2: Sorting, Merging & Transformations*/
    /**11.	Sort array in ascending/descending order using streams*/
    @Test
    public void sortArrayTest()
    {
        int[] b = {3, 3, 3, 2, 2, 1};
        int[] a={1,2,2,3,3,3};
        b = isa.sortArray(b);
        for(int i=0;i<a.length;i++)
            Assert.assertEquals(a[i],b[i]);
    }
    /**12.	Sort array by frequency of elements**/
    @Test
    public void softByFrequencyTest()
    {
       int [] a= {6, 4, 4, 5, 5, 3, 3, 2, 2, 2};
       a = isa.softByFrequency(a);
        System.out.println(Arrays.toString(a));
    }

    /**13.	Sort array by number of set bits in binary representation*/
    @Test
    public void  sortBySetBits()
    {
        int[] a = {1,2,3,4,5,6,7,8,9};
        int[] b ={1, 2, 4, 8, 3, 5, 6, 9, 7};
        int [] c={1, 1, 2, 1, 2, 2, 3, 1, 2};
        int[] d = isa.sortBySetBits(a);
        System.out.println(Arrays.toString(b));

        for(int i=0;i<a.length;i++) {
            Assert.assertEquals(b[i], d[i]);
            Assert.assertEquals(c[i], Integer.bitCount(a[i]));
        }

    }
    /**14.	Merge two sorted arrays without duplicates*/
    @Test
    public void mergeTwoSortedArrayUniqueValTest()
    {
        int []a={1,2,5,6,6,9};
        int []b={1,1,3,4,4,5,7,8};
        int []c={1,2,3,4,5,6,7,8,9};

        int[] d=isa.mergeTwoSortedArrayUniqueVal(a,b);
        for(int i=0;i<a.length;i++)
        {
            Assert.assertEquals(c[i],d[i]);
        }
    }
    /**15.	Merge multiple arrays into one sorted array**/
    @Test
    public void mergeMultipleArrayTest()
    {
        List<int[]> listOfArrays = new ArrayList<>();
        listOfArrays.add(new int[]{1, 2, 3});
        listOfArrays.add(new int[]{4, 5});
        listOfArrays.add(new int[]{6, 7, 8});
        int a[] ={1,2,3,4,5,6,7,8};
        int[]b=isa.mergeMultipleArray(listOfArrays);
        for(int i=0;i<a.length;i++)
        {
            Assert.assertEquals(a[i],b[i]);
        }
    }

    /**17.	Sort based on length (for String arrays)*/
    @Test
    public void sortOnLength(){
        String[] a ={"a","cat","apple","banana"};
        String[] arr = {"apple", "a", "banana", "cat"};
        String []b = isa.sortOnLength(arr);
        for(int i=0;i<a.length;i++)
            Assert.assertEquals(a[i],b[i]);
    }
    /**18.	Sort based on frequency higher fist, then value (tie-breaker)*/
    @Test
    public void sortOnFrequencyThenByValTest()
    {
        int [] a= {6, 4, 4, 5, 5, 3, 3, 2, 2, 2};
        a = isa.softByFrequency(a);
        System.out.println(Arrays.toString(a));
        int[] b={2,2,2,3,3,4,4,5,5,6};
        for (int i=0;i<a.length;i++)
            Assert.assertEquals(a[i],b[i]);
    }

    @Test
    public void sortOnFrequencyAndValAsTest()
    {
        int [] a= {6, 4, 4, 5, 5, 3, 3, 2, 2, 2};
        a = isa.sortOnFrequencyAndValAs(a);
        System.out.println(Arrays.toString(a));
        int[] b={2,2,2,4,4,5,5,3,3,6};
        for (int i=0;i<a.length;i++)
            Assert.assertEquals(a[i],b[i]);
    }

    /**19.	Rotate an array left/right by K positions*/
    @Test
    public void rotateLeftRightTest()
    {
        int[] a={1,2,3,4,5,6,7,8,9};
        int[] a1={1,2,3,4,5,6,7,8,9};
        int []b ={3,4,5,6,7,8,9,1,2};
        int []c={8,9,1,2,3,4,5,6,7};
        a=isa.rotateLeftRight(a,2,true);
        for(int i=0;i<a.length;i++)
            Assert.assertEquals(a[i],b[i]);
        int []d= isa.rotateLeftRight(a1,2,false);
        for(int i=0;i<a.length;i++)
            Assert.assertEquals(d[i],c[i]);
    }

    /**20.	Zig-zag sort (alternate smaller and larger elements)*/
    @Test
    public void sortZigZagTest()
    {
        int[] a ={1,9,2,8,3,7,4,6,5};
        int[] b={2,1,4,3,6,5,8,7,9};
        a = isa.sortZigZag(a);
        for(int i=0;i<a.length;i++)
        {
            Assert.assertEquals(a[i],b[i]);
        }
    }

/* *    Category 3: Numeric Operations & Aggregations*/
    /**21.	Find max, min, sum, average of array elements**/
    @Test
    public void getArrayStatics(){
        int []a = {1,2,3,4,5,6,7,8,9,10};
        ArrayStatics arrayStatics = isa.getArrayStatics(a);
        System.out.println(arrayStatics.toString());

        Assert.assertEquals(10,arrayStatics.max());
        Assert.assertEquals(1,arrayStatics.min());
        Assert.assertEquals(55,arrayStatics.sum());
        Assert.assertEquals(5.5,arrayStatics.avg(),.0);
    }

    /**22.	Find second/kth largest and second smallest**/
    /**23.	Find Kth largest element **/
    @Test
    public void kthLargeSmallTest(){
        int []a = {1,9,2,8,3,7,4,6,5,10};
        Assert.assertEquals(8,isa.kthLargeSmall(a,3,true).intValue());
        Assert.assertEquals(3,isa.kthLargeSmall(a,3,false).intValue());
    }
    /**24.	Find missing number in 1…n sequence*/
    @Test
    public void missingNoTest(){
        int []a ={1,2,3,4,5,7,8,9,10};
        Assert.assertEquals(6,isa.missingNo(a).intValue());
    }

    /**25.	Find duplicate number in 1…n+1 sequence*/
    @Test
    public void duplicateNoTest(){
        int []a ={1,2,3,4,5,6,6,7,8,9,10};
        Assert.assertEquals(6,isa.duplicateNo(a).intValue());
    }
    /**26.	Find intersection sum of two arrays**/
    @Test
    public void intersectionSum(){
        int[]a = {1, 2, 3, 4, 5};
        int[]b = {3, 4, 5, 6, 7};
        Assert.assertEquals(12,isa.intersectionSum(a,b).intValue());
    }

    @Test
    public void intersectionSumDuplicateAvailTest()
    {
        int[] a = {1, 2, 2, 3, 4};
        int[] b = {2, 2, 4, 5};
        Assert.assertEquals(8,isa.intersectionSumDuplicateAvail(a,b).intValue());
    }

    /**27.	Check if subarray with sum = target exists**/
    @Test
    public void sumTargetSubarrayExistsTest()
    {
        int []a ={1,4,7,9,2,3};
        int target = 7;
        Assert.assertEquals(3, (int) isa.sumTargetSubarrayExists(a, 7).get(4));
        Assert.assertEquals(2, (int) isa.sumTargetSubarrayExists(a, 11).get(9));
        System.out.println(isa.sumTargetSubarrayExists(a, 2).isEmpty());

        //int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
    }
    /**28.	Find subarray with maximum sum (Kadane’s Algorithm using streams idea)**/
    @Test
    public void maxSumSubArrayTest(){
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        arr = isa.maxSumSubArray(arr);
        System.out.println(Arrays.toString(arr));
        Assert.assertEquals(6,Arrays.stream(arr).sum());
    }

    /**29.	Compute prefix sum and suffix sum arrays*/
    @Test
    public void prefixSuffixSumArrTest()
    {
        int []a ={2,4,6,8,10};
        int[] preFix={2,6,12,20,30};
        int [] postFix ={30,28,24,18,10};
        Assert.assertArrayEquals(preFix, isa.prefixSuffixSumArr(a, true));
        Assert.assertArrayEquals(postFix, isa.prefixSuffixSumArr(a, false));
    }
    /**30.	Find equilibrium index (sum of left = sum of right)**/
    @Test
    public void equilibriumIndexTest() {
        int [] a ={-7, 1, 5, 2, -4, 3, 0};
        Assert.assertEquals(3,isa.equilibriumIndex(a));
    }


/* *Category 4: Searching & Set-Based Problems*/
    /**31.	Binary search using streams (custom implementation)**/
    @Test
    public void binarySearchStreamTest()
    {
        int[] arr = {1, 3, 5, 7, 9, 11};

        Assert.assertEquals(3,isa.binarySearchStream(arr,7).intValue());
        Assert.assertEquals(-1,isa.binarySearchStream(arr,4).intValue());
    }
    @Test
    public void binarySearchStreamXTest()
    {
        int[] arr = {1, 3, 5, 7, 9, 11};

        Assert.assertEquals(3,isa.binarySearchStreamX(arr,7).intValue());
        Assert.assertEquals(-1,isa.binarySearchStreamX(arr,4).intValue());
    }
    /**32.	Linear search using anyMatch / filter**/
    @Test
    public void searchAnyMatchTest()
    {
        int []a ={1,2,3,4,5,6,7,8,9,0};
        Assert.assertTrue(isa.searchAnyMatch(a,0));
        Assert.assertFalse(isa.searchAnyMatch(a,-1));
        Assert.assertTrue(isa.searchAnyMatch(a,7));
    }
    /**33.	Find common elements between two arrays **/
    @Test
    public void findCommonElementsGenericTest()
     {
         Integer[] a={1,8,4,6,734};
         Integer[] b={6,34,78,8,34,1};
         List<Integer> list = isa.findCommonElementsGeneric(a,b);
         Assert.assertEquals(List.of(1,8,6),list);

         List<String> strList = isa.findCommonElementsGeneric(
             new String[]{"apple", "banana", "mango"},
             new String[]{"banana", "grape", "apple"});
         Assert.assertEquals(List.of("apple","banana"),strList);
     }

    /**34.	Find elements present in one but not the other (difference)*/
    @Test
    public void findUnCommonElementsGenericTest()
    {
        Integer[] a={1,8,4,6,734};
        Integer[] b={6,34,78,8,34,1};
        List<Integer> list = isa.findUnCommonElementsGeneric(a,b);
        Assert.assertEquals(List.of(4,734),list);

        List<String> strList = isa.findUnCommonElementsGeneric(
            new String[]{"apple", "banana", "mango"},
            new String[]{"banana", "grape", "apple"});
        Assert.assertEquals(List.of("mango"),strList);
    }

    /* *Category 5: Rearrangement & Partitioning**/

    /**41.	Move all zeroes to the end while maintaining order**/
    @Test
    public void moveAllZerosToEndOnOrderTest() {
        int[] a = {2, 0, 3, 0, 0, 3, 6, 7, 0};
        List<Integer> list = isa.moveAllZerosToEndOnOrder(a);
        List<Integer> rList = List.of(2,3,3,6,7,0,0,0,0);
        Assert.assertEquals(list, rList);
    }

    /**42.	Partition array into evens and odds**/
    @Test
    public void  evenOddPartitionTest()
    {
        Map<Boolean,List<Integer>> listmap = isa.evenOddPartition(new int[]{1,2,3,4,5,6,7,8,9,10});
        Assert.assertEquals(List.of(1,3,5,7,9),listmap.get(false));
        Assert.assertEquals(List.of(2,4,6,8,10),listmap.get(true));
    }

    /**43.	Rearrange array to place positive and negative alternately**/
    @Test
    public void posNegPartitionTest()
    {
        Map<Boolean,List<Integer>> listmap = isa.evenOddPartition(new int[]{-1,2,-3,4,-5,6,-7,8,-9,10});
        Assert.assertEquals(List.of(-1,-3,-5,-7,-9),listmap.get(false));
        Assert.assertEquals(List.of(2,4,6,8,10),listmap.get(true));
    }
    /**44.	Stable partition based on a predicate (e.g., divisible by 3)**/
    //@see 43 or 42
    /**45.	Shuffle array randomly**/
    @Test
    public void shuffleRandomlyTest()
    {
        int []a = {1,2,3,4,5,6,7,8,9};
        int []b = isa.shuffleRandomly(a);
        System.out.println(Arrays.toString(b));
    }
    /**46.	Rearrange array in wave form (peak-valley-peak…)**/
    @Test
    public void waveFormTest()
    {
        int []a={1,9,2,8,3,4,5,6,7};
        System.out.println(Arrays.toString(isa.waveForm(a)));
    }
    /**47.	Segregate 0s, 1s, and 2s (Dutch national flag)**/
    @Test
    public void segregateOs1s2sTest()
    {
        int[]a  ={1,2,3,1,2,3,1,2,3,1,1,2};
        System.out.println(Arrays.toString(isa.segregateOs1s2s(a)));
    }

    /*48.	Rearrange array based on frequency parity (even/odd)*/
    @Test
    public void arrangeEvenOddFreqTest()
    {
        int []a ={4, 5, 6, 5, 4, 3, 5};
        System.out.println(Arrays.toString(isa.arrangeEvenOddFreq(a)));
    }

    /**49.	Group numbers by sign (positive, negative, zero)*/
    @Test
    public void groupPosNevZeroTest()
    {
        int []a ={1,2,3,-1,-9,0,5,-5,0};
        Map<String,List<Integer>>  map = isa.groupPosNevZero(a);
        Assert.assertEquals(4,map.get("POSITIVE").size());
        Assert.assertEquals(3,map.get("NEGATIVE").size());
        Assert.assertEquals(2,map.get("ZERO").size());
    }

    /**50.	Move prime numbers to front**/
    @Test
    public void movePrimeNoToFrontTest()
    {
        int[]a ={1,2,3,4,5,6,7,8,9,17,13,31};
        System.out.println(Arrays.toString(isa.movePrimeNoToFront(a)));
    }
    /**---------------------------------------------------question comes in mind-------------------------------------------------------------------**/
    /** Reverse order of an array**/
    @Test
    public void reverseOrderOfArrayTest()
    {
        int []a ={1,3,5,7,9,2,4,6,8};
        int []b ={8,6,4,2,9,7,5,3,1};
        a = isa.reverseOrderOfArray(a);
        for(int i=0;i<a.length;i++)
            Assert.assertEquals(a[i],b[i]);

    }
}
