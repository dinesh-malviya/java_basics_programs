package com.malviyad.algo.ds;

import java.util.HashSet;

public class LinkedList {
	Node head;
	Node tail;

	class Node {
		int data;
		Node next;

		public Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	private void add(int data) {
		Node newNode = new Node(data);
		newNode.next = null;
		if (head == null) {
			head = newNode;
			tail = newNode;
		} else {
			tail.next = newNode;
			tail = newNode;
		}
	}

	private void addAfter(int after, int data) {
		Node current = head;
		Node newNode = new Node(data);
		if (head == null) {
			head = newNode;
		}
		Node temp = null;
		while (current != null) {
			if (current.data == after) {
				// remember temp is pointing to the current,
				// so if we make any changes in current then it will be reflected to temo as
				// well.
				temp = current;
				break;
			}
			current = current.next;
		}
		if (temp != null) {
			newNode.next = temp.next;
			current.next = newNode;
		}
	}

	private void delete(int data) {
		Node current = head;
		Node prev = null;
		while (current != null && current.data != data) {
			prev = current;
			current = current.next;
		}
		prev.next = current.next;
	}

	private void deleteAfter(int after) {
		Node current = head;
		Node prev = null;
		while (current != null) {
			if (current.data == after) {
				prev = current;
				current = current.next;
				break;
			}
			current = current.next;
		}
		if (prev != null) {
			prev.next = current.next;
		}
	}

	private void printMiddleElement() {
		Node fast = head;
		Node middle = head;
		if (head != null) {
			while (fast != null && fast.next != null) {
				fast = fast.next.next;
				middle = middle.next;
			}
			System.out.println("middle eleme is: " + middle.data);
		}
	}

	private boolean isLinkedListCyclic() {
		Node fast = head;
		Node slow = head;
		boolean flag = false;
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
			if (fast == slow) {
				flag = true;
				break;
			}
		}
		return flag;
	}

	private void traverse() {
		Node tempNode = head;
		while (tempNode != null) {
			System.out.println("Node data: " + tempNode.data);
			tempNode = tempNode.next;
		}
	}

	private void traverse(Node head) {
		Node tempNode = head;
		while (tempNode != null) {
			System.out.println("Node data: " + tempNode.data);
			tempNode = tempNode.next;
		}
	}

	private Node reverseLinkedList() {
		Node current = head;
		Node nextNode = null;
		Node prev = null;
		while (current != null) {
			nextNode = current.next;
			current.next = prev;
			prev = current;
			current = nextNode;
		}
		return prev;
	}

	private void deleteNode(Node node) {
		Node temp = node.next;
		node.data = temp.data;
		node.next = temp.next;
		// System.gc();
	}

	private boolean removeLoop(Node head) {
		Node prev = null;
		HashSet<Node> set = new HashSet<>();
		while (head != null) {
			if (set.contains(head)) {
				prev.next = null;
				return true;
			} else {
				set.add(head);
				prev = head;
				head = head.next;
			}
		}
		return false;
	}

	private void sortLinkedList() {
		Node current = head;
		Node nextNode = null;
		int temp;
		if (head == null) {
			System.out.println("LinkedList is empty");
			return;
		}
		while (current != null) {
			nextNode = current.next;
			while (nextNode != null) {
				if (current.data > nextNode.data) {
					temp = nextNode.data;
					nextNode.data = current.data;
					current.data = temp;
				}
				nextNode = nextNode.next;
			}
			current = current.next;
		}
	}

	private void findNthNodeFromLast(int n) {
		Node main_ptr = head;
		Node ref_ptr = head;
		int count = 0;
		if (head != null) {
			while (count < n) {
				if (ref_ptr == null) {
					System.out.println(n + " is greater than the no " + " of nodes in the list");
					return;
				}
				ref_ptr = ref_ptr.next;
				count++;
			}

			if (ref_ptr == null) {
				head = head.next;
				if (head != null)
					System.out.println("Node no. " + n + " from last is " + head.data);
			} else {
				while (ref_ptr != null) {
					main_ptr = main_ptr.next;
					ref_ptr = ref_ptr.next;
				}
				System.out.println("Node no. " + n + " from last is " + main_ptr.data);
			}
		}
	}

	private void deleteGivenNode(Node node) {
		Node temp = node.next;
		node.data = temp.data;
		node.next = temp.next;
		//System.gc();
	}

	public static void main(String[] args) {
		LinkedList linkedList = new LinkedList();
		linkedList.add(15);
		linkedList.add(2);
		linkedList.add(87);
		linkedList.add(12);
		linkedList.add(14);
		linkedList.add(8);

		linkedList.printMiddleElement();

		linkedList.findNthNodeFromLast(3);

		linkedList.traverse();
		linkedList.addAfter(12, 28);
		System.out.println("Adding 28 after 12");
		linkedList.traverse();

		linkedList.deleteAfter(2);
		System.out.println("delete after 2");
		linkedList.traverse();

		linkedList.delete(12);
		System.out.println("delete 12");
		linkedList.traverse();
		linkedList.delete(8);
		System.out.println("after deleting 8");
		linkedList.traverse();

		linkedList.printMiddleElement();
		boolean isCyclic = linkedList.isLinkedListCyclic();
		System.out.println("isCyclic: " + isCyclic);

		linkedList.deleteNode(linkedList.head);
		System.out.println("deleting head");
		linkedList.traverse();

		System.out.println("reversing linked list");
		Node node = linkedList.reverseLinkedList();
		linkedList.traverse(node);

		LinkedList linkedList2 = new LinkedList();
		linkedList2.add(15);
		linkedList2.add(2);
		linkedList2.add(87);
		linkedList2.add(12);
		linkedList2.add(14);
		linkedList2.add(8);
		linkedList2.head.next.next.next.next.next.next = linkedList2.head.next;
		System.out.println("created looped LL");
		linkedList2.removeLoop(linkedList2.head);
		linkedList2.traverse(linkedList2.head);

		linkedList2.sortLinkedList();
		System.out.println("after sorting");
		linkedList2.traverse();

		//linkedList2.findNthNode(6);
		//linkedList2.findNthNode(3);
		linkedList2.deleteGivenNode(linkedList2.head.next);

		System.out.println("after sorting");
		linkedList2.traverse(linkedList2.head);
	}
}
