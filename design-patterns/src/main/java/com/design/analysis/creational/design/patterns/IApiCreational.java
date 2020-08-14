package com.design.analysis.creational.design.patterns;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import com.design.analysis.creational.design.patterns.factory.ComputerSuper;
import com.design.analysis.creational.design.patterns.prototype.Employees;
import com.design.analysis.creational.design.patterns.singaltion.BillPughSingleton;
import com.design.analysis.creational.design.patterns.singaltion.EagerInitializedSingleton;
import com.design.analysis.creational.design.patterns.singaltion.LazyInitializedSingleton;
import com.design.analysis.creational.design.patterns.singaltion.StaticBlockSingleton;
import com.design.analysis.creational.design.patterns.singaltion.ThreadSafeSingleton;

/*
 * 
 * @author GuruG
 * 
 * Creational Design Patterns
	1. Singleton Pattern
	2. Factory Pattern
	3. Abstract Factory Pattern
	4. Builder Pattern
	5. Prototype Pattern
 */
public interface IApiCreational {

	/** 1. Singleton Pattern **/
	/* 1. Eager initialization */
	public boolean eagerInitializedSingleton(EagerInitializedSingleton es1, EagerInitializedSingleton es2);

	/* 2. Static block initialization */
	public boolean staticBlockInitialiizatioin(StaticBlockSingleton st1, StaticBlockSingleton st2);

	/* 3. Lazy Initialization */
	public boolean lazyInitializedSingleton(LazyInitializedSingleton lis1, LazyInitializedSingleton lis2);

	/* 4. Thread Safe Singleton */
	public boolean threadSafeSingleton(ThreadSafeSingleton ts1, ThreadSafeSingleton ts2);

	/* 5. Bill Pugh Singleton Implementation */
	public boolean billPughSingleton(BillPughSingleton bps1, BillPughSingleton bps2);

	/* 6. Using Reflection to destroy Singleton Pattern */
	public boolean reflectionSingletonDestroy();

	/* 7. Enum Singleton */
	public boolean singletonEnum();

	/* 8. Serialization and Singleton */
	public boolean serializationSingelton() throws FileNotFoundException, IOException, ClassNotFoundException;

	/** 2. Factory Pattern **/

	/* Factory Design Pattern Super Class */
	public ComputerSuper factoryDesignPatternBySuperClass(String type, String ram, String hdd, String cpu);

	/** Abstract Factory Design Pattern in Java **/
	public ComputerSuper abstractFactoryDesignPattern(String type, String ram, String hdd, String cpu);

	/** Builder Pattern **/
	public void builderDesignPattern(String hdd, String ram);

	/** Prototype Design Pattern **/
	public List<Employees> prototypeDesignPattern(String name);
}
