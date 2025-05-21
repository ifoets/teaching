package com.udemy.basic.generic;

import org.junit.Before;
import org.junit.Test;

public class IGenericTest {

	IGeneric ig = null;

	@Before
	public void init() {
		ig = new GenericImpl();
	}

	/* Making you Familiar Very basic generic example */
	@Test
	public void basicGenericExmplTest() {
		ig.basicGenericExmpl();
	}

	/* Generic Type Interface scenarios */
	@Test
	public void genericTypeInterfacec() {
		ig.genericTypeInterfacec();
	}

	/** Subclassing Generic analysis **/

	/*
	 * A Generic interface can extends other generic interface using same type
	 * parameter
	 */
	@Test
	public void subclassingExmplTest() {
		ig.subclassingExmpl();
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
	@Test
	public void rowTypeExmplTest() {
		ig.rowTypeExmpl();
	}

	/** Multiple parameter */
	@Test
	public void multipleParmeterExmplTest() {
		ig.multipleParmeterExmpl();
	}

	/* Sub typing parameter */
	@Test
	public void subTypingPramExmplTest() {
		ig.subTypingPramExmpl();
	}

	/*
	 * Generic method/constructor, suppose we do not have multiple area in a class
	 * to use the type parameter or if we dn not need to parametrise the hole class
	 **/
	@Test
	public void genericMethodCoustructorExmplTest() {
		ig.genericMethodCoustructorExmpl();
	}

	/* Bounded Type parameter at many ways */
	/* Unbounded class Type parameter */
	@Test
	public void unboundedGenericExmplTest() {
		ig.unboundedGenericExmpl();
	}

	/* class level Bounded class Type parameter */
	@Test
	public void boundedGenericExmplTest() {
		ig.boundedGenericExmpl();
	}

	/* method level Bounded class Type parameter */
	@Test
	public void boundedGenericMehotdLevelTest() {
		ig.boundedGenericMehotdLevel();
	}

	/*
	 * Interface/class level, we can bound by multiple intterface but with only
	 * single class
	 */
	@Test
	public void boundedGenericinferTest() {
		ig.boundedGenericinfer();
	}

	/* very basic example */
	@Test
	public void basicWildCardExampleTest() {
		ig.basicWildCardExample();
	}

	/* data structure Wild card suitable example */
	@Test
	public void unbouddedWildCardExmpl() {
		ig.unbouddedWildCardExmpl();
	}

	/* Bounded wild card example */
	@Test
	public void upperBoundedwildCardExmplTest() {
		ig.upperBoundedwildCardExmpl();
	}	

	/* Lower Bounded wild card example */
	@Test
	public void lowerBoundedWildCardExmpl() {
		ig.lowerBoundedWildCardExmpl();
	}

	/**  Behaviours in Generic and Non Generic Area **/
	@Test
	public void genNonGenAreaWriteExmplTest() {
		ig.genNonGenAreaWriteExmpl();
	}
}
