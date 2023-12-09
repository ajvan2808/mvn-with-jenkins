package org.example;

public class mergeSort {

    // main algorithm that split array, sort and merge()
    public void sort(int arr[], int l, int r) {
        System.out.println("Splitting left and right: " + l + " " + r);
        if (l < r) {
            // Find the middle point
            int m = (l + r)/2;

            // Sort 1st and 2nd halves (phân nửa): từ left - m, và từ m+1 - right
            sort(arr, l, m);
            sort(arr, m+1, r);

            // Call merge() to combine the sorted halves
            merge(arr, l, m, r);
        }
    }

    // Merge final 2 sorted arrays
    public void merge(int arr[], int l, int m, int r) {
        System.out.println("Merging left, middle, right: " + l + " " + m + " " + r);

        // Find sizes of the 2 sub-arrays of arr[]
        int n1 = m - l + 1;
        int n2 = r - m;

        // temp array
        int leftArr[] = new int[n1];
        int rightArr[] = new int[n2];

        // Copy data to temp arrays
        for (int i = 0; i < n1; ++i) {
            leftArr[i] = arr[l + i];
        }
        for (int j = 0; j < n2; ++j) {
            rightArr[j] = arr[m + 1 + j];
        }

        // Merge temp arrays
        // Initialize index of 1st and 2nd sub-arr
        int i = 0, j = 0;

        // Index of sub-arrays after merged
        int k = l;

        while(i < n1 && j < n2) {
            if (leftArr[i] < rightArr[j]) {
                arr[k] = leftArr[i];
                i++;
            }
            else {
                arr[k] = rightArr[j];
                j++;
            }
            k++;
        }

        // Copying remaining elements of leftArray if any
        while (i < n1) {
            arr[k] = leftArr[i];
            i++;
            k++;
        }

        // Copying remaining elements of rightArray if any
        while (j < n2) {
            arr[k] = rightArr[j];
            j++;
            k++;
        }

        System.out.println("After merged: ");
        printArray(arr);

    }

    public void printArray(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
