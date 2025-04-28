package interview.preparation.company.interviews.impl;

import interview.preparation.company.interviews.model.X;
import interview.preparation.company.interviews.question.ICoforge;

public class CoforgeImpl implements ICoforge {

	@Override
	public void useFunctionalInferface() {
		X a = () -> System.out.println("xyz");
		a.test();
	}

}
