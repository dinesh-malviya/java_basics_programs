package com.malviyad.concurrent;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class ConcurrentModificationExceptionExample {
	public static void main(String[] args) {
		
		System.out.println(LocalDate.now());
		List<String> list = new ArrayList<>();
		list.add("Dinesh");
		list.add("Baba");
		list.add("Peps");
		list.add("Megs");
		list.add("Dubey");
		list.add("Chaman");
		Iterator<String> iterator = list.iterator();
		while (iterator.hasNext()) {
			String value = iterator.next();
			System.out.println(value);
			//list.remove(2);//this will cause ConcurrentModificationException while calling next() method
			if (value.equals("Dinesh")) {
				iterator.remove();//this works fine
			}
		}
		System.out.println(list);
		for (String string : list) {
			//list.remove(2);// We cannot modify the list in foreach loop as well as in iterator.
		}
		
		System.out.println("list ::::"+list);
		for(int i = 0; i<list.size(); i++) {
			System.out.println("i :"+i);
			list.remove(i);
			System.out.println("list size::::"+list.size());
		}
		System.out.println("list after::::"+list);
		//0<4
		//1<3
		//2<2
		Map<String, String> myMap = new HashMap<>();
		myMap.put("1", "1");
		myMap.put("2", "2");
		myMap.put("3", "3");
		
		myMap.forEach((k,v)->System.out.println("key:"+k+" value:"+v));
		Iterator<Entry<String, String>> it = myMap.entrySet().iterator();
		
		for (Map.Entry<String, String> entry: myMap.entrySet()) {
			System.out.println(entry.getKey());
			System.out.println(entry.getValue());
		}
		
		Iterator<String> iter = myMap.keySet().iterator();
		while(iter.hasNext()) {
			String key = iter.next();
			System.out.println(key);
		}
	}
}
