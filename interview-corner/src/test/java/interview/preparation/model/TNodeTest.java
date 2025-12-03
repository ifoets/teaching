package interview.preparation.model;

import interview.preparation.company.interviews.model.TNode;
import org.junit.Test;

public class TNodeTest {

    @Test
    public void displayTest()
    {
         int []a ={7,3,11,1,5,9,13,0,2,4,8,10,12,14};
         TNode  tNode = null;
            for(int i:a)
                tNode = TNode.create(tNode, i);

            TNode.display(tNode);
    }
}
