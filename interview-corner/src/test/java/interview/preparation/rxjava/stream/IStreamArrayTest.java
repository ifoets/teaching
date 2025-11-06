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

    /**51.	Find all pairs with a given sum**/
    @Test
    public void findAllPairSumTest()
    {
        List<int[]> list = isa.findAllPairSum(new int[]{3,4,7,8,9,10},12);
        for(int[] a:list)
            System.out.println(Arrays.toString(a));
    }

    /**52.	Find all unique triplets with a given sum (3-sum problem)**/
    @Test
    public void findAllTripletsTest()
    {
        int[] arr = {-1, 0, 1, 2, -1, -4, 3, -2};
        int target = 0;
        List<List<Integer>> list = isa.findAllTriplets(arr,target);
        for(List<Integer> l:list)
            System.out.println(l);
        Assert.assertEquals(5,list.size());
    }
    @Test
    public void closestTripletTest()
    {
        int[] arr = {-1, 2, 1, -4, 3, 0};
        int target = 1;
        List<Integer> rList = isa.closestTriplet(arr,target);
        System.out.println(rList);
    }

    /**53.	Count pairs with sum divisible by K*/
    @Test
    public void findAllPairDivisibleTest()
    {
        int[] arr = {2, 2, 1, 7, 5, 3};
        int k = 4;
        List<int[]> list = isa.findAllPairDivisible(arr,k);
        for(int[]x:list)
            System.out.println(Arrays.toString(x));
    }

    /**54.	Find pair with minimum absolute difference**/
    @Test
    public void pairMinAbsDiffTest()
    {
        int[] arr = {5, 3, 7, 17, 10, 11};
        int [] ra = isa.pairMinAbsDiff(arr);
        Assert.assertEquals(10,ra[0]);
        Assert.assertEquals(11,ra[1]);
    }

    /**55.	Find triplets with product = target**/
    @Test
    public void findTripletsProductTargetTest()
    {
        int[] arr = {1,2,3,4,5,6,7,8,9,10,2};
        List<int[]> rsList = isa.findTripletsProductTarget(arr,20);
        for(int[] a:rsList)
            System.out.println(Arrays.toString(a));
    }

    /**56.	Count pairs with XOR = target**/
    @Test
    public void findPairsWithXORTest()
    {
        int[] arr = {5, 4, 10, 15, 7, 6,1,2};
        int target = 5;

        List<int[]> pairs = isa.findPairsWithXOR(arr, target);
        Assert.assertEquals(3,pairs.size());
        for(int[]a: pairs)
            System.out.println(Arrays.toString(a));
    }
    /**57.	Find two elements closest to each other in array**/
    @Test
    public void twoClosestElemTest()
    {
        int[]a  ={-5, -2, 0, 3, 8,12,13};
        int []rs = isa.twoClosestElem(a);
        System.out.println(Arrays.toString(rs));
        Assert.assertEquals(12,rs[0]);
        Assert.assertEquals(13,rs[1]);
    }
    /**58.	Find all pairs whose difference is exactly K**/
    @Test
    public void allPairsDiffKTest()
    {
        int[]a  ={-2,-1, 2, 3, 8,13,12};
        List<int[]> rsList = isa.allPairsDiffK(a,1);
        for(int[]ar:rsList) System.out.println(Arrays.toString(ar));
        Assert.assertEquals(3,rsList.size());
    }

    /**59.	Count pairs (i,j) where arr[i] > arr[j] (inversions)**/
    @Test
    public void pairGoesDownTest()
    {
        int []a ={1,3,5,7,9,2,4,6,8};
        List<int[]> rsList = isa.pairGoesDown(a);
        for(int[]ar:rsList) System.out.println(Arrays.toString(ar));
        Assert.assertEquals(10,rsList.size());
    }
    /**59.	Count pairs (i,j) where arr[i] > arr[j] (inversions)**/

    @Test
    public void pairGoesDownCountTest()
    {
        int []a ={1,3,5,7,9,2,4,6,8};
        Assert.assertEquals(10,isa.pairGoesDownCount(a));
    }

    /** 60.	Find quadruplets that sum to a target (4-sum)**/
    @Test
    public void quadrupletsSumTargetTest()
    {
        int[] arr = {1, 0, -1, 0, -2, 2};
        List<List<Integer>> rsList = isa.quadrupletsSumTarget(arr,0);
        Assert.assertEquals(3,rsList.size());
        for(List<Integer> ll:rsList)
            System.out.println(ll);
    }
/* /Category 7: String Arrays / Conversion Problems**/
    /**61.	Convert int[] to List<Integer> and vice versa using streams**/
    @Test
    public void toList(){
        int []a={1,2,3,4,5,6};
        List<Integer> rsList = isa.toList(a);
        Assert.assertEquals(List.of(1,2,3,4,5,6),rsList);
    }
    @Test
    public void toArrayTest()
    {
       Assert.assertArrayEquals(new int[]{1,2,3,4,5,6},isa.toArray(List.of(1,2,3,4,5,6)));
    }

    /**62.	Flatten 2D array to 1D using streams**/
    @Test
    public void twoDArrayTo1DTest()
    {
     int[][]a={
         {1,2,3},
         {4,5,6},
         {7,8,9}
     };
     Assert.assertEquals(9,isa.twoDArrayTo1D(a).length);
    }

    /**63.	Find longest string in String[] **/
    @Test
    public void longestStrTest(){
        String[]strings ={"abhi","kumar","sumanji","abhimanyu"};
        Assert.assertEquals("abhimanyu",isa.longestStr(strings));
    }

    /**64.	Count frequency of words in a String[]**/
    @Test
    public void countFrequency1Test()
    {
        Map<String,Long> map = isa.countFrequency(new String[]{"aa","ab","bc","aa","bc","bc"});
        Assert.assertEquals(2,map.get("aa").intValue());
        Assert.assertEquals(3,map.get("bc").intValue());
    }

    /**65.	Remove duplicates from String[]**/
    @Test
    public void removeDuplicateTest(){
       Assert.assertEquals(3,isa.removeDuplicate(new String[]{"aa","ab","bc","aa","bc","bc"}).length);
    }

    /**66.	Sort String[] by length / lexicographically using streams**/
    public void sortByLengthTest(){
        String[] arr = {"banana", "kiwi", "apple", "mango", "grape"};
        String[] rs ={"kiwi", "mango", "apple", "grape", "banana"};
        String [] rList = isa.sortByLength(arr);
        Assert.assertArrayEquals(rs, rList);
    }

    /**67.	Group anagrams from String[] using streams**/
    @Test
    public void groupAnagramsTest(){
        String[] words = {"eat", "tea", "tan", "ate", "nat", "bat"};
        Map<String,List<String>> map = isa.groupAnagrams(words);
        for(Map.Entry<String,List<String>> set: map.entrySet())
        {
            System.out.println();
            map.get(set.getKey()).forEach(item-> System.out.print(item+", "));
        }
    }

    /**68.	Find all palindromic strings in array**/
    @Test
    public void allPalindromicTest()
    {
        String[] words = {"madam", "apple", "level", "world", "noon", "java"};
        List<String> rsList = List.of("madam", "level", "noon");
        Assert.assertEquals(rsList,isa.allPalindromic(words));
    }

    /**69.	Check if all strings are unique (case insensitive)**/
    @Test
    public void isAllStringUniqueTest()
    {
        String[] words = {"Apple", "Banana", "apple", "Cherry"};
        Assert.assertFalse(isa.isAllStringUnique(words));
    }

    /**70.	Merge two String arrays and remove duplicates**/
    @Test
    public void mergeAndRemoveDuplicateTest()
    {
        String[] words1 = {"apple", "Banana", "apple", "cherry"};
        String[] words2 = {"mango", "Banana", "apple", "tomato"};
        Assert.assertEquals(5,isa.mergeAndRemoveDuplicate(words1,words2).size());
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

/* *    Category 8: Subarrays / Sliding Window / Intervals*/
    /**71.	Generate all subarrays using IntStream ranges**/
    @Test
    public void generateAllSubArraysTest(){
        int []a = {1,2,3};
        List<int[]> rList = isa.generateAllSubArrays(a);
        Assert.assertEquals(6,rList.size());
        for(int[]arr:rList)
            System.out.println(Arrays.toString(arr));
    }

    /**72.	Find subarray with maximum average of size K**/
    @Test
    public void maxAvgSubArrayOfSizeKTest()
    {
        int []a = {1,2,3};
        List<int[]> rList = isa.maxAvgSubArrayOfSizeK(a, 2);
        Assert.assertEquals(5,rList.getFirst()[0]+rList.getFirst()[1]);
    }

    /**73.	Find longest subarray with all distinct elements**/
    @Test
    public void longestSubArrayDistinctElemTest()
    {
        int[] a = {1, 2, 3, 1, 2, 4, 5};
        int[]b={3, 1, 2, 4, 5};
        List<int[]> rList = isa.longestSubArrayDistinctElem(a);
        System.out.println(Arrays.toString(rList.getFirst()));
        Assert.assertArrayEquals(b,rList.getFirst());
    }

    /**74.	Find longest subarray with sum = target**/
    @Test
    public void longestSubArrSumTargetTest()
    {
        int[] a = {1, 2, 3, 1, 1, 1, 2, -1, 4};
        int target = 5;
        List<int[]> rsList = isa.longestSubArrSumTarget(a,target);
        System.out.println(Arrays.toString(rsList.getFirst()));
        Assert.assertEquals(4,rsList.getFirst().length);
    }

    /**75.	Count number of subarrays with sum divisible by K**/
    @Test
    public void noOfSubarraySumDivByKTest(){
        int[] a = {4, 5, 0, -2, -3, 1};
        int k = 5;
        Assert.assertEquals(7,isa.noOfSubarraySumDivByK(a,k));
    }

    /**76.	Check if array has increasing triplet subsequence**/
    @Test
    public void checkIncreasingTripletTest()
    {
        int[]a={1,3,2,5,6,0,3,1,8};
        Assert.assertTrue(isa.checkIncreasingTriplet(a));
    }

    /**77.	Find longest increasing contiguous subarray**/
    @Test
    public void longestIncreasingContiguousSubArrTest()
    {
        int[] a = {1, 2, 2, 3, 4, 1, 2, 3, 4, 5};
        List<int[]> rsList = isa.longestIncreasingContiguousSubArr(a);
        System.out.println(Arrays.toString(rsList.getFirst()));
        Assert.assertArrayEquals(new int[]{1, 2, 3, 4, 5},rsList.getFirst());
    }

    /**78.	Count number of subarrays with all elements even**/
    @Test
    public void noOfSubArrayAllElemEvenTest()
    {
        int[] a = {2, 4, 6, 1, 8, 10};
        Assert.assertEquals(9,isa.noOfSubArrayAllElemEven(a));
    }

    /**79.	Check if array contains a subarray with 0 sum**/
    @Test
    public void checkSubArraysZeroSumTest()
    {
        int[] a = {4, 2, -3, 1, 6};
        Assert.assertTrue(isa.checkSubArraysZeroSum(a));
    }

    /**80.	Find smallest subarray with sum >= target**/
    @Test
    public void smallestSubArraySumGretThanTargetTest()
    {
        int[] a = {2, 3, 1, 2, 4, 3};
        int target = 7;
        Assert.assertEquals(1,isa.smallestSubArraySumGretThanTarget(a,target).size());
    }

    /* *   Category 9: Advanced Grouping / Partition Problems**/
    /**81.	Group elements by modulo value (e.g., % 3)**/
    @Test
    public void groupByModuloTest()
    {
        int[]a = {1,2,3,4,5,6,7,8,9};
        Map<Integer,List<Integer>> map = isa.groupByModulo(a,3);
        for(Map.Entry<Integer,List<Integer>> set :map.entrySet())
        {
            System.out.print(set.getKey()+":-");
            set.getValue().forEach(e->System.out.print(e+", "));
            System.out.println();
        }
        Assert.assertEquals(3,map.size());
    }

    /**82.	Group numbers by number of digits**/
    @Test
    public void groupByNoOfDigitsTest()
    {
        int[]a ={1,22,333,4,55,666,7777,89897};
        Map<Integer,List<Integer>> map = isa.groupByNoOfDigits(a);
        Assert.assertEquals(5,map.size());
        for (Map.Entry<Integer,List<Integer>> set:map.entrySet())
        {
            System.out.print(set.getKey()+":-");
            set.getValue().forEach(e->System.out.print(e+", "));
            System.out.println();
        }
    }

    /**83.	Group by even/odd index positions**/
    @Test
    public void groupByIndexOddEvenPosTest()
    {
        int[]a ={1,2,3,4,5,6,7,8,9,10};
        Map<Integer,List<Integer>> map = isa.groupByIndexOddEvenPos(a);
        Assert.assertEquals(2,map.size());

        for (Map.Entry<Integer,List<Integer>> set:map.entrySet())
        {
            System.out.print(set.getKey()+":-");
            set.getValue().forEach(e->System.out.print(e+", "));
            System.out.println();
        }
    }

    /**84.	Group array into chunks of fixed size using streams**/
    @Test
    public void groupIntoChunkOfFixedSizeTest()
    {
        int[]a = {1,2,3,4,5,6,7,8,9,10};
        Map<Integer,List<Integer>> map = isa.groupIntoChunkOfFixedSize(a,3);
        Assert.assertEquals(4,map.size());
        for (Map.Entry<Integer,List<Integer>> set:map.entrySet())
        {
            System.out.print(set.getKey()+":-");
            set.getValue().forEach(e->System.out.print(e+", "));
            System.out.println();
        }
    }
    /**85.	Partition array around a pivot value**/
    @Test
    public void partitionAroundPivotValTest()
    {
        int[]a = {1,2,3,4,5,6,7,8,9,10};
        Map<Boolean,List<Integer>> map = isa.partitionAroundPivotVal(a,6);
        Assert.assertEquals(2,map.size());
        for (Map.Entry<Boolean,List<Integer>> set:map.entrySet())
        {
            System.out.print(set.getKey()+":-");
            set.getValue().forEach(e->System.out.print(e+", "));
            System.out.println();
        }
    }

    /**86.	Group by frequency buckets (e.g., map<frequency, List>)**/
    //@See **6

    /**87.	Group by sorted characters (anagram grouping)**/
    //@see 67

    /**88.	Group by first digit of each number**/
    @Test
    public void groupByFirstCharTest()
    {
        int[]a = {1,12,13,24,25,26,37,38,39,410};
        Map<Integer,List<Integer>> map = isa.groupByFirstChar(a);
        Assert.assertEquals(4,map.size());
        for (Map.Entry<Integer,List<Integer>> set:map.entrySet())
        {
            System.out.print(set.getKey()+":-");
            set.getValue().forEach(e->System.out.print(e+", "));
            System.out.println();
        }
    }

    /**89.	Partition array into k equal-sum subsets (NP-hard → interesting to discuss)**/
    @Test
    public void partitionKEqualSumTest()
    {
        int[] a = {4, 3, 2, 3, 5, 2, 1};
        int k = 4;

        List<List<Integer>> result = isa.partitionKEqualSum(a, k);
        for(List<Integer> list:result) {
            System.out.println(list);
        }
    }

    /**90.	Group integers by bit-count**/
    @Test
    public void groupBitCountTest()
    {
        int[]a ={1,2,3,4,5,6,7,8,9,10};
        Map<Integer,List<Integer>> map = isa.groupBitCount(a);
        for (Map.Entry<Integer,List<Integer>> set:map.entrySet())
        {
            System.out.print(set.getKey()+": ");
            set.getValue().forEach(e->System.out.print(e+", "));
            System.out.println();
        }
    }

/**    Category 10: Mixed / Tricky / Pattern Problems**/

    /**91.	Find majority element (> n/2) using streams**/
    @Test
    public void findMajorityElemTest()
    {
        int[]a ={1,2,1,3,1,4,1,5,1,6,1,7,1,8,9,1,1};
        Assert.assertEquals(1,isa.findMajorityElem(a));
    }

    /**92.	Find leader elements (greater than all to the right)**/
    @Test
    public void findLeaderElemTest()
    {
        int[] a ={16,17,4,8,3,7,0};
        List<Integer> list = isa.findLeaderElem(a);
        System.out.println(list);
        Assert.assertEquals(4, list.size());
    }

    /**93.	Find peak elements using IntStream**/
    @Test
    public void findPeakElemTest()
    {
        int []a = {10, 20, 15, 2, 23, 90, 67};
        List<Integer> list = isa.findPeakElem(a);
        System.out.println(list);
        Assert.assertEquals(20,list.getFirst().intValue());
        Assert.assertEquals(90,list.getLast().intValue());
    }

    /**94.	Find elements appearing exactly twice**/
    @Test
    public void findIfEleTwiceTest()
    {
        int[]a = {1,2,3,4,5,6,7,8,9,4,7};
        List<Integer> list = isa.findIfEleTwice(a);
        System.out.println(list);
        Assert.assertEquals(4,list.getFirst().intValue());
        Assert.assertEquals(7,list.getLast().intValue());
    }

    /**95.	Check if array can be divided into pairs whose sum is divisible by K**/
    @Test
    public void checkPairsDivisibleByKTest()
    {
        int[] arr1 = {9, 7, 5, 3};
        int k1 = 6;
        Assert.assertTrue(isa.checkPairsDivisibleByK(arr1,k1));

        int[] arr2 = {8, 4, 1, 3};
        int k2 = 4;
        Assert.assertTrue(isa.checkPairsDivisibleByK(arr2,k2));

        int[] arr3 = {2, 4, 6};
        int k3 = 4;
        Assert.assertFalse(isa.checkPairsDivisibleByK(arr3,k3));
    }

    /**96.	Check if array elements form an arithmetic progression**/
    @Test
    public void checkElemFormArithmeticProgressionTest()
    {
        int[]a ={60,70,80,90,100,10,20,30,40,50};
        Assert.assertTrue(isa.checkElemFormArithmeticProgression(a));
    }

    /**97.	Check if array elements form a geometric progression**/
    @Test
    public void checkElemFormGeometricProgressionTest()
    {
        int[] arr1 = {2, 6, 18, 54};   // GP with r = 3
        int[] arr2 = {1, 3, 9, 27};    // GP with r = 3
        int[] arr3 = {1, 2, 4, 9};     // Not GP
        int[] arr4 = {81, 9, 3, 27};
        Assert.assertTrue(isa.checkElemFormGeometricProgression(arr1));
        Assert.assertTrue(isa.checkElemFormGeometricProgression(arr2));
        Assert.assertFalse(isa.checkElemFormGeometricProgression(arr3));
        Assert.assertTrue(isa.checkElemFormGeometricProgression(arr4));
    }

    /**98.	Find minimum jumps to reach the end (greedy + streams support)**/
    @Test
    public void minJumToReachEndTest()
    {
        int[] arr1 = {2, 3, 1, 1, 4};
        int[] arr2 = {1, 1, 1, 1, 1};
        int[] arr3 = {3, 2, 1, 0, 4};
        int[] arr4 = {0};

        Assert.assertEquals(2,isa.minJumToReachEnd(arr1)); // 2
        Assert.assertEquals(4,isa.minJumToReachEnd(arr2)); // 4
        Assert.assertEquals(-1,isa.minJumToReachEnd(arr3)); // -1
        Assert.assertEquals(0,isa.minJumToReachEnd(arr4)); // 0
    }

    /**99.	Find length of longest consecutive sequence**/
    @Test
    public void findLongestConsecutiveSequenceTest()
    {
        int[] arr1 = {100, 4, 200, 1, 3, 2};
        int[] arr2 = {9, 1, 4, 7, 3, 2, 6, 5};
        int[] arr3 = {};

        Assert.assertEquals(4,isa.findLongestConsecutiveSequence(arr1)); // 2
        Assert.assertEquals(7,isa.findLongestConsecutiveSequence(arr2)); // 4
        Assert.assertEquals(0,isa.findLongestConsecutiveSequence(arr3)); // -1
    }

    /**100.	Reconstruct array from pairwise sums**/
    @Test
    public void reconstructArrayFromPairwiseSumsTest()
    {
        int []a ={5, 7, 8, 9, 10, 12};
        List<Integer> result = isa.reconstructArrayFromPairwiseSums(a);
        System.out.println(result);
    }

}
