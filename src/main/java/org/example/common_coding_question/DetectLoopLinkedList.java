package org.example.common_coding_question;

//import src.main.java.LinkedList;

public class DetectLoopLinkedList {
    public static class Node{
        int value;
        Node next;

        public Node (int data) {
            this.value = data;
        }
    }

    public Node head;
    public int size = 0;

    public boolean checkLoop(){
        return hasLoop(head);
    }

    public boolean addBack(Node newNode) {
        // if Head then set and return
        if (head == null) {
            head = newNode;
            size++;
            return true;
        }

        // else , walk from head
        Node currentNode = head;
        while (currentNode.next != null) {
            currentNode = currentNode.next;
            boolean isDup = hasLoop(currentNode);
            if (isDup) {
                return false;
            }
        }
        currentNode.next = newNode;
        size++;
        return true;
    }

    boolean hasLoop(Node first){
        Node previousNode = first;
        Node nextNode = first;
        while (nextNode != null && nextNode.next != null) {
            previousNode = previousNode.next;
            nextNode = nextNode.next.next;
            if (previousNode == nextNode) {
                return true;
            }
        }
        return false;
    }

}
