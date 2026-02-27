package interview.preparation.company.interviews.interview;

import interview.preparation.company.interviews.impl.GoldmanSachImpl;
import interview.preparation.company.interviews.question.IGoldmanSach;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

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

    /**151. Reverse Words in a String.**/
    @Test
    public void reverseWordsTest()
    {
      String str1 = "this   is  a   cat ";
      String str2 = " hello  world" ;

      Assert.assertEquals("cat a is this",igs.reverseWords(str1));
      //Assert.assertEquals("world hello",igs.reverseWords(str2));
    }

    /**given a grid of numbers move right and up find max sum**/
    @Test
    public void maxSumTest()
    {
        int[][] mat={
            {0, 0, 0, 0, 5},
            {0, 1, 1, 1, 0},
            {2, 0, 0, 0, 0}
        };
        Assert.assertEquals(10,igs.maxSum(mat));
        for(int i=0;i<mat.length;i++)
            System.out.println(Arrays.toString(mat[i]));
    }

    /**find least recently used ip,ie older used ip*/
    @Test
    public void lruFromLogTest()
    {
      String[] logs = {
          "192.168.1.10 - - [10/Jan/2026:10:01:10 +0530] \"GET /home HTTP/1.1\" 200",
          "192.168.1.11 - - [10/Jan/2026:10:01:20 +0530] \"GET /login HTTP/1.1\" 200",
          "192.168.1.10 - - [10/Jan/2026:10:02:10 +0530] \"GET /profile HTTP/1.1\" 200",
          "192.168.1.12 - - [10/Jan/2026:10:03:10 +0530] \"GET /about HTTP/1.1\" 200"
      };
      Assert.assertEquals("192.168.1.11",igs.lruFromLog(logs));
    };

    /**Best Average Grade**/
    @Test
    public void bestAverageTest()
    {
        String[][] input1 = {
            {"Bobby", "87"},
            {"Charles", "100"},
            {"Eric", "64"},
            {"Charles", "22"}
        };

        String[][] input2 = {
            {"Bobby", "-64"},
            {"Charles", "-65"},
            {"Charles", "-66"}
        };

        System.out.println(igs.bestAverage(input1));  // 87
        System.out.println(igs.bestAverage(input2));  // -66
    }

    /**median of two sorted Array O(m+n)*/


    @Test
    public void medianSortedArrayByMergeTest(){

    }

    /**O(log(m+n))*/
    public void findMedianSortedArraysTest()
    {

    }
    /**Your local Foyle's is running a scheme to promote reading amongst users. If you sign up for the scheme,
     *  you can buy any books from the store at a fixed cost of c. You can also exchange x number of books to get 1 new book.
     *  Write an algorithm to find the maximum number of books you can read for a given amount of money m.**/
    @Test
    public void maxBooksTest(){
        Assert.assertEquals(3,igs.maxBooks(10,5,2));
        Assert.assertEquals(9,igs.maxBooks(5,1,2));
    }

    /**Minimum Steps to Make All Elements 1
     Every 0 becomes 1 if at least one of its neighbors is 1 (left or right).
     1 always stays 1**/
    @Test
    public void minStepsToAllOnesTest()
    {
        int[] a = {0,1,1,1,0,0};
        Assert.assertEquals(3,igs.minStepsToAllOnes(a));
    }

    /**Longest Repeating Substring **/
    @Test
    public void longestRepSubStrTest()
    {
        System.out.println(igs.longestRepSubStr("abbbcdjgjfsksnbb"));
    }
    @Test
    public void minSlidingWindowTest()
    {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        String exp = "BANC";
        Assert.assertEquals(exp,igs.minSlidingWindow(s,t));

    }

    /**Longest Increasing Subsequence in a String**/
    @Test
    public void longestIncreasingSubsequenceTest()
    {
        Assert.assertEquals("abhkm",igs.longestIncreasingSubsequence("abhkdfm"));
    }

    /**Minimum number of moves required to move all 1s together
     0 0 1 0 0 0 0 1 1 0 0 0 1 0 0 0 **/
    @Test
    public void minNoOfMovesReqAllOneTogetherTest()
    {
        Assert.assertEquals(1,igs.minSwaps(new int[]{1,0,0,1,0,1}));
        Assert.assertEquals(1,igs.minSwaps(new int[]{1,0,1,0,1}));
        Assert.assertEquals(0,igs.minSwaps(new int[]{1,1,0,0,1}));
        Assert.assertEquals(0,igs.minSwaps(new int[]{0,0,0}));
        Assert.assertEquals(0,igs.minSwaps(new int[]{1,0,0,1}));
    }

    /**Find the sum of minimum and maximum element of all subarrays of size K**/
    @Test
    public void maxMinSubArraySumOfSizeKTest()
    {
        int[] a ={4,3,-1,7,0,3,-3,2};
        igs.sumOfMinAndMax(a,4);
    }
}
