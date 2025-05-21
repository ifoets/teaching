package com.udemy.basic.functional.demo;

import java.util.Spliterator;
import java.util.function.Consumer;

import com.udemy.basic.functional.model.Book;

public class BookSpliterator implements Spliterator<Book> {

	private String name;
	private String author;
	private String genre;
	private double rating;
	private Spliterator<String> baseSpliterator;

	public BookSpliterator(Spliterator<String> baseSpliterator) {
		this.baseSpliterator = baseSpliterator;
	}

	@Override
	public boolean tryAdvance(Consumer<? super Book> action) {
		if (this.baseSpliterator.tryAdvance(name -> this.name = name)
				&& this.baseSpliterator.tryAdvance(author -> this.author = author)
				&& this.baseSpliterator.tryAdvance(genre -> this.genre = genre)
				&& this.baseSpliterator.tryAdvance(rating -> this.rating = Double.valueOf(rating))) {

			action.accept(new Book(this.name, this.author, this.genre, this.rating));
			return true;

		}
		return false;
	}

	@Override
	public Spliterator<Book> trySplit() {
		return null;
	}

	@Override
	public long estimateSize() {
		return baseSpliterator.estimateSize() / 4;
	}

	@Override
	public int characteristics() {
		return baseSpliterator.characteristics();
	}

}
