package interview.preparation.self.asked.company.impl;

import interview.preparation.self.asked.company.question.IZeinAndArt;
import org.junit.Before;
import org.junit.Test;

public class IZeinAndArtTest {

	private IZeinAndArt iza = null;

	@Before
	public void init() {
		iza = new ZeinAndArtImpl();
	}

	@Test
	public void oveloadMethodTest() {
		iza.oveloadMethod();
	}
}
