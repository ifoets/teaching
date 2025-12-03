package com.design.analysis.ds.node;

import lombok.Data;
import lombok.Getter;

@Data
public class ListNode {
      @Getter
      public  int val;
      public ListNode next;
      public ListNode() {}
      public ListNode(int val) { this.val = val; }
      public ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}