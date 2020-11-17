package com.malviyad.concurrent;

import java.util.concurrent.Semaphore;

//A Semaphore is a thread synchronization construct that can be used either to send signals between threads 
//to avoid missed signals, or to guard a critical section like you would with a lock. 

//Semaphore in Java maintains a specified number of pass or permits, In order to access a shared resource, 
// Current Thread must acquire a permit. If a permit is already exhausted by other threads than it can wait until
// a permit is available due to the release of permits from different threads
// Usage:- Semaphores can be used to restrict number of database connections at a time
// Semaphores can also be used to bound any collection

public class SemaphoreTest {
	Semaphore binary = new Semaphore(1);

	public static void main(String[] args) {
		SemaphoreTest test = new SemaphoreTest();
		new Thread() {
			@Override
			public void run() {
				test.mutualExclusion();
			}
		}.start();
	}

	protected void mutualExclusion() {
		try {
			binary.acquire();
			// here we can add the code which is critical (mutual exclusion region)
			System.out.println(Thread.currentThread().getName() + ": Inside mutual exclusion");
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		} finally {
			binary.release();
			System.out.println(Thread.currentThread().getName() + ": Outside of mutual exclusion");
		}

	}
}
