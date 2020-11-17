package com.malviyad.algo.ds;

public class StackAsLinkedList {
	private Node head;

	class Node {
		int data;
		Node next;
		
		public Node(int data) {
			this.data=data;
			this.next=null;
		}
	}

	private boolean isEmpty() {
		if (head == null) {
			return true;
		}
		return false;
	}

	private void push(int data) {
		Node newNode = new Node(data);
		if (head == null) {
			head = newNode;
		} else {
			newNode.next = head;
			head = newNode;
		}
	}

	private int pop() {
		if (head == null) {
			System.out.println("\nstack is empty");
			return 0;
		}
		int popped = head.data;
		head = head.next;
		return popped;
	}

	private void printStack() {
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.data + "->");
			temp = temp.next;
		}
		System.out.println();
	}
	private int peek() {
		if (head == null) {
			System.out.println("\nstack is empty");
			return 0;
		}
		return head.data;
	}

	public static void main(String[] args) {
		StackAsLinkedList stackAsLinkedList = new StackAsLinkedList();
		stackAsLinkedList.push(54);
		stackAsLinkedList.push(10);
		stackAsLinkedList.push(100);
		stackAsLinkedList.push(8);
		stackAsLinkedList.push(8);
		stackAsLinkedList.push(75);
		stackAsLinkedList.push(45);
		stackAsLinkedList.printStack();
		System.out.println(stackAsLinkedList.pop());
		System.out.println(stackAsLinkedList.peek());
	}
}
