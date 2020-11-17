package com.malviyad.algo.sorting;
//best case is O(n), worst case time complexity O(n2)
public class BubbleSort {
	public static void main(String args[]) {
		int arr[] = { 64, 34, 25, 12, 22, 11, 90 };
		int sortedArr[] = bubbleSort(arr);
		System.out.println("Sorted array");
		printArray(sortedArr);
	}

	private static int[] bubbleSort(int[] arr) {
		//outer loop for number of passes
		for (int i = 0; i < arr.length - 1; i++) {
			boolean swapped = false;
			//inner loop for number of comparison between adjacent elements  
			for (int j = 0; j < arr.length - 1 - i; j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j + 1];
					arr[j + 1] = arr[j];
					arr[j] = temp;
					swapped = true;
				}
			}
			//if swapping has not happened that means we can break because no more sorting is required.
			if(!swapped){
				break;
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
