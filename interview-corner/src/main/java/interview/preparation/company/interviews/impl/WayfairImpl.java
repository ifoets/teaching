package interview.preparation.company.interviews.impl;

import interview.preparation.company.interviews.question.IWayfair;

import java.util.*;

public class WayfairImpl implements IWayfair {

    /* find the indexes of the values of sum */
    @Override
    public List<Integer> getIndexesOfValueSum(int[] a, int sum){
         int N = a.length;
        List<Integer> rsList = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<N;i++)
        {
            if(map.containsKey(sum-a[i])) {
                rsList.add(map.get(sum - a[i]));
                rsList.add(i);
            }
            else map.put(a[i],i);
        }
        return  rsList;
    }
}
