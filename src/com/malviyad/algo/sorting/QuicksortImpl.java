package com.malviyad.algo.sorting;

//best case is O(nlogn) and worst case time complexity is O(n2)
public class QuicksortImpl {

	public static void main(String[] args) {
		// int inputArray[] ={4, 5, 1, 2, 3, 3};
		int inputArray[] = { 25, 10, 82, 5, 97, 1 };
		// int inputArray[] = {24,2,45,20,56,75,2,56,99,53,12};
		if (inputArray == null || inputArray.length == 0) {
			return;
		}
		quickSort(inputArray, 0, inputArray.length - 1);
		for (int i : inputArray) {
			System.out.println(i);
		}
	}

	private static void quickSort(int[] inputArray, int lb, int ub) {
		//int pivot = inputArray[lb + (ub - lb) / 2]; this one is also valid
		int pivot = inputArray[(lb + ub) / 2];
		int start = lb;
		int end = ub;
		while (start <= end) {
			while (inputArray[start] < pivot) {
				start++;
			}
			while (inputArray[end] > pivot) {
				end--;
			}
			if (start <= end) {
				int temp = inputArray[start];
				inputArray[start] = inputArray[end];
				inputArray[end] = temp;
				start++;
				end--;
			}
		}
		// here start and end pointers crosses each other and hence we have
		// recursively call quickSort(lb, end) and quickSort(start, ub)
		if (lb < end) {
			quickSort(inputArray, lb, end);
		}
		if (start < ub) {
			quickSort(inputArray, start, ub);
		}
	}
}
