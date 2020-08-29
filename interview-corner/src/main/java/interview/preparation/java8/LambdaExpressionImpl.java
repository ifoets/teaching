package interview.preparation.java8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class LambdaExpressionImpl implements ILambdaExpression {

	@Override
	public void noParmAndNoReturn() {
		int width = 10;
		Drawable d2 = () -> {
			System.out.println("Drawing " + width);
		};
		d2.draw();
	}

	@Override
	public void singleParmAndReturn() {
		Sayable s = () -> {
			return "I have nothing to say.";
		};
		System.out.println(s.say());
	}

	public void parmAndReturn() {
		SayableRetrn s1 = (name) -> {
			return "Hello, " + name;
		};
		System.out.println(s1.say("Sonoo"));

		// You can omit function parentheses
		SayableRetrn s2 = name -> {
			return "Hello, " + name;
		};
		System.out.println(s2.say("Sonoo"));
	}

	public void mulParmAndReturn() {
		// Multiple parameters in lambda expression
		Addable ad1 = (a, b) -> (a + b);
		System.out.println(ad1.add(10, 20));

		// Multiple parameters with data type in lambda expression
		Addable ad2 = (int a, int b) -> (a + b);
		System.out.println(ad2.add(100, 200));
	}

	public void withOrWithoutReturn() {
		// Lambda expression without return keyword.
		Addable ad1 = (a, b) -> (a + b);
		System.out.println(ad1.add(10, 20));

		// Lambda expression with return keyword.
		Addable ad2 = (int a, int b) -> {
			return (a + b);
		};
		System.out.println(ad2.add(100, 200));
	}

	public void foreachLoop() {
		List<String> list = new ArrayList<String>();
		list.add("ankit");
		list.add("mayank");
		list.add("irfan");
		list.add("jai");

		list.forEach((n) -> System.out.println(n));
	}

	public void creatingThread() {
		Runnable r2 = () -> {
			System.out.println("Thread2 is running...");
		};
		Thread t2 = new Thread(r2);
		t2.start();
	}

	public void useComparator() {

		List<Product> list = new ArrayList<Product>();
		// Adding Products
		list.add(new Product(1, "HP Laptop", 25000f));
		list.add(new Product(3, "Keyboard", 300f));
		list.add(new Product(2, "Dell Mouse", 150f));

		System.out.println("Sorting on the basis of name...");

		// implementing lambda expression
		Collections.sort(list, (p1, p2) -> {
			return p1.name.compareTo(p2.name);
		});
		for (Product p : list) {
			System.out.println(p.id + " " + p.name + " " + p.price);
		}
	}

	public void filterCollectionData() {
		List<Product> list = new ArrayList<Product>();
		list.add(new Product(1, "Samsung A5", 17000f));
		list.add(new Product(3, "Iphone 6S", 65000f));
		list.add(new Product(2, "Sony Xperia", 25000f));
		list.add(new Product(4, "Nokia Lumia", 15000f));
		list.add(new Product(5, "Redmi4 ", 26000f));
		list.add(new Product(6, "Lenevo Vibe", 19000f));

		// using lambda to filter data
		Stream<Product> filtered_data = list.stream().filter(p -> p.price > 20000);

		// using lambda to iterate through collection
		filtered_data.forEach(product -> System.out.println(product.name + ": " + product.price));
	}

	public void eventListener() {
		JTextField tf = new JTextField();
		tf.setBounds(50, 50, 150, 20);
		JButton b = new JButton("click");
		b.setBounds(80, 100, 70, 30);

		// lambda expression implementing here.
		b.addActionListener(e -> {
			tf.setText("hello swing");
		});

		JFrame f = new JFrame();
		f.add(tf);
		f.add(b);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setLayout(null);
		f.setSize(300, 200);
		f.setVisible(true);

	}
}

class Product {
	int id;
	String name;
	float price;

	public Product(int id, String name, float price) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
	}
}
