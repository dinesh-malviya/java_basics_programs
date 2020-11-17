package com.malviyad.algo.sorting;

//Both best and worst time complexity is O(nlogn)
public class HeapSort {
	public static void main(String[] args) {
		int[] array = { 24, 2, 45, 20, 56, 75, 2, 56, 99, 53, 12 };
		//int[] array = {15,5,20,1,17,10,30};
		int n = array.length;
		heapSort(array, n);
		for (int i : array) {
			System.out.print(i + " ");
		}
	}

	private static void heapSort(int[] array, int n) {
		//This for loop for building the max heap.
		for (int i = n / 2 - 1; i >= 0; i--) {
			maxHeapify(array, n, i);
		}
		//This for loop for deleting the elements from max heap (from top) and store them in the same array.
		//Once all elements are deleted and stored in the array then the final array will be sorted.
		for (int i = n - 1; i >= 0; i--) {
			int temp = array[i];
			array[i] = array[0];
			array[0] = temp;
			maxHeapify(array, i, 0);
		}
	}

	private static void maxHeapify(int[] array, int n, int i) {
		int largest = i;
		int left = (2 * i) + 1;
		int right = (2 * i) + 2;
		while (left < n && array[left] > array[largest]) {
			largest = left;
		}
		while (right < n && array[right] > array[largest]) {
			largest = right;
		}
		if (largest != i) {
			int temp = array[largest];
			array[largest] = array[i];
			array[i] = temp;
			maxHeapify(array, n, largest);
		}
	}
}
