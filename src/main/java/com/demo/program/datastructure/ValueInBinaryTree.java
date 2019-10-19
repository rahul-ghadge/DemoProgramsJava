package com.demo.program.datastructure;

/*
 * Find given number is present in Binary tree
 * 
 * Recursion is used here to reach out leaf node
 */
public class ValueInBinaryTree {

	static Node head;

	public static void main(String[] args) {

		head = new Node(8);
		head.left = new Node(3);
		head.left = new Node(1);
		head.left.right = new Node(6);
		head.right = new Node(10);
		head.right.right = new Node(15);

		System.out.println(search(head, 6) != null ? "Found" : "No data");
    System.out.println(search(head, 5) != null ? "Found" : "No data");

	}

	static Node search(Node node, int value) {

		if (node == null)
			return null;
		else if (node.data == value)
			return node;
		else if (value < node.data)
			return search(node.left, value);
		else
			return search(node.right, value);
	}

	static class Node {
		int data;
		Node left;
		Node right;

		Node(int data) {
			this.data = data;
			this.left = this.right = null;
		}
	}
}
