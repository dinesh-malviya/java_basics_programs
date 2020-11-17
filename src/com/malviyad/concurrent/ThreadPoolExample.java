package com.malviyad.concurrent;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/*Java thread pool manages the pool of worker threads. It contains a queue that keeps 
 * tasks waiting to get executed. We can use ThreadPoolExecutor to create thread pool in Java.

Java thread pool manages the collection of Runnable threads. The worker threads execute 
Runnable threads from the queue. java.util.concurrent.Executors provide factory and support 
methods for java.util.concurrent.Executor interface to create the thread pool in java.
*/

public class ThreadPoolExample {
	public static void main(String[] args) throws InterruptedException {
		ExecutorService executorService = Executors.newFixedThreadPool(5);
		for (int i = 0; i < 10; i++) {
			executorService.execute(new WorkerThread("task: " + i));
			//executorService.submit(new WorkerThread("task: " + i));
		}
		executorService.shutdown();
		while (!executorService.isTerminated()) {
			// System.out.println("Still running executor");
		}
		System.out.println("Finished execution of all threads (FixedThreadPool)");

		ScheduledExecutorService scheduledExecutorSer = Executors.newScheduledThreadPool(5);
		System.out.println("Current Time = " + new Date());
		for (int i = 0; i < 3; i++) {
			scheduledExecutorSer.schedule(new WorkerThread("" + i), 5, TimeUnit.SECONDS);
		}
		// add some delay to let some threads spawn by scheduler
		Thread.sleep(30000);

		scheduledExecutorSer.shutdown();
		while (!scheduledExecutorSer.isTerminated()) {
			// wait for all tasks to finish
		}
		System.out.println("Finished execution of all threads (ScheduledThreadPool)");

		for (int i = 0; i < 3; i++) {
			Thread.sleep(1000);
			WorkerThread worker = new WorkerThread("do heavy processing");
			// schedule task to execute at fixed rate
			scheduledExecutorSer.scheduleAtFixedRate(worker, 0, 10, TimeUnit.SECONDS);
		}

		for (int i = 0; i < 3; i++) {
			Thread.sleep(1000);
			WorkerThread worker = new WorkerThread("do heavy processing");
			scheduledExecutorSer.scheduleWithFixedDelay(worker, 0, 1, TimeUnit.SECONDS);
		}

		Runnable worker = () -> {
			for (int j = 0; j < 10; j++) {
				System.out.println("child thread");
			}
		};
		scheduledExecutorSer.schedule(worker, 10, TimeUnit.SECONDS);

	}
}

class WorkerThread implements Runnable {
	private String command;

	public WorkerThread(String command) {
		this.command = command;
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + " started : " + command + " at time : " + new Date());
		processCommand();
		System.out.println(Thread.currentThread().getName() + " Ended : " + command + " at time : " + new Date());
	}

	private void processCommand() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
/*
 * In the above program, we are creating a fixed-size thread pool of 5 worker
 * threads. Then we are submitting 10 jobs to this pool, since the pool size is
 * 5, it will start working on 5 jobs and other jobs will be in wait state, as
 * soon as one of the job is finished, another job from the wait queue will be
 * picked up by worker thread and get’s executed
 */