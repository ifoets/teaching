package interview.preparation.self.asked.company.impl;

import interview.preparation.self.asked.company.question.IJoulestoWatts;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class IJoulestoWattsTest {
//
    IJoulestoWatts ijw;

    @Before
    public void init()
    {
        ijw = new JoulestoWattsImpl();
    }
    //"a?bb", "a?b?aa", "aa??aa", ???a??b??? -> "aabb", "aabbaa",  "aabbaa", //???a??b???
    @Test
    public void transformTest()
    {
        List<String> list = List.of("a?bb","a?b?aa","???a??b???","??????????");
        List<String> listR = List.of("aabb","ababaa","abaabababa","abaabaabab");
        for(int i=0; i<list.size();i++)
        {
            Assert.assertEquals(ijw.transform(list.get(i)), listR.get(i));
        }
    }
    @Test
    public void transformStrTest()
    {
        Assert.assertEquals("aabb", ijw.transformStr("a?bb".toCharArray(), 4, 1));
        Assert.assertEquals("ababaa", ijw.transformStr("a?b?aa".toCharArray(), 6, 2));
        Assert.assertEquals("abaabababa", ijw.transformStr("???a??b???".toCharArray(), 10, 8));
        Assert.assertEquals("abaabaabab", ijw.transformStr("??????????".toCharArray(), 10, 10));
    }

    /*technique build string of length str.length() ababab...series then replace indexed a or b
   and finally check 3 consecutive a or b
    */
    @Test
    public void convertTest()
    {
        Assert.assertEquals("aabb", ijw.convert("a?bb"));
        Assert.assertEquals("aabbaa", ijw.convert("a?b?aa"));
        Assert.assertEquals("aabababbaa", ijw.convert("???a??b???"));
        Assert.assertEquals("aabbaabbaa", ijw.convert("??????????"));
    }
}
