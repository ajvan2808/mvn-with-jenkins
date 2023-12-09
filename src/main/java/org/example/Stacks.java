package org.example;

import java.util.EmptyStackException;

/*
 The static keyword is a non-access modifier used for methods and attributes. Static methods/attributes can be accessed without creating an object of a class.
 */

public class Stacks {
    private class Node {
        private int data;
        private Node next;

        // constructor
        private Node(int data) {
            this.data = data;
        }

    }
    static Node head;

    // methods
    public boolean isEmpty(){
        return head == null;
    }

    public int peek() {
        return head.data;
    }

    public void push(int data) {
        // create new Node
        // set it's next to be head
        // set head to be the new node
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    public int pop() {
        // store the value you want to return
        // set the current head.next to be the new head
        // return the value

        if (head == null)
            throw new EmptyStackException();

        int data = head.data;
        head = head.next;
        return data;
    }
}
