package org.example;

/**
 * bubbleSort
 */
public class bubbleSort {

    public static int[] sort(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n-1; i++) {
            // System.out.println("i: " + i);
            for (int j = 0; j < n - i -1; j++) {
                // System.out.println("j: " + j + " and arr[j] " + arr[j]);
                if (arr[j] > arr[j + 1]) {
                    // swap temp and arr[i]
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
                
            }
        }
        return arr;
    }

//    public static void main(String args[])
//    {
//        int arr[] = { 64, 34, 25, 12, 22, 11, 90 };
//        sort(arr);
//        int i;
//        for (i = 0; i < arr.length; i++)
//            System.out.print(arr[i] + " ");
//        // System.out.println();
//    }
}