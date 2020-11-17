package com.malviyad.concurrent;

/*Atomic operations are performed in a single unit of task without interference from other operations. 
 * Atomic operations are necessity in multi-threaded environment to avoid data inconsistency.
*/
public class AtomicOperation {
	public static void main(String[] args) throws InterruptedException {
		ProcessingThread pt = new ProcessingThread();
		Thread t1 = new Thread(pt, "t1");
		t1.start();
		Thread t2 = new Thread(pt, "t2");
		t2.start();
		//wait for threads to finish processing
		t1.join();
		t2.join();
		System.out.println("Processing count=" + pt.getCount());
	}
}

class ProcessingThread implements Runnable {
	private int count;
	// private AtomicInteger count = new AtomicInteger();

	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			processSomething(i);
			count++;
			// count.incrementAndGet();
		}
	}

	public int getCount() {
		return this.count;
		// return this.count.get();
	}

	private void processSomething(int i) {
		try {
			Thread.sleep(i * 10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

//Output of this program varies between 5 to 9
//After commenting line numbers 22, 30, 36 and uncommenting 23, 31, 37 will always produce 10 as output.