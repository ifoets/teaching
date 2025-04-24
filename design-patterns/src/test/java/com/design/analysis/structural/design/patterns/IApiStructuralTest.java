package com.design.analysis.structural.design.patterns;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.design.analysis.structural.design.patterns.bridge.GreenColor;
import com.design.analysis.structural.design.patterns.bridge.Pentagon;
import com.design.analysis.structural.design.patterns.bridge.RedColor;
import com.design.analysis.structural.design.patterns.composite.Circle;
import com.design.analysis.structural.design.patterns.composite.Triangle;
import com.design.analysis.structural.design.patterns.decoder.BasicCar;
import com.design.analysis.structural.design.patterns.decoder.LuxuryCar;
import com.design.analysis.structural.design.patterns.decoder.SportsCar;
import com.design.analysis.structural.design.patterns.facade.HelperFacade;

public class IApiStructuralTest {

	public IApiStructural ias = null;

	@Before
	public void init() {
		ias = new ApiStructuralImpl();
	}

	/** 1. Adapter Pattern **/
	/* Adapter Design Pattern  Class Adapter */
	@Test
	public void classAdapterDesignPatternTest() {

		Assert.assertTrue(ias.classAdapterDesignPattern(120, 3) == 3);
		Assert.assertTrue(ias.classAdapterDesignPattern(120, 12) == 12);
		Assert.assertTrue(ias.classAdapterDesignPattern(120, 120) == 120);
	}

	/* Adapter Design Pattern  Object Adapter Implementation */
	@Test
	public void objectAdapterDesignPatternTest() {

		Assert.assertTrue(ias.objectAdapterDesignPattern(120, 3) == 3);
		Assert.assertTrue(ias.objectAdapterDesignPattern(120, 12) == 12);
		Assert.assertTrue(ias.objectAdapterDesignPattern(120, 120) == 120);
	}

	/** 2. Composite Pattern **/
	@Test
	public void compositePatternTest() {
		ias.compositePattern(new Triangle(), "Red");
		ias.compositePattern(new Circle(), "Green");
	}

	/** 3. Proxy Pattern **/
	@Test // TODO result not come proper
	public void proxyPatternTest() {
		ias.proxyPattern("abhi", "guruji");

		ias.proxyPattern("suman", "worng-usr");
	}

	/** 4. Flyweight Pattern **/
	@Test
	public void flyweightPatternTest() {
		// run this form DrawingClient.java
	}

	/** 5. Facade Pattern **/
	@Test
	public void facadePatternTest() {

		ias.facadePattern(HelperFacade.DBTypes.MYSQL, HelperFacade.ReportTypes.HTML, "Employee");
		ias.facadePattern(HelperFacade.DBTypes.ORACLE, HelperFacade.ReportTypes.PDF, "Employee");
	}

	/** 6. Bridge Pattern **/
	@Test
	public void bridgePattern() {
		ias.bridgePattern(new com.design.analysis.structural.design.patterns.bridge.Triangle(new RedColor()));
		ias.bridgePattern(new Pentagon(new GreenColor()));
	}

	/** 7. Decorator Pattern **/
	@Test
	public void decoratorPatternTest() {
		ias.decoratorPattern(new SportsCar(new BasicCar()));

		System.out.println("\n*****");

		ias.decoratorPattern(new SportsCar(new LuxuryCar(new BasicCar())));
	}
}
