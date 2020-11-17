package com.malviyad.algo.tests;

public class TestClass implements TestInterface, DemoInterface {

	// if exactly same method present in two different interfaces & class
	// implement both them, then in the class implementing these two interfaces
	// then there will be having only one implementation as both methods are same.

	// If two interfaces contain a method with the same signature(same method
	// name, same type of agrs) but different return types, then it is
	// impossible to implement both the interface simultaneously (compile time error).
	 void sum(int a,long b){System.out.println("a method invoked");}  
	 void sum(long a,int b){System.out.println("b method invoked");}  

	public void test1() {
		System.out.println("here");
	}

	public int test2() {
		System.out.println("here");
		return 1;
	}

	public static void main(String[] args) {
		TestClass test = new TestClass();
		test.test1();
		////now ambiguity  test.sum(10, 20); compile time error
		System.out.println(args.length);
		int i=0;
		int res = 0%5;
		System.out.println("res0:"+res);
		res = 1%5;
		System.out.println("res1:"+res);
		res = 2%5;
		System.out.println("res2:"+res);
		res = 3%5;
		System.out.println("res3:"+res);
		res = 4%5;
		System.out.println("res4:"+res);
		res = 5%5;
		System.out.println("res5:"+res);
		res = 6%5;
		System.out.println("res6:"+res);
		res = 7%5;
		System.out.println("res7:"+res);
	}
//
//	//@Override
//	public void test() {
//		// TODO Auto-generated method stub
//		// return 0;
//	}

	@Override
	public int test() {
		// TODO Auto-generated method stub
		return 0;
	}
}
