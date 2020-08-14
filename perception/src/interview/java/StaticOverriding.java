package interview.java;

class Pt {
	public static void m1() {

	}

	public void m2() {

	}

}

public class StaticOverriding extends Pt {

	/*
	 * public void m1() {
	 * 
	 * }
	 */

	/*
	 * This instance method cannot override the
	 * static method from Pt
	 */
	/*
	 * public static void m2() {
	 * 
	 * }
	 */
//This static method cannot hide the instance method from Pt
}
