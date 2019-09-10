package com.demo.program.datastructure;

public class LoopInLinkedList {


    static Node head;

    // Driver program to test above functions
    public static void main(String[] args) {
        LoopInLinkedList list = new LoopInLinkedList();
        list.head = new Node(50);
        list.head.next = new Node(20);
        list.head.next.next = new Node(15);
        list.head.next.next.next = new Node(4);
        list.head.next.next.next.next = new Node(10);

        // Creating a loop for testing
        head.next.next.next.next.next = head.next.next;

        list.detectLoopInLinkedList(head);
        System.out.println("Linked List after removing loop : ");
        list.printList(head);
    }

    public int detectLoopInLinkedList(Node startingNode) {

        Node fast = startingNode, slow = startingNode;

        while (null != slow && null != fast && null != fast.next) {

            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                removeLoop(slow, startingNode);
                return 1;
            }
        }

        return 0;
    }


    // Function to remove loop
    void removeLoop(Node loop, Node startingNode) {
        Node ptr1 = null;
        Node ptr2 = null;

        ptr1 = startingNode;
        while (1 == 1) {

            ptr2 = loop;
            while (ptr2.next != loop && ptr2.next != ptr1) {
                ptr2 = ptr2.next;
            }

            if (ptr2.next == ptr1) {
                break;
            }

            ptr1 = ptr1.next;
        }

        ptr2.next = null;
    }


    void printList(Node startingNode) {
        while (null != startingNode) {
            System.out.print(startingNode.data + "-->");
            startingNode = startingNode.next;
        }
    }

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            next = null;
        }
    }

}
