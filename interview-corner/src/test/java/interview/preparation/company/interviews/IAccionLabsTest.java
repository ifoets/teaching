package interview.preparation.company.interviews;

import interview.preparation.company.interviews.impl.AccionLabsImpl;
import interview.preparation.company.interviews.question.IAccionLabs;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class IAccionLabsTest {

    IAccionLabs ial;

    @Before
    public void init()
    {
        ial = new AccionLabsImpl();
    }
    @Test
    public void maxLenUniqueSubStrTest()
    {
        System.out.println(ial.maxLenUniqueSubStr("abcabcbbdef"));
        Assert.assertEquals("bdef",ial.maxLenUniqueSubStr("abcabcbbdef"));
    }
    @Test
    public void maxLenUniqueSubStrXTest()
    {
        System.out.println(ial.maxLenUniqueSubStrX("abcabcbbdef"));
        Assert.assertEquals("bdef",ial.maxLenUniqueSubStrX("abcabcbbdef"));
    }
}
