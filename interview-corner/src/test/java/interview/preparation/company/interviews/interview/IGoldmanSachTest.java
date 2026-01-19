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
}
