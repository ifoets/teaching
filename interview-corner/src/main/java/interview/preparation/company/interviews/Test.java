package interview.preparation.company.interviews;


import io.reactivex.rxjava3.internal.functions.Functions;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;


public class Test {
   /* Given two arrays start[] and finish[], representing the start and finish times of activities. A person can perform only one activity at a time,
   and an activity can be performed only if its
   start time is greater than the finish time of the last chosen activity.
    Find the maximum number of activities that can be performed without overlapping.
    Examples:
    Input: start[] = [1, 3, 0, 5, 8, 5], finish[] = [2, 4, 6, 7, 9, 9]
    Output: 4
    Explanation: A person can perform at most four activities. The maximum set of activities that can be performed is {0, 1, 3, 4} (these are the indexes in the start[] and finish[] arrays).
    Input: start[] = [10, 12, 20], finish[] = [20, 25, 30]
    Output: 1
    Explanation: A person can perform at most one activity.
    */


 /*

1,-2
3, -4
0,-6
5, -7
8,-9
5-9
    */

/*
10-20
12-25
20-30
*/

    public static void main(String[] args) {

    }

    public int maxActivity(int[]start, int[] end)
    {
        int[][]t = new int[start.length][2];
        for(int i=0;i<start.length;i++)
        {
            t[i][0]=start[i];
            t[i][1]=end[i];
        }

        Arrays.sort(t,Comparator.comparing(x->x[1]));//

        int activit=1;
        int endTime=t[0][1];
        for (int i=1;i<t.length;i++)//n
        {
            if(t[i][1]>endTime)
            {
                endTime=t[i][0];
                activit++;
            }
        }
        return activit;
    }
    public boolean canReach(int[] nums)
    {
        int maxReach = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i > maxReach) return false;   // can't even reach this index
            maxReach = Math.max(maxReach, i + nums[i]);
            if (maxReach >= nums.length - 1) return true;
        }
        return true;
    }

}
