package com.malviyad.java8.features;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FlatMapExample {
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("Dinesh malviya");
		list.add("Abhishek Singh");
		list.add("Sourabh Dubey");
		list.add("Mayur Patki");
		list.add("Rahul Sharam");
		list.stream().flatMap(a->{
			String[] arr = a.split(" ");
			return Arrays.asList(arr).stream();
		}).forEach((x)->System.out.println(x));
		System.out.println("list:"+list);
	}
}
