package com.design.analysis.structural.design.patterns;

import com.design.analysis.structural.design.patterns.adapter.SocketAdapter;
import com.design.analysis.structural.design.patterns.adapter.Volt;
import com.design.analysis.structural.design.patterns.bridge.BridgeShape;
import com.design.analysis.structural.design.patterns.composite.Shape;
import com.design.analysis.structural.design.patterns.decoder.Car;
import com.design.analysis.structural.design.patterns.facade.HelperFacade.DBTypes;
import com.design.analysis.structural.design.patterns.facade.HelperFacade.ReportTypes;

/*
 * 
 * @author GuruG
 * Structural Design Patterns
1.	Adapter Pattern
2.	Composite Pattern
3.	Proxy Pattern
4.	Flyweight Pattern
5.	Facade Pattern
6.	Bridge Pattern
7.	Decorator Pattern

 */
public interface IApiStructural {

	/** 1. Adapter Pattern **/
	/* Adapter Design Pattern – Class Adapter */
	public int classAdapterDesignPattern(int fromVolt, int toVolt);

	/* Adapter Design Pattern – Object Adapter Implementation */
	public int objectAdapterDesignPattern(int fromVolt, int toVolt);

	public Volt getVolt(SocketAdapter sockAdapter, int toVolt);

	/** 2. Composite Pattern **/
	public void compositePattern(Shape s, String str);

	/** 3. Proxy Pattern **/
	public void proxyPattern(String usr, String password);

	/** 4. Flyweight Pattern **/
	public void flyweightPattern(int height, int width);

	/** 5. Facade Pattern **/
	public void facadePattern(DBTypes dbType, ReportTypes reportType, String tableName);

	/** 6. Bridge Pattern **/
	public void bridgePattern(BridgeShape shape);

	/** 7. Decorator Pattern **/
	public void decoratorPattern(Car car);
}
