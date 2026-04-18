package com.demo.program.datastructure;

public class LoopInLinkedList {


    static Node head;

    // Driver program to test above functions
    @SuppressWarnings("static-access")
    public static void main(String[] args) {
        LoopInLinkedList list = new LoopInLinkedList();
        list.head = new Node(50);
        list.head.next = new Node(20);
        list.head.next.next = new Node(15);
        list.head.next.next.next = new Node(4);
        list.head.next.next.next.next = new Node(10);

        // Creating a loop for testing
        list.head.next.next.next.next.next = head.next.next;

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
                findFirstElementOfLoop(startingNode, fast);
                System.out.println("Loop found in linked list: " + slow.data);
                removeLoop(slow, startingNode);
                return 1;
            }
        }

        return 0;
    }

    private void findFirstElementOfLoop(Node startingNode, Node next) {

        while (startingNode != null || next != null) {
            startingNode = startingNode.next;
            next = next.next;

            System.out.println(startingNode.data + " : " + next.data);


            if (startingNode == next) {
                System.out.println("Loop found at " + next.data);
                return;
            }
        }
    }


    // Function to remove loop
    void removeLoop(Node loop, Node startingNode) {
        Node ptr1 = startingNode;
        Node ptr2 = null;

        while (true) {
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
            System.out.print((startingNode.next == null) ? startingNode.data : startingNode.data + " --> ");
            startingNode = startingNode.next;
        }
        System.out.println();
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

//-----------------------------------------------------------------------------
//        Output
//-----------------------------------------------------------------------------
//        20 : 10
//        15 : 15
//        Loop found at 15
//        Loop found in linked list: 4
//        Linked List after removing loop :
//        50 --> 20 --> 15 --> 4 --> 10
