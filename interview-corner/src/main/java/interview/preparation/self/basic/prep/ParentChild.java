package interview.preparation.self.basic.prep;

class Parent {
	public static void m() {
		System.out.println("Parent called");
	}
}

public class ParentChild extends Parent {

	public static void m() {
		System.out.println("Child class Called");
	}

	public static void main(String[] args) {

		Parent pt = new ParentChild();

		// child class called
		ParentChild pc = (ParentChild) pt;
		pc.m();
		// called paretn
		pt.m();
	}
}
