package com.malviyad.algo.ds;

public class Stack {
	int MAX = 100;
	int top;
	int array[] = new int[MAX];

	public Stack() {
		top = -1;
	}

	private boolean isEmpty() {
		return (top < 0);
	}

	private boolean push(int data) {
		if (top >= (MAX - 1)) {
			System.out.println("Stack is overflow.");
			return false;
		}
		array[++top] = data;
		System.out.println(data + " :is pushed into stack.");
		return true;
	}

	private int pop() {
		if (isEmpty()) {
			System.out.println("Stack is underflow.");
			return 0;
		}
		return array[top--];
	}

	private int peek() {
		if (isEmpty()) {
			System.out.println("Stack is underflow.");
			return 0;
		}
		return array[top];
	}

	public static void main(String[] args) {
		Stack stack = new Stack();
		stack.push(10);
		stack.push(17);
		stack.push(9);
		stack.push(84);
		stack.push(19);
		stack.push(12);
		stack.push(1);
		System.out.println(stack.pop());
		System.out.println(stack.peek());
		System.out.println(stack.peek());
		System.out.println(stack.peek());
	}
}
