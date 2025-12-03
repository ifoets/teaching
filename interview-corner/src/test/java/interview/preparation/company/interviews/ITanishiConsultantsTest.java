package interview.preparation.company.interviews;

import interview.preparation.company.interviews.impl.TanishiConsultantsImpl;
import interview.preparation.company.interviews.question.ITanishiConsultants;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;

public class ITanishiConsultantsTest {

    ITanishiConsultants itc;

    @Before
    public void init()
    {
        itc = new TanishiConsultantsImpl();
    }

    @Test
    public void duplicateCharTest()
    {
        Map<Character,Long> map1 = Map.of('a',3L,'u',2L,'m',2L);
        Map<Character,Long> map = itc.duplicateChar("abhimanyukumar");
        System.out.println(map.toString());
        Assert.assertEquals(map1, map);
    }
}
