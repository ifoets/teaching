package interview.preparation.java8;

import interview.preparation.newjava.java8.ILambdaExpression;
import interview.preparation.newjava.java8.LambdaExpressionImpl;
import org.junit.Before;
import org.junit.Test;

public class ILambdaExpressionTest {

	ILambdaExpression ile = null;

	@Before
	public void init() {
		ile = new LambdaExpressionImpl();
	}

	@Test
	public void noParmAndNoReturnTest() {
		ile.noParmAndNoReturn();
	}

	@Test
	public void singleParmAndReturnTest() {
		ile.singleParmAndReturn();
	}

	@Test
	public void mulParmAndReturnTest() {
		ile.mulParmAndReturn();
	}

	@Test
	public void withOrWithoutReturnTest() {
		ile.withOrWithoutReturn();
	}

	@Test
	public void foreachLoopTest() {
		ile.foreachLoop();
	}

	@Test
	public void creatingThreadTest() {

	}

	@Test
	public void useComparatorTest() {
		ile.useComparator();
	}

	@Test
	public void filterCollectionDataTest() {
		ile.filterCollectionData();
	}

	@Test
	public void eventListenerTest() {
		ile.eventListener();
	}
}
