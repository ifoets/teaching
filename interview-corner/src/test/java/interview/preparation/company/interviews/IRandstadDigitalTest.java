package interview.preparation.company.interviews;

import interview.preparation.company.interviews.impl.RandstadDigitalImpl;
import interview.preparation.company.interviews.question.IRandstadDigital;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class IRandstadDigitalTest {

    private IRandstadDigital ird;

    @Before
    public void init()
    {
        ird = new RandstadDigitalImpl();
    }

    @Test
    public void findUubStrTest()
    {
        String str ="This ERROR is bug, ERROR get here, ERROR on ERROR";
        Assert.assertEquals(4,ird.findUubStr(str,"ERROR").intValue());
    }

    @Test
    public void secondRepeatedCharTest()
    {
        String input = "java is bestt";
        Assert.assertEquals('s',ird.secondRepeatedChar(input).charValue());
    }
}
