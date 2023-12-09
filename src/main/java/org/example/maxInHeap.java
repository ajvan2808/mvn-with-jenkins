package org.example;

import java.util.Arrays;

public class maxInHeap {
    private int Capacity = 20;
    private int Size = 0;

    // khởi tạo an array called items ưith capacity is 10
    public int[] items = new int[Capacity];

    private int leftChildIndex(int parentIndex) {
        return 2 * parentIndex + 1;
    }

    private int rightChildIndex(int parentIndex) {
        return 2 * parentIndex + 2;
    }

    private int parentIndex(int childIndex) {
        return childIndex/2;
    }

    // find children index
    private boolean hasLeftChild(int index) {
        return leftChildIndex(index) < Size;
    }

    private boolean hasRightChild(int index) {
        return rightChildIndex(index) < Size;
    }

    private boolean hasParent(int index) {
        return parentIndex(index) >= 0;
    }

    private int leftChild(int index) {
        return items[leftChildIndex(index)];
    }

    private int rightChild(int index) {
        return items[rightChildIndex(index)];
    }

    private int parent(int index) {
        return items[parentIndex(index)];
    }

    // GET MAX
    public int extractMax() {
        if (Size == 0) { 
            // Class IllegalStateException: Signals that a method has been invoked at an illegal or inappropriate time.
            throw new IllegalStateException(); 
        }

        int max = items[0];     // Grab the Max
        items[0] = items[Size - 1];   // Swap top and bottom
        Size--;
        heapifyDown();      // Reorder
        return max;
    }

    private void ensureCapacity() {
        if (Size == Capacity) {
            items = Arrays.copyOf(items, Capacity*2);
            Capacity *= 2;
        }
    }

    // INSERT 
    public void insert(int item) {
        // check capacity
        ensureCapacity();
        // insert to bottom last 
        items[Size] = item;
        Size++;
        heapifyUp();
    }


    private void heapifyUp() {
        int index = Size - 1;    // Start from bottom
        // while parent less than child
        while (hasParent(index) && parent(index) < items[index]) {
            swap(parentIndex(index), index);     
            index = parentIndex(index); // then walk upwards to next child
        }

        // int temp = items[index];
        // while (index > 0 && temp > items[parent(index)]) {
        //     items[index] = items[parent(index)];
        //     index = parent(index);
        // }
        // items[index] = temp;

    }

    public void heapifyDown() {
        int index = 0;  // Start at the top

        // Check the left only cause if no left, there's no right
        while (hasLeftChild(index)) {
            // take the larger btw 2 indexes: called smaller child index cause staring fron left, left index always
            // smaller than right
            int smallerChildIndex = leftChildIndex(index);
            if (hasRightChild(index) && rightChild(index) > leftChild(index)) {
                smallerChildIndex = rightChildIndex(index);
            }

            // if larger child index is smaller than the top then it's sorted
            if (items[index] > items[smallerChildIndex]) {
                break;
            }
            // else reorder by swap the indexes
            else {
                // QUICK SORT
                swap(index, smallerChildIndex);
            }

            // move down to smaller schild
            index = smallerChildIndex;
        }
    }

    // Using quick sort algorithm
    private void swap(int index1, int index2) {
        int temp = items[index1];
        items[index1] = items[index2];
        items[index2] = temp;
    }

    public void print() {
        for (int i = 0; i < Size; i++) {
            System.out.println(i + "[" + items[i] + "]");
        }
    }
}
