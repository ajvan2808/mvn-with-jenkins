package org.example;

public class dynamicArrays <String>{
    private Object[] data;
    private int size;
    private int initialCapacity;

    // Constructor
    public dynamicArrays(int initialCapacity) {
        this.initialCapacity = initialCapacity;
        data = new Object[initialCapacity];
    }

    public String get(int index) {
        return (String)data[index];
    }

    public void set(int index, String value) {
        data[index] = value;
    }

    public void insert(int index, String value) {
        // Check size
        if (size == initialCapacity) {
            resize();
        }

        // Copy/shift elements up by walk through the array from tail backward and move elements up
        for (int i = size; i > index; i--) {
            data[i] = data[i-1];
        }

        // insert new value at index and increase array size by 1
        data[index] = value;
        size++;

    }

    public int size() {
        return size;
    }

    // Dynamically resize the array
    public void resize() {
        Object[] newData = new Object[initialCapacity * 2];
        // copy elements from old arr to new one
        for (int j = 0; j < initialCapacity; j++) {
            newData[j] = data[j];
        }

        // re-assign the attributes
        data = newData;
        initialCapacity = initialCapacity * 2;
    }


    // Delete arr elements
    public void delete(int index) {
        // start copy down from the element index we need to delete
        for (int i = index; i < size -1; i++) {
            data[i] = data[i+1];
        }
        size--;
    }

    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    public boolean contains(String value) {
        for (int i = 0; i < size; i++) {
            String currentValue = (String)data[i];
            if(currentValue.equals(value)) {
                return true;
            }
        }
        return false;
    }

    // Additional actions
    public void display() {
        for(int i = 0; i < size; i++) {
            System.out.println("data[i] = " + data[i]);
        }
    }

    public void add(String value) {
        if (size == initialCapacity) {
            resize();
        }
        data[size] = value;
        size++;
    }
}