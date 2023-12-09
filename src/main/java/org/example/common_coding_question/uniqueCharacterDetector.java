package org.example.common_coding_question;

public class uniqueCharacterDetector {
    // There are lots of ways we could solve this:
    // - HashMap: where we store every character and boolean on whether found
    // - An array that counts the number of times a character occurs
    // The solution below use a simple array, that stores boolean

    public boolean isUnique(String text) {
        // Create an array representing all unique 128 characters in ASCII
        // Set a flag to true for each letter
        // Return false when found a match of the previous letter
        // If length > 128 there must be duplicate
        if (text.length() > 128) return false;

        boolean[] char_set = new boolean[128];
        for (int i = 0; i < text.length(); i++) {
            int val = text.charAt(i);
            if (char_set[val]) {
                return false;
            }
            char_set[val] = true;
        }
        return true;
    }
}
