package interview.preparation.java8;

/**
 * @author Guruji
 */
/*
 * () -> { //Body of no parameter lambda }
 */

public interface ILambdaExpression {

	public void noParmAndNoReturn();

	public void singleParmAndReturn();

	public void mulParmAndReturn();

	public void withOrWithoutReturn();

	public void foreachLoop();

	public void creatingThread();

	public void useComparator();

	public void filterCollectionData();

	public void eventListener();
}

interface Drawable {
	public void draw();
}

interface Sayable {
	public String say();
}

interface SayableRetrn {
	public String say(String name);
}

interface Addable {
	int add(int a, int b);
}