package interview.preparation.self.asked.company.impl;

import interview.preparation.self.asked.company.question.INetcore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class
NetcoreImpl implements INetcore {

	/* The total number of subarrays */
	public int subArrayCount(int []a) {

		Map<Integer, List<List<Integer>>> map = new HashMap<>();
		int N = a.length;
		for (int i = 0; i < N; i++) {
			map.put(i + 1, new ArrayList<>());
			for (int j = i; j < N; j++) {
				int t = 0;
				List<Integer> l = new ArrayList<>();
				for (int k = i; k <= j; k++) {
					l.add(a[k]);
				}
				if (map.containsKey(i + 1)) {
					List<List<Integer>> ll = map.get(i + 1);
					ll.add(l);
					map.put(i + 1, ll);

				} else {
					List<List<Integer>> ll = new ArrayList<>();
					ll.add(l);
					map.put(i + 1, ll);
				}
			}
		}
		System.out.println("\n");
		int count = 0;
		for (Map.Entry<Integer, List<List<Integer>>> entry : map.entrySet()) {
			count += entry.getValue().size();
		  System.out.println(entry.getValue());
		}

		return count;
	}
	// pattern 1+2+3+..n pattern getting no of sab array
	public int subArrayCountX(int []a){
		return a.length*(a.length+1)/2;
	}

	/* Count sub-arrays which have elements less than or equal to X */
	public int subArrayLesEqualToX(int a[], int x) {
		Map<Integer, Integer> map = new HashMap<>();
		int N = a.length;
		int sum=0;
		for(int i=1;i<=N;map.put(i,N-i+1),i++);
		for(Map.Entry keySet:map.entrySet()) {
			if ((int)keySet.getKey() <= x)
				sum += (int)keySet.getValue();
		}
		return sum;
	}
	// pattern 1!*1/subarrays+2!*2/subarrays+3!*3/subarrays+..n length pattern getting no of noncontinuous sab array multiply factorial/arrangement
    //ie n!*n(n+1)/2
	public int subArrayCountNonContinuous(int a[]){
		int N= a.length;
		int factVal = 1;
		for(int i=1;i<=N;factVal*=i,i++);
		return factVal*subArrayCountX(a);
	}
	/* Number of subarrays having even product */
	public int countSubArrayEvenProd(int a[]) {
		return 1;
	}
}
