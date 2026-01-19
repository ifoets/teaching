package com.design.analysis.ds.node;

import lombok.Data;
import lombok.Getter;

import java.util.Objects;

@Data
public class ListNode {
      @Getter
      public  int val;
      public ListNode next;
      public ListNode() {}
      public ListNode(int val) { this.val = val; }
      public ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ListNode listNode = (ListNode) o;
        return val == listNode.val;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(val);
    }
}