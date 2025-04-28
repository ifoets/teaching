package interview.preparation.self.asked.company.impl;

import java.util.List;

import interview.preparation.company.interviews.impl.EmpowerImpl;
import interview.preparation.company.interviews.question.IEmpower;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import interview.preparation.company.interviews.model.BoardingPass;

/*
 * find the initial and final destination by looking boarding pass of passenger
 * D->E (pass1)
 * A->B (pass 2)
 * B->D (pass 3)
 * E->C (pass 4) 
 * 
 * ANS A->C
 * 
 */
public class IEmpowerTest {

	private IEmpower iemp;

	@Before
	public void init() {
		iemp = new EmpowerImpl();
	}

	@Test
	public void findInitailAndFinalDesitination() {

		List<BoardingPass> passes = List.of(new BoardingPass("D", "E"), new BoardingPass("A", "B"),
				new BoardingPass("B", "D"), new BoardingPass("E", "C")

		);
		Assert.assertTrue(iemp.findInitailAndFinalDesitination(passes).equals("A->C"));
	}
	@Test
	public void getRoutsTest()
	{
		List<BoardingPass> passes = List.of(new BoardingPass("D", "E"), new BoardingPass("A", "B"),
				new BoardingPass("B", "D"), new BoardingPass("E", "C")
		);
		Assert.assertTrue(iemp.getRouts(passes).equals("A->B->D->E->C"));
	}
}
