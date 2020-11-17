package com.malviyad.basic.programs;

public class JavaBasicPrograms {
	int my = 20;
	static int myStatic = 20;

	public static void main(String[] args) {
		String a = new String("abc");
		String b = new String("abc");

		int i = 'A';// variable that stores the integer value of the character
		System.out.println("ASCII value of A :" + i);
		// Using Type-Casting we can get the ASCII value or character
		char chara = (char) 65;
		System.out.println("Character: " + chara);
		System.out.println(new JavaBasicPrograms().my);
		System.out.println(myStatic);

		System.out.println(a == b);
		System.out.println(a.equals(b));
		System.out.println(Math.random());
		
		fibonacciSeries();
		System.out.println();
		
		System.out.println("Nth Number: " + findNthFibonacciNumber(3));
		primeNumber();
		System.out.println();
		System.out.println("is Prime number: " + isPrime(71));
		System.out.println("is Prime number: " + isPrime(72));
		System.out.println("3 is Prime number: " + isPrime(3));
		System.out.println("is Palindrome number: " + isPalindrome(555));
		System.out.println("is Palindrome number: " + isPalindrome(720));
		System.out.println("is Armstrong number: " + isArmstrong(153));
		System.out.println("is Armstrong number: " + isArmstrong(720));
		System.out.println("is Factorial number: " + factorial(5));
		drawRightTriangle(5);
		drawLeftTriangle(5);
		drawPyramid();

	}

	private static void fibonacciSeries() {
		int n1 = 0;
		int n2 = 1;
		int n3 = 0;
		for (int k = 0; k < 11; k++) {
			System.out.print(n1 + " ");
			n3 = n1 + n2;
			n1 = n2;
			n2 = n3;
		}
	}

	private static int findNthFibonacciNumber(int n) {
		System.out.println("n:" + n);
		if (n <= 1) {
			return n;
		}
		// return findNthFibonacciNumber(n - 1) + findNthFibonacciNumber(n - 2);
		int first = findNthFibonacciNumber(n - 1);
		int second = findNthFibonacciNumber(n - 2);
		// System.out.println("final first:"+first);
		// System.out.println("final second:"+second);
		return first + second;
	}

	private static void primeNumber() {
		for (int i = 1; i < 100; i++) {
			int count = 0;
			for (int j = i; j >= 1; j--) {
				if (i % j == 0) {
					count++;
				}
			}
			if (count == 2) {
				System.out.print(i + " ");
			}
		}
	}

	private static boolean isPrime(int n) {
		// Check if number is less than
		// equal to 1
		if (n <= 1) {
			return false;
		}
		// Check if number is 2
		else if (n == 2) {
			return true;
		} else if (n % 2 == 0) {
			return false;
		}
		// Check from 2 to n-1
		for (int i = 3; i < n; i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}

	private static boolean isPalindrome(int n) {
		int sum = 0;
		int temp = n;
		while (n > 0) {
			int r = n % 10;
			sum = (sum * 10) + r;
			n = n / 10;
		}
		// return (sum == temp);
		if (sum == temp) {
			return true;
		}
		return false;
	}

	private static boolean isArmstrong(int n) {
		int sum = 0;
		int temp = n;
		while (n > 0) {
			int r = n % 10;
			sum = sum + (r * r * r);
			n = n / 10;
		}
		return (sum == temp);
	}

	private static int factorial(int n) {
		if (n == 0) {
			return 1;
		}
		return n * factorial(n - 1);
	}

	private static void drawRightTriangle(int n) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j <= i; j++) {
				// Remember here we are using print method
				System.out.print("* ");
			}
			System.out.println();
		}
	}

	private static void drawLeftTriangle(int n) {
		int i, j;
		for (i = 0; i < n; i++) {
			for (j = 2 * (n - i); j >= 0; j--) {
				System.out.print(" ");
			}
			for (j = 0; j <= i; j++) {
				System.out.print("* ");
			}
			System.out.println();
		}
	}

	private static void drawPyramid() {

	}

}
