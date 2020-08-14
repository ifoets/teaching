package com.design.analysis.algorithms.interview.java8;

import java.util.List;

import com.design.analysis.algorithms.interview.java8.model.Student;

public interface IStreamUse {

	/** find unique string in list of string */
	public List<String> listOfUniqueStr(List<String> ls);

	/** find list of even pos element */
	public List<Integer> listOfEvenPos(List<Integer> l);

	public void useManyFunction();

	public List<String> getEvenIndexedStrings(String[] names);

	/*matching or non matching*/
	public boolean allMatch(List<Student> l);

	public boolean anyMatch(List<Student> l);

	public boolean noMatch(List<Student> l);
	
	public List<Integer> collectX(List<Integer> list);
	
	public List<Integer> collectY(List<Integer> list);
}
