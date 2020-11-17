package com.malviyad.concurrent;

public class PrintEvenOddNumber {
	int count=1;
	int MAX = 10;

	public void printEvenNumber() throws InterruptedException {
		synchronized (this) {
			while (count < MAX) {
				while (count % 2 == 1) {
					wait();
				}
				System.out.println("Even Number: " + count);
				count++;
				notify();
			}
		}
	}

	public void printOddNumber() throws InterruptedException {
		synchronized (this) {
			while (count < MAX) {
				while (count % 2 == 0) {
					wait();
				}
				System.out.println("Odd Number: " + count);
				count++;
				notify();
			}
		}
	}
	public static void main(String[] args) {
		PrintEvenOddNumber printEvenOddNumber = new PrintEvenOddNumber();
		Thread t1 = new Thread(() -> {
			try {
				printEvenOddNumber.printEvenNumber();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		t1.start();
		
		Thread t2 = new Thread(()-> {
			try {
				printEvenOddNumber.printOddNumber();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		t2.start();
	}
}
