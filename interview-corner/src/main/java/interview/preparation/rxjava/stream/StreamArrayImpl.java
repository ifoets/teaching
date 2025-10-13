package interview.preparation.rxjava.stream;

import interview.preparation.rxjava.stream.model.ArrayStatics;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamArrayImpl implements IStreamArray{
/* Category 1: Frequency & Counting (Fundamental Patterns)*/
    /**1.	Count frequency of each element in an array*/
    @Override
    public Map<Integer,Long> countFrequency(int []a){
        return
            Arrays.stream(a).boxed()
                .collect(Collectors.groupingBy(
                   Integer::intValue,
                   Collectors.counting()
                ));
    }
    /** 2.	Find the most frequent element*/
    @Override
    public Integer mostFrequentElement(int []a){
        return
            Arrays.stream(a).boxed()
                .collect(Collectors.groupingBy(
                    Integer::intValue,
                    LinkedHashMap::new,
                    Collectors.counting()
                ))
                .entrySet()
                .stream()
                .sorted(
                    Map.Entry.<Integer,Long>comparingByValue().reversed()
                )
                .map(Map.Entry::getKey)
                .findFirst().orElseThrow();
    }
    /**3.	Find the least frequent element*/
    @Override
    public Integer leastFrequentElement(int []a){
        return
            Arrays.stream(a).boxed()
                .collect(Collectors.groupingBy(
                    Integer::intValue,
                    LinkedHashMap::new,
                    Collectors.counting()
                ))
                .entrySet()
                .stream()
                .sorted(
                    Map.Entry.comparingByValue()
                )
                .map(Map.Entry::getKey)
                .findFirst().orElseThrow();
    }
    /**4.	Find top K frequent elements*/
    @Override
    public List<Integer> topKFrequentItem(int []a, int k){
        return
            Arrays.stream(a).boxed()
                .collect(Collectors.groupingBy(
                    Integer::intValue,
                    LinkedHashMap::new,
                    Collectors.counting()
                ))
                .entrySet()
                .stream()
                .sorted(
                    Map.Entry.<Integer,Long>comparingByValue().reversed()
                        .thenComparing(Map.Entry.comparingByKey())
                )
                .limit(k)
                .map(Map.Entry::getKey)
                .toList();
    }

    /**5.	Count occurrences of a specific number*/
    @Override
    public Long countNo(int[] a, int k){
        return
            Arrays.stream(a).boxed()
                .filter(x->x==k).count();
    }

    /**6.	Group elements by frequency (Map<frequency, List<elements>>)*/
    @Override
    public Map<Integer, List<Integer>> groupByFrequency(int[] a){
        return
            Arrays.stream(a).boxed()
                .collect(Collectors.groupingBy(
                    Integer::intValue,
                    LinkedHashMap::new,
                    Collectors.toList()
                ));
    }
    /**7.	Check if two arrays have the same frequency distribution*/
    @Override
    public boolean checkSameFrequency(int []a,int []b){

        Map<Integer,Long> map1 = Arrays.stream(a).boxed()
            .collect(Collectors.groupingBy(
                Integer::intValue,
                LinkedHashMap::new,
                Collectors.counting()
            ));
        Map<Integer,Long> map2 = Arrays.stream(b).boxed()
            .collect(Collectors.groupingBy(
                Integer::intValue,
                LinkedHashMap::new,
                Collectors.counting()
            ));
        return map1.equals(map2);
    }

    /**8.	Check if an array can be rearranged to form a palindrome**/
    @Override//check odd count==1
    public boolean canArrangeInPalindrome(int []a){
        return
            Arrays.stream(a).boxed()
                .collect(Collectors.groupingBy(
                    Integer::intValue,
                    LinkedHashMap::new,
                    Collectors.counting()
                ))
                .entrySet()
                .stream()
                .filter(e-> e.getValue()%2!=0)
                .count()==1;

    }
    /**9.	Check if two arrays are permutations of each other**/
    @Override
   public boolean permutationOfEachOther(int[]a,int []b){
       Map<Integer,Long> map1 = Arrays.stream(a).boxed()
           .collect(Collectors.groupingBy(
               Integer::intValue,
               LinkedHashMap::new,
               Collectors.counting()
           ));
       Map<Integer,Long> map2 = Arrays.stream(b).boxed()
           .collect(Collectors.groupingBy(
               Integer::intValue,
               LinkedHashMap::new,
               Collectors.counting()
           ));
       return map1.equals(map2);

    }
    /**
     * 10.	Find elements appearing more than n/3 times
     */
    @Override
    public Integer appearsNByThreeTimes(int[] a){
        return
            Arrays.stream(a).boxed()
                .collect(Collectors.groupingBy(
                    Integer::intValue,
                    LinkedHashMap::new,
                    Collectors.counting()
                ))
                .entrySet()
                .stream()
                .filter(e-> e.getValue()>=a.length/3)
                .map(Map.Entry::getKey)
                .findFirst().orElseThrow();
    }
/* *Category 2: Sorting, Merging & Transformations*/
    /**11.	Sort array in ascending/descending order using streams*/
    @Override
    public int[] sortArray(int[] a){
        return
            Arrays.stream(a)
            .sorted().toArray();
    }
    /**12.	Sort array by frequency of elements**/
    @Override
    public int[] softByFrequency(int[] a){

        Map<Integer, Long> freMap = Arrays.stream(a).boxed()
            .collect(Collectors.groupingBy(
                i->i,
                LinkedHashMap::new,
                Collectors.counting()
            ));
        return
            Arrays.stream(a).boxed()
                .sorted(Comparator
                    .comparingLong((Integer x)->freMap.get(x)).reversed()
                        .thenComparingInt(x->x)
                )
                .mapToInt(Integer::intValue)
                .toArray();
    }
    /**13.	Sort array by number of set bits in binary representation*/
    @Override
    public int [] sortBySetBits(int []a){
        return Arrays.stream(a).boxed()
            .sorted(
                Comparator.comparingInt(Integer::bitCount)
                    .thenComparingInt(x->x)
            )
            .mapToInt(Integer::intValue)
            .toArray();

    }
    /**14.	Merge two sorted arrays without duplicates*/
    @Override
    public int[] mergeTwoSortedArrayUniqueVal(int[]a,int []b){
        return IntStream.concat(Arrays.stream(a),Arrays.stream(b))
            .sorted().distinct().toArray();
    }

    /**15.	Merge multiple arrays into one sorted array**/
    @Override
    public int[] mergeMultipleArray(List<int[]> list){
        return list.stream()
            .flatMapToInt(IntStream::of)
            .toArray();
    }

    /**16.	Sort based on absolute values (e.g., distance from 0)*/
    @Override
    public int[] sortOnAbsoluteVal(int[]a){
        return
            Arrays.stream(a).boxed()
                .sorted((x,y)->
                    Integer.compare(Math.abs(x),Math.abs(y))
                )
                .mapToInt(Integer::intValue)
                .toArray();
    }
    /**17.	Sort based on length (for String arrays)*/
    @Override
    public String[] sortOnLength(String[] s){
        return
            Arrays.stream(s)
                .sorted(
                    Comparator.comparingInt(String::length)
                )
                .toArray(String[]::new);
    }

    /**18.	Sort based on frequency, then value (tie-breaker)*/
    @Override
    public int[] sortOnFrequencyThenByVal(int[]a){

        Map<Integer,Long> mapFrq = Arrays.stream(a).boxed()
            .collect(Collectors.groupingBy(
                i->i,
                LinkedHashMap::new,
                Collectors.counting()
            ));

        return
            Arrays.stream(a).boxed()
                .sorted(
                    Comparator.comparingLong((Integer x)-> mapFrq.get(x))
                        .thenComparingInt(x->x)
                )
                .mapToInt(Integer::intValue)
                .toArray();
    }

    @Override
    public int[] sortOnFrequencyAndValAs(int[]a){

        Map<Integer,Long> freMap= Arrays.stream(a).boxed()
            .collect(Collectors.groupingBy(
                i->i,
                LinkedHashMap::new,
                Collectors.counting()
            ));

        return
            Arrays.stream(a).boxed()
                .sorted(
                    Comparator.comparingLong(freMap::get).reversed()
                )
                .mapToInt(Integer::intValue)
                .toArray();


    }
    /**19.	Rotate an array left/right by K positions*/
    @Override
    public int[] rotateLeftRight(int[]a, int k, boolean leftRight){
        int n = a.length;
        return
            leftRight
                ?
                IntStream.concat(
                    Arrays.stream(a, k, n),
                    Arrays.stream(a, 0, k)).toArray()

                :
        IntStream.concat(
            Arrays.stream(a, n - k, n),
            Arrays.stream(a, 0, n - k)).toArray();
    }

    /**20.	Zig-zag sort (alternate smaller and larger elements)*/
    @Override
    public int[] sortZigZag(int[]a){
      int[]b = Arrays.stream(a)
            .sorted().toArray();
        return
            IntStream.range(0, b.length)
                .map(i -> (i % 2 == 0 && i + 1 < b.length) ? b[i + 1] : b[i - (i % 2 == 1 ? 1 : 0)])
                .toArray();
    }

/* *    Category 3: Numeric Operations & Aggregations*/
    /**21.	Find max, min, sum, average of array elements**/
    @Override
    public ArrayStatics getArrayStatics(int[] a){
        return
            new ArrayStatics(
              Arrays.stream(a).max().orElseThrow(),
              Arrays.stream(a).min().getAsInt(),
              Arrays.stream(a).sum(),
              Arrays.stream(a).average().orElseThrow()
            );
    }

    /**22.	Find second/kth largest and second smallest**/
    /**23.	Find Kth largest element **/
    @Override
    public Integer kthLargeSmall(int[] a, int k, boolean largeOrSmall){

        return largeOrSmall
            ? Arrays.stream(a).boxed().sorted(Comparator.comparingInt(Integer::intValue).reversed()).skip(k-1).findFirst().orElseThrow()
            : Arrays.stream(a).boxed().sorted(Comparator.comparingInt(Integer::intValue)).skip(k-1).findFirst().orElseThrow();

    }

    /**24.	Find missing number in 1…n sequence*/
    @Override
    public Integer missingNo(int[] a) {
        int N=a.length;
        return
            ((N+1)*(N+2)/2)-Arrays.stream(a).sum();
    }

    /**25.	Find duplicate number in 1…n+1 sequence*/
    @Override
    public Integer duplicateNo(int []a){
        int N=a.length;
        return
            N-((N*(N+1)/2)-Arrays.stream(a).sum());
    }

    /**26.	Find intersection sum of two arrays**/
    @Override
    public Integer intersectionSum(int []a,int []b){
        return
            Arrays.stream(a)
                .filter(i-> Arrays.stream(b).anyMatch(j-> i==j)).sum();
    }

    @Override
    public Integer intersectionSumDuplicateAvail(int []a,int []b){
        Map<Integer,Long> freqMap = Arrays.stream(a).boxed()
            .collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new,Collectors.counting()));

        return
            Arrays.stream(b)
                .filter(e-> freqMap.getOrDefault(e,0L)>0)
                .peek(e-> freqMap.put(e, freqMap.get(e)-1))
                .sum();

    }

    /**27.	Check if subarray with sum = target exists**/
    @Override
    public Map<Integer,Integer> sumTargetSubarrayExists(int []a, int target){
        return IntStream.range(0, a.length)
            .filter(i -> IntStream.range(0, a.length)
                .anyMatch(j -> i != j && a[i] + a[j] == target))
            .boxed()
            .collect(Collectors.toMap(
                i -> a[i], // key = value at index i
                i -> IntStream.range(0, a.length)
                    .filter(j -> i != j && a[i] + a[j] == target)
                    .map(j -> a[j])        // get matching a[j]
                    .findFirst()           // pick the first one
                    .orElse(-1)          // handle missing case
            ));
    }
    /**28.	Find subarray with maximum sum (Kadane’s Algorithm using streams idea)**/
    @Override
    public int[] maxSumSubArray(int []a){
        int currentMax=a[0];
        int globalMax=a[0];
        int start=0,end=0,tempStart=0;

        for(int i=0;i<a.length;i++)
        {
             if(a[i]>currentMax+a[i]) {
                 currentMax = a[i];
                 tempStart=i;
             }
             else currentMax+=a[i];

             if(currentMax>globalMax)
             {
                 globalMax=currentMax;
                 start=tempStart;
                 end=i;
             }
        }
        return Arrays.copyOfRange(a,start,end+1);
    }
    /**29.	Compute prefix sum and suffix sum arrays*/
    @Override
    public int[] prefixSuffixSumArr(int []a, boolean preSuffix){
        int n= a.length;
       if(preSuffix)
       {
           int[] prefix = new int[n];
           IntStream.range(0,n).forEach(i->{
               prefix[i]=i==0 ? a[i] : prefix[i-1]+a[i];
           });
           return prefix;
       }
       else {
           int [] postfix = new int[n];
           IntStream.iterate(n-1,i->i>=0,i->i-1).forEach(i->{
               postfix[i]=(i==n-1)?a[i]:postfix[i+1]+a[i];
           });
           return postfix;
       }
    }

    /**30.	Find equilibrium index (sum of left = sum of right)**/
    @Override
    public int equilibriumIndex(int[]a){

        int totalSum = Arrays.stream(a).sum();
        int[] leftSum ={0};
        return
            IntStream.range(0,a.length)
                .filter(i->
                {
                    int rightSum=totalSum-leftSum[0]-a[i];
                    boolean isEq=rightSum==leftSum[0];
                    leftSum[0]+=a[i];
                    return isEq;
                })
                .findFirst().orElseThrow();
    }

/* *Category 4: Searching & Set-Based Problems*/
    /**31.	Binary search using streams (custom implementation)**/
    @Override
    public Integer binarySearchStream(int[] a, int x){

        return
            IntStream.of(binarySearch(a,x,0,a.length-1)).findFirst().orElseThrow();
    }
    private int binarySearch(int []a, int x, int l, int r)
    {
        while (l<=r)
        {
            int mid = (l+r)/2;
            if(a[mid]==x) return mid;
            else if(a[mid]<x)
                l=mid+1;
            else
                r=mid-1;
        }
        return -1;
    }
    @Override
    public Integer binarySearchStreamX(int[] a, int x){
        int n = a.length;
        return
            Stream.iterate(
                new int[]{0,n-1},
                b-> b[0]<=b[1],
                b->
                {
                    int low=b[0], high=b[1];
                    int mid= (low+high)/2;
                    if (a[mid]>x) return new int[]{low,mid-1};
                    else if(a[mid]<x) return new int[]{mid+1,high};
                    else return new int[]{mid,mid};
                }
            ).map(b->
            {
                int low=b[0], high=b[1];
                if(low==high && a[low]==x)
                    return low;
                 return -1;
            }).filter(idx -> idx != -1)   // pick only found
            .findFirst()
            .orElse(-1);
    }

    /**32.	Linear search using anyMatch / filter**/
    @Override
    public boolean searchAnyMatch(int[]a, int x){
        return
            Arrays.stream(a)
                .anyMatch( i->i==x);
    }

    /**33.	Find common elements between two arrays **/
    @Override
    public <T> List<T> findCommonElementsGeneric(T[] a1, T[] a2) {
        Set<T> set2 = new HashSet<>(Arrays.asList(a2));
        return Arrays.stream(a1)
            .filter(set2::contains)
            .distinct()
            .collect(Collectors.toList());
    }
    /**34.	Find elements present in one but not the other (difference)*/
    @Override
    public <T> List<T> findUnCommonElementsGeneric(T[] a1, T[] a2){
        Set<T> set2 = new HashSet<>(Arrays.asList(a2));
        return Arrays.stream(a1)
            .filter(e-> !set2.contains(e))
            .distinct()
            .collect(Collectors.toList());
    }

/* *Category 5: Rearrangement & Partitioning**/

    /**41.	Move all zeroes to the end while maintaining order**/
    @Override
    public List<Integer> moveAllZerosToEndOnOrder(int[] a){
        List<Integer> nonZero = Arrays.stream(a)
            .boxed()
            .filter(i->i!=0)
                .collect(Collectors.toList());

        IntStream.range(0,a.length-nonZero.size())
            .forEach(i-> nonZero.add(0));
        return  nonZero;
    }

    /**42.	Partition array into evens and odds**/
    @Override
    public Map<Boolean,List<Integer>> evenOddPartition(int[]a){
        return
            Arrays.stream(a)
                .boxed()
                .collect(Collectors.groupingBy(
                    i-> i % 2 == 0,
                    Collectors.toList()
                ));
    }

    /**43.	Rearrange array to place positive and negative alternately**/
    @Override
    public Map<Boolean,List<Integer>> posNegPartition(int[]a){
        return
            Arrays.stream(a)
                .boxed()
                .collect(Collectors.groupingBy(
                    i-> i < 0,
                    Collectors.toList()
                ));
    }
    /**44.	Stable partition based on a predicate (e.g., divisible by 3)**/
    //@see 43 or 42

    /**45.	Shuffle array randomly**/
    @Override
    public int [] shuffleRandomly(int[] a){

        List<Integer> list = Arrays.stream(a)
            .boxed()
            .collect(Collectors.toList());
        Collections.shuffle(list);
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    /**46.	Rearrange array in wave form (peak-valley-peak…)**/
    @Override
    public int [] waveForm(int[] a){
        int[] b = Arrays.stream(a).sorted().toArray();
         IntStream.range(0,b.length-1)
            .filter(i->i%2==0)
                .forEach(i->{
                    int temp = b[i];
                    b[i] = b[i + 1];
                    b[i + 1] = temp;
                });
       return b;
    }

    /**47.	Segregate 0s, 1s, and 2s (Dutch national flag)**/
    @Override
    public int [] segregateOs1s2s(int[] a){
        return
            Arrays.stream(a)
                .sorted().toArray();
    }

    /*48.	Rearrange array based on frequency parity (even/odd)*/
    @Override
    public int [] arrangeEvenOddFreq(int []a){

        Map<Integer,Long> map = Arrays.stream(a)
            .boxed()
            .collect(Collectors.groupingBy(
                i->i,
                LinkedHashMap::new,
                Collectors.counting()
            ));
        List<Integer> evenFre = new ArrayList<>(Arrays.stream(a)
            .boxed()
            .filter(i -> map.get(i) % 2 == 0)
            .toList());

        List<Integer> oddFre = Arrays.stream(a)
            .boxed()
            .filter(i->map.get(i)%2!=0)
            .toList();
        evenFre.addAll(oddFre);
        return evenFre.stream().mapToInt(Integer::intValue).toArray();
    }

    /**49.	Group numbers by sign (positive, negative, zero)*/
    @Override
    public Map<String,List<Integer>> groupPosNevZero(int[]a){
        return
            Arrays.stream(a)
                .boxed()
                .collect(Collectors.groupingBy(
                    i-> i>0?"POSITIVE":i<0?"NEGATIVE":"ZERO",
                    Collectors.toList()
                ));
    }

    /**50.	Move prime numbers to front**/
    @Override
    public int[] movePrimeNoToFront(int[]a ){
        Predicate<Integer> isPrime = n ->
            n > 1 &&
                IntStream.rangeClosed(2, (int) Math.sqrt(n))
                    .noneMatch(i -> n % i == 0);
        List<Integer> prime = new ArrayList<>(Arrays.stream(a).boxed().filter(isPrime).toList());
        List<Integer> nonPrime = Arrays.stream(a).boxed().filter(i->!isPrime.test(i)).toList();
        prime.addAll(nonPrime);

        return prime.stream().mapToInt(Integer::intValue).toArray();

    }
/**---------------------------------------------------question comes in mind-------------------------------------------------------------------**
 }/
    /** Reverse order of an array**/
    @Override
    public int [] reverseOrderOfArray(int[] a){
        int n = a.length;
        return
            IntStream.range(0,n)
            .map(i->a[n-1-i])
                .toArray();
    }
}

