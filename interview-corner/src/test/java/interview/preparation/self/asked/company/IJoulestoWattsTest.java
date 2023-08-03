package interview.preparation.self.asked.company;

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
            Assert.assertTrue(ijw.transform(list.get(i)).equals(listR.get(i)));
        }
    }
    @Test
    public void transformStrTest()
    {
        Assert.assertTrue(ijw.transformStr("a?bb".toCharArray(),4,1).equals("aabb"));
        Assert.assertTrue(ijw.transformStr("a?b?aa".toCharArray(),6,2).equals("ababaa"));
        Assert.assertTrue(ijw.transformStr("???a??b???".toCharArray(),10,8).equals("abaabababa"));
        Assert.assertTrue(ijw.transformStr("??????????".toCharArray(),10,10).equals("abaabaabab"));
    }
}
