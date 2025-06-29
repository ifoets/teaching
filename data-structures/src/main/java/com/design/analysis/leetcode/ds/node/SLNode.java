package com.design.analysis.leetcode.ds.node;

import lombok.Data;

@Data
public class SLNode<K> {
    public K k;
    public SLNode<K> next;

    public SLNode(K k, SLNode<K> next) {
        this.k = k;
        this.next = next;
    }
}
