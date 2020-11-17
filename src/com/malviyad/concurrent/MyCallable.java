package com.malviyad.concurrent;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/* Java Callable and Future are used a lot in multithreaded programming. 
 * In last few posts, we learned a lot about java threads but sometimes we wish 
 * that a thread could return some value that we can use. Java 5 introduced java.util.concurrent.Callable 
 * interface in concurrency package that is similar to Runnable interface but it can return 
 * any Object and able to throw Exception.
 
  Java Callable interface use Generic to define the return type of Object. 
  Executors class provide useful methods to execute Java Callable in a thread pool. 
  Since callable tasks run in parallel, we have to wait for the returned Object
  
  Java Future provides cancel() method to cancel the associated Callable task. 
  There is an overloaded version of get() method where we can specify the time to wait for the result, 
  it’s useful to avoid current thread getting blocked for longer time. 
  There are isDone() and isCancelled() methods to find out the current status of associated Callable task.
*/
public class MyCallable implements Callable<String> {
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService executorService = Executors.newFixedThreadPool(10);
		List<Future<String>> futureList = new ArrayList<>();
		Callable<String> callable = new MyCallable();
		for (int i = 0; i < 100; i++) {
			Future<String> future = executorService.submit(callable);
			futureList.add(future);
		}
		for (Future<String> future : futureList) {
			System.out.println(new Date() + "::" + future.get());
		}
		executorService.shutdown();
	}

	@Override
	public String call() throws Exception {
		Thread.sleep(1000);
		return Thread.currentThread().getName();
	}

}
