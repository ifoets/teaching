package interview.java;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

interface I1 {
	// only static method
	default public int add(int a, int b) {
		return a + b;
	}
	
	public void m1();
	public void m2();
}

interface I2 {
	default public int add(int a, int b) {
		return a - b;
	}
}

//uplicate default methods named add with the parameters (int, int) and (int, int) are inherited from the types I2 and I1
public class MultipleInheritence {// implements I1, I2

	public static void main(String[] args) {
       final List<Integer> list = new ArrayList<>();
       list.add(1);
       list.add(2);
       list.addAll(list);
    
       System.out.println(list);
		
		@SuppressWarnings("unused")
		MultipleInheritence mh = new MultipleInheritence();
		// mh.add(2,4); no call from mh
		//
		PriorityQueue<Integer> q = new PriorityQueue<>();
		q.add(6);
		q.add(1);
		q.add(5);
		while(!q.isEmpty())
			System.out.println(q.poll());
	}
}
