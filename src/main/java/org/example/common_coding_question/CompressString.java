package org.example.common_coding_question;

public class CompressString {
    // Compress a string to only have unique character and its repetitive times
    // StringBuilder much faster than append to String manually

    public String compressor(String s) {
        StringBuilder compressedString = new StringBuilder();
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            count++;
            if (i + 1 >= s.length() || s.charAt(i) != s.charAt(i + 1)) {
                compressedString.append(s.charAt(i));
                compressedString.append(count);
                // after append a char and its count, reset counter to 0 for next character count
                count = 0;
            }
        }
        // return compressed string if it's shorter than original string else just return original
        return compressedString.length() < s.length() ? compressedString.toString() : s;
    }

}
