package com.malviyad.algo.tests;

public class Dog extends Animal {
	Dog() {
		super();
		System.out.println("dog is created");
	}

	void eat() {
		System.out.println("eating bread...");
	}

	void bark() {
		System.out.println("barking...");
	}

	void work() {
		super.eat();
		bark();
	}
	public static void animalTesting() {
		System.out.println("inside dog testing");
	}
}
