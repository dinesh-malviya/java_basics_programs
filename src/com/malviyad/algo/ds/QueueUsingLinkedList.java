package com.malviyad.algo.ds;

public class QueueUsingLinkedList {
	Node front;
	Node rear;

	class Node {
		int data;
		Node next;

		public Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	public void enqueue(int data) {
		// Create new node
		Node newNode = new Node(data);
		// If queue is empty, then new node is front and rear both
		if (rear == null) {
			front = newNode;
			rear = newNode;
			return;
		}
		// Add the new node at the end of queue and change rear
		rear.next = newNode;
		rear = newNode;
	}

	public void dequeue() {
		// If queue is empty, return NULL.
		if (front == null) {
			return;
		}
		// Store previous front and move front one node ahead
		Node tempNode = front;
		front = front.next;
		// If front becomes NULL, then change rear also as NULL
		if (front == null) {
			rear = null;
		}
	}

	public static void main(String[] args) {
		QueueUsingLinkedList q = new QueueUsingLinkedList();
		q.enqueue(10);
		q.enqueue(20);
		q.dequeue();
		q.dequeue();
		q.enqueue(30);
		q.enqueue(40);
		q.enqueue(50);
		q.dequeue();
		System.out.println("Queue Front : " + q.front.data);
		System.out.println("Queue Rear : " + q.rear.data);
	}
}
