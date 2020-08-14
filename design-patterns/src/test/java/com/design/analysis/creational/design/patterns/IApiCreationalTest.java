package com.design.analysis.creational.design.patterns;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.design.analysis.creational.design.patterns.factory.ComputerSuper;
import com.design.analysis.creational.design.patterns.factory.model.PC;
import com.design.analysis.creational.design.patterns.factory.model.Server;
import com.design.analysis.creational.design.patterns.prototype.Employees;
import com.design.analysis.creational.design.patterns.singaltion.BillPughSingleton;
import com.design.analysis.creational.design.patterns.singaltion.EagerInitializedSingleton;
import com.design.analysis.creational.design.patterns.singaltion.LazyInitializedSingleton;
import com.design.analysis.creational.design.patterns.singaltion.StaticBlockSingleton;
import com.design.analysis.creational.design.patterns.singaltion.ThreadSafeSingleton;

public class IApiCreationalTest {

	IApiCreational iac = null;

	@Before
	public void init() {
		iac = new ApiCreationalImpl();
	}

	/** 1. Singleton Pattern **/
	/* 1. Eager initialization */
	@Test
	public void eagerInitializedSingletonTest() {
		EagerInitializedSingleton eg1 = EagerInitializedSingleton.getInstance();
		EagerInitializedSingleton eg2 = EagerInitializedSingleton.getInstance();
		Assert.assertTrue(iac.eagerInitializedSingleton(eg1, eg2));
	}

	/* 2. Static block initialization */
	@Test
	public void staticBlockInitialiizatioinTest() {
		StaticBlockSingleton sbi1 = StaticBlockSingleton.getInstance();
		StaticBlockSingleton sbi2 = StaticBlockSingleton.getInstance();
		Assert.assertTrue(iac.staticBlockInitialiizatioin(sbi1, sbi2));
	}

	/* 3. Lazy Initialization */
	@Test
	public void lazyInitializedSingletonTest() {
		LazyInitializedSingleton lis1 = LazyInitializedSingleton.getInstance();
		LazyInitializedSingleton lis2 = LazyInitializedSingleton.getInstance();
		Assert.assertTrue(iac.lazyInitializedSingleton(lis1, lis2));
	}

	/* 4. Thread Safe Singleton */
	@Test
	public void threadSafeSingletonTest() {
		ThreadSafeSingleton ts1 = ThreadSafeSingleton.getInstance();
		ThreadSafeSingleton ts2 = ThreadSafeSingleton.getInstance();
		Assert.assertTrue(iac.threadSafeSingleton(ts1, ts2));

		ThreadSafeSingleton ts11 = ThreadSafeSingleton.getInstanceUsingDoubleLocking();
		ThreadSafeSingleton ts12 = ThreadSafeSingleton.getInstanceUsingDoubleLocking();
		Assert.assertTrue(iac.threadSafeSingleton(ts11, ts12));
	}

	/* 5. Bill Pugh Singleton Implementation */
	@Test
	public void billPughSingletonTest() {
		BillPughSingleton lis1 = BillPughSingleton.getInstance();
		BillPughSingleton lis2 = BillPughSingleton.getInstance();
		Assert.assertTrue(iac.billPughSingleton(lis1, lis2));
	}

	/* 6. Using Reflection to destroy Singleton Pattern */
	@Test
	public void reflectionSingletonDestroyTest() {
		Assert.assertFalse(iac.reflectionSingletonDestroy());
	}

	/* 7. Enum Singleton */
	@Test
	public void singletonEnumTest() {
		Assert.assertTrue(iac.singletonEnum());
	}

	/* 8. Serialization and Singleton */
	@Test
	public void serializationSingelton() throws FileNotFoundException, IOException, ClassNotFoundException {
		Assert.assertTrue(iac.serializationSingelton());
	}

	/** 2. Factory Pattern **/

	/* Factory Design Pattern Super Class */
	@Test
	public void factoryDesignPatternBySuperClassTest() {

		ComputerSuper pc = iac.factoryDesignPatternBySuperClass("pc", "2 GB", "500 GB", "2.4 GHz");
		System.out.println("Factory PC Config::" + pc);
		Assert.assertTrue(pc.getClass().equals(PC.class));
		ComputerSuper server = iac.factoryDesignPatternBySuperClass("server", "16 GB", "1 TB", "2.9 GHz");
		System.out.println("Factory Server Config::" + server);
		Assert.assertTrue(server.getClass().equals(Server.class));
	}

	/** Abstract Factory Design Pattern in Java **/
	@Test
	public void abstractFactoryDesignPatternTest() {
		ComputerSuper pc = iac.abstractFactoryDesignPattern("PC", "2 GB", "500 GB", "2.4 GHz");
		System.out.println("Factory PC Config::" + pc);
		Assert.assertTrue(pc.getClass().equals(PC.class));
		ComputerSuper server = iac.abstractFactoryDesignPattern("server", "16 GB", "1 TB", "2.9 GHz");
		System.out.println("Factory Server Config::" + server);
		Assert.assertTrue(server.getClass().equals(Server.class));
	}

	/** Builder Pattern **/
	@Test
	public void builderDesignPatternTest() {
		iac.builderDesignPattern("2 GB", "500 GB");
	}

	/** Prototype Design Pattern **/
	@Test
	public void prototypeDesignPatternTest() {
		List<Employees> emps = iac.prototypeDesignPattern("abhi");
		System.out.println("emps List: " + emps.get(0).getEmpList());
		System.out.println("empsNew List: " + emps.get(1).getEmpList());
		System.out.println("empsNew1 List: " + emps.get(2).getEmpList());

		Assert.assertTrue(emps.get(1).getEmpList().get(emps.get(1).getEmpList().size() - 1).equals("abhi"));
	}
}
