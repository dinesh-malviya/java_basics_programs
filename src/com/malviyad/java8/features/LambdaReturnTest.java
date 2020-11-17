package com.malviyad.java8.features;

//The return type of a method in which lambda expression used in a return statement must be a functional interface.
public class LambdaReturnTest {
	interface Addition {
		int add(int a, int b);
	}

	interface Drawable {
		public void draw();
	}

	public static Addition getAddition() {
		return (a, b) -> a + b; // lambda expression return statement
	}

	public static void main(String args[]) {
		System.out.println("The addition of a and b is: " + getAddition().add(20, 50));
		Addition addition = (a, b) -> a + b;
		System.out.println("without return: " + addition.add(10, 30));
		
		Addition addition1 = (a, b) -> {
			return (a + b);
		};
		System.out.println("with return: " + addition1.add(20, 30));
		// return type is functional interface type and with reference we can invoke its
		// method.
		Drawable d = () -> {
			System.out.println("Drawable draw() method implementation");
		};
		// invoking the functional interface method using functional interface
		// reference.
		d.draw();
	}
}
