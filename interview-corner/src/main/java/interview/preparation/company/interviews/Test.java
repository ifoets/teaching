package interview.preparation.company.interviews;


import java.util.*;
import java.util.stream.Collectors;

class TNode{
    int k;
    TNode lt, rt;
    int ltRtPos;

    public TNode(int k)
    {
        this.k=k;
        this.lt= this.rt =null;
        this.ltRtPos=0;
    }
}
public class Test {
    static Map<Integer,List<TNode>> map = new HashMap<>();
    public static void main(String[] args) {

        System.out.println("...Hi");
        TNode t = new TNode(3);
        verticalTravel(t);
    }


    public static void verticalTravel(TNode node)
    {
        if(node!=null)
        {
            if(node.lt!=null) {
                verticalTravel(node.lt);
            }
            List<TNode> list = map.getOrDefault(node.k, new ArrayList<>());
            list.add(node);
            map.put(node.k,list);

            if(node.rt!=null)
            {
                verticalTravel(node.rt);
            }
        }
    }

}
