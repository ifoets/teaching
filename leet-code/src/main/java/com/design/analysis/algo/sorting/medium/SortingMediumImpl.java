package com.design.analysis.algo.sorting.medium;

import com.design.analysis.algo.AlgoUtils;

import java.util.*;
import java.util.stream.Collectors;

public class SortingMediumImpl implements ISortingMedium{

    /**49. Group Anagrams**/
    @Override
    public List<List<String>> groupAnagrams(String[] strs){
        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            int[] freq = new int[26];

            for (char c : s.toCharArray()) {
                freq[c - 'a']++;
            }

            StringBuilder key = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                if (freq[i] > 0) {
                    key.append((char) ('a' + i))
                        .append(freq[i]);
                }
            }

            map.computeIfAbsent(key.toString(), k -> new ArrayList<>())
                .add(s);
        }

        return new ArrayList<>(map.values());
    }

    public List<List<String>> groupAnagramsS(String[] strs){
        return
            Arrays.stream(strs)
                .collect(
                    Collectors.groupingBy(
                        s->s.chars().mapToObj(c->(char)c).sorted().map(String::valueOf).collect(Collectors.joining()),
                        Collectors.toList()
                    )
                )
                .values()
                .stream()
                .toList();
    }

    /**56. Merge Intervals**/
    //int[][] intervals ={{1,3}, {2,4}, {3,5}, {6,8}};
    //int[][] result = {{1,3}, {3,5}, {6,8}};
    @Override
    public int[][] mergeOverlappingInterval(int[][] intervals){

        if(intervals==null||intervals.length<=1)return intervals;
        Arrays.sort(intervals,Comparator.comparing(a->a[0]));
        int n = intervals.length;
        List<int[]> result = new ArrayList<>();
        int[] prev = intervals[0];

        for(int i=1;i<n;i++)
        {
            int[] current=intervals[i];

            //overlapping merge
            if(prev[1]>=current[0])
            {
                prev[1]=Math.max(prev[1],current[1]);
            }
            else {
                result.add(prev);
                prev=current;
            }
        }
        //at last result in prev at loop break; ex {1,3}, {2,4} only prev
        result.add(prev);
        return result.toArray(new int[result.size()][]);
    }

    /*[1,3] and [3,5]  (touching)-shouldn't
        [1,3] and [2,4]  (overlapping)-shouldn't
        [1,3] and [4,6] -fine*/
    @Override
    public int[][] addNonTouchingInterval(int[][]intervals, int[]current){
        if(intervals==null)
            return new int[][]{current};

        TreeMap<Integer,int[]> treeMap = new TreeMap<>();
        for (int[] interval : intervals) treeMap.put(interval[0], interval);

        Map.Entry<Integer,int[]> prev = treeMap.floorEntry(current[0]);
        if(prev!=null&&prev.getValue()[1]>=current[0])//overlapping
            return intervals;
        Map.Entry<Integer,int[]> next = treeMap.ceilingEntry(current[0]);
            if(next!=null&&current[1]>=next.getValue()[0])//overlaping
                return intervals;
            treeMap.put(current[0],current);
            return treeMap.values().toArray(new int[treeMap.size()][]);
    }

    /**75. Sort Colors** k color, 0, 1,2..k-1**/
    @Override
    public void sortColors(int[] nums, int k){
        int[]x = new int[k];
        for(int i:nums)x[i]++;
        for(int i=0,j=0;i<k;i++)
        {
            while (x[i]!=0) {
                nums[j++] = i;
                x[i]--;
            }
        }
    }

}
