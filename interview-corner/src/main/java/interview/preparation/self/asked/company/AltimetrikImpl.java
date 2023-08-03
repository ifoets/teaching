package interview.preparation.self.asked.company;

import java.util.*;
import java.util.stream.Collectors;

public class AltimetrikImpl implements IAltimetrik {

	//Not resolved
	@Override
	public int minimumCandiesPerHour(List<Integer> candyPiles, int numHours) {

		// List<Integer> list = List.of(8,3,2,1,4,5,2,3,4);//(4, 9, 11, 17);//
		// (8,3,2,1,4,5,2,3,4);
		// System.out.println(minimumCandiesPerHour(list, 12));
		// System.out.println(Math.ceilMod(11, 4));

		List<Integer> list = new ArrayList<>(candyPiles);
		Collections.sort(list);
		int n = candyPiles.size();
		double val = 0;
		int rs;
		for (int i = 0; i < n; i++) {
			rs = 0;
			val = numHours;
			for (int j = 0; j < n; j++) {
				int x = list.get(j);
				int y = list.get(i);
				while (x > 0) {
					val--;
					rs++;
					x -= y;
				}
				if (val < 0)
					break;
			}
			if (val >= 0) {
				return rs;
			}
		}
		return -1;
	}
	@Override
	public boolean checkDuplicateCountVal(int a[])
	{
		int N=a.length;
	    Map<Integer, Integer> map = new HashMap<>();
		for(int i=0 ;i<N ;i++)
		{
			if(map.containsKey(a[i]))
				map.put(a[i],map.get(a[i])+1);
			else map.put(a[i],1);
		}
		Set<Integer> set = new HashSet<>();
		for(Map.Entry entry:map.entrySet())
			set.add((Integer) entry.getValue());
		return set.size()==map.size();
	}

	@Override
	public int get2ndMaxNo(List<List<Integer>> ll){
		List<Integer> l = ll.stream().flatMap( e-> e.stream()).collect(Collectors.toSet()).stream().sorted().collect(Collectors.toList());
		return l.get(l.size()-2);
	}
}
