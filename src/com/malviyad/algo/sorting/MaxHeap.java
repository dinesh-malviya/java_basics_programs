package com.malviyad.algo.sorting;

public class MaxHeap {
	private int size;
	private int myHeap[];

	public MaxHeap(int maxSize) {
		this.size = 0;
		this.myHeap = new int[maxSize];
	}

	private void addIntoMaxHeap(int array[], int n, int data) {
		int newArray[] = copyFromOldToNewArray(array, n);
		newArray[n] = data;
		int i = n;
		while (i > 0) {
			int parent = (i - 1) / 2;
			if (newArray[parent] < newArray[i]) {
				int temp = newArray[parent];
				newArray[parent] = newArray[i];
				newArray[i] = temp;
			} else {
				break;
			}
			i = parent;
		}
		System.out.println("===========");
		for (int j : newArray) {
			System.out.println(j);
		}
	}

	private int[] copyFromOldToNewArray(int[] array, int n) {
		int newArray[] = new int[n + 1];
		for (int i = 0; i < n; i++) {
			newArray[i] = array[i];
		}
		return newArray;
	}

	private void insert(int data) {
		myHeap[size] = data;
		int i = size;
		while (i > 0) {
			int parent = (i - 1) / 2;
			if (myHeap[parent] < myHeap[i]) {
				int temp = myHeap[parent];
				myHeap[parent] = myHeap[i];
				myHeap[i] = temp;
			} else {
				break;
			}
			i = parent;
		}
		size++;
	}

	private void print() {
		for (int i = 0; i < size; i++) {
			System.out.println(" " + myHeap[i]);
		}
	}

	public static void main(String[] args) {
		MaxHeap maxHeap = new MaxHeap(10);
		maxHeap.insert(15);
		maxHeap.insert(18);
		maxHeap.insert(40);
		maxHeap.insert(5);
		maxHeap.insert(48);
		maxHeap.insert(17);
		maxHeap.insert(9);
		maxHeap.insert(4);
		maxHeap.insert(62);
		maxHeap.insert(52);
		maxHeap.print();
		maxHeap.addIntoMaxHeap(maxHeap.myHeap, maxHeap.myHeap.length, 56);
	}
}
