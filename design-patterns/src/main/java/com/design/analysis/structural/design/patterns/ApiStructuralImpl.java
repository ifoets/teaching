package com.design.analysis.structural.design.patterns;

import java.sql.Connection;

import com.design.analysis.structural.design.patterns.adapter.SocketAdapter;
import com.design.analysis.structural.design.patterns.adapter.SocketClassAdapterImpl;
import com.design.analysis.structural.design.patterns.adapter.SocketObjectAdapterImpl;
import com.design.analysis.structural.design.patterns.adapter.Volt;
import com.design.analysis.structural.design.patterns.bridge.BridgeShape;
import com.design.analysis.structural.design.patterns.composite.Drawing;
import com.design.analysis.structural.design.patterns.composite.Shape;
import com.design.analysis.structural.design.patterns.decoder.Car;
import com.design.analysis.structural.design.patterns.facade.HelperFacade;
import com.design.analysis.structural.design.patterns.facade.HelperFacade.DBTypes;
import com.design.analysis.structural.design.patterns.facade.HelperFacade.ReportTypes;
import com.design.analysis.structural.design.patterns.facade.MySqlHelper;
import com.design.analysis.structural.design.patterns.facade.OracleHelper;
import com.design.analysis.structural.design.patterns.proxy.CommandExecutor;
import com.design.analysis.structural.design.patterns.proxy.CommandExecutorProxy;

public class ApiStructuralImpl implements IApiStructural {

	/** 1. Adapter Pattern **/
	/* Adapter Design Pattern  Class Adapter */
	@Override
	public int classAdapterDesignPattern(int fromVolt, int toVolt) {

		return getVolt(new SocketClassAdapterImpl(), toVolt).getVolts();
	}

	@Override
	public int objectAdapterDesignPattern(int fromVolt, int toVolt) {

		return getVolt(new SocketObjectAdapterImpl(), toVolt).getVolts();
	}

	@Override
	public Volt getVolt(SocketAdapter sockAdapter, int i) {
		switch (i) {
		case 3:
			return sockAdapter.get3Volt();
		case 12:
			return sockAdapter.get12Volt();
		case 120:
			return sockAdapter.get120Volt();
		default:
			return sockAdapter.get120Volt();
		}
	}

	/** 2. Composite Pattern **/
	@Override
	public void compositePattern(Shape s, String str) {
		Drawing drawing = new Drawing();
		drawing.add(s);
		drawing.draw(str);
		drawing.clear();
	}

	/** 3. Proxy Pattern **/
	@Override
	public void proxyPattern(String usr, String password) {
		CommandExecutor executor = new CommandExecutorProxy(usr, password);
		try {
			executor.runCommand("ls-ltr");
			executor.runCommand("rm -rf abc.pdf");
		} catch (Exception e) {
			System.out.println("Exception Message::" + e.getMessage());
		}
	}

	/** 4. Flyweight Pattern **/
	@Override
	public void flyweightPattern(int height, int width) {
		// run this from DrawingClient
	}

	/** 5. Facade Pattern **/
	@Override
	public void facadePattern(DBTypes dbType, ReportTypes reportType, String tableName) {
		// String tableName = "Employee";

		// generating MySql HTML report and Oracle PDF report without using Facade
		Connection con = MySqlHelper.getMySqlDBConnection();
		MySqlHelper mySqlHelper = new MySqlHelper();
		mySqlHelper.generateMySqlHTMLReport(tableName, con);

		Connection con1 = OracleHelper.getOracleDBConnection();
		OracleHelper oracleHelper = new OracleHelper();
		oracleHelper.generateOraclePDFReport(tableName, con1);

		// generating MySql HTML report and Oracle PDF report using Facade
		HelperFacade.generateReport(HelperFacade.DBTypes.MYSQL, HelperFacade.ReportTypes.HTML, tableName);
		HelperFacade.generateReport(HelperFacade.DBTypes.ORACLE, HelperFacade.ReportTypes.PDF, tableName);
	}

	/** 6. Bridge Pattern **/
	@Override
	public void bridgePattern(BridgeShape shape) {
		shape.applyColor();
	}

	/** 7. Decorator Pattern **/
	@Override
	public void decoratorPattern(Car car) {
		car.assemble();
	}
}
