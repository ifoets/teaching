package interview.preparation.rxjava.stream;

import interview.preparation.rxjava.stream.model.ArrayStatics;
import lombok.ToString;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collector;
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
                .sorted(Comparator.comparingInt(Math::abs))
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

    /**51.	Find all pairs with a given sum**/
    @Override
    public List<int[]> findAllPairSum(int[]a, int sum){
       Set<Integer> seen = new HashSet<>();
       List<int[]> rs = new ArrayList<>();

            IntStream.range(0,a.length)
                .forEach(i->{
                    int complement = sum-a[i];
                    if(seen.contains(complement)) {
                        rs.add(new int[]{a[i], complement});
                    }
                     seen.add(a[i]);
                });
            return rs;
    }

    /**52.	Find all unique triplets with a given sum (3-sum problem)**/
    @Override
    public List<List<Integer>> findAllTriplets(int[]a, int sum){
        Arrays.sort(a);

       return  IntStream.range(0,a.length-2)
            .boxed()
            .flatMap(i->
            {
                if (i > 0 && a[i] == a[i - 1])
                    return Stream.empty();

                int left = i + 1;
                int right = a.length - 1;
                List<List<Integer>> triplets = new ArrayList<>();
                while (left < right) {
                    int target = a[i] + a[left] + a[right];
                    if (sum == target) {
                        triplets.add(Arrays.asList(a[i], a[left], a[right]));

                        int leftVal = a[left];
                        int rightVal = a[right];
                        while (left < right && leftVal == a[left]) left++;//skip duplicate
                        while (left < right && rightVal == a[right]) right--;//skip duplicate
                    }
                    if (target < sum)
                        left++;
                    else if(target>sum)
                        right--;
                }
                return triplets.stream();
            }).toList();

    }

    @Override
    public List<Integer> closestTriplet(int[]a,int target){

        Arrays.sort(a);
        AtomicInteger closest = new AtomicInteger(a[0]+a[1]+a[2]);
        List<Integer> closestTriplet = new ArrayList<>(List.of(a[0],a[1],a[2]));

         IntStream.range(0, a.length - 2)
            .forEach(i -> {
                int left = i+1;
                int right = a.length-1;
                while(left<right) {
                    int sum = a[i] + a[left] + a[right];
                    if(Math.abs(target-sum)<Math.abs(target-closest.get()))
                    {
                        closest.set(sum);
                        closestTriplet.clear();
                        closestTriplet.addAll(List.of(a[i],a[left],a[right]));
                    }
                    if(sum<target)
                        left++;
                    else if(sum>target)
                        right--;
                    else
                        return ;//exact match-easily stop*/ it is like breaking the loop of lamda
                }
            });
        return closestTriplet;
    }
    /**53.	Count pairs with sum divisible by K*/
    @Override
    public List<int[]> findAllPairDivisible(int[]a, int k){
       Map<Integer,List<Integer>> reminderMap = new HashMap<>();
       List<int[]> rsList = new ArrayList<>();

      IntStream.of(a)
          .forEach(num->
          {
              int rem= ((num%k)+k)%k;
              int complement = (k-rem)%k;
              if(reminderMap.containsKey(complement))
              {
                  reminderMap.get(complement)
                      .forEach(x-> rsList.add(new int[]{x,num}));
              }
              reminderMap.computeIfAbsent(rem, _ ->new ArrayList<>()).add(num);
          });
      return rsList;
    }
    /**54.	Find pair with minimum absolute difference**/
    @Override
    public int[] pairMinAbsDiff(int[]a){
       int[] sorted= Arrays.stream(a).sorted().toArray();

       return IntStream.range(0,sorted.length-1)
           .mapToObj(i->new int[]{sorted[i],sorted[i+1]})
           .min(Comparator.comparingInt(p->Math.abs(p[0]-p[1])))
           .orElseThrow();
    }

    /**55.	Find triplets with product = target**/
    @Override
    public List<int[]> findTripletsProductTarget(int[]a, int target){
        int n= a.length;
        Arrays.sort(a);
        List<int[]> rsList = new ArrayList<>();
        IntStream.range(0,n-2)
            .forEach(i->
            {
                int left = i+1;
                int right = a.length-1;
                while (left<right)
                {
                    int prod = a[i]*a[left]*a[right];
                    if(prod==target) {
                        rsList.add(new int[]{a[i], a[left], a[right]});
                    }
                    if(prod<target)left++;
                    else if(prod>target)right--;
                    else return;
                }
            });
        return rsList;
    }
    /**56.	Count pairs with XOR = target**/
    @Override
    public List<int[]> findPairsWithXOR(int []a,int target){
        List<int[]> rsLit = new ArrayList<>();
        Set<Integer> seen = new HashSet<>();

        IntStream.range(0,a.length)
            .forEach(i->
            {
                int complement = a[i]^target; //a ^ b = target   ⟺   b = a ^ target
                if(seen.contains(complement)) {
                    rsLit.add(new int[]{a[i], complement});
                }
                seen.add(a[i]);
            });
        return rsLit;
    }

    /**57.	Find two elements closest to each other in array**/
    @Override
    public int[] twoClosestElem(int[]a){
        Arrays.sort(a);
        return
            IntStream.range(0,a.length-1)
                .mapToObj(i-> new int[]{a[i],a[i+1]})
                .min(Comparator.comparing(p->Math.abs(p[0]-p[1])))
                .orElseThrow();
    }

    /**58.	Find all pairs whose difference is exactly K**/
    @Override
    public List<int[]> allPairsDiffK(int[]a, int k){
        List<int[]> rsLit = new ArrayList<>();
        Set<Integer> seen = new HashSet<>();

        IntStream.of(a).forEach(num -> {
            if (seen.contains(num + k)) rsLit.add(new int[]{num, num + k});
            if (seen.contains(num - k)) rsLit.add(new int[]{num, num - k});
            seen.add(num);
        });
        return rsLit;
    }

    /**59.	Count pairs (i,j) where arr[i] > arr[j] (inversions)**/
    @Override
    public List<int[]> pairGoesDown(int[]a){
        return
            IntStream.range(0,a.length-1)
                .mapToObj(i->IntStream.range(i+1,a.length).filter(j->a[i]>a[j]).mapToObj(x->new int[]{a[i],a[x]}))
                .flatMap(s->s)
                .toList();
    }

    /**59.	Count pairs (i,j) where arr[i] > arr[j] (inversions)**/
    @Override
    public long pairGoesDownCount(int[]a){
        return
            IntStream.range(0,a.length)
                .flatMap(i-> IntStream.range(i+1,a.length).filter(j->a[i]>a[j]))
                .count();
    }

    /** 60.	Find quadruplets that sum to a target (4-sum)**/
    @Override
    public List<List<Integer>> quadrupletsSumTarget(int[]a, int target){
        Arrays.sort(a);
        int n = a.length;
        List<List<Integer>> rsList = new ArrayList<>();
        IntStream.range(0,n-3).forEach(i->
        {
            if(i>0&&a[i]==a[i-1])return;

            IntStream.range(i+1,n-2).forEach(j->
            {
                if(j>i+1&&a[j]==a[j-1]) return;

                int left = j+1;
                int right = n-1;

                while (left<right)
                {
                    int sum = a[i]+a[j]+a[left]+a[right];
                    if(sum==target)
                    {
                        rsList.add(Arrays.asList(a[i],a[j],a[left],a[right]));
                        left++;
                        right--;
                        while (left<right && a[left]==a[left-1])left++;
                        while (left<right&&a[right]==a[right+1])right--;
                    }
                    if(sum<target)left++;
                    else right--;

                }
            });
        });
        return rsList;
    }

/* /Category 7: String Arrays / Conversion Problems**/
    /**61.	Convert int[] to List<Integer> and vice versa using streams**/
    @Override
   public  List<Integer> toList(int[]a){
       return Arrays.stream(a)
           .boxed().toList();
   }
   @Override
   public int[] toArray(List<Integer> list){
       return
           list.stream().mapToInt(Integer::intValue).toArray();
   }

    /**62.	Flatten 2D array to 1D using streams**/
    @Override
    public int[] twoDArrayTo1D(int[][]a){
       return Arrays.stream(a)
            .flatMap(i->Arrays.stream(i).boxed())
            .mapToInt(Integer::intValue)
            .toArray();
    }

    /**63.	Find longest string in String[] **/
    @Override
    public String longestStr(String[] strA){
        return
            Arrays.stream(strA)
                .sorted(Comparator.comparing(String::length).reversed())
                .map(String::valueOf)
                .findFirst()
                .orElseThrow();
    }

    /**64.	Count frequency of words in a String[]**/
    @Override
    public Map<String,Long> countFrequency(String[] strA){

        return
            Arrays.stream(strA)
                .collect(Collectors.groupingBy(
                    s->s,
                    Collectors.counting()
                ));
    }

    /**65.	Remove duplicates from String[]**/
    @Override
    public String[] removeDuplicate(String[] strA){
        return
            Arrays.stream(strA)
                .distinct()
                .toArray(String[]::new);
    }

    /**66.	Sort String[] by length / lexicographically using streams**/
    @Override
    public String[] sortByLength(String[] strA){

        return
            Arrays.stream(strA)
                .sorted(Comparator.comparing(String::length))
                .toArray(String[]::new);
    }

    /**67.	Group anagrams from String[] using streams**/
    @Override
    public Map<String,List<String>> groupAnagrams(String[] strA){
        return
            Arrays.stream(strA)
                .collect(
                    Collectors.groupingBy(
                        words-> words.chars().mapToObj(c->(char)c).sorted().map(String::valueOf).collect(Collectors.joining()),
                        Collectors.toList()
                    )
                );
    }

    /**68.	Find all palindromic strings in array**/
    @Override
    public List<String> allPalindromic(String[] strA){
        return Arrays.stream(strA)
            .filter(this::isPalindrome)
            .toList();
    }

    private boolean isPalindrome(String str)
    {
        return
            IntStream.range(0,str.length()/2)
                .allMatch(i-> str.charAt(i)==str.charAt(str.length()-1-i));
    }

    /**69.	Check if all strings are unique (case insensitive)**/
    @Override
    public boolean isAllStringUnique(String[] strA){
        return
            Arrays.stream(strA)
                .map(String::toLowerCase)
                .distinct()
                .count()==strA.length;
    }

    /**70.	Merge two String arrays and remove duplicates**/
    @Override
    public List<String> mergeAndRemoveDuplicate(String[] strA, String[]strB){
        return
            Stream.concat(Arrays.stream(strA),Arrays.stream(strB))
            .distinct()
            .toList();

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

 /* *    Category 8: Subarrays / Sliding Window / Intervals*/
    /**71.	Generate all subarrays using IntStream ranges**/
    @Override
    public List<int[]> generateAllSubArrays(int[]a){

        int n = a.length;
        return IntStream.range(0,n)
            .boxed()
            .flatMap(i-> IntStream.rangeClosed(i+1,n).boxed().map(j-> Arrays.copyOfRange(a,i,j)))
            .toList();
    }

    /**72.	Find subarray with maximum average of size K**/
    @Override
    public List<int[]> maxAvgSubArrayOfSizeK(int[]a, int k){
        int n = a.length;
        return
            IntStream.range(0,n)
                .boxed()
                .flatMap(i-> IntStream.rangeClosed(i+1,n).boxed().map(j-> Arrays.copyOfRange(a,i,j)))
                .filter(arr-> arr.length==k)
                .max(Comparator.comparingDouble(this::average))
                .stream().toList();

    }
    private double average(int[] arr) {
        return Arrays.stream(arr).average().orElse(Double.NEGATIVE_INFINITY);
    }

    /**73.	Find longest subarray with all distinct elements**/
    @Override
    public List<int[]> longestSubArrayDistinctElem(int[] a){
        int n = a.length;

        return
            IntStream.range(0,n)
                .boxed()
                .flatMap(i-> IntStream.rangeClosed(i+1,n).mapToObj(j-> Arrays.copyOfRange(a,i,j)))
                .filter(arr->Arrays.stream(arr).boxed().collect(Collectors.toSet()).size()==arr.length)
                .max(Comparator.comparingInt(arr->arr.length))
                .stream().toList();
    }


    /**74.	Find longest subarray with sum = target**/
    @Override
    public List<int[]> longestSubArrSumTarget(int[]a, int target){
        int n= a.length;
        return
            IntStream.range(0,n)
                .boxed()
                .flatMap(i->IntStream.rangeClosed(i+1,n).mapToObj(j->Arrays.copyOfRange(a,i,j)))
                .filter(ar-> Arrays.stream(ar).sum()==target)
                .max(Comparator.comparingInt(arr->arr.length))
                .stream().toList();
    }

    /**75.	Count number of subarrays with sum divisible by K**/
    @Override
    public long noOfSubarraySumDivByK(int[]a, int k){
        int n = a.length;
        return
            IntStream.range(0,n)
                .boxed()
                .flatMap(i-> IntStream.rangeClosed(i+1,n).mapToObj(j->Arrays.copyOfRange(a,i,j)))
                .filter(arr-> Arrays.stream(arr).sum()%k==0)
                .count();

    }

    /**76.	Check if array has increasing triplet subsequence**/
    @Override
    public boolean checkIncreasingTriplet(int[]a){

        return
            IntStream.range(0, a.length - 2)
                .filter(i -> a[i] < a[i + 1] && a[i + 1] < a[i + 2]).findAny().isPresent();
    }

    /**77.	Find longest increasing contiguous subarray**/
    @Override
    public List<int[]> longestIncreasingContiguousSubArr(int[]a){
        int n=a.length;
        return
            IntStream.range(0,n)
                .boxed()
                .flatMap(i-> IntStream.rangeClosed(i+1,n).mapToObj(j-> Arrays.copyOfRange(a,i,j)))
                .filter(arr-> IntStream.range(0,arr.length-1).allMatch(k-> arr[k]<arr[k+1]))
                .max(Comparator.comparingInt(ar->ar.length))
                .stream().toList();
    }

    /**78.	Count number of subarrays with all elements even**/
    @Override
    public long noOfSubArrayAllElemEven(int[] a){
        int n = a.length;

        return
            IntStream.range(0,n)
                .boxed()
                .flatMap(i-> IntStream.rangeClosed(i+1,n).mapToObj(j-> Arrays.copyOfRange(a,i,j)))
                .filter(arr-> Arrays.stream(arr).allMatch(x->x%2==0))
                .count();
    }

    /**79.	Check if array contains a subarray with 0 sum**/
    @Override
    public boolean checkSubArraysZeroSum(int[] a){
        int n = a.length;

        return
            IntStream.range(0,n)
                .boxed()
                .flatMap(i-> IntStream.rangeClosed(i+1,n).mapToObj(j-> Arrays.copyOfRange(a,i,j)))
                .anyMatch(arr-> Arrays.stream(arr).sum()==0);
    }

    /**80.	Find smallest subarray with sum >= target**/
    @Override
    public List<int[]> smallestSubArraySumGretThanTarget(int[]a, int target){
        int n = a.length;

        return IntStream.range(0, n)
            .boxed()
            .flatMap(i ->
                IntStream.rangeClosed(i + 1, n)
                    .mapToObj(j -> Arrays.copyOfRange(a, i, j))
            )
            .filter(arr -> Arrays.stream(arr).sum() >= target)
            .min(Comparator.comparingInt(arr -> arr.length))
            .stream()
            .toList();

    }

/* *   Category 9: Advanced Grouping / Partition Problems**/
    /**81.	Group elements by modulo value (e.g., % 3)**/
    @Override
    public Map<Integer,List<Integer>> groupByModulo(int[]a, int k){
        return
            Arrays.stream(a)
                .boxed()
                .collect(Collectors.groupingBy(
                    i->i%k,
                    Collectors.toList()
                ));
    }

    /**82.	Group numbers by number of digits**/
    @Override
    public Map<Integer,List<Integer>> groupByNoOfDigits(int[]a){
        return
            Arrays.stream(a)
                .boxed()
                .collect(Collectors.groupingBy(
                    i->String.valueOf(i).length(),
                    Collectors.toList()
                ));
    }

    /**83.	Group by even/odd index positions**/
    @Override
    public Map<Integer,List<Integer>> groupByIndexOddEvenPos(int[] a){
        return
            IntStream.range(0,a.length)
                .boxed()
                .collect(Collectors.groupingBy(
                   i->i%2,
                   Collectors.mapping(i->a[i],Collectors.toList())
                ));
    }

    /**84.	Group array into chunks of fixed size using streams**/
    @Override
    public Map<Integer,List<Integer>> groupIntoChunkOfFixedSize(int[] a, int k){
        int n = a.length;
        return
            IntStream.range(0,n)
                .boxed()
                .collect(Collectors.groupingBy(
                    i->i/k,
                    Collectors.mapping(i-> a[i],Collectors.toList())
                ));
    }

    /**85.	Partition array around a pivot value**/
    @Override
    public Map<Boolean,List<Integer>> partitionAroundPivotVal(int[]a, int pivotVal){
        return
            Arrays.stream(a)
                .boxed()
                .collect(Collectors.groupingBy(
                    i-> i<=pivotVal,
                    Collectors.toList()
                ));
    }

    /**86.	Group by frequency buckets (e.g., map<frequency, List>)**/
    //@See **6

    /**87.	Group by sorted characters (anagram grouping)**/
    //@see 67

    /**88.	Group by first digit of each number**/
    @Override
    public Map<Integer,List<Integer>> groupByFirstChar(int[]a){
        return
            Arrays.stream(a)
                .boxed()
                .collect(Collectors.groupingBy(
                   i->Math.divideExact(i,(int)Math.pow(10,String.valueOf(i).length()-1)),
                   Collectors.toList()
                ));
    }

    /**89.	Partition array into k equal-sum subsets (NP-hard → interesting to discuss)**/
    @Override
    public  List<List<Integer>> partitionKEqualSum(int []a, int k){
        int totalSum = Arrays.stream(a).sum();
        if(totalSum%k!=0) return Collections.emptyList();

        int target = totalSum/k;
        Arrays.sort(a);
        if(a[a.length-1]>target) return Collections.emptyList();

        boolean[] used = new boolean[a.length];

        //create empty list for result
        List<List<Integer>> resultList = IntStream.range(0,k)
            .mapToObj( i-> new ArrayList<Integer>())
            .collect(Collectors.toList());
        return backTrack(a, used, k, 0, 0, target, resultList) ? resultList : Collections.emptyList();

    }
    private boolean backTrack(int[] a,boolean[] used, int k, int start, int currSum,int target, List<List<Integer>> resultList)
    {
        if(k==0) return true;

        if(currSum==target)
            return backTrack(a,used,k-1,0,0,target,resultList);

        return
            IntStream.range(start,a.length)
                .filter(i-> !used[i] && a[i]+currSum<=target)
                .anyMatch(i->
                {
                    used[i]=true;
                    resultList.get(k-1).add(a[i]);

                    boolean ok = backTrack(a,used,k, i+1,a[i]+currSum, target,resultList);
                    if(ok)
                        return true;

                    //backtrack
                    used[i]=false;
                    resultList.get(k-1).removeLast();
                    return false;
                });
    }

    /**90.	Group integers by bit-count**/
    @Override
    public Map<Integer,List<Integer>> groupBitCount(int[]a){

        return Arrays.stream(a)
            .boxed()
            .collect(Collectors.groupingBy(
                Integer::bitCount,
                Collectors.toList()
            ));
    }

/**    Category 10: Mixed / Tricky / Pattern Problems**/

    /**91.	Find majority element (> n/2) using streams**/
    @Override
    public int findMajorityElem(int[]a ){
        return
            Arrays.stream(a)
                .boxed()
                .collect(Collectors.groupingBy(
                    i->i,
                    Collectors.toList()
                ))
                .entrySet()
                .stream()
                .filter(e-> e.getValue().size()>=a.length/2)
                .map(Map.Entry::getKey)
                .findFirst()
                .orElseThrow();
    }
    /**92.	Find leader elements (greater than all to the right)**/
    @Override
    public List<Integer> findLeaderElem(int[]a ){
        int n = a.length;
        return
            IntStream.range(0,n)
                .filter(i-> IntStream.range(i+1,n).noneMatch(j-> a[j]>a[i]))
                .mapToObj(i-> a[i])
                .toList();
    }

    /**93.	Find peak elements using IntStream**/
    @Override
    public List<Integer> findPeakElem(int[]a ){
        int n = a.length;
        return IntStream.range(0, n)
            .filter(i ->
                (i == 0 && a[i] > a[i + 1]) ||
                    (i == n - 1 && a[i] > a[i - 1]) ||
                    (i > 0 && i < n - 1 && a[i] > a[i - 1] && a[i] > a[i + 1])
            )
            .mapToObj(i -> a[i]) // return values, not indices
            .collect(Collectors.toList());
    }

    /**94.	Find elements appearing exactly twice**/
    @Override
    public List<Integer> findIfEleTwice(int[] a){
        return
            Arrays.stream(a)
                .boxed()
                .collect(Collectors.groupingBy(
                    i->i,
                    Collectors.toList()
                ))
                .entrySet()
                .stream()
                .filter(e-> e.getValue().size()==2)
                .map(Map.Entry::getKey)
                .toList();
    }

    /**95.	Check if array can be divided into pairs whose sum is divisible by K**/
    @Override
    public boolean checkPairsDivisibleByK(int[]a, int k){

        Map<Integer,Long> freqMap =
            Arrays.stream(a)
                .mapToObj(i-> ((i%k)+k)%k)
                .collect(Collectors.groupingBy(
                    i->i,
                    Collectors.counting()
                ));
        return freqMap.entrySet().stream()
            .allMatch(e->
            {
                int r = e.getKey();
                long count = e.getValue();

                if(r==0) return count%2==0;
                long complementCount = freqMap.getOrDefault(k-r,0l);
                return count==complementCount;
            });
    }

    /**96.	Check if array elements form an arithmetic progression**/
    @Override
    public boolean checkElemFormArithmeticProgression(int[]a){
        int n = a.length;
        if(n<2) return true;
        int []sorted = Arrays.stream(a).sorted().toArray();
        int diff = sorted[1]-sorted[0];

        return
            IntStream.range(0,n-1)
                .boxed()
                .allMatch(i-> sorted[i+1]-sorted[i]==diff);

    }

    /**97.	Check if array elements form a geometric progression**/
    @Override
    public boolean checkElemFormGeometricProgression(int[]a){
        int n =a .length;
        if(n<2) return true;
        double[] sorted = Arrays.stream(a)
            .mapToDouble(x -> x)
            .sorted()
            .toArray();
        double gpRatio = sorted[1]/sorted[0];

        return IntStream.range(0,n-1)
            .boxed()
            .allMatch(i-> Math.abs(sorted[i + 1] / sorted[i] - gpRatio) < 1e-9); // floating tolerance
    }

    /**98.	Find minimum jumps to reach the end (greedy + streams support)**/
    @Override
    public int minJumToReachEnd(int[]a){
        int n = a.length;
        if(n<=1) return 0;//already at end
        if (a[0] == 0) return -1;      // cannot move anywhere

        AtomicInteger jumps = new AtomicInteger(0);
        AtomicInteger currentEnd = new AtomicInteger(0);
        AtomicInteger farthest = new AtomicInteger(0);

        IntStream.range(0, a.length - 1).forEach(i -> {
            farthest.set(Math.max(farthest.get(), i + a[i]));

            if (i == currentEnd.get()) {
                jumps.incrementAndGet();
                currentEnd.set(farthest.get());
            }
        });

        return (currentEnd.get() >= a.length - 1) ? jumps.get() : -1;
    }

    /**99.	Find length of longest consecutive sequence**/
    @Override
    public int findLongestConsecutiveSequence(int[]a ){
        if(a.length==0) return  0;

        Set<Integer> set = Arrays.stream(a).boxed().collect(Collectors.toSet());
        return
            Arrays.stream(a)
                .boxed()
                .filter(i-> !set.contains(i-1)) //only collect start of sequence
                .mapToInt(start->
                    {
                        int len=1;
                        while (set.contains(start+len))len++;
                        return len;
                    }
                ).max().orElseThrow();
    }

    /**100.	Reconstruct array from pairwise sums**/
    @Override
    public List<Integer> reconstructArrayFromPairwiseSums(int []a){

        Arrays.sort(a);
        int len = a.length;
        int n = (int) ((1 + Math.sqrt(1 + 8 * len)) / 2);

        int s1 = a[0];
        int s2 = a[1];
        int s3 = a[2];

        int a0 = (s1 + s2 - s3) / 2;
        int a1 = s1 - a0;
        int a2 = s2 - a0;

        List<Integer> result = new ArrayList<>(List.of(a0, a1, a2));

        // Keep track of pairwise sums already explained
        List<Integer> explained = IntStream.range(0, result.size())
            .boxed()
            .flatMap(i -> IntStream.range(i + 1, result.size())
                .mapToObj(j -> result.get(i) + result.get(j)))
            .sorted()
            .collect(Collectors.toList());

        // Now find missing elements using unexplained sums that involve a₀
        for (int sum : a) {
            if (!explained.contains(sum)) {
                int candidate = sum - a0;
                if (!result.contains(candidate)) {
                    result.add(candidate);
                    // add new pairwise sums with this candidate
                    for (int x : result)
                        if (x != candidate) explained.add(x + candidate);
                }
            }
            if (result.size() == n) break;
        }

        // Sort and verify
        Collections.sort(result);
        List<Integer> verify = IntStream.range(0, result.size())
            .boxed()
            .flatMap(i -> IntStream.range(i + 1, result.size())
                .mapToObj(j -> result.get(i) + result.get(j)))
            .sorted()
            .toList();

        if (!Arrays.equals(verify.stream().mapToInt(Integer::intValue).toArray(), a))
            throw new IllegalArgumentException("Invalid or ambiguous input");

        return result;
    }
}

