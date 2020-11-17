package com.malviyad.algo.sorting;

/**
 * complete array will be divided into n equal sublists untill we get the sublist with one elements
 * and then we will start merging these n sublists to form sorted array.
 * mergeSort(array, lower, upper) if(lower < upper){ mid = (lower + upper)/2
 * mergeSort(array, lower, mid) mergeSort(array, mid+1, upper) merge(array,
 * lower, mid, upper) }
 */
//Both best and worst time complexity is O(nlogn)
public class MergeSort {
	public static void main(String[] args) {
		int[] array =  { 25, 10, 82, 5, 97, 1 };//{ 24, 2, 45, 20, 56, 75, 2, 56, 99, 53, 12 };
		mergeSort(array, 0, array.length - 1);
		for (int i : array) {
			System.out.print(i +" ");
		}
	}

	private static void mergeSort(int[] array, int lower, int upper) {
		if (lower < upper) {
			//int mid = (lower + upper) / 2;
			int mid = lower + (upper - lower) / 2;
			mergeSort(array, lower, mid); // this is left part of array
			mergeSort(array, mid + 1, upper); // this is right part of array
			merge(array, lower, mid, upper);// this is to merge the sublists.
		}
	}

	private static void merge(int[] array, int lower, int mid, int upper) {
		int i = lower;
		int j = mid + 1;
		int k = lower;
		int finalArray[] = new int[array.length];
		//here we are comparing two final lists (left and right)
		while (i <= mid && j <= upper) {
			if (array[i] <= array[j]) {
				finalArray[k] = array[i];
				i++;
			} else {
				finalArray[k] = array[j];
				j++;
			}
			k++;
		}
		//here we are checking if left sublist is completed but there might be some elements still in right sublist
		//so we just need to blindly copy the right elements into final list.
		if (i > mid) {
			while (j <= upper) {
				finalArray[k] = array[j];
				j++;
				k++;
			}
		} else {
			while (i <= mid) {
				finalArray[k] = array[i];
				i++;
				k++;
			}
		}
		System.out.println(finalArray.length);
		for (k = lower; k <= upper; k++) {
			System.out.println("k= "+k);
			array[k] = finalArray[k];
		}
	}
}
