package com.malviyad.design.patterns.singleton;

public class Singleton2 {
	private static Singleton2 instance;

	private Singleton2() {

	}
	static{
		instance = new Singleton2();
	}
}
