package org.example;

/**
 * fibMemoized
 * optimaized Fibonacci with Memoization algorithm
 */
public class fibMemoized {
    private int[] memo = new int[1001];
    // MEMOIZATION
    public int fibMemo(int n) {
        System.out.println("n = " + n);
        if (n <= 0) {
            return 0;
        }
        else if (n == 1) {
            return 1;
        }
        else if (memo[n] == 0){
            memo[n] = fibMemo(n - 1) + fibMemo(n - 2);  // time complexity linear time O(n) 
        }

        return memo[n];
    }
}