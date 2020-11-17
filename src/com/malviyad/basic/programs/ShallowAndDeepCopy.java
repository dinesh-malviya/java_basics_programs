package com.malviyad.basic.programs;

/*
 Shallow Copy:
  Whenever you try to create a copy of an object using the shallow copy, 
  all fields of the original objects are copied exactly. But, if it contains any objects as fields 
  then, only references to those objects are copied not the complete objects.

  This implies that, if you perform shallow copy on an object that contains any objects as 
  fields, since only references are copied in a shallow copy, both the original and copied object 
  points to the same reference internally and, if you do any changes to the data using
  the copied object, they are reflected in the original object too.
  
 Deep Copy: 
 Whenever you try to create a copy of an object, in the deep copy all fields 
  of the original objects are copied exactly, in addition to this, if it contains 
  any objects as fields then copy of those is also created (using the clone() method).
  
  This implies that, if you perform deep copy on an object that contains reference (object), 
  both the original and copied object refers to different objects and, if you do any changes 
  to the data the copied object they are not reflected in the original object.
*/
class Student implements Cloneable {
	private String name;
	private int age;
	protected Contact contact;

	public Student(String name, int age, Contact contact) {
		super();
		this.name = name;
		this.age = age;
		this.contact = contact;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

	protected Object clone() throws CloneNotSupportedException {
		Student student = (Student) super.clone();
		// if we comment line 54 (student.contact = (Contact) contact.clone()) then it will be shallow copy.
		//Default version of clone method creates the shallow copy of an object. 
		//To create the deep copy of an object, you have to override clone method. 
		//Shallow copy is preferred if an object has only primitive fields. 
		//Here we have an object reference "Contact" hence we need to call clone() method for deep copy operation.
		student.contact = (Contact) contact.clone();
		return student;
	}

	public void displayStudent() {
		System.out.println("Name : " + this.name);
		System.out.println("Age : " + this.age);
		contact.displayContact();
	}
}

class Contact implements Cloneable {
	private String email;
	private long phoneNo;

	public Contact(String email, long phoneNo) {
		super();
		this.email = email;
		this.phoneNo = phoneNo;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPhoneNo(long phoneNo) {
		this.phoneNo = phoneNo;
	}

	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	public void displayContact() {
		System.out.println("Phone no: " + this.phoneNo);
		System.out.println("Email: " + this.email);
	}

}

public class ShallowAndDeepCopy {
	public static void main(String[] args) throws CloneNotSupportedException {
		Contact contact = new Contact("malviya.dinesh01@gmail.com", 7795825251L);
		Student student = new Student("Dinesh", 32, contact);

		Student student1 = (Student) student.clone();
		student1.contact.setEmail("priyakhedekar.iips@gmail.com");
		student1.contact.setPhoneNo(9754621646L);

		student.displayStudent();
		System.out.println("=====================");
		student1.displayStudent();
	}
}
