package interview.preparation.company.interviews.impl;

import interview.preparation.company.interviews.model.TNode;
import interview.preparation.company.interviews.question.IMuthootFincorp;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MuthootFincorpImpl implements IMuthootFincorp {

    @Override
    public void levelOrderTraverseTree(TNode root) {
        List<TNode> list = new ArrayList<>();
        list.add(root);
        Queue<List<TNode>> queue = new LinkedList<>();
        queue.add(list);
        while (!queue.isEmpty())
        {
            List<TNode> nodes = queue.poll();
            List<TNode> newNodes = new ArrayList<>();
            for(TNode tn: nodes) {
                System.out.print(tn.k+", ");
                if(tn.lt!=null)
                    newNodes.add(tn.lt);
                if(tn.rt!=null)
                    newNodes.add(tn.rt);
            }
            if(!newNodes.isEmpty())
                queue.add(newNodes);
        }
    }
}
