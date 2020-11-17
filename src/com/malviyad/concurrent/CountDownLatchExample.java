package com.malviyad.concurrent;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchExample {
	public static void main(String[] args) {
		CountDownLatch latch = new CountDownLatch(3);
		Thread t1 = new Thread(new Task(latch, "cache service"));
		Thread t2 = new Thread(new Task(latch, "validate service"));
		Thread t3 = new Thread(new Task(latch, "alert service"));
		t1.start();
		t2.start();
		t3.start();
		try {
			latch.await();
			System.out.println("All services are up, Application is starting now");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class Task implements Runnable {
	private final CountDownLatch latch;
	String service;

	public Task(CountDownLatch latch, String service) {
		this.latch = latch;
		this.service = service;
	}

	@Override
	public void run() {
		System.out.println(service + " is Up");
		latch.countDown();
	}
}
