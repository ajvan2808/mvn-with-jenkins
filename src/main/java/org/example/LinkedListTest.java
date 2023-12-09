package org.example;

public class LinkedListTest {
    private static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }
    public static int Size = 0;
    public static Node head;

    public void addFront(int data) {
        // create Node
        Node newNode = new Node(data);

        // if head is Null
        if (head == null) {
            head = newNode;
            Size++;
            return;
        }

        // else set it to current Head
        newNode.next = head;

        // set Head value to this new node
        head = newNode;
        Size++;
    }

    // Get first Node/ Head
    public int getFirst() {
        return head.data;
    }

    // Get last Node/Tail
    public int getLast() {
        if (head == null) {
            throw new IllegalStateException("EMPTY LIST");
        }
        Node current = head;

        // while we are not at Tail, keep pointing to the next Node
        while(current.next != null) {
            current = current.next;
        }

        // til we meet the Tail
        return current.data;
    }

    public void addBack(int data) {
        Node newNode = new Node(data);

        // if Head then set and return
        if (head == null) {
            head = newNode;
            Size++;
            return;
        }

        // else , start at head
        Node currentNode = head;
        while (currentNode.next != null) {
            currentNode = currentNode.next;
        }

        currentNode.next = newNode;
        Size++;
    }

    /* Size of list
        2 ways checking size of list
        1. Adding a counter in the list itself to keep trach of the size (best practice)
        2. Loop through the list
    */
    public int size() {
        if (head == null) {
            return 0;
        }

        Node currentNode = head;
        int counter = 1;

        while (currentNode.next != null) {
            currentNode = currentNode.next;
            counter++;
        }
        return counter;
    }

    public void clearList() {
        head = null;
        Size = 0;
    }

    public void deleteNode(int data) {
        // if empty list
        if (head == null) {
            return;
        }

        // delete head Node
        if (head.data == data) {
            head = head.next;
        }

        // else walk through list from head
        Node current = head;
        while (current.next != null) {
            if (current.next.data == data) {
                current.next = current.next.next;
                // Size--;
                return;
            }
        }

    }


}
