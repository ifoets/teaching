package interview.preparation.java8.model;

import java.util.HashMap;

public class Book {
	String ISBN;
	String name;

	@Override
	public String toString() {
		return "Book [ISBN=" + ISBN + ", name=" + name + "]";
	}

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Book(String iSBN, String name) {
		super();
		ISBN = iSBN;
		this.name = name;
	}
}
