package com.design.analysis.ds.linked.list.medium;

import com.design.analysis.ds.linked.list.Utils.ListUtils;
import com.design.analysis.ds.node.ListNode;

import java.util.ArrayList;
import java.util.List;

public class ListMediumImpl implements IListMedium{

    /**2. Add Two Numbers, The digits are stored in reverse order*/
    public ListNode addTwoNumbers(ListNode l1, ListNode l2){

        ListNode head = null;
        ListNode tail = null;
        int carry=0;
        while (l1!=null && l2!=null)
        {
            if(head==null)
                head = tail=new ListNode((l1.val+l2.val+carry)%10);
            else
            {
                tail.next=new ListNode((l1.val+l2.val+carry)%10);
                tail = tail.next;
            }

            carry = (l1.val+l2.val+carry)/10;
            l1=l1.next;
            l2=l2.next;
        }
        while (l1!=null && tail!=null)
        {
            tail.next=new ListNode((l1.val+carry)%10);
            tail = tail.next;
            carry = (l1.val+carry)/10;
            l1=l1.next;
        }
        while (l2!=null && tail!=null)
        {
            tail.next=new ListNode((l2.val+carry)%10);
            tail = tail.next;
            carry = (l2.val+carry)/10;
            l2=l2.next;
        }
        if(carry!=0)
            tail.next = new ListNode(carry);
        return head;
    }
    /**Add two numbers, list is as nos ex 342+465, 3->4->2 + 4->6->5 = 8->0->7**/
    @Override
    public ListNode addTwoNumbersAsItInList(ListNode l1, ListNode l2){
        return
            ListUtils.reverse(addTwoNumbers(ListUtils.reverse(l1),ListUtils.reverse(l2)));
    }

    /**19. Remove Nth Node From End of List**/
    @Override
    public ListNode removeNthFromEnd(ListNode head, int n){
         int L = ListUtils.len(head);
         int delBeforePoint=L-n-1;
         if(delBeforePoint==-1)
             return head.next;
         ListNode temp = head;
         while (delBeforePoint-->0)
         {
             temp=temp.next;
         }
         ListNode q = temp.next;
         temp.next = q.next;
         q.next = null;
         return head;
    }

    /**24. Swap Nodes in Pairs**/
    @Override
    public ListNode swapPairs(ListNode head){

        if(head==null || head.next==null)
            return head;
        ListNode p = head;
        ListNode q = head.next;
        while (p!=null && q!=null)
        {
            int temp = p.val;
            p.val = q.val;
            q.val=temp;
            p=q.next;
            if(p!=null)
                q=p.next;
        }
        return head;
    }
    /**reverse list in part wise, n=2 pairwise, n=k,in k nodes**/
    @Override
    public ListNode reverseInSlotN(ListNode head, int n){
        List<ListNode> headList = new ArrayList<>();
        ListNode p = head;
        ListNode q = head;
        int newNo = n;
        while (n-->1)
        {
            if(q!=null) {
                q = q.next;
                if(q==null)
                {
                    headList.add(p);
                    break;
                }
            }
            if(n==1) {
                ListNode r = q.next;
                q.next = null;
                headList.add(p);
                p = q = r;
                n = newNo;
            }
        }
       List<ListNode> reverseSlotList = headList.stream().map(ListUtils::reverse).toList();
       for(int i=0;i<reverseSlotList.size()-1;i++)
       {
           ListNode temp = reverseSlotList.get(i);
           while (temp.next!=null)
               temp=temp.next;
           temp.next=reverseSlotList.get(i+1);
       }
       head = reverseSlotList.getFirst();
       return head;
    }

    /**61. Rotate List k from right1,2,3,4,5-> 4,5,1,2,3**/
    @Override
    public ListNode rotateRight(ListNode head, int k){
        int L = ListUtils.len(head);
        if(head==null || head.next==null || k%L==0)
            return head;
        ListNode p = head;
        ListNode q = p;

        k=k%L;
        int shift=L-k-1;
        while (shift-->0)q=q.next;
        ListNode r = q.next;
        q.next=null;
        head=r;
        while (r.next!=null)r=r.next;
        r.next=p;
        return head;
    }
    /**. Rotate List k from Left, k=2, 1,2,3,4,5-> 3,4,5,1,2**/
    @Override
    public ListNode rotateLeft(ListNode head, int k){
        int L = ListUtils.len(head);
       return rotateRight(head,L-k%L);
    }

    /**82. Remove Duplicates from Sorted List II**/
    @Override
    public ListNode deleteDuplicates(ListNode head){
        if(head==null||head.next==null)
            return head;
        ListNode p = head;
        ListNode preP = null;
        boolean isDeleted=false;
        while (p!=null)
        {
            isDeleted =false;
            if(p.next!=null && p.val==p.next.val)
            {
                isDeleted = true;
                if(p==head)
                {
                    while (head.next!=null&&head.val==head.next.val)head=head.next;
                    head=head.next;
                    p=head;
                    continue;
                }
                else {
                    while (p.next!=null&&p.val==p.next.val)p=p.next;
                    preP.next=p.next;
                }
            }
            if(!isDeleted) {
                preP = p;
            }
            p=p.next;
        }
        return head;
    }
}
