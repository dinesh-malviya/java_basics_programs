package com.malviyad.design.factory.patterns;

public class FactoryCreator {
	public Plan getPlan(String planName) {
		if(planName.equalsIgnoreCase("Domestic")) {
			return new DomesticPlan();
		}else if(planName.equalsIgnoreCase("CommercialPlan")) {
			return new CommercialPlan();
		}else if(planName.equalsIgnoreCase("InternationalPlan")) {
			return new InternationalPlan();
		}
		return null;
	}
}
