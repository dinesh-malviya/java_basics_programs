package com.malviyad.java8.features;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

interface FunctionalInterface {
	void printHello();

	default void sayHello() {
	}

	static void sayBye() {
	}
}

interface FunctionalInterface1 {
	void printHello(int i);
}

interface FunctionalInterface2 {
	void printHello(int i, int j);
}

public class JavaNewFeatures {
	public static void main(String[] args) {
		FunctionalInterface functionalInterface = () -> {
			System.out.println("Hello FunctionalInterface");
		};
		functionalInterface.printHello();

		FunctionalInterface1 functionalInterface1 = (i) -> {
			System.out.println("Hello FunctionalInterface i :" + i);
		};
		functionalInterface1.printHello(10);

		FunctionalInterface2 functionalInterface2 = (i, j) -> {
			System.out.println("Hello FunctionalInterface i :" + i + " and j:" + j);
		};
		functionalInterface2.printHello(10, 20);
		
		Function<Integer, Integer> f = a -> a * a;
		System.out.println(f.apply(10));

		ArrayList<Integer> list = new ArrayList<>();
		list.add(20);
		list.add(2);
		list.add(17);
		list.add(9);
		list.add(0);
		list.add(12);
		// Using Comparator to sort ArrayList elements.
		Collections.sort(list, (i1, i2) -> (i1 < i2) ? -1 : (i1 > i2) ? 1 : 0);
		System.out.println(list);
		list.forEach((n)->{
			System.out.println(n);
		});
		list.stream().forEach(System.out::println);
		List<Integer> filterList = list.stream().filter(i -> i % 2 == 0).collect(Collectors.toList());
		System.out.println(filterList);
	}
}
