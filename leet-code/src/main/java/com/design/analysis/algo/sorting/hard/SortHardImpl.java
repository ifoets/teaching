package com.design.analysis.algo.sorting.hard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class SortHardImpl implements ISortHard{

    /**218. The Skyline Problem**/
    @Override
    public List<List<Integer>> getSkyline(int[][] buildings){
        List<int[]> events = new ArrayList<>();

        // Step 1: Create events
        for (int[] b : buildings) {
            events.add(new int[]{b[0], -b[2]}); // building start
            events.add(new int[]{b[1],  b[2]}); // building end
        }

        // Step 2: Sort events
        Collections.sort(events, (a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0];
            return a[1] - b[1]; // start (-H) before end (+H)
        });

        // Step 3: Max Heap
        PriorityQueue<Integer> maxHeap =
            new PriorityQueue<>(Collections.reverseOrder());
        maxHeap.add(0);

        int prevMax = 0;
        List<List<Integer>> result = new ArrayList<>();

        // Step 4: Process events
        for (int[] e : events) {
            int x = e[0];
            int h = e[1];

            if (h < 0) {
                maxHeap.add(-h);   // start
            } else {
                maxHeap.remove(h); // end
            }

            int currMax = maxHeap.peek();
            if (currMax != prevMax) {
                result.add(List.of(x, currMax));
                prevMax = currMax;
            }
        }

        return result;
    }
}
