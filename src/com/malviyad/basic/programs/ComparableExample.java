package com.malviyad.basic.programs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComparableExample {
	public static void main(String[] args) {
		Employee e1= new Employee("Dinesh", 8);
		Employee e2= new Employee("Sourabh", 2);
		Employee e3= new Employee("Vikash", 6);
		Employee e4= new Employee("Suresh", 12);
		Employee e5= new Employee("Mayur", 17);
		Employee e6= new Employee("Kumar", 7);
		List<Employee> empList = new ArrayList<>();
		empList.add(e1);
		empList.add(e2);
		empList.add(e3);
		empList.add(e4);
		empList.add(e5);
		empList.add(e6);
		Collections.sort(empList);
		System.out.println(empList);
	}
}
class Employee implements Comparable<Employee> {
	private String name;
	private int id;
	public Employee(String name, int id) {
		this.name=name;
		this.id=id;
	}
	@Override
	public int compareTo(Employee employee) {
		return this.name.compareTo(employee.name);
	}
	
	/* this is for sorting by id
	 * @Override public int compareTo(Employee employee) { return
	 * this.id-employee.id; }
	 */
	@Override
	public String toString() {
		return name +":"+id;
	}
}