package interview.classical.design.ds;

import java.util.Stack;

public class ImpMinStack {

    Stack<Integer> mainStack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();

    public void push(Integer t)
    {
        mainStack.push(t);
        if(minStack.isEmpty())
            minStack.push(t);
        else
            minStack.push(Math.min(t, minStack.peek()));
    }

    public int pop()
    {
        if(!mainStack.isEmpty())
        {
            minStack.pop();
            return mainStack.pop();
        }
        throw new RuntimeException("Stack is empty");
    }
    public int top() {
        return mainStack.peek();
    }

    public int getMinStack()
    {
        return minStack.peek();
    }

    public void print()
    {
        mainStack.forEach(System.out::println);
    }
}
