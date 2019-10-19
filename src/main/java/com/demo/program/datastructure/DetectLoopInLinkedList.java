package com.demo.program.datastructure;

import java.util.HashSet;
import java.util.Set;

public class DetectLoopInLinkedList {

	static Node head;

	class Node {
		int data;
		Node next;

		Node(int d) {
			data = d;
			next = null;
		}
	}

	public void push(int new_data) {
		Node new_node = new Node(new_data);
		new_node.next = head;
		head = new_node;
	}

	static Node detectLoop(Node h) {
		Set<Node> s = new HashSet<>();
		while (h != null) {
			if (s.contains(h))
				return h;

			s.add(h);
			h = h.next;
		}
		return null;
	}

	@SuppressWarnings("static-access")
	public static void main(String[] args) {

		DetectLoopInLinkedList llist = new DetectLoopInLinkedList();
		llist.push(20);
		llist.push(4);
		llist.push(15);
		llist.push(4);
		llist.push(10);
		llist.push(4);

		Node loop = detectLoop(head);
		if (null != loop)
			System.out.println("Loop found: " + loop.next.data);
		else
			System.out.println("No Loop");

		// added loop here 4'th node
		llist.head.next.next.next.next = llist.head.next;

		loop = detectLoop(head);
		if (null != loop)
			System.out.println("Loop found: " + loop.next.data);
		else
			System.out.println("No Loop");
	}
}
