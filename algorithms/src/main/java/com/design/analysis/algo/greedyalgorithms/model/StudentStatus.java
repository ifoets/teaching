package com.design.analysis.algo.greedyalgorithms.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class StudentStatus implements Comparable<StudentStatus> {

	public Date sleepSt;
	public Date sleepEnd;
	public boolean isSleep;

	public StudentStatus(Date sleepSt, Date sleepEnd) {
		super();
		this.sleepSt = sleepSt;
		this.sleepEnd = sleepEnd;
		this.isSleep = true;
	}

	@Override
	public int compareTo(StudentStatus o) {
		if (this.sleepSt.equals(o.sleepSt))
			return this.sleepEnd.before(o.sleepEnd) ? -1 : 1;
		return this.sleepSt.before(o.sleepSt) ? -1 : 1;
	}

	
	@Override
	public String toString() {
		return "StudentStatus [sleepSt=" + sleepSt + ", sleepEnd=" + sleepEnd + "]";
	}

	public List<Date> timeListGetAllMatterersUed(List<StudentStatus> list, int noOfmatteres) {
		List<Date> result = new ArrayList<>();
		Collections.sort(list);
		int count = 1;
		count++;// default 1 for firt stud sleeping
		for (int i = 0; i < list.size() - 1; i++) {
			if (list.get(i + 1).sleepSt.before(list.get(i).sleepEnd) && list.get(i).isSleep)
				count++;
			// check any get wakeup before start sleeping some one vacate the bed
			for (int j = 0; j <= i; j++) {
				if (list.get(j).sleepEnd.after(list.get(i).sleepSt) && list.get(j).isSleep) {
					list.get(j).isSleep = false;
					count--;
				}
			}
			if (count == noOfmatteres)
				result.add(list.get(i).sleepSt);
		}
		return result;
	}
	
	public static void main(String[] args) {
		
		List<StudentStatus> ls = new ArrayList<>();
		ls.add(new StudentStatus(new Date(10000000), new Date(210000000)));
		ls.add(new StudentStatus(new Date(2000000), new Date(30000000)));
		ls.add(new StudentStatus(new Date(20000000), new Date(40000000)));
		ls.add(new StudentStatus(new Date(30000000), new Date(40000000)));
		Collections.sort(ls);
		
	}
}
