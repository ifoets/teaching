package com.design.analysis.creational.design.patterns;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import com.design.analysis.creational.design.patterns.builder.BuilderPattern;
import com.design.analysis.creational.design.patterns.factory.ComputerFactory;
import com.design.analysis.creational.design.patterns.factory.ComputerSuper;
import com.design.analysis.creational.design.patterns.factory.PCFactory;
import com.design.analysis.creational.design.patterns.factory.ServerFactory;
import com.design.analysis.creational.design.patterns.factory.model.ComputerSuperFactory;
import com.design.analysis.creational.design.patterns.prototype.Employees;
import com.design.analysis.creational.design.patterns.singaltion.BillPughSingleton;
import com.design.analysis.creational.design.patterns.singaltion.EagerInitializedSingleton;
import com.design.analysis.creational.design.patterns.singaltion.LazyInitializedSingleton;
import com.design.analysis.creational.design.patterns.singaltion.ReflectionSingletonDestroy;
import com.design.analysis.creational.design.patterns.singaltion.SerializedSingleton;
import com.design.analysis.creational.design.patterns.singaltion.SingletonEnum;
import com.design.analysis.creational.design.patterns.singaltion.StaticBlockSingleton;
import com.design.analysis.creational.design.patterns.singaltion.ThreadSafeSingleton;

public class ApiCreationalImpl implements IApiCreational {

	/** 1. Singleton Pattern **/
	/* 1. Eager initialization */
	@Override
	public boolean eagerInitializedSingleton(EagerInitializedSingleton es1, EagerInitializedSingleton es2) {

		return es1.equals(es2);
	}

	/* 2. Static block initialization */
	@Override
	public boolean staticBlockInitialiizatioin(StaticBlockSingleton st1, StaticBlockSingleton st2) {

		return st1.equals(st2);
	}

	/* 3. Lazy Initialization */
	@Override
	public boolean lazyInitializedSingleton(LazyInitializedSingleton lis1, LazyInitializedSingleton lis2) {
		return lis1.equals(lis2);
	}

	/* 4. Thread Safe Singleton */
	@Override
	public boolean threadSafeSingleton(ThreadSafeSingleton ts1, ThreadSafeSingleton ts2) {
		return ts1.equals(ts2);
	}

	/* 5. Bill Pugh Singleton Implementation */
	@Override
	public boolean billPughSingleton(BillPughSingleton bps1, BillPughSingleton bps2) {
		return bps1.equals(bps2);
	}

	/* 6. Using Reflection to destroy Singleton Pattern */
	@Override
	public boolean reflectionSingletonDestroy() {
		return new ReflectionSingletonDestroy().destroySingalton();
	}

	/* 7. Enum Singleton */
	@Override
	public boolean singletonEnum() {
		SingletonEnum singleton = SingletonEnum.INSTANCE;
		System.out.println(singleton.getValue());
		singleton.setValue(2);
		SingletonEnum singleton2 = SingletonEnum.INSTANCE;
		;
		;
		System.out.println(singleton2.getValue());
		return singleton.equals(singleton2);
	}

	/* 8. Serialization and Singleton */
	@Override
	public boolean serializationSingelton() throws FileNotFoundException, IOException, ClassNotFoundException {
		SerializedSingleton instanceOne = SerializedSingleton.getInstance();
		ObjectOutput out = new ObjectOutputStream(new FileOutputStream("src/common/filename.txt"));
		out.writeObject(instanceOne);
		out.close();

		// deserailize from file to object
		ObjectInput in = new ObjectInputStream(new FileInputStream("src/common/filename.txt"));
		SerializedSingleton instanceTwo = (SerializedSingleton) in.readObject();
		in.close();

		System.out.println("instanceOne hashCode=" + instanceOne.hashCode());
		System.out.println("instanceTwo hashCode=" + instanceTwo.hashCode());
		return instanceOne.equals(instanceTwo);
	}

	/** 2. Factory Pattern **/

	/* Factory Design Pattern Super Class */
	@Override
	public ComputerSuper factoryDesignPatternBySuperClass(String type, String ram, String hdd, String cpu) {
		return ComputerSuperFactory.getComputer(type, ram, hdd, cpu);
	}

	/** Abstract Factory Design Pattern in Java **/
	public ComputerSuper abstractFactoryDesignPattern(String type, String ram, String hdd, String cpu) {

		if (type.equals("PC"))
			return ComputerFactory.getComputer(new PCFactory("2 GB", "500 GB", "2.4 GHz"));
		else
			return ComputerFactory.getComputer(new ServerFactory("16 GB", "1 TB", "2.9 GHz"));
	}

	/** Builder Pattern **/
	@Override
	public void builderDesignPattern(String hdd, String ram) {
		// Using builder to get the object in a single line of code and
		// without any inconsistent state or arguments management issues
		BuilderPattern comp = new BuilderPattern.ComputerBuilder(hdd, ram).setBluetoothEnabled(true)
				.setGraphicsCardEnabled(true).build();
		System.out.println(comp.getHDD());
	}

	/** Prototype Design Pattern **/
	@Override
	public List<Employees> prototypeDesignPattern(String name) {
		Employees emps = new Employees();
		emps.loadData();

		// Use the clone method to get the Employee object
		Employees empsNew = null;
		Employees empsNew1 = null;
		try {
			empsNew = (Employees) emps.clone();
			empsNew1 = (Employees) emps.clone();
		} catch (CloneNotSupportedException auther) {
			// TODO Auto-generated catch block
			auther.printStackTrace();
		}

		List<String> list = empsNew.getEmpList();
		list.add(name);
		List<String> list1 = empsNew1.getEmpList();
		list1.remove(list1.get(0));

		List<Employees> listEmps = new ArrayList<>();
		listEmps.add(emps);
		listEmps.add(empsNew);
		listEmps.add(empsNew1);

		return listEmps;
	}
}
