package interview.preparation.company.interviews.interview;

import interview.preparation.company.interviews.impl.GoldmanSachImpl;
import interview.preparation.company.interviews.question.IGoldmanSach;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class IGoldmanSachTest {

    IGoldmanSach igs;

    @Before
    public void init()
    {
        igs = new GoldmanSachImpl();
    }
    @Test
    public void shortestDistanceTest()
    {

    }


    @Test
    public void minJumToReachEndOfArrayTest()
    {
        int[] x = {2,3,1,1,4};
        Assert.assertEquals(2,igs.minJumToReachEndOfArray(x));
        int[]a = {1, 4, 3, 2, 6, 7};
        Assert.assertEquals(2,igs.minJumToReachEndOfArray(a));
        int[]b = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
        Assert.assertEquals(3,igs.minJumToReachEndOfArray(b));
        int[]c ={1,2,1,1,1};
        Assert.assertEquals(3,igs.minJumToReachEndOfArray(c));
        int[] d = {10,9,8,7,6,5,4,3,2,1,1,0};
        Assert.assertEquals(2,igs.minJumToReachEndOfArray(d));
    }
    /**Given two arrays start[] and finish[], representing the start and finish times of activities. A person can perform only one activity at a time, and an activity can be performed only if its start time is greater than the finish time of the last chosen activity.
     Find the maximum number of activities that can be performed without overlapping.*/
    @Test
    public void maxActivityTest()
    {
        int[] start = {1, 3, 0, 5, 8, 5};
        int[] finish = {2, 4, 6, 7, 9, 9};

        Assert.assertEquals(4,igs.maxActivity(start,finish));

        int[] start1 = {10,12,20};
        int[] finish1 = {20,25,30};

        Assert.assertEquals(1,igs.maxActivity(start1,finish1));
    }
}
