package interview.classical.design.ds;

import java.util.Stack;

public class ImpMaxStack {

    Stack<String> mainStack = new Stack<>();
    Stack<String> maxStack = new Stack<>();

    public void push(String item)
    {
        mainStack.push(item);
        if(maxStack.isEmpty())
            maxStack.push(item);
        else maxStack.push(item.length()<maxStack.peek().length()?maxStack.peek():item);
    }

    public String pop()
    {
        if(!mainStack.isEmpty())
        {
            maxStack.pop();
            return mainStack.pop();
        }
        throw new RuntimeException("Stack is Empty");
    }

    public void top()
    {
        mainStack.peek();
    }

    public String getMaxLenItem()
    {
        return maxStack.peek();
    }

    public void print()
    {
        mainStack.forEach(System.out::println);
    }
}
