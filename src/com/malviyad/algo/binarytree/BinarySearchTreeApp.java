package com.malviyad.algo.binarytree;

class BSTNode {
	int data;
	BSTNode left;
	BSTNode right;
}

//The worst case time complexity of search and insert operations is O(h) where h is height of Binary Search Tree.
//Inorder traversal of BST always produces sorted output.
class BinarySearchTree {
	public BSTNode createNewNode(int data) {
		BSTNode newNode = new BSTNode();
		newNode.data = data;
		newNode.left = null;
		newNode.right = null;
		return newNode;
	}

	public BSTNode insertNode(BSTNode node, int data) {
		if (node == null) {
			return createNewNode(data);
		}
		if (data < node.data) {
			node.left = insertNode(node.left, data);
		} else if (data > node.data) {
			node.right = insertNode(node.right, data);
		}
		return node;
	}

	public BSTNode searchNode(BSTNode root, int data) {
		if (root == null || root.data==data) {
			return root;
		}
		if (data < root.data) {
			return searchNode(root.left, data);
		} else if (data > root.data) {
			return searchNode(root.right, data);
		}
		return root;
	}
	
//	public BSTNode deleteNode(BSTNode node, int data) {
//		if (node == null) {
//			return null;
//		}
//		if (data < node.data) {
//			node.left = deleteNode(node.left, data);
//		}
//		if (data > node.data) {
//			node.right = deleteNode(node.right, data);
//		} else {
//			if (node.left == null || node.right == null) {
//				BSTNode temp = null;
//				temp = node.left == null ? node.right : node.left;
//				if (temp == null) {
//					return null;
//				} else {
//					return temp;
//				}
//			}else{
//				BSTNode successor = getSucessor(node);
//			}
//		}
//		return node;
//	}
}

public class BinarySearchTreeApp {
	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		BSTNode root = null;
		root = bst.insertNode(root, 8);
		root = bst.insertNode(root, 3);
		root = bst.insertNode(root, 6);
		root = bst.insertNode(root, 10);
		root = bst.insertNode(root, 4);
		root = bst.insertNode(root, 7);
		root = bst.insertNode(root, 1);
		root = bst.insertNode(root, 14);
		root = bst.insertNode(root, 13);
		/**
		 *     					8
		 * 
		 * 			  3					10
		 *  
		 * 		1  		  6			13		 14
		 * 								
		 * 4 		 7
		 * 
		 * 
		 * 
		 */
		
		BSTNode node = bst.searchNode(root, 10);
		System.out.println(node.data);
	}
}
