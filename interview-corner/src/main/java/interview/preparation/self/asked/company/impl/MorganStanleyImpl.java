package interview.preparation.self.asked.company.impl;

import interview.preparation.self.asked.company.question.IMorganStanley;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class MorganStanleyImpl implements IMorganStanley {

	/* how to configure a microservices that is strictly call by only one ms */
	/* how to show milliion of recored to customer at a time/pagination */
	/*
	 * how to show milliion of recored to customer for filter at a time/excel
	 * download
	 */

	/* OAth1 and OAth2 difference what get improved */

	/* Run two thread that print two diffrent thing */
	public void runTwoTreadPrintDiff() {

		new Thread(() -> System.out.println(Thread.currentThread().getName() + ": HI")).start();

		new Thread(() -> System.out.println(Thread.currentThread().getName() + ": Abhimanyu")).start();
	}

	/*
	 * 
	 * create map whose key is Thread having different priority and sort map based
	 * on priority
	 */
	public Map<Thread, String> sortMapOnKeyProperty(Map<Thread, String> tmap) {

		return tmap.entrySet().stream().sorted(Map.Entry.comparingByKey(Comparator.comparingInt(Thread::getPriority)))
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
	}

	/* print 1 to 100 odd from one thread and even form another thread */
	 int i = 1;

	public static void main(String[] args) {
		new MorganStanleyImpl().printByDiffThread();
	}

	public void printByDiffThread() {
		int countLimit = 14;
		Runnable r = () -> {
			String tName = Thread.currentThread().getName();
			while (i < countLimit) {
				try {
					if (Objects.equals(tName, "X")) {
						synchronized (this) {
							while (i % 3 != 1) {
								wait();
								Thread.sleep(500);
							}
							System.out.println(tName + ": " + i);
							i++;
							notifyAll();
						}
					}
					if (Objects.equals(tName, "Y")) {
						synchronized (this) {
							while (i % 3 != 2) {
								wait();
								Thread.sleep(500);
							}
							System.out.println(tName + ": " + i);
							i++;
							notifyAll();
						}
					}
					if (Objects.equals(tName, "Z")) {
						synchronized (this) {
							while (i % 3 != 0) {
								wait();
								Thread.sleep(500);
							}
							System.out.println(tName + ": " + i);
							i++;
							notifyAll();
						}
					}
				} catch (InterruptedException e) {
				}
			}
		};

		new Thread(r, "X").start();
		new Thread(r, "Y").start();
		new Thread(r, "Z").start();

	}

}
