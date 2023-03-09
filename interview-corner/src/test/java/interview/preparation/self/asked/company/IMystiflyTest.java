package interview.preparation.self.asked.company;

import java.util.List;
import java.util.Scanner;

import org.junit.Before;

public class IMystiflyTest {

	IMystifly im = null;
	private static final String ZERO = "0";

	@Before
	public void init() {
		im = new MystiflyImpl();
	}

	/*
	 * Write a function to print following pattern for N(1<=50) = 5
	 * 
	 * 0 11 000 1111 00000
	 */

	public void processingTest() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the value, 0 for exit:");
		String ob = sc.next();

		while (true) {
			List<String> list = im.processing(ob);
			for (String str : list)
				System.out.println(str);
			if (ob.equals(ZERO)) {
				System.out.println("Thanks");
				break;
			}
			System.out.println("Enter the value, 0 for exit:");
			ob = sc.next();
		}

	}
}
