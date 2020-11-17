package com.malviyad.basic.programs;

import java.util.HashMap;
// Another simple example : https://www.geeksforgeeks.org/design-a-data-structure-for-lru-cache/
public class LRUCache {
	private HashMap<Integer, Node> map;
	int capacity;
	int count;
	Node head;
	Node tail;

	public LRUCache(int capacity) {
		this.capacity = capacity;
		count = 0;
		map = new HashMap<>();
		head = new Node(0, 0);
		tail = new Node(0, 0);
		head.next = tail;
		tail.prev = head;
		head.prev = null;
		tail.next = null;
	}

	class Node {
		int key;
		int value;
		Node prev;
		Node next;

		public Node(int key, int value) {
			this.key = key;
			this.value = value;
		}
	}

	private void addToHead(Node node) {
		node.next = head.next; 
		head = node; 
        node.prev = head; 
        head.next = node; 
        
//        node.next = head.next; 
//        node.next.pre = node; 
//        node.pre = head; 
//        head.next = node; 

	}

	private void deleteNode(Node node) {
		node.prev.next = node.next;
		node.next.prev = node.prev;
	}

	public void setCache(int key, int value) {
		if (map.get(key) != null) {
			Node node = map.get(key);
			deleteNode(node);
			addToHead(node);
		} else {
			Node node = new Node(key, value);
			map.put(key, node);
			if (count < capacity) {
				count++;
				addToHead(node);
			} else {
				map.remove(tail.prev.key);
				deleteNode(tail.prev);
				addToHead(node);
			}
		}
	}

	// This method works in O(1)
	public int getCache(int key) {
		if (map.get(key) != null) {
			Node node = map.get(key);
			int result = node.value;
			deleteNode(node);
			addToHead(node);
			System.out.println("Got the value : " + result + " for the key: " + key);
			return result;
		}
		System.out.println("Did not get any value" + " for the key: " + key);
		return -1;
	}

	public static void main(String[] args) {
		System.out.println("Going to test the LRU " + " Cache Implementation");
		LRUCache cache = new LRUCache(2);

		// it will store a key (1) with value  10 in the cache. 
		cache.setCache(1, 10);

		// it will store a key (2) with value 20 in the cache. 
		cache.setCache(2, 20);
		System.out.println("Value for the key: 1 is " + cache.getCache(1)); // returns 10

		// evicts key 2 and store a key (3) with value 30 in the cache. 
		cache.setCache(3, 30);

		System.out.println("Value for the key: 2 is " + cache.getCache(2)); // returns -1 (not found)

	}
}
