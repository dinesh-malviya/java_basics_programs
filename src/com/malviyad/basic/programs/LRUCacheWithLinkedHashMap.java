package com.malviyad.basic.programs;

import java.util.LinkedHashMap;

public class LRUCacheWithLinkedHashMap {
	private final int capacity;
	private LinkedHashMap<Integer, Integer> map;
	public LRUCacheWithLinkedHashMap(int capacity){
		this.capacity= capacity;
		map = new LinkedHashMap<>(capacity, 0.75f, true){
			@Override
			protected boolean removeEldestEntry(java.util.Map.Entry<Integer,Integer> eldest) {
				return size()>capacity;
			}
		};
	}
	
	public void setCache(int key, int value) {
		map.put(key, value);
		System.out.println("setting cache for key :"+key+" with value :"+value);
	}
	
	public int getCache(int key) {
		int value = map.getOrDefault(key, -1);
		System.out.println("getting cache for key :"+key+" with value :"+value);
		return value;
	}
	
	public static void main(String[] args) {
		LRUCacheWithLinkedHashMap LRUCache = new LRUCacheWithLinkedHashMap(2);
		LRUCache.setCache(1, 5);
		LRUCache.setCache(2, 10);
		LRUCache.setCache(3, 15);
		LRUCache.setCache(4, 20);
		LRUCache.getCache(1);
		LRUCache.getCache(2);
		LRUCache.getCache(3);
		LRUCache.getCache(4);
		LRUCache.setCache(5, 25);
	}
}
