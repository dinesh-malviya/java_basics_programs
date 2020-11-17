package com.malviyad.algo.sorting;

/*	The selection sort algorithm sorts an array by repeatedly finding the minimum element (considering ascending order)
	from unsorted part and putting it at the beginning. The algorithm maintains two subarrays in a given array.
	1) The subarray which is already sorted.
	2) Remaining subarray which is unsorted.
*/

//best case and worst case time complexity is O(n2)
public class SelectionSort {
	public static void main(String args[]) {
		int arr[] = { 64, 25, 12, 22, 11 };
		int sortedArr[] = selectionSort(arr);
		System.out.println("Sorted array");
		printArray(sortedArr);
	}

	private static int[] selectionSort(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			int minIndex = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] < arr[minIndex]) {
					minIndex = j;
				}
			}
			if (minIndex != i) {
				int temp = arr[minIndex];
				arr[minIndex] = arr[i];
				arr[i] = temp;
			}
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
