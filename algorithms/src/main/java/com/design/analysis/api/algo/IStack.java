package com.design.analysis.api.algo;

public interface IStack<E> {

    public E push(E e);

    public E pop();

    public E peek();

    public int search(Object obj);

    public void traverse();
}
