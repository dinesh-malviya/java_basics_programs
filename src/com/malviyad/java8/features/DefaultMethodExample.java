package com.malviyad.java8.features;

interface I {
	default void m() {
		System.out.println("m I");
	}

	static void m1() {
		System.out.println("m1 I");
	}
}

interface J {
	default void mj() {
		System.out.println("J");
	}
}

class A implements I {
	public void callM() {
		m();
	}
}

//class B extends A implements J{
//	
//}
public class DefaultMethodExample {
	public static void main(String[] args) {
		A a = new A();
		a.m();
		I.m1();
		a.callM();
	}
}
