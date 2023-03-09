package interview.preparation.self.asked.company;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import interview.preparation.self.asked.model.BoardingPass;

public class EmpowerImpl implements IEmpower {

	@Override
	public String findInitailAndFinalDesitination(List<BoardingPass> passes) {

		String initalDes = null;
		String finalDes = null;
		Map<String, String> map1 = new HashMap<>();
		Map<String, String> map2 = new HashMap<>();

		for (BoardingPass bps : passes) {
			map1.put(bps.getStart(), bps.getEnd());
			map2.put(bps.getEnd(), bps.getStart());
		}

		for (Map.Entry<String, String> set : map1.entrySet()) {
			if (map1.get(set.getValue()) == null) {
				finalDes = set.getValue();
				break;
			}
		}

		for (Map.Entry<String, String> set : map2.entrySet()) {
			if (map2.get(set.getValue()) == null) {
				initalDes = set.getValue();
				break;
			}
		}
		return initalDes + "->" + finalDes;
	}

}
