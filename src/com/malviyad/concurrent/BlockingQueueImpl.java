package com.malviyad.concurrent;

import java.util.LinkedList;
import java.util.Queue;

public class BlockingQueueImpl {
	Queue<Integer> queue = new LinkedList<>();
	int limit = 10;
	public BlockingQueueImpl(int limit) {
		this.limit= limit;
	}
	

	public synchronized void enqueue(int elem) throws InterruptedException {
		while(queue.size()==limit) {
			wait();
		}
		queue.add(elem);
		System.out.println("enqueue: "+elem);
		notify();
	}
	
	public synchronized int dequeue() throws InterruptedException {
		while(queue.size()==0) {
			wait();
		}
		int elem =queue.poll();
		notify();
		System.out.println("dequeue: "+elem);
		return elem;
	}
	public static void main(String[] args) {
		BlockingQueueImpl queueImpl = new BlockingQueueImpl(10);
		Thread producer = new Thread(new Runnable() {
			public void run() {
				for(int i =0; i<15; i++) {
					try {
						queueImpl.enqueue(i);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		producer.start();
		
		Thread consumer = new Thread(new Runnable() {
			public void run() {
				while(true) {
					try {
						queueImpl.dequeue();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		consumer.start();
	}
}
