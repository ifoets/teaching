package interview.preparation.company.interviews.impl;

import interview.preparation.company.interviews.question.IGoldmanSach;

import java.util.stream.IntStream;

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

        System.out.println(shortest);

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
}
