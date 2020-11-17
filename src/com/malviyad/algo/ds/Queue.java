package com.malviyad.algo.ds;

public class Queue {
	private int arr[]; // array to store queue elements
	private int front; // front points to front element in the queue
	private int rear; // rear points to last element in the queue
	private int capacity; // maximum capacity of the queue

	// Constructor to initialize queue
	Queue(int capacity) {
		arr = new int[capacity];
		this.capacity = capacity;
		front = 0;
		rear = 0;
	}

	// Utility function to add an item to the queue
	public void enqueue(int item) {
		// check for queue overflow
		if (capacity == rear) {
			System.out.println("OverFlow\nProgram Terminated");
			System.exit(1);
		}
		System.out.println("Inserting " + item);
		arr[rear] = item;
		rear++;
	}

	// Utility function to remove front element from the queue
	public void dequeue() {
		// check for queue underflow
		if (front == rear) {
			System.out.println("UnderFlow\nProgram Terminated");
			System.exit(1);
		} else {
			for (int i = 0; i < rear - 1; i++) {
				arr[i] = arr[i + 1];
			}
		}
		rear--;
	}

	// Utility function to return front element in the queue
	public int peek() {
		if (front == rear) {
			System.out.println("UnderFlow\nProgram Terminated");
			System.exit(1);
		}
		return arr[front];
	}

	// print queue elements
	public void queueDisplay() {
		if (front == rear) {
			System.out.printf("\nQueue is Empty\n");
			return;
		}

		// traverse front to rear and print elements
		for (int i = front; i < rear; i++) {
			System.out.printf(" %d <-- ", arr[i]);
		}
		System.out.println();
		return;
	}

	// Queue implementation in java
	public static void main(String[] args) {
		// create a queue of capacity 5
		Queue q = new Queue(5);
		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
		q.enqueue(9);
		q.enqueue(5);
		q.queueDisplay();
		System.out.println();
		System.out.println("Front element is: " + q.peek());
		q.dequeue();
		System.out.println("Front element is: " + q.peek());
		q.queueDisplay();
		q.dequeue();
		q.queueDisplay();
		q.dequeue();
		q.queueDisplay();
	}
}
