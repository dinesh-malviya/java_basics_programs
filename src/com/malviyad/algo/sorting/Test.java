package com.malviyad.algo.sorting;

public class Test {
	Node head;
	Node tail;
	class Node{
		int data;
		Node next;
		public Node(int data){
			this.data= data;
			this.next=null;
		}
	}
	private void add(int data){
		Node newNode =  new Node(data);
		if(head==null){
			head=newNode;
			tail=newNode;
		}else{
			tail.next=newNode;
			tail=newNode;
		}
	}
	private void traverse(){
		Node current = head;
		while(current!=null){
			System.out.println("Node: "+current.data);
			current =current.next;
		}
	}
	private void addAfter(int after, int data){
		Node newNode = new Node(data);
		Node current = head;
		if(head==null){
			head = newNode;
		}else{
			Node temp = null;
			while(current!=null){
				if(current.data==after){
					temp=current;
					break;
				}
				current =current.next;
			}
			if(temp!=null){
				newNode.next=temp.next;
				temp.next=newNode;
			}
		}
	}
	public static void main(String[] args) {
		Test test = new Test();
		test.add(15);
		test.add(20);
		test.add(1);
		test.add(5);
		test.add(115);
		test.add(87);
		test.add(7);
		test.traverse();
		
		test.addAfter(5,25);
		System.out.println("Adding 25 after 5");
		test.traverse();
	}
}
