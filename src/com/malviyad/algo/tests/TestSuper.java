package com.malviyad.algo.tests;

//Final methods cannot be overriden in subclass, static methods also cannot be
//overriden in subclass but we can declare a method with same signature in subclass
public class TestSuper extends Dog implements Cloneable{
	public static void main(String args[]) throws CloneNotSupportedException {
		Dog d = new Dog();
		animalTesting();
		Dog  t = new TestSuper();
		Class clas = TestSuper.class;
		System.out.println(clas.getName());
		TestSuper testSuper = new TestSuper();
		TestSuper testSuper2 = (TestSuper) testSuper.clone();//shallow copy
		System.out.println("testSuper2: "+ testSuper2);
		
		TestSuper testSuper3 = testSuper;//shallow copy
	}
//	public static void animalTesting() {
//		System.out.println("inside animal testing");
//	}
	
	protected Object clone() throws CloneNotSupportedException{
		return super.clone();
	}
	
}
