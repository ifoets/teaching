package interview.preparation.self.asked.company.impl;

import interview.preparation.self.asked.company.model.X;
import interview.preparation.self.asked.company.question.ICoforge;
public class CoforgeImpl implements ICoforge {

	@Override
	public void useFunctionalInferface() {
		X a = () -> System.out.println("xyz");
		a.test();
	}

}
