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
	public void overloadMethodTest() {
		iza.overloadMethod();
	}

    @Test
    public void overloadMethodXTest() {
        iza.overloadMethodX();
    }

    @Test
    public void overloadMethodYTest() {
        iza.overloadMethodY();
    }

    @Test
    public void overloadMethodZTest() {
        iza.overloadMethodZ();
    }
}
