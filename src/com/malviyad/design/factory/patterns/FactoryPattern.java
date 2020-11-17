package com.malviyad.design.factory.patterns;

public class FactoryPattern {
	public static void main(String[] args) {
		FactoryCreator f = new FactoryCreator();
		Plan plan = f.getPlan("Domestic");
		plan.getRate();
		plan.calculateBill(5);
	}
}
