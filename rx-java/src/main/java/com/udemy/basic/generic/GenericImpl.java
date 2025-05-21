package com.udemy.basic.generic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.udemy.basic.generic.creation.BaseData;
import com.udemy.basic.generic.creation.BasicWildCard;
import com.udemy.basic.generic.creation.Behaviour;
import com.udemy.basic.generic.creation.Bin;
import com.udemy.basic.generic.creation.BoundedSorter;
import com.udemy.basic.generic.creation.Box;
import com.udemy.basic.generic.creation.Cbound;
import com.udemy.basic.generic.creation.Data;
import com.udemy.basic.generic.creation.GenericMethod;
import com.udemy.basic.generic.creation.IData;
import com.udemy.basic.generic.creation.LNodeUnbounded;
import com.udemy.basic.generic.creation.SquareBox;
import com.udemy.basic.generic.creation.SubclassingData;
import com.udemy.basic.generic.creation.UnboundedSorter;

import io.reactivex.rxjava3.core.Observable;

public class GenericImpl implements IGeneric {

	/* Making you Familiar Very basic generic example */
	public void basicGenericExmpl() {

		Observable.just(new Data<>("This is Generic String"))
		        .subscribe(e -> System.out.println(e));

		Observable.just(new Data<Integer>(Integer.valueOf(10)))
		        .subscribe(e -> System.out.println(e));

	}

	/* Generic Type Interface scenarios */
	@Override
	public void genericTypeInterfacec() {
		Observable<IData<String>> data = Observable.just(new Data<String>("Implemented Generic Interface"));
		data.subscribe(e -> System.out.println(e));
	}

	/** Subclassing Generic analysis **/

	/*
	 * A Generic interface can extends other generic interface using same type
	 * parameter
	 */
	@Override
	public void subclassingExmpl() {

		Observable<BaseData<String>> data = Observable.just(new SubclassingData<String>("Subclassing"));
		// we can assign to base class when both have parametrise type only
		// BaseData<Integer> bi=d; not useful compile type error
		data.subscribe(e -> System.out.println(e));
	}

	/***
	 * A generic interface can implemented by a non generic class only if only
	 * define the particular class/interface as a type parameter *
	 * 
	 * @See SClass.java full details with example in comment section
	 */

	/*
	 * /* generic class can extends or implements a non generic type non generic
	 * class
	 * 
	 * @See SClass.java full details with example in comment section
	 */

	/** Collections with Generic */

	/* it gives the type safety */

	/** Raw type **/
	@Override
	public void rowTypeExmpl() {

		Observable.just(new Box<>(List.of(1, 2, 3, 4, 5)))
		        .subscribe(e -> System.out.println(e));

		// warning and during extracting need to type casting
		// Box roBox = new Box<>(List.of(1, 2, "BasicStrong"));
	}

	/** Multiple parameter */
	@Override
	public void multipleParmeterExmpl() {
		Observable.just(new Bin<String, Integer>("Kumar", 007))
		        .subscribe(e -> System.out.println(e.toString()));

	}

	/* Sub typing parameter */
	@Override
	public void subTypingPramExmpl() {
		@SuppressWarnings("unused")
		Object o = new Object();
		Integer i = Integer.valueOf(10);

		o = i;// since Integer is sub type of Object

		List<Number> nlist = new ArrayList<>();
		nlist.add(Integer.valueOf(10));
		nlist.add(Double.valueOf(10.8));

		List<Box<Integer>> lbox = new ArrayList<>();
		lbox.add(new Box<>(List.of(1, 2, 3)));
		lbox.add(new SquareBox<>(List.of(5, 6, 7)));

		for (Box<Integer> box : lbox) {
			System.out.println(Arrays.asList(box.getA()));
		}

		// not comfortable this is different stuff assign of one type reference to
		// another type reference who have no child parent relation
		// List<Number> ln = new ArrayList<Integer>();
	}

	/*
	 * Generic method/constructor, suppose we do not have multiple area in a class
	 * to use the type parameter or if we dn not need to parametrise the hole class
	 **/
	@Override
	public void genericMethodCoustructorExmpl() {
		System.out.println(GenericMethod.concat("Basic Strong"));
		System.out.println(GenericMethod.concat(Integer.valueOf(10)));
	}

	/* Bounded Type parameter at many ways */
	/* Unbounded class Type parameter */
	public void unboundedGenericExmpl() {

		List<Integer> list = Arrays.asList(1, 9, 4, 7);
		List<String> slist = Arrays.asList("hello", "there", "BasicStrong");
		UnboundedSorter<Integer> sorter1 = new UnboundedSorter<>(list);
		UnboundedSorter<String> sorter2 = new UnboundedSorter<>(slist);

		// ie any thing can be sort since class is unbounded
		sorter1.getSorted(list);
		sorter2.getSorted(slist);
	}

	/* class level Bounded class Type parameter */
	@Override
	public void boundedGenericExmpl() {
		List<Integer> list = Arrays.asList(1, 9, 4, 7);
		@SuppressWarnings("unused")
		List<String> slist = Arrays.asList("hello", "there", "BasicStrong");
		BoundedSorter<Integer> sorter1 = new BoundedSorter<>(list);

		// this is not useful since String not extends Number
		// BoundedSorter<String> sorter2 = new BoundedSorter<>(slist);

		sorter1.getSorted(list);
	}

	/* method level Bounded class Type parameter */
	@Override
	public void boundedGenericMehotdLevel() {
		List<Integer> list = Arrays.asList(1, 9, 4, 7);
		BoundedSorter.getSortedMethod(list);

	}

	/*
	 * Interface/class level, we can bound by multiple interface but with only
	 * single class
	 */
	@Override
	public void boundedGenericinfer() {
		List<Integer> list1 = Arrays.asList(1, 9, 4, 7);
		List<Integer> list2 = Arrays.asList(10, 90, 40, 70);

		Cbound<Integer> sorter1 = new Cbound<>(list1);
		Cbound<Integer> sorter2 = new Cbound<>(list2);

		List<Cbound<Integer>> clist = List.of(sorter1, sorter2);
		BoundedSorter.getSortedInter(clist);
	}

	/* very basic example */
	@Override
	public void basicWildCardExample() {
		// no compile time issue but it is meaningless
		@SuppressWarnings("unused")
		List<?> list1 = new ArrayList<>();
		// compile time issue , always tell to compiler for Type parameter
		// List<T> list1 = new ArrayList<>();

		List<Integer> list = new ArrayList<>();
		list.add(10);
		list.add(20);
		BasicWildCard.displayWildCard(list);
	}

	/* data structure Wild card suitable example */
	@Override
	public void unbouddedWildCardExmpl() {
		LNodeUnbounded<Integer> node2 = new LNodeUnbounded<>(10, null);
		LNodeUnbounded<Integer> node1 = new LNodeUnbounded<>(20, node2);
		// LNode(Integer, LNode<Integer>) Type
		System.out.println(node1.toString());

		// whatever type you can use here
		LNodeUnbounded<String> snode2 = new LNodeUnbounded<>("Strong", null);
		LNodeUnbounded<String> snode1 = new LNodeUnbounded<>("Basic", snode2);
		// LNode(Integer, LNode<Integer>) Type
		System.out.println(snode1.toString());

		// but we can't use this compile issue, since next pinter is fixed a Type
		// parameter private LNode<E> next; this can be solved by LNode<?> next
		// LNode<String> snode1 = new LNode<>("Basic", node2);
		// snode1.setNext(node1);
		// Map<Integer, String> is not sub type of Map<Number,String>

		LNodeUnbounded<String> snode11 = new LNodeUnbounded<>("Basic", node2);
		snode11.setNext(node1);
		System.out.println(snode11.toString());
	}

	/* Bounded wild card example */
	@Override
	public void upperBoundedwildCardExmpl() {
		LNodeUnbounded<Integer> node2 = new LNodeUnbounded<>(10, null);
		LNodeUnbounded<Double> node1 = new LNodeUnbounded<>(Double.valueOf(20.5), node2);

		System.out.println(node1.toString());
	}

	/* Lower Bounded wild card example */
	public void lowerBoundedWildCardExmpl() {
		LNodeUnbounded<Integer> node2 = new LNodeUnbounded<>(10, null);
		// Number of super type of Integer so it is comfortable
		LNodeUnbounded<Number> node1 = new LNodeUnbounded<>(Double.valueOf(20.5), node2);

		System.out.println(node1.toString());
	}

	/** Behaviours in Generic and Non Generic Area **/
	@Override
	public void genNonGenAreaWriteExmpl() {
		Behaviour.displayGen();
		Behaviour.displayGenReverse();
	}

}
