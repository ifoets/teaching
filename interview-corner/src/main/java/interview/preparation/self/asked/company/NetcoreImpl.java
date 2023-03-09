package interview.preparation.self.asked.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NetcoreImpl implements INetcore {

	/* The total number of subarrays */
	public int subArrayCount(int a[]) {

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
		 // System.out.println();
		}

		return count;
	}

	/* Count sub-arrays which have elements less than or equal to X */
	public int subArrayLesEqualToX(int a[], int x) {
		return 1;
	}

	/* Number of subarrays having even product */
	public int countSubArrayEvenProd(int a[]) {
		return 1;
	}
}
