package org.example;

public class reverseArray {
    /*
     * Runtime O(n/2) => O(n)
     */

     
    /*
     * 1. Iterative 
        - Initialize start and end indexes as start = 0, end = n-1 
        - In a loop, swap arr[start] with arr[end] and change start and end as follows : 
        start = start +1, end = end – 1
     */

     static void reverseInter(int arr[], int start, int end) {
        int temp;
        while (start < end) {
            temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }


    /*
     * 2. Recursive 
        - Initialize start and end indexes as start = 0, end = n-1 
        - Swap arr[start] with arr[end] 
        - Recursively call reverse for rest of the array.
     */

     static void reverseRecursive(int arr[], int start, int end) {
        int temp;
        while (start < end) {
            temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            reverseRecursive(arr, start+1, end-1);
        }
    }


     /* Utility that prints out an
    array on a line */
    static void printArray(int arr[], int size) {
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String args[]) {
          
        int arr[] = {1, 2, 3, 4, 5, 6};
        printArray(arr, 6);
        reverseInter(arr, 0, 5);
        // reverseRecursive(arr, 0, 5);
        System.out.print("Reversed array is \n");
        printArray(arr, 6); 
         
    }

}
