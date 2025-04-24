package com.udemy.basic.reactive.utils;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.function.Consumer;

import com.github.javafaker.Faker;

public class ReactorUtil {

	public static final Path PATH = Paths.get("src/comman/inputdoc");

	public static final Faker FAKER = new Faker();

	public static Consumer<Object> onNext() {
		return e -> System.out.println("Received: " + e);
	}

	public static Consumer<Throwable> onEroor() {
		return e -> System.out.println("ERROR: " + e.getMessage());
	}

	public static Runnable onCompleted() {
		return () -> System.out.println("Completed...");
	}

	public static Faker faker() {
		return FAKER;
	}

	public static String getName() {
		System.out.println("Executed before name...");
		return FAKER.name()
		        .fullName();
	}

	public static void sleeppSecond(int second) {
		try {
			Thread.sleep(second * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
