package com.malviyad.association;

import java.util.ArrayList;
import java.util.List;

/* The composition is the strong type of association. An association is said to composition 
 * if an Object owns another object and another object cannot exist without the owner object. 
 * Consider the case of Human having a heart. Here Human object contains the heart and heart 
 * cannot exist without Human.
*/
public class CompositionExample {
	int j=20;
	static int k=20;
	public static void main(String[] args) {
		Book b1 = new Book("EffectiveJ Java", "Joshua Bloch");
		Book b2 = new Book("Thinking in Java", "Bruce Eckel");
		Book b3 = new Book("Java: The Complete Reference", "Herbert Schildt");
		int i =10;
		//System.out.println(j);
		System.out.println(k);
		List<Book> books = new ArrayList<>();
		books.add(b1);
		books.add(b2);
		books.add(b3);
		Library library = new Library(books);
		List<Book> bks = library.getTotalBooksInLibrary();
		for (Book bk : bks) {
			System.out.println("Title : " + bk.title + " and " + " Author : " + bk.author);
		}
	}
	private void getTest(){
		System.out.println(j);
		System.out.println(k);
	}
}

class Book {
	public String title;
	public String author;

	Book(String title, String author) {
		this.title = title;
		this.author = author;
	}
}

class Library {
	private final List<Book> books;

	Library(List<Book> books) {
		this.books = books;
	}

	public List<Book> getTotalBooksInLibrary() {
		return books;
	}
}