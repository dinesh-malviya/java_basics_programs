package com.malviyad.interview.qa;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class SortByFrequency {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Map<Integer, Integer> map = new LinkedHashMap<>();
		while (in.hasNext()) {
			int key = in.nextInt();
			map.put(key, map.getOrDefault(key, 0) + 1);
		}
		List<Integer> list = new ArrayList<>();
		map.entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByValue())).forEach(entry -> {
			for (int i = 1; i <= entry.getValue(); i++) {
				list.add(entry.getKey());
			}
		});
		for (int item : list) {
			System.out.print(item + " ");
		}
		for (int i : map.keySet()) {
			
		}
	}
}
