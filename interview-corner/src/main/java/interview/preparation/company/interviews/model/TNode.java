package interview.preparation.company.interviews.model;

public class TNode {

    public int k;
    public TNode lt, rt;
    public int ltRtPos;

    public TNode(int k)
    {
        this.k=k;
        this.lt= this.rt =null;
        this.ltRtPos=0;
    }

    public static TNode create(TNode node, int k)
    {
        if(node==null)
            return new TNode(k);
        else if(k<node.k)
        {
            node.lt = create(node.lt,k);
            node.lt.ltRtPos= node.ltRtPos-1;
        }
        else {
            node.rt = create(node.rt,k);
            node.rt.ltRtPos= node.ltRtPos+1;
        }
        return node;
    }

    public static void display(TNode node)
    {
        if(node!=null)
        {
            display(node.lt);
            System.out.print("("+node.k+","+node.ltRtPos+")");
            display(node.rt);
        }
    }
}
