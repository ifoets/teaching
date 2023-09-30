package interview.preparation.self.asked.company.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import interview.preparation.self.asked.company.question.IEmpower;
import interview.preparation.self.asked.company.model.BoardingPass;

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

	public String getRouts(List<BoardingPass> passes)
	{
		String []initFinal = findInitailAndFinalDesitination(passes).split("->");
		StringBuilder builder = new StringBuilder();
		Map<String, String> map = new HashMap<>();
		for (BoardingPass bps : passes) {
			map.put(bps.getStart(), bps.getEnd());
		}
		while (map.get(initFinal[0])!=null)
		{
			builder.append(initFinal[0]+"->");
			initFinal[0]= map.get(initFinal[0]);
		}
		builder.append(initFinal[0]);
		return builder.toString();
	}

}
