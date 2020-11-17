package com.malviyad.serialization.deserialization;

import java.io.Serializable;

public class Employee implements Serializable {
	protected String empName;
	protected int empId;

	public Employee(String empName, int empId) {
		this.empName = empName;
		this.empId = empId;
	}
}
