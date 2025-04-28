package interview.preparation.company.interviews.question;

import java.util.Map;

public interface  IMorganStanley {

	/* how to configure a microservices that is strictly call by only one ms */
	/* how to show milliion of recored to customer at a time/pagination */
	/*
	 * how to show milliion of recored to customer for filter at a time/excel
	 * download
	 */

	/* OAth1 and OAth2 difference what get improved */
	/* 3rd max value in Oracle */

	/* Run two thread that print two diffrent thing */
	public void runTwoTreadPrintDiff();

	/*
	 * 
	 * create map whose key is Thread having different priority and sort map based
	 * on priority
	 */
	public Map<Thread, String> sortMapOnKeyProperty(Map<Thread, String> tmap);

	/* print 1 to 100 odd from one thread and even form another thread */
	public void printByDiffThread();
}
