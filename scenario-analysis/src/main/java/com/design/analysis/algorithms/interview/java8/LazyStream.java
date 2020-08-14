package com.design.analysis.algorithms.interview.java8;

import java.util.Arrays;
import java.util.List;

public class LazyStream {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

		//no output due to lazyness
		list.stream().filter(i->{
			System.out.println(i);
			return true;
		});
		
		//findFirst() wakeup stream from lazyness
		list.stream().filter(i->{
			System.out.println(i);
			return true;
		}).findFirst();
		
		System.out.println(list.stream().map(i->i*2).reduce(0,(a,e)->a+e));
		System.out.println(list.stream().map(i->i*2).reduce(0,(a,e)->Integer.sum(a,e)));
		System.out.println(list.stream().map(i->i*2).reduce(0,Integer::sum));
		System.out.println(list.stream().filter(i->i%2==0).reduce(0,Integer::sum));
		System.out.println(list.stream().filter(i->i%2==0).map(i->i*2).reduce(0,Integer::sum));
		
		System.out.println(list.stream().map(i->i*3).filter(i->i%2==0).findFirst());
		System.out.println(list.stream().map(i->i*3).filter(i->i%99==0).findFirst().orElse(0));
	}
}
