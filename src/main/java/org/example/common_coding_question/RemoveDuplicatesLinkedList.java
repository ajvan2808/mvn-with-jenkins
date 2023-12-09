package org.example.common_coding_question;

import java.util.HashSet;

public class RemoveDuplicatesLinkedList {
    // Apply LinkedList
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    // 'static' is used to share the same variable or method of a given class.
    public Node current;
    static int Size = 0;

    public void addFront(int data) {
        // create Node
        Node newNode = new Node(data);
        // if head is Null
        if (current == null) {
            current = newNode;
            Size++;
            return;
        }

        // else set it to current Head
        newNode.next = current;

        // set Head value to this new node
        current = newNode;
        Size++;
    }

    public String removeDuplicates(Node current) {
        // Create a hash table to store unique values
        // Bypass duplicate as soon as we detect one
        // Time complex O(n)

        // A HashSet is a collection of items where every item is unique, and it is found in the java.util package
        HashSet<Integer> uniqueList = new HashSet<>();
        Node previous = null;
        while (current != null) {
            if (uniqueList.contains(current.data)) {
                previous.next = current.next;
            }
            else {
                uniqueList.add(current.data);
                previous = current;
            }
            current = current.next;
        }
        return uniqueList.toString();
    }
}
