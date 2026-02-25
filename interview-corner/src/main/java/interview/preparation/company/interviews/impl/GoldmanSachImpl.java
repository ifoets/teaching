package interview.preparation.company.interviews.impl;

import interview.preparation.company.interviews.question.IGoldmanSach;

import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeMap;

public class GoldmanSachImpl implements IGoldmanSach {

    @Override
    public double shortestDistance(String document, String word1, String word2) {
        String[] words = document.split("[,.\\s]");

        int index = 0;
        double shortest = document.length();
        double word1Loc = 0;
        double word2Loc = 0;

        for (String word : words) {
            if (word.equalsIgnoreCase(word1)) {
                word1Loc = index + (word.length() / 2.0);
            } else if (word.equalsIgnoreCase(word2)) {
                word2Loc = index + (word.length() / 2.0);
            }

            if (word1Loc > 0 && word2Loc > 0) {
                double current = Math.abs(word2Loc - word1Loc);
                if (current < shortest) {
                    shortest = current;
                }
            }

            index += word.length() + 1;
        }

        if (word1Loc == 0 || word2Loc == 0) {
            return -1;
        }

        return shortest;
    }
//{2,3,1,1,4};
    @Override
    public int minJumToReachEndOfArray(int[] a){
        int jump =0;
        int n=a.length;
        int fardest=0;
        int end=0;
        for(int i=0;i<n;i++)
        {
            // update the farthest reachable index from the current position
            fardest = Math.max(fardest,i+a[i]);
            if(fardest>=n-1) {
                jump++;
                break;
            }
            // it's time to make next jump
            if(i==end)
            {
                jump++;
                end=fardest;
            }
        }
        return jump;
    }

    /**Given two arrays start[] and finish[], representing the start and finish times of activities. A person can perform only one activity at a time, and an activity can be performed only if its start time is greater than the finish time of the last chosen activity.
     Find the maximum number of activities that can be performed without overlapping.*/
    @Override
    public int maxActivity(int[]start, int[]end){
       int[][]a = new int[start.length][2];
       for(int i=0;i<start.length;i++){
           a[i][0]=start[i];
           a[i][1]=end[i];
       }
       Arrays.sort(a, Comparator.comparing(x->x[1]));
       int countMax=1;
       int prev=a[0][1];
       for(int i=1;i<start.length;i++)
       {
           if(a[i][0]>prev)
           {
               prev=a[i][1];
               countMax++;
           }
       }
       return countMax;
    }
}
