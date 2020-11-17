package com.malviyad.algo.searching;

class IterativeBinarySearch {
	private static int binarySearch(int arr[], int x) {
		int leftIndex = 0, rightIndex = arr.length - 1;
		while (rightIndex >= leftIndex) {
			int mid = (leftIndex + rightIndex) / 2;
			if (arr[mid] == x) {
				return mid;
			}
			if (x < arr[mid]) {
				rightIndex = mid - 1;
			} else {
				leftIndex = mid + 1;
			}
		}
		return -1;
	}

	public static void main(String args[]) {
		int arr[] = { 2, 3, 4, 10, 40, 50, 55, 60 };
		int x = 10;
		int result = binarySearch(arr, x);
		if (result == -1) {
			System.out.println("Element not present");
		} else {
			System.out.println("Element found at " + "index " + result);
		}
	}
}
