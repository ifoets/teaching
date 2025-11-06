package interview.preparation.company.interviews.impl;

import interview.preparation.company.interviews.question.IRakutenSymphony;

import java.util.*;

public class RakutenSymphonyImpl implements IRakutenSymphony {

    /**min cost to join the broken ropes in single rope*/

    public int minCostJoinRopes(List<Integer> list, int cost){
        if (list.size() == 1) return cost;
        if (list.size() == 2) return cost + list.get(0) + list.get(1);

        // Sort and copy to a modifiable list
        List<Integer> sorted = new ArrayList<>(list);
        Collections.sort(sorted);

        int currentCost = sorted.get(0) + sorted.get(1);
        List<Integer> newList = new ArrayList<>(sorted.subList(2, sorted.size()));
        newList.add(currentCost);

        return minCostJoinRopes(newList, cost + currentCost);
    }

    public int minCostJoinRopesX(List<Integer> list){
        PriorityQueue<Integer> pq = new PriorityQueue<>(list);

        int totalCost = 0;
        while (pq.size()>1)
        {
            int cost =pq.poll()+ (!pq.isEmpty()?pq.poll():0);
            totalCost+=cost;
            pq.add(cost);
        }
        return totalCost;
    }
}
