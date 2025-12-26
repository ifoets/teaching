package interview.preparation.company.design;

import java.util.*;
/*[1,3] and [3,5]  (touching)-shouldn't
[1,3] and [2,4]  (overlapping)-shouldn't
[1,3] and [4,6] -fine

*/

interface IIntervalManager {
    boolean addInterval(int start, int end);
    boolean removeInterval(int start, int end);
    List<int[]> getIntervals();
}
public class IntervalManager implements IIntervalManager {

    private final TreeMap<Integer, int[]> intervals = new TreeMap<>();

    // Add interval if non-overlapping and non-touching
    public boolean addInterval(int start, int end) {
        if (start >= end) return false;

        // Find previous interval(Ex- [1,3] inserting [3,5]) =>  [1,3] [3,5] touch overlapping
        Map.Entry<Integer, int[]> prev = intervals.floorEntry(start);//Returns the entry with the greatest key ≤ given key
        if (prev != null && prev.getValue()[1] >= start) {
            return false; // overlapping or touching
        }

        // Find next interval (Ex- [4,5] inserting [3,5]) => [3,5],[4,5], 1 overlapping
        Map.Entry<Integer, int[]> next = intervals.ceilingEntry(start);//Returns the entry with the smallest key ≥ given key
        if (next != null && end >= next.getValue()[0]) {
            return false; // overlapping or touching
        }

        intervals.put(start, new int[]{start, end});
        return true;
    }

    // Remove exact interval
    public boolean removeInterval(int start, int end) {
        int[] interval = intervals.get(start);
        if (interval != null && interval[1] == end) {
            intervals.remove(start);
            return true;
        }
        return false;
    }

    // Return all intervals
    public List<int[]> getIntervals() {
        return new ArrayList<>(intervals.values());
    }

    public static void main(String[] args) {
        IntervalManager manager = new IntervalManager();

        System.out.println(manager.addInterval(1, 3)); // true
        System.out.println(manager.addInterval(4, 6)); // true
        System.out.println(manager.addInterval(3, 4)); // false (touching)
        System.out.println(manager.addInterval(2, 5)); // false (overlap)

        for (int[] i : manager.getIntervals()) {
            System.out.println(Arrays.toString(i));
        }
    }
}
