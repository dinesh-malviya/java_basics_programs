package com.malviyad.design.patterns.singleton;

public class Singleton6 {

	private Singleton6() {

	}

	private static class BillPughSingleton {
		private static final Singleton6 INSTANCE = new Singleton6();
	}

	public static Singleton6 getInstance() {
		return BillPughSingleton.INSTANCE;
	}
}
