package interview.preparation.self.asked.company.impl;

import interview.preparation.self.asked.company.question.ISynechron;
import interview.preparation.self.asked.company.model.Node;

import java.util.Objects;

public class SynechronImpl implements ISynechron {
    @Override
    public Node createList(Node node, int a[]){
        boolean flag = node == null;
        if(Objects.isNull(node) && !Objects.isNull(a) && a.length>0)
            node = new Node(a[0]);
        Node q = node;
        while (q.next!=null)
            q=q.next;
        for(int i=flag ? 1:0;i<a.length;i++) {
            q.next = new Node(a[i]);
            q=q.next;
        }
        return  node;
    }
    public void display(Node node){
        Node q = node;
        while (q!=null)
        {
            System.out.print(q.val +"->");
            q = q.next;
        }
    }
    @Override
    public Node createCycle(Node node){

        int i=3;
        Node q,t=null ;
        q=node;
        while (q.next!=null)
        {
            i--;
            q=q.next;
            if(i==0)
                t = q;
        }
        q.next=t;
        return  node;
    }
    @Override
    public void detectRemoveCycle(Node node){

        Node q = node;
        while (q.next !=null)
        {
            if(q!=null && q.next !=null && q.next.flage==true)
            {
                q.next = null;
                break;
            }
            q = q.next;
            q.flage = true;
        }
        display(node);
    }

    @Override
    public Node nthNodeFromLast(Node node, int n){

        int len =0;
        Node q = node;
        while (q != null)
        {
            q= q.next;
            len++;
        }
        q = node;
        while (len-->0)
            q = q.next;
        return  q;
    }
}
