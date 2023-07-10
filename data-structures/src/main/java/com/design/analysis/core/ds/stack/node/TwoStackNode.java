package com.design.analysis.core.ds.stack.node;

public class TwoStackNode {

    public int stack[];

    public  int size;
    public int top1;
    public int top2;
    public TwoStackNode(int n)
    {
        this.stack = new int[n];
        this.size = n;
        this.top1 = size/2+1;
        this.top2 = size/2;
    }
    public void push1(int x)
    {
        if(top1>0) {
            top1--;
            stack[top1] = x;
        }
        else throw new RuntimeException("Stack1 is over flow by element "+x);
    }
    public void push2(int x)
    {
        if(top2<size-1) {
            top2++;
            stack[top2] = x;
        }
        else throw new RuntimeException("Stack2 is over flow by element "+x);
    }

    public int pop1()
    {
      if(top1<=size/2)
          return stack[top1++];
      else throw new RuntimeException("Stack1 is Under flow");
    }

    public int pop2()
    {
        if(top2>=size/2+1) {
            int y = stack[top2];
            top2--;
            return y;
        }
        else throw  new RuntimeException("Stack2 is Under flow");
    }

}
