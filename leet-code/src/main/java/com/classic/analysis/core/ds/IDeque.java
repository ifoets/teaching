package com.classic.analysis.core.ds;

public class IDeque<K> {
     public final K[] arr;
     private int front;
     private int rear;
     private int size;
     private final int capacity;

    @SuppressWarnings("unchecked")
    public IDeque(int k) {
     this.capacity=k;
     this.front=0;
     this.rear=-1;
     this.size=0;
     arr = (K[])new Object[k];
    }
    public boolean insertFront(K val) {
            if(isFull()) return false;

            front = (front-1+capacity)%capacity;
            arr[front]=val;
            if(size==0)front=rear;
            size++;
            return true;
    }

    public boolean insertRear(K val) {
        if(isFull()) return false;

        rear=(rear+1)%capacity;
        arr[rear]=val;
        if(size==0)front=rear;
        size++;
        return true;
    }

    public boolean deleteFront() {
       if(isEmpty()) return false;
       front=(front+1)%capacity;
       size--;
       return true;
    }

    public boolean deleteRear() {
         if(isEmpty())return false;
         rear=(rear-1+capacity)%capacity;
         size--;
         return true;
    }

    public K getFront() {
      return isEmpty()?null:arr[front];
    }

    public K getRear() {
      return isEmpty()?null:arr[rear];
    }

    public boolean isEmpty() {
        return size==0;
    }

    public boolean isFull() {
       return size==capacity;
    }
}
