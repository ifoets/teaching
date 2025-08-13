package interview.classical.design.ds;

import java.util.Stack;

public class QueueUsingStack<T> {

    Stack<T> stack1 = new Stack<>();
    Stack<T> stack2 = new Stack<>();

    public void push(T t)
    {
        stack1.push(t);
    }

    public T pop()
    {
        if(stack1.isEmpty())
            throw new RuntimeException("Queue is Empty");
        while (!stack1.isEmpty())
            stack2.push(stack1.pop());
        //swap stack
       T pop = stack2.pop();

        while (!stack2.isEmpty())
            stack1.push(stack2.pop());
        return pop;
    }

    public T peek()
    {
        if(stack1.isEmpty())
            return null;
        while (!stack1.isEmpty())
            stack2.push(stack1.pop());
        T peekEle = stack2.peek();
        //swap stack
        while (!stack2.isEmpty())
            stack1.push(stack2.pop());

        return peekEle;
    }

    public void print()
    {
      stack1.forEach(System.out::println);

    }
}
