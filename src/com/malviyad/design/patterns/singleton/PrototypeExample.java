package com.malviyad.design.patterns.singleton;

import java.io.IOException;

interface Prototype {

	public Prototype getClone();

}

public class PrototypeExample {
	public static void main(String[] args) throws IOException {

		EmployeeRecord e1 = new EmployeeRecord(105, "Dinesh", "SSE", 5000, "HRBR");

		e1.showRecord();
		System.out.println("\n");
		EmployeeRecord e2 = (EmployeeRecord) e1.getClone();
		e2.showRecord();
	}
}

class EmployeeRecord implements Prototype {
	private int id;
	private String name, designation;
	private double salary;
	private String address;

	public EmployeeRecord() {
		System.out.println("   Employee Records of Oracle Corporation ");
		System.out.println("---------------------------------------------");
		System.out.println("Eid" + "\t" + "Ename" + "\t" + "Edesignation" + "\t" + "Esalary" + "\t\t" + "Eaddress");
	}

	public EmployeeRecord(int id, String name, String designation, double salary, String address) {
		this();
		this.id = id;
		this.name = name;
		this.designation = designation;
		this.salary = salary;
		this.address = address;
	}

	public void showRecord() {

		System.out.println(id + "\t" + name + "\t" + designation + "\t" + salary + "\t" + address);
	}

	@Override
	public Prototype getClone() {

		return new EmployeeRecord(id, name, designation, salary, address);
	}
}