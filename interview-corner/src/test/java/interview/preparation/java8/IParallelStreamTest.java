package interview.preparation.java8;

import interview.preparation.newjava.java8.IParallelStream;
import interview.preparation.newjava.java8.ParallelStreamImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.beans.BeanProperty;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class IParallelStreamTest {

    private IParallelStream ips;

    @Before
    public void init()
    {
        ips = new ParallelStreamImpl();
    }

    @Test
    public void orderLossTest()
    {
        List<Integer> list = IntStream.range(1,10).boxed().toList();
        List<String> listR = ips.orderLoss(list);
        System.out.println(listR);
        Assert.assertEquals(4, listR.size());
    }

    @Test
    public void checkPerformanceTest()
    {
        List<Integer> list = IntStream.rangeClosed(1,10000000).boxed().toList();
        Map<Long,List<Integer>> map = ips.checkPerformance(list);
        List<Long> listTime = map.keySet().stream().sorted().toList();
        System.out.println("Parallel Stream Time taken :"+listTime.get(0));
        System.out.println("Serial Stream Time taken :"+listTime.get(1));
        Assert.assertTrue(list.get(0)<list.get(1));
    }
    /**2. Thread-Safety, You must not modify shared data inside a parallel stream unless it’s thread-safe.
     * keep performance in mind**/
    @Test
    public void addTwoListOnIndexesTest()
    {
        List<Integer> list = List.of(1,2,3,4,5,6,7,8,9);
        List<Integer> list2 = List.of(9,8,7,6,5,4,4,4,4);
        List<Integer> resultList = ips.addTwoListOnIndexes(list,list2);
        System.out.println(resultList);
       Assert.assertEquals(9,resultList.size());
    }

    /**get sum of large nos keep performance in mind**/;
    @Test
    public void getSumTest()
    {
        int[]  a = {1,2,9,7,8,6,5,4,3,10};
        Assert.assertEquals(55, (int)ips.getSum(a));
    }

    /**find max or min keep performance in mind*/
    @Test
    public void getMaxOrMinTest()
    {
        int[]  a = {1,2,9,7,8,6,5,4,3,10};
        Assert.assertEquals(10, (int)ips.getMaxOrMin(a,true));
        Assert.assertEquals(1, (int)ips.getMaxOrMin(a,false));
    }

    @Test
    public void test()
    {

    }
}
