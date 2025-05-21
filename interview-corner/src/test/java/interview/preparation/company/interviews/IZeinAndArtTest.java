package interview.preparation.company.interviews;

import interview.preparation.company.interviews.impl.ZeinAndArtImpl;
import interview.preparation.company.interviews.question.IZeinAndArt;
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
