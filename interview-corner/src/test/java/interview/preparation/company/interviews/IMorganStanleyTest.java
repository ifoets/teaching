package interview.preparation.company.interviews;

import java.util.HashMap;
import java.util.Map;

import interview.preparation.company.interviews.impl.MorganStanleyImpl;
import interview.preparation.company.interviews.question.IMorganStanley;
import org.junit.Before;
import org.junit.Test;

public class IMorganStanleyTest {

	private IMorganStanley ims;

	@Before
	public void init() {
		ims = new MorganStanleyImpl();
	}
	/* how to configure a microservices that is strictly call by only one ms */
	/* how to show milliion of recored to customer at a time/pagination */
	/*
	 * how to show milliion of recored to customer for filter at a time/excel
	 * download
	 */

	/* OAth1 and OAth2 difference what get improved */

	/* Run two thread that print two diffrent thing */
	@Test
	public void runTwoTreadPrintDiffTest() {
		ims.runTwoTreadPrintDiff();
	}

	/*
	 * 
	 * create map whose key is Thread having different priority and sort map based
	 * on priority
	 */
	@Test
	public void sortMapOnKeyPropertyTest() {

		Runnable r = () -> System.out.println();
		Thread t1 = new Thread(r);
		t1.setPriority(5);
		Thread t2 = new Thread(r);
		t2.setPriority(4);
		Thread t3 = new Thread(r);
		t3.setPriority(1);
		Thread t4 = new Thread(r);
		t4.setPriority(2);
		Thread t5 = new Thread(r);
		t5.setPriority(3);

		Map<Thread, String> map = new HashMap<>();
		map.put(t1, "AAA");
		map.put(t2, "BBB");
		map.put(t3, "CCC");
		map.put(t4, "DDD");
		map.put(t5, "EEE");
		map = ims.sortMapOnKeyProperty(map);
		for (Map.Entry<Thread, String> entry : map.entrySet()) {
			System.out.println(entry.getKey().getPriority() + " :" + entry.getValue());
		}
	}

	/* print 1 to 100 odd from one thread and even form another thread */
}
