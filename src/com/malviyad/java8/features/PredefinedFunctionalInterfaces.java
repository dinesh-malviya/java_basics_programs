package com.malviyad.java8.features;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

//Autoboxing and Autounboxing happens for functional interfaces hence these should be used for Objects.
//For premitive, use premitive functional interfaces.
public class PredefinedFunctionalInterfaces {
	public static void main(String[] args) {
		/****************
		 ** Predicate ---->test()
		 ****************/
		Predicate<Integer> predicate = (i) -> i % 2 == 0;
		System.out.println(predicate.test(10));
		System.out.println(predicate.test(5));
		int x[] = { 0, 5, 10, 15, 20, 25, 30, 35 };
		Predicate<Integer> p1 = i -> i % 2 == 0;
		Predicate<Integer> p2 = i -> i > 10;
		System.out.println("printing numbers which are even and > 10");
		for (int x1 : x) {
			if (p1.and(p2).test(x1)) {
				System.out.println(x1);
			}
			// if (p1.or(p2).test(x1)) {
			// System.out.println(x1);
			// }
			// if (p1.negate().test(x1)) {
			// System.out.println(x1);
			// }
		}

		/****************
		 ** Function ---->apply()
		 ****************/
		Function<Integer, Integer> f1 = i -> i * i;
		System.out.println(f1.apply(10));

		Function<String, Integer> f2 = s -> s.length();
		System.out.println(f2.apply("Dinesh"));
		// Inside if, else if conditions we can Predicate as well.
		Predicate<Integer> p3 = m -> m >= 80;
		Predicate<Integer> p4 = m -> m >= 60;
		Predicate<Integer> p5 = m -> m >= 50;
		Predicate<Integer> p6 = m -> m >= 35;
		Function<Student, String> f3 = s -> {
			int marks = s.marks;
			String grade = "";
			if (marks >= 80 && p3.test(marks)) {
				grade = "A[Dictinctions]";
			} else if (marks >= 60 && p4.test(marks)) {
				grade = "B[First Class]";
			} else if (marks >= 50 && p5.test(marks)) {
				grade = "C[Second Class]";
			} else if (marks >= 35 && p6.test(marks)) {
				grade = "D[Third Class]";
			} else {
				grade = "E[Failed]";
			}
			return grade;
		};
		Student s[] = { new Student("Dinesh", 100), new Student("Vinod", 60), new Student("Buntty", 80),
				new Student("Dilip", 32), new Student("Sonu", 40), };
		Predicate<Student> p7 = student -> student.marks >= 80;

		/****************
		 ** Consumer ---->accept()
		 ****************/
		Consumer<String> c1 = s1 -> System.out.println(s1);
		c1.accept("Dinesh Malviya");

		Consumer<Student> c2 = s2 -> {
			System.out.println("Consumer Student name:" + s2.name);
			System.out.println("Consumer Student marks:" + s2.marks);
			System.out.println("Consumer Student grade:" + f3.apply(s2));
			System.out.println();
		};
		for (Student s1 : s) {
			System.out.println("Student name:" + s1.name);
			System.out.println("Student marks:" + s1.marks);
			System.out.println("Student grade:" + f3.apply(s1));
			System.out.println();
			if (p7.test(s1)) {
				c2.accept(s1);
			}
		}

		// Function Chaining: f1.andThen(f2).apply(i)
		Function<Integer, Integer> f4 = i -> 2 * i;
		Function<Integer, Integer> f5 = i -> i * i * i;
		System.out.println(f4.andThen(f5).apply(2));
		System.out.println(f4.compose(f5).apply(2));

		/****************
		 ** Supplier ---->get()
		 ****************/
		Supplier<String> supplier = () -> {
			String otp = "";
			for (int i = 0; i < 6; i++) {
				otp = otp + (int) (Math.random() * 10);
			}
			return otp;
		};
		System.out.println(supplier.get());
	}
}

class Student {
	String name;
	int marks;

	public Student(String name, int marks) {
		this.name = name;
		this.marks = marks;
	}
}
