package com.malviyad.concurrent;

class Book {
	String title;
	boolean isCompleted;

	public Book(String title) {
		this.title = title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	public void setCompleted(boolean isCompleted) {
		this.isCompleted = isCompleted;
	}

	public boolean isCompleted() {
		return isCompleted;
	}
}

class BookReader implements Runnable {
	Book book;

	public BookReader(Book book) {
		this.book = book;
	}

	public void run() {
		synchronized (book) {
			try {
				System.out.println(Thread.currentThread().getName() + " :waiting for the book to be completed");
				book.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + " :Book has been completed now!!! you can read");
		}
	}
}

class BookWritter implements Runnable {
	Book book;

	public BookWritter(Book book) {
		this.book = book;
	}

	public void run() {
		synchronized (book) {
			System.out.println("Author is starting book : " + book.getTitle());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			book.setCompleted(true);
			System.out.println("Book has been completed now");
			book.notify();
			//book.notifyAll();
			System.out.println("notified one reader");
		}
	}
}

public class ThreadInterCommunicationMain {
	public static void main(String[] args) {
		// Book object on which wait and notify method will be called
		Book book = new Book("The Alchemist");
		BookReader johnReader = new BookReader(book);
		BookReader arpitReader = new BookReader(book);

		// BookReader threads which will wait for completion of book
		Thread johnThread = new Thread(johnReader, "John");
		Thread arpitThread = new Thread(arpitReader, "Arpit");

		arpitThread.start();
		johnThread.start();

		// To ensure both readers started waiting for the book
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		// BookWriter thread which will notify once book get completed
		BookWritter bookWriter = new BookWritter(book);
		Thread bookWriterThread = new Thread(bookWriter);
		bookWriterThread.start();
	}
}
