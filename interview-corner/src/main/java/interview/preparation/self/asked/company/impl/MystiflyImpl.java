package interview.preparation.self.asked.company.impl;

import interview.preparation.self.asked.company.question.IMystifly;

import java.util.ArrayList;
import java.util.List;

public class MystiflyImpl implements IMystifly {
	private static final String ZERO = "0";
	private static final String ONE = "1";
	private static final String INALID_RANGE_MESSAGE = "Range Must be 1-50";
	private static final String INVALID_FOMATE_MESSAGE = "Input must be Integer";

	public List<String> processing(String obj) {
		List<String> vList = new ArrayList<>();
		Integer val = 0;
		try {
			val = Integer.parseInt(obj);
		} catch (NumberFormatException ex) {
			vList.add(INVALID_FOMATE_MESSAGE);
		}
		if (val < 0 || val > 50)
			vList.add(INALID_RANGE_MESSAGE);
		if (vList.size() > 0)
			return vList;
		return print(val);

	}

	public static List<String> print(Integer no) {

		List<String> list = new ArrayList<>();
		for (int i = 1; i <= no; i++) {
			StringBuilder sb = new StringBuilder();
			int inVal = i;
			if (i % 2 != 0) {
				while (inVal > 0) {
					sb.append(ZERO);
					inVal--;
				}
			} else {
				while (inVal > 0) {
					sb.append(ONE);
					inVal--;
				}
			}
			list.add(sb.toString());
		}
		return list;
	}
}
