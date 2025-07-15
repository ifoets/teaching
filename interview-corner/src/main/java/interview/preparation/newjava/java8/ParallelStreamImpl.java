package interview.preparation.newjava.java8;

import java.util.*;
import java.util.function.IntConsumer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.lang.Thread.sleep;

public class ParallelStreamImpl implements IParallelStream{

    public List<String> orderLoss(List<Integer> list){
        return list.parallelStream().filter(i-> i%2==0).map(x-> Thread.currentThread().getName()+":-"+x).toList();
    }

    /**2-8 times faster depends up on the cores4-32*/
    public Map<Long,List<Integer>> checkPerformance(List<Integer> list){

        Long plStart = System.currentTimeMillis();
        List<Integer> listParallel = list
            .parallelStream()
            .filter(i-> String.valueOf(i).contentEquals(new StringBuilder(String.valueOf(i)).reverse())
            ).toList();
        Long plSEnd = System.currentTimeMillis();
        List<Integer> listSeries = list
            .stream()
            .filter(i->String.valueOf(i).contentEquals(new StringBuilder(String.valueOf(i)).reverse())
            ).toList();
        Long serEnd = System.currentTimeMillis();
        return Map.of(
            plSEnd - plStart,
            listParallel,
            serEnd - plSEnd,
            listSeries
        );
    }

    /**2. Thread-Safety, You must not modify shared data inside a parallel stream unless it’s thread-safe.
     * keep performance in mind**/
    @Override
    public List<Integer> addTwoListOnIndexes(List<Integer> l1, List<Integer> l2){
        List<Integer> threadSafe = Collections.synchronizedList(new ArrayList<>());
        int N1 = l1.size();
        int N2 = l2.size();
        IntStream.range(0, Math.max(N1, N2)).boxed().toList().parallelStream().forEach(i -> threadSafe.add((i < N1 ? l1.get(i) : 0) + (i < N2 ? l2.get(i) : 0)));
            return threadSafe;
    }
    /**get sum of large nos keep performance in mind**/;
    @Override
    public Integer getSum(int[] a){
       return IntStream.of(a).parallel().sum();
    }
    /**find max or min keep performance in mind*/
    @Override
    public Integer getMaxOrMin(int[] a, boolean maxOrMin){
        return maxOrMin?
            IntStream.of(a).parallel().max().orElseGet(() -> Integer.MIN_VALUE)
            :IntStream.of(a).parallel().min().orElseGet(() -> Integer.MIN_VALUE);
    }
}
