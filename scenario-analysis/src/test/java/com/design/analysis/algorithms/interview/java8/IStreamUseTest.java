package com.design.analysis.algorithms.interview.java8;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.design.analysis.algorithms.interview.java8.model.Student;

public class IStreamUseTest {

	public IStreamUse isu = null;
	List<Student> list = Student.getStudents();

	@Before
	public void init() {
		isu = new StreamUseImpl();
	}

	/** find unique string in list of string */

	@Test
	public void listOfUniqueStrTest() {
		List<String> list = Arrays.asList("aa", "bb", "cc", "aa", "cc");
		Assert.assertTrue(isu.listOfUniqueStr(list).size() == 3);
	}

	/** find list of even pos element */
	@Test
	public void listOfEvenPosTest() {
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		//System.err.println(list.stream().filter(i->i+2));
		// list=isu.listOfEvenPos(list);
		isu.listOfEvenPos(list).stream().forEach(e -> e.intValue());
	}

	@Test
	public void useManyFunctionTest() {

		isu.useManyFunction();
	}

	@Test
	public void getEvenIndexedStringsTest() {
		String[] names = { "Afrim", "Bashkim", "Besim", "Lulzim", "Durim", "Shpetim" };
		List<String> expectedResult = Arrays.asList("Afrim", "Besim", "Durim");
		List<String> actualResult = isu.getEvenIndexedStrings(names);
		assertEquals(expectedResult, actualResult);
	}

	@Test
	public void allMatchTest() {
		assertEquals(isu.allMatch(list), false);
	}

	@Test
	public void anyMatchTest() {
		assertEquals(isu.anyMatch(list), true);

	}

	@Test
	public void noMatchTest() {
		assertEquals(isu.noMatch(list), false);

	}
}
