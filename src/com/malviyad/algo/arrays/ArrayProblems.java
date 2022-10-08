package com.malviyad.algo.arrays;

import java.util.Arrays;
import java.util.BitSet;
import java.util.HashSet;
import java.util.Iterator;
import java.util.stream.IntStream;

public class ArrayProblems {
	public static void main(String[] args) {
		int array[] = { 1, 2, 3, 4, 6, 7, 8, 9 };

		// Find Missing Number in Array, where array contains Number from 1....n
		int missingNumber = findMissingNumberInArray(array, 9);
		System.out.println("missingNumber:" + missingNumber);
		// Find Missing Numbers (multiple missing numbers) in Array, where array
		// contains Number from 1....n
		int multMissingArry[] = { 1, 2, 3, 4, 6, 7, 8, 9, 10, 12, 15 };
		findMultipleMissingNumberInArray(multMissingArry, 15);

		// Reverse an Array
		int arr[] = { 58, 5, 78, 1, 56, 87, 10 };
		reverseArray(arr, 0, arr.length - 1);
		for (int i : arr) {
			System.out.print(i + " ");
		}
		System.out.println("\n");

		// Reverse an Array recursively
		reverseArrayRecursive(arr, 0, arr.length - 1);
		for (int i : arr) {
			System.out.print(i + " ");
		}

		System.out.println("\n");

		// Find maximum product subarray. O(n^3)
		// If all are positive numbers then we can sort the array and get the product of
		// last 3 elements of array
		int arr1[] = { 1, 5, 2, -6, -4, 3 };
		int maxProd = maxProdTriplet(arr1, arr1.length);
		System.out.println("maximum prod triplet: " + maxProd);

		System.out.println("\n");
		// we can sort the array and get the product of last 2 elements of array
		// 1) Sort input array in increasing order.
		// 2) If all elements are positive, then return the product of the last two
		// numbers.
		// 3) Else return a maximum of products of the first two and last two numbers.
		maxProd = maxProdOfTwo(arr1, arr1.length);
		System.out.println("maximum prod of two elements: " + maxProd);

		// maxProdSubArray();

		// Kadane's Algorithm
		System.out.println("\n");
		int arr2[] = { -2, -3, 4, -1, -2, 1, 5, -3 };
		// int arr2[] = { 4, -3, -2, 2, 3, 1, -2, -3, 4, 2, -6, -3, 3, 1, 2 };
		int sum = maxContiguousSubArraySum(arr2, arr2.length);
		System.out.println("sum: " + sum);

		// Given an array A[] and a number x, check for pair in A[] with sum as
		// x
		int arr3[] = { 1, 4, 45, 6, 10, -8, 12 };
		findPairForGivenSum(arr3, 16);// for this to work we have to sort the array first
		findPairForGivenSumUsingHashing(arr3, 16);
		
		int givenArr[] = {15, 2, 4, 8, 9, 5, 10, 23};
		subArraySum(givenArr, givenArr.length, 23);

		// Convert an array into Zig Zag Array
		int arr4[] = { 3, 4, 6, 2, 1, 8, 9 };
		covertArrayIntoZigZagArrya(arr4);
		System.out.println("Zig Zag Array: " + Arrays.toString(arr4));

		int arr5[] = { 3, 4, 1, 6, 2, 1, 8, 9, 2, 7 };
		Arrays.sort(arr5);
		int removedCount = removeDuplicates(arr5, arr5.length);
		System.out.println("removed dulicates removedCount:" + removedCount);
		for (int i = 0; i < removedCount; i++) {
			System.out.print(arr5[i] + " ");
		}
		System.out.println();
		// Identify and print the duplicate elements from array
		printDuplicates();
		
		// remove element from an specified index
		int[] arr6 = { 1, 2, 3, 4, 5 };
		int index = 3; // need to remove from element from index 3, which is 4
		int[] newArra = IntStream.range(0, arr6.length).filter(i -> i != index).map(i -> arr6[i]).toArray();
		for (int i : newArra) {
			System.out.println("arr6:" + i);
		}
		double[] weights = { 1.01, 1.99, 2.5, 1.5, 1.01 };
		int trips = findMinimunNumberOfTrips(weights);
		System.out.println("trips: " + trips);

		largestAndSmallest(new int[] { -20, 34, 21, -87, 92, Integer.MAX_VALUE });
		largestAndSmallest(new int[] { 10, Integer.MIN_VALUE, -2 });
		largestAndSmallest(new int[] { Integer.MAX_VALUE, 40, Integer.MAX_VALUE });
		largestAndSmallest(new int[] { 1, -1, 0 });
		int price[] = new int[] { 100, 120, 150, 200, 80, 50, 110, 150, 200, 210 };
		calculateMaxProfit(price);
		calculateMaxProfit1(price);
	}

	private static int calculateMaxProfit1(int[] prices) {
		if (prices == null || prices.length <= 1) {
			return 0;
		}
		int min = prices[0];
		int result = 0;
		for (int i = 1; i < prices.length; i++) {
			System.out.println("before result: "+result +" before min :"+min);
			result = Math.max(result, prices[i] - min);
			min = Math.min(min, prices[i]);
			System.out.println("result: "+result +" min :"+min);
		}
		System.out.println("max result :" + result);
		return result;
	}

	private static void calculateMaxProfit(int[] price) {
		int minPrice = price[0];
		int maxPrice = price[0];
		int profit = 0;
		int difference = 0;
		for (int i = 1; i < price.length; i++) {
			if (minPrice > price[i]) {
				difference = maxPrice - minPrice;
				if (difference > profit) {
					profit = difference;
				}
				maxPrice = price[i];
				minPrice = price[i];
			} else if (maxPrice < price[i]) {
				maxPrice = price[i];
			}
		}
		difference = maxPrice - minPrice;
		if (difference > profit) {
			profit = difference;
		}
		System.out.println("max profit ::" + profit);
	}

	public static void largestAndSmallest(int[] numbers) {
		int largest = Integer.MIN_VALUE;
		int smallest = Integer.MAX_VALUE;
		for (int number : numbers) {
			if (number > largest) {
				largest = number;
			} else if (number < smallest) {
				smallest = number;
			}
		}
		System.out.println("Largest number in array is : " + largest);
		System.out.println("Smallest number in array is : " + smallest);
	}

	private static int findMinimunNumberOfTrips(double[] weights) {
		int trips = 0;
		Arrays.sort(weights);
		int left = 0;
		int right = weights.length - 1;
		while (left <= right) {
			if (weights[right] > 1.99) {
				trips++;
			} else if (weights[right] <= 1.99) {
				if (weights[right] + weights[left] <= 3) {
					left++;
				}
				trips++;
			}
			right--;
		}
		return trips;
	}

	private static int removeDuplicates(int arr[], int n) {
		if (n == 0 || n == 1) {
			return n;
		}
		int[] temp = new int[n];
		int j = 0;
		for (int i = 0; i < n - 1; i++) {
			// If current element is not equal to next element then store that current
			// element
			if (arr[i] != arr[i + 1]) {
				temp[j++] = arr[i];
			}
		}
		// Store the last element as whether it is unique or repeated, it hasn't stored
		// previously
		temp[j++] = arr[n - 1];
		// Modify original array
		for (int i = 0; i < j; i++) {
			arr[i] = temp[i];
		}
		return j;
	}

	private static void printDuplicates() {
		HashSet<Integer> set = new HashSet<>();
		int array[] = { 1, 5, 4, 7, 1, 9, 4 };
		for (int i : array) {
			if (set.add(i)) {
				System.out.println("Adding number: " + i);
			} else {
				System.out.println("duplicate number: " + i);
			}
		}
		Iterator<Integer> iterator = set.iterator();
		while (iterator.hasNext()) {
			System.out.println("printing: " + iterator.next());
		}
	}

	private static void covertArrayIntoZigZagArrya(int[] arr) {
		boolean flag = true;
		int temp = 0;
		for (int i = 0; i <= arr.length - 2; i++) {
			if (flag) {
				if (arr[i] > arr[i + 1]) {
					temp = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = temp;
				}
			} else {
				if (arr[i] < arr[i + 1]) {
					temp = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = temp;
				}
			}
			flag = !flag;
		}
	}

	private static void findPairForGivenSumUsingHashing(int[] arr, int sum) {
		HashSet<Integer> set = new HashSet<>();
		for (int i = 0; i < arr.length - 1; i++) {
			int temp = sum - arr[i];
			if (set.contains(temp)) {
				System.out.println("first::: " + temp + " second:::" + arr[i]);
			}
			set.add(arr[i]);
		}
	}

	private static void findPairForGivenSum(int[] arr, int sum) {
		Arrays.sort(arr);
		int start = 0;
		int end = arr.length - 1;
		while (start < end) {
			if (arr[start] + arr[end] == sum) {
				System.out.println("first: " + arr[start] + " second: " + arr[end]);
				return;
			} else if (arr[start] + arr[end] < sum) {
				start++;
			} else {
				end--;
			}
		}
	}

	private static int subArraySum(int arr[], int n, int sum) {
		int currentSum = arr[0];
		int start = 0;
		// Pick a starting point
		for (int i = 1; i <= n; i++) {
		    // If currentSum exceeds the sum,
		    // then remove the starting elements
		    while (currentSum > sum && start < i - 1) {
			currentSum = currentSum - arr[start];
			start++;
		    }
		    // If currentSum becomes equal to sum,
		    // then return true
		    if (currentSum == sum) {
			int p = i - 1;
			System.out.println("Sum found between indexes " + start + " and " + p);
			return 1;
		    }
		    // Add this element to curr_sum
		    if (i < n) {
			currentSum = currentSum + arr[i];
		    }
		    System.out.println("i value; " + i);
		}
		System.out.println("No subarray found");
		return 0;
    }
	private static int maxContiguousSubArraySum(int[] arr, int length) {
		int max = 0;
		int maxEndsHere = 0;
		int start = 0;
		int end = 0;
		int search = 0;
		for (int i = 0; i < length; i++) {
			maxEndsHere = maxEndsHere + arr[i];
			if (max < maxEndsHere) {
				max = maxEndsHere;
				start = search;
				end = i;
			}
			if (maxEndsHere < 0) {
				maxEndsHere = 0;
				search = i + 1;
			}
		}
		System.out.println(search);
		System.out.println("start: " + start + " end: " + end);
		return max;
	}

	private static int maxProdOfTwo(int[] arr, int n) {
		if (n < 2) {
			System.out.println("No pairs exists");
			return 0;
		}
		if (n == 2) {
			System.out.println(arr[0] + " " + arr[1]);
			return 0;
		}
		// Initialize maximum and second maximum
		int posa = Integer.MIN_VALUE, posb = Integer.MIN_VALUE;
		// Initialize minimum and second minimum
		int nega = Integer.MIN_VALUE, negb = Integer.MIN_VALUE;

		// Traverse given array
		for (int i = 0; i < n; i++) {
			// Update maximum and second maximum
			// if needed
			if (arr[i] > posa) {
				posb = posa;
				posa = arr[i];
			} else if (arr[i] > posb) {
				posb = arr[i];
			}
			// Update minimum and second minimum
			// if needed
			if (arr[i] < 0 && Math.abs(arr[i]) > Math.abs(nega)) {
				negb = nega;
				nega = arr[i];
			} else if (arr[i] < 0 && Math.abs(arr[i]) > Math.abs(negb)) {
				negb = arr[i];
			}
		}

		if (nega * negb > posa * posb) {
			System.out.println("Max product pair is {" + nega + ", " + negb + "}");
			return nega * negb;
		} else {
			System.out.println("Max product pair is {" + posa + ", " + posb + "}");
			return posa * posb;
		}
	}

	private static int maxProdTriplet(int[] arr, int n) {
		if (n < 3) {
			return -1;
		}
		int maxProd = Integer.MIN_VALUE;
		for (int i = 0; i < n - 2; i++) {
			for (int j = i + 1; j < n - 1; j++) {
				for (int k = j + 1; k < n; k++) {
					maxProd = Math.max(maxProd, arr[i] * arr[j] * arr[k]);
					System.out.println(arr[i] + ":" + arr[j] + ":" + arr[k]);
					System.out.println("maxProd: " + maxProd);
				}
			}
		}
		return maxProd;
	}

	private static void reverseArrayRecursive(int[] arr, int start, int end) {
		if (start < end) {
			int temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;
			reverseArrayRecursive(arr, start + 1, end - 1);
		}
	}

	private static void reverseArray(int[] arr, int start, int end) {
		while (start < end) {
			int temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;
			start++;
			end--;
		}
	}

	private static void findMultipleMissingNumberInArray(int[] array, int totalCount) {
		int missingCount = totalCount - array.length;
		BitSet bitSet = new BitSet(totalCount);

		for (int i : array) {
			bitSet.set(i - 1);
		}
		int lastMissingIndex = 0;
		for (int i = 0; i < missingCount; i++) {
			lastMissingIndex = bitSet.nextClearBit(lastMissingIndex);
			System.out.println(++lastMissingIndex);
		}
	}

	private static int findMissingNumberInArray(int[] array, int totalCount) {
		int expectedSum = (totalCount * (totalCount + 1)) / 2;
		int totalSum = 0;
		for (int i : array) {
			totalSum += i;
		}
		return expectedSum - totalSum;
	}
}
