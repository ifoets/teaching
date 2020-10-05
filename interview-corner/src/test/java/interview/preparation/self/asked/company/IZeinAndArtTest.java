package interview.preparation.self.asked.company;

import org.junit.Before;
import org.junit.Test;

import interview.preparation.self.asked.IZeinAndArt;
import interview.preparation.self.asked.ZeinAndArtImpl;

class B {
	int a = 10;
}

public class IZeinAndArtTest extends B {

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
