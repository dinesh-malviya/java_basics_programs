package com.malviyad.design.factory.patterns;

abstract class Plan {
	int rate;
	abstract void getRate();
	public void calculateBill(int units) {
		System.out.println(rate*units);
	}
}
