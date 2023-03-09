package interview.preparation.self.asked.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
}
