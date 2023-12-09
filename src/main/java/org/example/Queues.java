package org.example;

public class Queues {
    private class Node {
        private int data;
        private Node nextNode;

        private Node(int data) {
            this.data = data;
        }
    }

    static Node head; // remove thing here
    static Node tail; // add things here

    public boolean isEmpty(){
        return head == null;
    }

    public int peek() {
        return head.data;
    }

    // ADDING TO QUEUES
    public void add(int data) {
        Node newNode = new Node(data);
        if (tail == null) {
            tail = newNode;
        }
        tail.nextNode = newNode;

        // handle case if first element where head is null
        if (head == null) {
            head = tail;
        }
    }

    // REMOVING FROM QUEUES
    public int remove() {
        /*
            Save the head data
            Point the head to next element (effectively remove it)
            Then return the data
         */
        int data = head.data;
        head = head.nextNode;

        // Handle the queue now being empty
        if(head == null) {
            tail = null;
        }

        return data;
    }


}
