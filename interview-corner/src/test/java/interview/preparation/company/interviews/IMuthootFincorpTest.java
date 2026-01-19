package interview.preparation.company.interviews;

import interview.preparation.company.interviews.impl.MuthootFincorpImpl;
import interview.preparation.company.interviews.model.TNode;
import interview.preparation.company.interviews.question.IMuthootFincorp;
import org.junit.Before;
import org.junit.Test;

public class IMuthootFincorpTest {

    IMuthootFincorp imf;

    @Before
    public void init()
    {
        imf = new MuthootFincorpImpl();
    }

    @Test
    public  void levelOrderTraverseTreeTest()
    {
        int []a ={7,3,11,1,5,9,13,0,2,4,6,8,10,12,14};
        interview.preparation.company.interviews.model.TNode tNode = null;
        for(int i:a)
            tNode = TNode.create(tNode, i);
        imf.levelOrderTraverseTree(tNode);

    }
}
