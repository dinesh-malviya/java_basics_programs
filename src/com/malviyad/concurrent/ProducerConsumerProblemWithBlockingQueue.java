package com.malviyad.concurrent;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ProducerConsumerProblemWithBlockingQueue {
	public static void main(String[] args) {
		BlockingQueue<Integer> sharedQueue = new LinkedBlockingQueue<Integer>();

		Thread producer = new Thread(new Producer(sharedQueue));
		Thread consumer = new Thread(new Consumer(sharedQueue));
		producer.start();
		consumer.start();
	}
}

class Producer implements Runnable {
	private BlockingQueue<Integer> sharedQueue;

	public Producer(BlockingQueue<Integer> sharedQueue) {
		this.sharedQueue = sharedQueue;
	}

	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			try {
				System.out.println("Produced: " + i);
				sharedQueue.put(i);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("");
		}
	}
}

class Consumer implements Runnable {
	private BlockingQueue<Integer> sharedQueue;

	public Consumer(BlockingQueue<Integer> sharedQueue) {
		this.sharedQueue = sharedQueue;
	}

	@Override
	public void run() {
		while (true) {
			try {
				System.out.println("Consumed: " + sharedQueue.take());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}