package interview.preparation.self.asked.company.impl;

import java.io.Serializable;

import interview.preparation.self.asked.company.question.Iinnoverdigital;
import interview.preparation.self.asked.company.question.InnoverdigitalImpl;
import org.junit.Before;

public class InnoverdigitalTest {

	Iinnoverdigital iid = null;

	@Before
	public void init() {
		iid = new InnoverdigitalImpl();
	}

	@org.junit.Test
	public void serlizeDeserlizeObjectTest() throws Exception {

		Employee emp = new Employee(1, "Abhimanyu");
		Employee desE = (Employee) iid.serlizeDeserlizeObject(emp);
		System.out.println("Id: " + desE.getId());
		System.out.println("Name: " + desE.getName());
	}
}

class Employee implements Serializable {

	private static final long serialVersionUID = 1L;
	private int id;
	private String name;

	public Employee(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + "]";
	}
}