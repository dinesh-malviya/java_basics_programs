package com.malviyad.association;

/* Association refers to the relationship between multiple objects. 
 * It refers to how objects are related to each other and how they 
 * are using each other's functionality. Composition and aggregation are two types of association.
*/

class Bank {
	private String name;

	Bank(String name) {
		this.name = name;
	}

	public String getBankName() {
		return this.name;
	}
}

class Employee {
	private String name;

	Employee(String name) {
		this.name = name;
	}

	public String getEmployeeName() {
		return this.name;
	}
}

public class AssociationExample {
	public static void main(String[] args) {
		Bank bank = new Bank("Axis");
		Employee emp = new Employee("Neha");
		System.out.println(emp.getEmployeeName() + " is employee of " + bank.getBankName());
	}
}
