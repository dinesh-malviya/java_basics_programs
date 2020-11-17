package com.malviyad.algo.sorting;
//https://www.youtube.com/watch?v=QN9hnmAgmOc&list=PLdo5W4Nhv31bEiyP4tclZMc5mP_X7OD7k&index=4

//best case is O(nlogn) and worst case time complexity is O(n2)
public class QuickSort {
	public static void main(String[] args) {
		int[] array = { 24, 2, 45, 20, 56, 75, 2, 56, 99, 53, 12 };
		quickSort(array, 0, array.length - 1);
		for (int i : array) {
			System.out.print(i + " ");
		}
	}

	private static void quickSort(int[] array, int lower, int upper) {
		if (lower < upper) {
			int location = partition(array, lower, upper);
			quickSort(array, lower, location - 1);
			quickSort(array, location + 1, upper);
		}
	}

	private static int partition(int[] array, int lower, int upper) {
		int pivot = array[lower];
		int start = lower;
		int end = upper;
		while (start < end) {
			while (start < array.length - 1 && array[start] <= pivot) {
				start++;
			}
			while (array[end] > pivot) {
				end--;
			}
			if (start < end) {
				int temp = array[start];
				array[start] = array[end];
				array[end] = temp;
			}
		}
		int temp = array[lower];
		array[lower] = array[end];
		array[end] = temp;
		return end;
	}
}
