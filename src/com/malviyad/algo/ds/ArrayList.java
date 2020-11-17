package com.malviyad.algo.ds;

import java.util.Arrays;

public class ArrayList {
	private static final int INITIAL_CAPACITY = 10;
	private int size = 0;
	private Object elementData[];// = {};

	public ArrayList() {
		elementData = new Object[INITIAL_CAPACITY];
	}

	private void add(int data) {
		if (size == elementData.length) {
			ensureCapacity();
		}
		elementData[size++] = data;
	}

	private Object get(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Index: " + index + " size: " + size);
		}
		return elementData[index];
	}
	
	private Object remove(int index){
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Index: " + index + " size: " + size);
		}
		Object removedElem = elementData[index];
		for(int i=index;i<size-1;i++){
			elementData[i]=elementData[i+1];
		}
		return removedElem;
	}
	private void ensureCapacity() {
		int newIncreasedCapacity = elementData.length * 2;
		elementData = Arrays.copyOf(elementData, newIncreasedCapacity);
		// Object tempArr[] = elementData;
		// elementData = new Object[newIncreasedCapacity];
		// for (int i = 0; i < tempArr.length - 1; i++) {
		// elementData[i] = tempArr[i];
		// }
	}

	private void printArray() {
		System.out.print("Displaying list : ");
		for (int i = 0; i < size; i++) {
			System.out.print(elementData[i] + " ");
		}
	}

	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		list.add(10);
		list.add(20);
		list.add(2);
		list.add(22);
		list.add(8);
		list.add(7);
		list.add(1);
		list.add(34);
		list.add(5);
		list.add(27);
		list.add(78);
		list.add(90);
		list.add(12);
		list.add(22);
		list.add(39);
		System.out.println(list.toString());
		System.out.println(list.get(5));
		System.out.println(list.size);
		list.printArray();
		System.out.println("\nremoved element: "+list.remove(11));
	}
}
