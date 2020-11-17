package com.malviyad.basic.programs;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class SortMap {
	public static void main(String[] args) {
		Map<String, String> unsortedMap = new HashMap<>();
		unsortedMap.put("Z", "dinesh");
		unsortedMap.put("B", "chetan");
		unsortedMap.put("A", "yogesh");
		unsortedMap.put("C", "vikas");
		unsortedMap.put("D", "mayur");
		unsortedMap.put("E", "sourabh");
		unsortedMap.put("Y", "happy");
		unsortedMap.put("N", "abhishek");
		unsortedMap.put("J", "vp");
		unsortedMap.put("M", "praveen");
		unsortedMap.put("F", "ram");

		// Sorting based on values
		unsortedMap.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEach(System.out::println);
		System.out.println("Sorting based on values :");
		printMap(unsortedMap);
		Map<String, String> result = unsortedMap.entrySet().stream().sorted(Map.Entry.comparingByValue())
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> oldValue,
						LinkedHashMap::new));

		System.out.println(result);

		printMap(unsortedMap);
		Map<String, String> treeMap = new TreeMap<>(unsortedMap);
		printMap(treeMap);

		Map<String, String> treeMap1 = new TreeMap<>((o1, o2) -> o1.compareTo(o2));
		treeMap1.putAll(unsortedMap);
		printMap(treeMap1);

	}

	private static void printMap(Map<String, String> unsortMap) {

		unsortMap.forEach((k, v) -> System.out.println("key :" + k + " value :" + v));
		
		System.out.println("=====================");
		
		for (String str : unsortMap.keySet()) {
			System.out.println("key ::" + str + " value ::" + unsortMap.get(str));
		}
		
		System.out.println("=====================");
		
		for (Map.Entry<String, String> entry : unsortMap.entrySet()) {
			System.out.println("key :::" + entry.getKey() + " value :::" + entry.getValue());
		}
	}
}
