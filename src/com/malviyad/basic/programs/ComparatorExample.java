package com.malviyad.basic.programs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Employee1 {
	String name;
	int id;

	public Employee1(String name, int id) {
		this.name = name;
		this.id = id;
	}

	@Override
	public String toString() {
		return name + ":" + id;
	}
}

class EmployeeSortByName implements Comparator<Employee1> {
	@Override
	public int compare(Employee1 e1, Employee1 e2) {
		return e1.name.compareTo(e2.name);
	}
}

class EmployeeSortById implements Comparator<Employee1> {
	@Override
	public int compare(Employee1 e1, Employee1 e2) {
		return e1.id - e2.id;
	}
}

public class ComparatorExample {
	public static void main(String[] args) {
		Employee1 e1 = new Employee1("Vikash", 8);
		Employee1 e2 = new Employee1("Sourabh", 2);
		Employee1 e3 = new Employee1("Dinesh", 6);
		Employee1 e4 = new Employee1("Suresh", 12);
		Employee1 e5 = new Employee1("Mayur", 17);
		Employee1 e6 = new Employee1("Ashok", 7);
		List<Employee1> empList = new ArrayList<>();
		empList.add(e1);
		empList.add(e2);
		empList.add(e3);
		empList.add(e4);
		empList.add(e5);
		empList.add(e6);
		System.out.println("empList:::" + empList);
		//Collections.sort(empList, new EmployeeSortByName());
		System.out.println("empList:::" + empList);
		
		//Collections.sort(empList, new EmployeeSortById());
		System.out.println("empList:::" + empList);
		
		Collections.sort(empList, (emp1, emp2)->{
			return emp1.name.compareTo(emp2.name);
		});
		System.out.println("using lambda empList:::" + empList);
		Collections.sort(empList, (emp1, emp2)->{
			return emp1.id-emp2.id;
		});
		System.out.println("using lambda empList:::" + empList);
		empList.forEach(emp->System.out.println(emp.name));
		
		System.out.println("foreach with method reference============");
		empList.forEach(System.out::println);
	}
}
