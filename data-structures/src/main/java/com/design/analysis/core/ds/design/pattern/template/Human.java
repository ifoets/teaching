package com.design.analysis.core.ds.design.pattern.template;

import com.design.analysis.ds.design.pattern.creation.IImmutableObjPoolTest;

public final class Human {

	private String name;
	private int age;

	public Human(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public boolean create(String name, int age) {
		return IImmutableObjPoolTest.iip.addObjInPool(new Human(name, age));
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	@Override
	public int hashCode() {
		return age;// since i try to put same age people in same tree
		// Note you can use as usual/as you want to implement hash code
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Human other = (Human) obj;
		if (age != other.age)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "(" + name + ", " + age + ")->";
	}

}
