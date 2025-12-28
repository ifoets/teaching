package core.design.analysis.ds;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
/**1.	Design LRU Cache**/
//current access node keep at last,
//when size is full remove from first
public class LRUCache {
    static class Node{
        String key;
        int value;
        Node next, prev;

        public Node(String key, Integer value)
        {
            this.key = key;
            this.value= value;
        }

        @Override
        public String toString()
        {
            return this.key+","+this.value;
        }
    }
    int size;
    @Getter
    public Map<String,Node> map;
    public LRUCache(int size)
    {
        this.size = size;
        this.map = new HashMap<>();
    }

    Node head=null;
    Node tail=null;
    public Integer put(String key, Integer value)
    {
        if(map.containsKey(key))
        {
            map.get(key).value=value;
            putlast(key);
            return map.get(key).value;
        }
        Node newNode = new Node(key,value);
        map.put(key,newNode);
        if(head==tail&&tail==null)
        {
            head=tail=newNode;
        }else {
            tail.next=newNode;
            newNode.prev=tail;
            tail=tail.next;
        }
        if(map.size()>size)//remove from fist
        {
            Node remove = head;
            head = head.next;
            head.prev=null;
            remove.next=null;
            map.remove(remove.key);
        }
        return value;
    }

    public Integer get(String k)
    {     //current access node put to last
        if(!map.containsKey(k)) return null;
        putlast(k);
        return map.get(k).value;

    }
    public void putlast(String k)
    {
        if(Objects.equals(k, tail.key))
            return ;
        else {
            if(Objects.equals(k,head.key))
            {
                Node moveToLst = head;
                head=head.next;
                moveToLst.next=null;
                head.prev=null;
                tail.next=moveToLst;
                moveToLst.prev=tail;
                tail=tail.next;
            }
            else {
                Node moveToLast = map.get(k);
                Node p=moveToLast.prev;
                Node n=moveToLast.next;
                p.next=n;
                n.prev=p;
                //add moving node to last
                moveToLast.next=moveToLast.prev=null;
                tail.next=moveToLast;
                moveToLast.prev=tail;
                tail=tail.next;
            }
        }
    }
    public void printList()
    {
        Node temp = head;
        while (temp!=null)
        {
            System.out.print("("+temp.key+","+temp.value+"), ");
            temp=temp.next;
        }
        System.out.println();
    }

}
