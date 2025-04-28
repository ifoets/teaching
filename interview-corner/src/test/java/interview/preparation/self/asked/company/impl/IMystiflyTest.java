package interview.preparation.self.asked.company.impl;

import java.util.List;

import interview.preparation.company.interviews.impl.MystiflyImpl;
import interview.preparation.company.interviews.question.IMystifly;
import org.junit.Before;
import org.junit.Test;

public class IMystiflyTest {

	IMystifly im = null;
	private static final String ZERO = "0";

	@Before
	public void init() {
		im = new MystiflyImpl();
	}

	/*
	 * Write a function to print following pattern for N(1<=50) = 5
	 * 
	 * 0 11 000 1111 00000
	 */

	@Test
	public void processingTest() {

			List<String> list = im.processing("5");
			for (String str : list)
				System.out.println(str);
	}
}
