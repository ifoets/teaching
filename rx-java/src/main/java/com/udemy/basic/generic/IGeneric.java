package com.udemy.basic.generic;

public interface IGeneric {

	/* Making you Familiar Very basic generic example */
	public void basicGenericExmpl();

	/* Generic Type Interface scenarios */
	public void genericTypeInterfacec();

	/** Subclassing Generic analysis **/

	/*
	 * A Generic interface can extends other generic interface using same type
	 * parameter ,
	 */
	public void subclassingExmpl();

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
	public void rowTypeExmpl();

	/** Multiple parameter */
	public void multipleParmeterExmpl();

	/* Sub typing parameter */
	public void subTypingPramExmpl();

	/*
	 * Generic method/constructor, suppose we do not have multiple area in a class
	 * to use the type parameter or if we dn not need to parametrise the hole class
	 **/
	public void genericMethodCoustructorExmpl();

	/* Bounded Type parameter at many ways */
	/* Unbounded class Type parameter */
	public void unboundedGenericExmpl();

	/* class level Bounded class Type parameter */
	public void boundedGenericExmpl();

	/* method level Bounded class Type parameter */
	public void boundedGenericMehotdLevel();

	/*
	 * Interface/class level, we can bound by multiple intterface but with only
	 * single class
	 */
	public void boundedGenericinfer();

	/**
	 * Wild Cards , and Upper Bound Wild Cards, ? called wild card, it is unknown
	 * it can be use a type of parameter , field or local variable or some time
	 * return type
	 **/
	/* very basic example */
	public void basicWildCardExample();

	/* unbounded Wild card suitable example */
	public void unbouddedWildCardExmpl();

	/*
	 * Upper Bounded wild card example <? extends Y> means type parameter either Y
	 * or sub type of Y
	 */
	public void upperBoundedwildCardExmpl();

	/*
	 * Lower Bounded wild card example <? super X> type parameter is either X or
	 * super type of X
	 */
	public void lowerBoundedWildCardExmpl();

	/**
	 * Restriction of wild card example
	 * 
	 * @see WildCardRestriction.java
	 * 
	 *      1. ? can?'t use Type parameter on class level, class Rest<?>{} not valid
	 */

	/**  Behaviours in Generic and Non Generic Area **/
	public void genNonGenAreaWriteExmpl();

	/**
	 * @See TypeErase.java
	 * 
	 *      Type Erasure, java compiler manage Type eraser automatically when
	 *      unbounded get executed the passed Type get installed
	 **/

}
