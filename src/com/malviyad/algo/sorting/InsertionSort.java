package com.malviyad.algo.sorting;

//in this algo the given array will be divided into two parts( sorted and unsorted list) and we will trace the unsorted 
//array and pick one value and then we will identify the appropriate position in the sorted array and insert this value. 
//best case is O(n), worst case time complexity O(n2)
public class InsertionSort {
	public static void main(String a[]) {
		//int[] arr = { 10, 34, 2, 56, 7, 67, 88, 42 };
		int[] arr = { 7, 17, 2, 9, 1};
		int[] sortedArr = insertionSort(arr);
		printArray(sortedArr);
	}

	// best case is O(n)
	private static int[] insertionSort(int arr[]) {
		int n = arr.length;
		for (int i = 1; i < n; ++i) {
			int key = arr[i];
			int j = i - 1;
			/*
			 * Move elements of arr[0..i-1], that are greater than key, to one
			 * position ahead of their current position
			 */
			while (j >= 0 && arr[j] > key) {
				arr[j + 1] = arr[j];
				j = j - 1;
			}
			arr[j + 1] = key;
		}
		return arr;
	}

	private static void printArray(int arr[]) {
		int n = arr.length;
		for (int i = 0; i < n; ++i)
			System.out.print(arr[i] + " ");
		System.out.println();
	}
}
