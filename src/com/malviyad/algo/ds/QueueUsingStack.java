package com.malviyad.algo.ds;

import java.util.Stack;

public class QueueUsingStack {
	Stack<Integer> s1 = new Stack<>();
	Stack<Integer> s2 = new Stack<>();

	public static void main(String[] args) {
		QueueUsingStack queue = new QueueUsingStack();
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		queue.enqueue(4);
		queue.enqueue(5);
		System.out.println("size: " + queue.s1.size());
		System.out.println("dequeue: " + queue.dequeue());
		System.out.println("size: " + queue.s1.size());
		System.out.println("dequeue: " + queue.dequeue());
	}

	public void enqueue(int data) {
		while (!s1.empty()) {
			s2.push(s1.pop());
		}
		s1.push(data);
		while (!s2.empty()) {
			s1.push(s2.pop());
		}
	}

	public int dequeue() {
		if (s1.empty()) {
			System.out.println("queue is empty");
			return 0;
		}
		return s1.pop();
	}
}
