package com.malviyad.java8.features;

//Method reference is used to refer method of functional interface
//Alternative to lambda expression syntax is method/constructor reference
//Advantage of method or constructor reference : we can use already implemented methods code (code re-usability)
//Method reference and constructor reference is alternative to Lambda expression (so that we can re utilize the code)
public class MethodAndCostructorReference {
	public static void m1() {
		for (int i = 0; i < 10; i++) {
			System.out.println("child thread from m1");
		}
	}
	
	public  void m2() {
		for (int i = 0; i < 10; i++) {
			System.out.println("child thread for m2");
		}
	}
	public static void main(String[] args) {
		
		/**********************
		 * Method Reference
		 * ********************/
		Runnable r = () -> {
			for (int i = 0; i < 10; i++) {
				System.out.println("child thread");
			}
		};
		//here Runnable's "run()" method is referring to MethodAndCostructorReference class m1() method
		//Here we are using m1 method instead of run() method, so for this method (run and m1) args should be same.
		//in case of method reference different return types are allowed but args types must match.
		
		//Syntax for static method => classname :: method name
		Runnable r1 = MethodAndCostructorReference::m1; 
		
		MethodAndCostructorReference methodAndCostRef = new MethodAndCostructorReference();
		//Syntax For instance method => Object reference :: method name
		Runnable r2 = methodAndCostRef::m2; 
		
		//we can replace r with r1 (which is method reference)
		//All three statements are true with r, r1 or r2
		
		//Thread t = new Thread(r1);
		//Thread t = new Thread(r2);
		Thread t = new Thread(r);
		t.start();
		for (int i = 0; i < 10; i++) {
			System.out.println("main thread");
		}
		
		
		/**************************
		 * Constructor Reference
		 * ************************/
		//Syntax For constructor reference method =>classname::new
		//MethodAndCostructorReference::new
		//If functional interface method returns an object then we should go for constructor reference 
		
		//Here Interf get() method is referring to Sample class constructor.
		Interf i = Sample::new; 
		Sample s1 = i.get();
		System.out.println("s1:"+s1);
		//Here InterfWithArgs get() method is referring to Sample class constructor.
		InterfWithArgs i2 = Sample::new; 
		Sample s2 = i2.get("Dinesh");
		System.out.println("s2:"+s2);
	}
}

interface Interf {
	public Sample get();
}
interface InterfWithArgs {
	public Sample get(String name);
}
class Sample {
	Sample(){
		System.out.println("sample class constructor executed....");
	}
	Sample(String name){
		System.out.println("sample class constructor executed...."+name);
	}
}
