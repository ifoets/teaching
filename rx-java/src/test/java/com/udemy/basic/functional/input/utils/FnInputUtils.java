package com.udemy.basic.functional.input.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.udemy.basic.functional.model.Book;
import com.udemy.basic.functional.model.EEmployee;
import com.udemy.basic.functional.model.Movie;

public class FnInputUtils {

	public static List<Book> getBooks() {
		List<Book> books = new ArrayList<>();
		books.add(new Book("The Alchemist", "Paulo Coelho", "Adventure", 4.408789797));
		books.add(new Book("The Notebook", "Nicholas Sparks", "Romance", 4.10));
		books.add(new Book("Horror Cocktail", "Robert Bloch", "Horror", 2.67));
		books.add(new Book("House of Leaves", "Mark Z. Danielewski", "Horror", 4.10908908));
		return books;
	}

	public static List<EEmployee> getEmployees() {
		List<EEmployee> list = new ArrayList<>();

		for (int i = 0; i < 100; i++) {
			list.add(new EEmployee("John", 20000));
			list.add(new EEmployee("Rohn", 3000));
			list.add(new EEmployee("Tom", 15000));
			list.add(new EEmployee("Bheem", 8000));
			list.add(new EEmployee("Shiva", 200));
			list.add(new EEmployee("Krishna", 50000));
		}
		return list;
	}

	public static List<Movie> getMovies() {
		List<Movie> movies = Arrays.asList(new Movie("Spotlight", 2015, "Hollywood"),
				new Movie("Avengers: Infinity War", 2018, "Hollywood"), new Movie("Inception", 2010, "Hollywood"),
				new Movie("Forest Gump", 1994, "Hollywood"), new Movie("3 Idiots", 2009, "Bollywood"),
				new Movie("Beauty and the beast", 2017, "Hollywood"),
				new Movie("Slumdog Millionaire", 2008, "Bollywood"));
		return movies;
	}

	public static Map<String, String> getContacts() {
		Map<String, String> contacts = new HashMap<>();
		contacts.put("1237589020", "John");
		contacts.put("1237009020", "John");
		contacts.put("7890291111", "Neal");
		contacts.put("2647210290", "Raju");
		contacts.put("9999999999", "Peter");
		contacts.put("9081234567", "Neha");
		return contacts;
	}
}
