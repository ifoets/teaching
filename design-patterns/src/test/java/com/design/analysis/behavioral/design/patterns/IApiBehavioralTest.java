package com.design.analysis.behavioral.design.patterns;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.design.analysis.behavioral.design.patterns.template.GlassHouse;
import com.design.analysis.behavioral.design.patterns.template.WoodenHouse;

public class IApiBehavioralTest {

	public IApiBehavioral iab = null;

	@Before
	public void init() {
		iab = new ApiBehavioralIml();
	}

	/** 1. Template Method Pattern **/
	@Test
	public void templateMethodPatternTest() {
		// using template method
		iab.templateMethodPattern(new WoodenHouse());
		System.out.println("************");
		iab.templateMethodPattern(new GlassHouse());
	}

	/** 2. Mediator Pattern **/
	@Test
	public void mediatorPatternTest() {

		List<String> nameList = new ArrayList<>();
		String arr[] = { "Pankaj", "Lisa", "Saurabh", "David" };
		for (int i = 0; i < arr.length; i++)
			nameList.add(arr[i]);
		iab.mediatorPattern(nameList);
	}

	/** 3. Chain of Responsibility Pattern **/
	@Test
	public void chainOfRespPatternTest() {
		iab.chainOfRespPattern();
	}
}
