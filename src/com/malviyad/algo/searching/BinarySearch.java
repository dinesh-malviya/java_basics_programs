package com.malviyad.algo.searching;
//Both best is O(1) and worst time complexity is O(logn)
public class BinarySearch {
	public static void main(String args[]) {
		int arr[] = { 2, 3, 4, 10, 40, 50, 55, 60 };
		int x = 60;
		int n = arr.length;
		int result = binarySearch(arr, 0, n - 1, x);
		if (result == -1) {
			System.out.println("Element not present");
		} else {
			System.out.println("Element found at " + "index " + result);
		}
	}

	private static int binarySearch(int[] arr, int start, int end, int x) {
		if (start <= end) {
			int midIndex = (start + end) / 2;
			if (arr[midIndex] == x) {
				return midIndex;
			}
			if (x < arr[midIndex]) {
				return binarySearch(arr, start, midIndex - 1, x);
			} else {
				return binarySearch(arr, midIndex + 1, end, x);
			}
		}
		return -1;
	}

}
