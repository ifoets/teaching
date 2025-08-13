package interview.classical.design.ds;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueue<T> {

    Queue<T> queue1 = new LinkedList<>();
    Queue<T> queue2 = new LinkedList<>();

    public void push(T t)
    {
        queue1.offer(t);
    }

    public T pop()
    {
        if(queue1.isEmpty())
            throw  new RuntimeException("Stack is Empty");

        //move all element from queue1 and put to queue2 except last
        while (queue1.size()>1)
        {
            queue2.offer(queue1.poll());
        }
        T top = queue1.poll();

        //change to queue
        Queue<T> temp = queue1;
        queue1 = queue2;
        queue2=temp;
        return top;
    }

    public int size()
    {
        return queue1.size();
    }

    public T peek()
    {
        if(queue1.isEmpty())
           return null;

        //move all element from queue1 and put to queue2 except last
        while (queue1.size()>1)
        {
            queue2.offer(queue1.poll());
        }
        T top = queue1.peek();
        queue2.offer(queue1.poll());

        //change to queue
        Queue<T> temp = queue1;
        queue1 = queue2;
        queue2=temp;
        return top;
    }

    public void print()
    {
        queue1.forEach(System.out::println);
        queue2.forEach(System.out::println);
    }
}
