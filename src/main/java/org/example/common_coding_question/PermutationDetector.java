package org.example.common_coding_question;

import java.util.Arrays;

public class PermutationDetector {
    public boolean isPermutation(String text, String perm) {
        /*
        A permutation is an arrangement of objects in a specific order.
        In other words, it is the number of ways to order a set of objects.
        */

        if (perm.length() != text.length()) return false;
        return sort(text).equals(sort(perm));
    }

    private String sort(String s) {
        /*
        * Takes a string as input and returns a sorted string as output.
        * First converting the string to a character array.
        * Then, it uses the Arrays.sort() method to sort the character array in ascending order.
        * Finally, converts the sorted character array back to a string and returns it.
        */
        char[] content = s.toCharArray();
        // Use Java sort() method: dual-pivot quicksort, 0n(log n)
        Arrays.sort(content);
        return new String(content);
    }
}
