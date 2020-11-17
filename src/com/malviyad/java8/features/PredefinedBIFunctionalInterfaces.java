package com.malviyad.java8.features;

import java.util.ArrayList;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;

//class Employee{
//	int eno;
//	String name;
//	public Employee(int eno, String name){
//		this.eno=eno;
//		this.name=name;
//	}
//}
public class PredefinedBIFunctionalInterfaces {
	public static void main(String[] args) {
		/****************
		 ** BiPredicate ---->test()
		 ****************/
		BiPredicate<Integer, Integer> p = (a, b) -> (a + b) % 2 == 0;
		System.out.println(p.test(10, 21));
		System.out.println(p.test(10, 20));

		/****************
		 ** BiFunction ---->apply()
		 ****************/
		ArrayList<Employee> list = new ArrayList<>();
		BiFunction<String, Integer, Employee> f = (name, enom) -> new Employee(name, enom);
		list.add(f.apply("Dinesh", 105));
		list.add(f.apply("Priya", 108));
		list.add(f.apply("Tabbu", 90));
		list.add(f.apply("Radhu", 95));
		for (Employee e : list) {
			System.out.println("Employee Name:" + e.name);
			System.out.println("Employee No:" + e.eNum);
			System.out.println();
		}

		/****************
		 ** BiConsumer ---->accept()
		 ****************/
		BiConsumer<Employee, Integer> c = (e, d) -> e.eNum = e.eNum + d;

		for (Employee e : list) {
			c.accept(e, 50);
		}
		for (Employee e : list) {
			System.out.println("BiConsumer Employee Name:" + e.name);
			System.out.println("BiConsumer Employee No:" + e.eNum);
			System.out.println();
		}
	}
}
