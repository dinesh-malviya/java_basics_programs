package com.malviyad.algo.binarytree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree {
	private TreeNode root;
	public static void main(String[] args) {
		BinaryTree binaryTree = new BinaryTree();
		binaryTree.createBinaryTree();
//		binaryTree.preOrderTraversal(binaryTree.root);
//		System.out.println("==========================");
//		binaryTree.iterativePreOrderTraversal();
//		System.out.println("==========================");
//		binaryTree.inOrderTraversal(binaryTree.root);
//		System.out.println("==========================");
//		binaryTree.interativeInOrderTraversal();
//		System.out.println("==========================");
//		binaryTree.postOrderTraversal(binaryTree.root);

		System.out.println("==========================");
		binaryTree.levelOrderTraversal();
		
		binaryTree.insertNode(binaryTree.root, 20);

//		System.out.println("==========================");
//		binaryTree.levelOrderTraversal();
	}

	private class TreeNode {
		int data;
		TreeNode left;
		TreeNode right;

		public TreeNode(int data) {
			this.data = data;
		}
	}

	public void createBinaryTree() {
		TreeNode firstNode = new TreeNode(9);
		TreeNode secondNode = new TreeNode(2);
		TreeNode thirdNode = new TreeNode(3);
		TreeNode fourthNode = new TreeNode(4);
		TreeNode fifthNode = new TreeNode(6);
		root = firstNode;
		firstNode.left = secondNode;
		firstNode.right = thirdNode;
		secondNode.left = fourthNode;
		secondNode.right = fifthNode;
//		9
//	2		3
//4		6	
	}
	
	public void preOrderTraversal(TreeNode rootNode) {
		if(rootNode==null){
			return;
		}
		System.out.println(rootNode.data + "");
		preOrderTraversal(rootNode.left);
		preOrderTraversal(rootNode.right);
	}
	
	public void iterativePreOrderTraversal() {
		if(root==null){
			return;
		}
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		while(!stack.isEmpty()){
			TreeNode tempNode = stack.pop();
			System.out.println(tempNode.data + "");
			if(tempNode.right!=null){
				stack.push(tempNode.right);
			}
			if(tempNode.left!=null){
				stack.push(tempNode.left);
			}
		}
	}
	
	public void inOrderTraversal(TreeNode rootNode) {
		if(rootNode==null){
			return;
		}
		inOrderTraversal(rootNode.left);
		System.out.println(rootNode.data + "");
		inOrderTraversal(rootNode.right);
	}
	
	public void interativeInOrderTraversal() {
		if(root==null){
			return;
		}
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode tempNode = root;
		while(!stack.isEmpty() || tempNode!=null){
			if(tempNode!=null){
				stack.push(tempNode);
				tempNode = tempNode.left;
			}else{
				tempNode=stack.pop();
				System.out.println(tempNode.data + "");
				tempNode = tempNode.right;
			}
		}
	}
	
	public void postOrderTraversal(TreeNode rootNode) {
		if(rootNode==null){
			return;
		}
		postOrderTraversal(rootNode.left);
		postOrderTraversal(rootNode.right);
		System.out.println(rootNode.data + "");
	}
	
	
//		 9
//	 2		3
//4		6	
	public void levelOrderTraversal() {
		if(root==null){
			return;
		}
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		while(!queue.isEmpty()){
			TreeNode tempNode = queue.poll();
			System.out.println(tempNode.data + "");	
			if(tempNode.left!=null){
				queue.offer(tempNode.left);
			}
			if(tempNode.right!=null){
				queue.offer(tempNode.right);
			}
		}
	}
	
	public void insertNode(TreeNode root, int data) {
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		while(!queue.isEmpty()){
			TreeNode tempNode = queue.poll();
			//System.out.println(tempNode.data + "");	
			if(tempNode.left==null){
				tempNode.left =  new TreeNode(data);
				break;
			}else{
				queue.offer(tempNode.left);
			}
			if(tempNode.right==null){
				tempNode.right =  new TreeNode(data);
				break;
			}else{
				queue.offer(tempNode.right);
			}
		}
		System.out.println("insersion done");
	}
}
